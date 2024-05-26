package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.dto.DonDangKyDTO;
import com.qlktx.qlktx.entities.Dondangky;
import com.qlktx.qlktx.entities.Sinhvien;
import com.qlktx.qlktx.payloads.APIResponse;
import com.qlktx.qlktx.repositories.DonDangKyRepo;
import com.qlktx.qlktx.repositories.SinhVienRepo;
import com.qlktx.qlktx.services.DonDangKyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Service
public class DonDangKyServiceImpl implements DonDangKyService {
    @Autowired
    private DonDangKyRepo donDangKyRepo;

    @Autowired
    private SinhVienRepo sinhVienRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Dondangky> list(String hoTenSinhVien, String doiTuongUuTien) {
        List<Dondangky> dondks = donDangKyRepo.findAll();
        return dondks;
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
}
