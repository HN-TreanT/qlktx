package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.dto.DonDangKyDTO;
import com.qlktx.qlktx.entities.Dondangky;
import com.qlktx.qlktx.entities.Hopdong;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.entities.Sinhvien;
import com.qlktx.qlktx.payloads.APIResponse;
import com.qlktx.qlktx.repositories.DonDangKyRepo;
import com.qlktx.qlktx.repositories.HopDongRepo;
import com.qlktx.qlktx.repositories.PhongRepo;
import com.qlktx.qlktx.repositories.SinhVienRepo;
import com.qlktx.qlktx.services.DonDangKyService;
import com.qlktx.qlktx.services.EmailSenderService;
import com.qlktx.qlktx.services.SendEmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class DonDangKyServiceImpl implements DonDangKyService {
    @Autowired
    private DonDangKyRepo donDangKyRepo;

    @Autowired
    private SinhVienRepo sinhVienRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private HopDongRepo hopDongRepo;


    @Autowired
    private PhongRepo phongRepo;

    @Autowired
    private SendEmailService sendEmailService;

    @Override
    public ResponseEntity<Object> list(String hoTenSinhVien, String doiTuongUuTien, String trangThai, Pageable pageable) {
        Page<Dondangky> list = donDangKyRepo.findAllDon(trangThai, pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("page", pageable.getPageNumber() + 1);
        response.put("limit", pageable.getPageSize());
        response.put("totalElements", list.getTotalElements());
        response.put("totalPage", list.getTotalPages());
        response.put("data", list.getContent());
        return  ResponseEntity.ok(response);
    }
    @Override
    public APIResponse create(DonDangKyDTO dto) {
        // Kiểm tra nếu ngayLamDon là null
        if (dto.getNgayLamDon() == null) {
            dto.setNgayLamDon(LocalDateTime.now());
        }
        dto.setTrangThai("Chờ duyệt");
        // Kiểm tra nếu maSinhVien không phải là null
        if (dto.getMaSinhVien() != null) {
            // Lấy tham chiếu đến Sinhvien từ maSinhVien
            Sinhvien optionalPhong = sinhVienRepo.getReferenceById(dto.getMaSinhVien());
            Dondangky donDk = modelMapper.map(dto, Dondangky.class);
            donDangKyRepo.save(donDk);
            return new APIResponse("success created", true, donDk);
        } else {
            Dondangky donDk = modelMapper.map(dto, Dondangky.class);
            donDangKyRepo.save(donDk);
            return new APIResponse("maSinhVien is null", false, donDk);
        }
    }
    @Override
    @Transactional
    public APIResponse edit(Integer maDonDangKy, DonDangKyDTO dto) {
        // Tìm kiếm phòng cần chỉnh sửa
        Dondangky donDk = donDangKyRepo.findByMaDonDangKy(maDonDangKy);
        if (donDk == null) {
            // Nếu không tìm thấy phòng, trả về thông báo lỗi
            return new APIResponse("Không tìm thấy sinh viên", false, "");
        }

        // Cập nhật thông tin của phòng dựa trên DTO
        donDk.setHoTenSinhVien(dto.getHoTenSinhVien());
        donDk.setTrangThai(dto.getTrangThai());
        donDk.setDoiTuongUuTien(dto.getDoiTuongUuTien());
        donDk.setNgayLamDon(dto.getNgayLamDon());
        // Tiếp tục cập nhật các trường khác nếu cần

        // Lưu các thay đổi vào cơ sở dữ liệu
        donDangKyRepo.save(donDk);

        // Trả về thông báo thành công
        return new APIResponse("success", true, donDk);
    }

    @Override
    @Transactional
    public APIResponse delete(Integer maDonDangKy) {
        Dondangky donDk = donDangKyRepo.findByMaDonDangKy(maDonDangKy);
        if (donDk == null) {
            // Nếu không tìm thấy phòng, trả về thông báo lỗi
            return new APIResponse("not found", false, "");
        }

        // Xóa phòng khỏi cơ sở dữ liệu
        donDangKyRepo.delete(donDk);

        // Trả về thông báo thành công
        return new APIResponse("delete success", true, "");
    }

    @Override
    public ResponseEntity<Object> duyetDonDangKy(Integer maDonDangKy, Integer maPhong) {
        Optional<Dondangky> dondangky = donDangKyRepo.findById(maDonDangKy);
        if (!dondangky.isPresent()) return new ResponseEntity<>(new APIResponse("not found", false, ""), HttpStatus.NOT_FOUND);

        Optional<Phong> phong = phongRepo.findById(maPhong);
        if (!phong.isPresent()) return new ResponseEntity<>(new APIResponse("not found phong", false, ""), HttpStatus.NOT_FOUND);

        if (phong.get().getSoNguoiO() >= phong.get().getLoaiphong().getSoLuongNguoi()) {
            return new ResponseEntity<>(new APIResponse("phòng đã đầy người", false, ""), HttpStatus.BAD_REQUEST);
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime futuretime = now.plusMonths(dondangky.get().getSoThang());
        //tao moi hop dong
        Hopdong hopdong = new Hopdong();
        hopdong.setNgayHopDong(LocalDateTime.now());
        hopdong.setThoiGianChoThue(LocalDateTime.now());
        hopdong.setThoiGianHetHan(futuretime);
        hopdong.setTrangThai("Đã duyệt");
        hopdong.setSinhvien(dondangky.get().getSinhvien());
        hopdong.setPhong(null);
        hopdong.setNguoidung(null);
        hopdong.setTienCoc(0);

        // update lai phong sinh vien
        dondangky.get().getSinhvien().setPhong(phong.get());
        // update lai so nguoi cua phong
        phong.get().setSoNguoiO(phong.get().getSoNguoiO() + 1);

        dondangky.get().setTrangThai("Đã duyệt");



        sinhVienRepo.save(dondangky.get().getSinhvien());
        phongRepo.save(phong.get());
        hopDongRepo.save(hopdong);
        donDangKyRepo.save(dondangky.get());

        sendEmailService.sendSimpleEmailMessage(dondangky.get().getSinhvien().getEmail(), "[THÔNG BÁO]: Phê duyệt đơn đăng ký của sinh viên " + dondangky.get().getSinhvien().getHoTenSinhVien(),
                "Chúc mừng bạn đăng ký thành công ký túc xá");

//        hopdong.set
        return  new ResponseEntity<>(new APIResponse("duyệt thanh công", false, ""), HttpStatus.OK);
    }
}
