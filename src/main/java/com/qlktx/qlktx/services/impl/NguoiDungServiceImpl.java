package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.Custom.CustomUserDetails;
import com.qlktx.qlktx.dto.NguoiDungDTO;
import com.qlktx.qlktx.dto.TaiKhoanDTO;
import com.qlktx.qlktx.entities.Nguoidung;
import com.qlktx.qlktx.entities.Nhomnguoidung;
import com.qlktx.qlktx.repositories.NguoiDungRepo;
import com.qlktx.qlktx.repositories.NhomNguoiDungRepo;
import com.qlktx.qlktx.services.NguoiDungService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {
    @Autowired
    private NguoiDungRepo nguoiDungRepo;
    @Autowired
    private NhomNguoiDungRepo nhomNguoiDungRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ResponseEntity<Object> register(NguoiDungDTO dto) {
        BCryptPasswordEncoder bcypt = new BCryptPasswordEncoder();
        Optional<Nguoidung> optionalNguoidung = Optional.ofNullable(nguoiDungRepo.findTopByTenDangNhap(dto.getTenDangNhap()));
        if (optionalNguoidung.isPresent()) {
            return new ResponseEntity<>("Đã tồn tại tên đăng nhập", HttpStatus.BAD_REQUEST);
        }
        String encryptedPwd = bcypt.encode(dto.getMatKhau());
        Nhomnguoidung nhomnguoidung = nhomNguoiDungRepo.getReferenceById(dto.getId_nhom());
        Nguoidung nguoidung = modelMapper.map(dto, Nguoidung.class);
        System.out.println(nguoidung);
        nguoidung.setNhomnguoidung(nhomnguoidung);
        nguoidung.setMatKhau(encryptedPwd);
        nguoiDungRepo.save(nguoidung);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<Object> login(TaiKhoanDTO taiKhoanDTO) {
        BCryptPasswordEncoder bcypt = new BCryptPasswordEncoder();

        Optional<Nguoidung> opNguoidung = Optional.ofNullable(nguoiDungRepo.findTopByTenDangNhap(taiKhoanDTO.getUsername()));
        if (opNguoidung.isEmpty()) {
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }

        if (bcypt.matches(taiKhoanDTO.getPassword(), opNguoidung.get().getMatKhau())) {
            return  new ResponseEntity<>(opNguoidung.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("login fail", HttpStatus.BAD_REQUEST);
        }


    }
}
