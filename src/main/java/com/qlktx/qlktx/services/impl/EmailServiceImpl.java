package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.entities.Dondangky;
import com.qlktx.qlktx.repositories.DonDangKyRepo;
import com.qlktx.qlktx.services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailServiceImpl implements SendEmailService {
    @Autowired
    private DonDangKyRepo donDangKyRepo;
    @Autowired
    private JavaMailSender mailSender;

    public  void sendSimpleEmailMessage(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }

    public  void sendEmailPheDuyet(Integer madondangky) {
        SimpleMailMessage message = new SimpleMailMessage();
        Optional<Dondangky> dondangky = donDangKyRepo.findById(madondangky);
        if (dondangky.isPresent()) {
           message.setTo(dondangky.get().getSinhvien().getEmail());
           message.setSubject("[THÔNG BÁO]: Phê duyệt đơn đăng ký của sinh viên " + dondangky.get().getSinhvien().getHoTenSinhVien());
           message.setText("Chúc mừng bạn đăng ký thành công ký túc xác");
           mailSender.send(message);
        }


    }
}
