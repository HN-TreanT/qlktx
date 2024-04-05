package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.dto.PhongDTO;
import com.qlktx.qlktx.dto.SinhVienDTO;
import com.qlktx.qlktx.entities.Loaiphong;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.entities.Sinhvien;
import com.qlktx.qlktx.payloads.APIResponse;
import com.qlktx.qlktx.repositories.LoaiPhongRepo;
import com.qlktx.qlktx.repositories.PhongRepo;
import com.qlktx.qlktx.repositories.SinhVienRepo;
import com.qlktx.qlktx.services.PhongService;
import com.qlktx.qlktx.services.SinhVienService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SinhVienServiceImpl implements SinhVienService {
    @Autowired
    private SinhVienRepo SinhVienRepo;

    @Autowired
    private PhongRepo PhongRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Sinhvien> list(String hoTenSinhVien, String GioiTinh, String Khoa) {
        List<Sinhvien> danhsachSVs = SinhVienRepo.findAll();
        return danhsachSVs;
    }
    @Override
    public APIResponse create(SinhVienDTO dto) {
        if (dto.getSoPhong() != null) {
            Phong optionalPhong = PhongRepo.getReferenceById(dto.getSoPhong());

            Sinhvien sv = modelMapper.map(dto, Sinhvien.class);
            // Lưu phòng mới vào cơ sở dữ liệu
            SinhVienRepo.save(sv);

            // Trả về APIResponse thông báo thành công
            return new APIResponse("success created", true, sv);
        } else {
            Sinhvien sv = modelMapper.map(dto, Sinhvien.class);
            // Lưu phòng mới vào cơ sở dữ liệu
            SinhVienRepo.save(sv);
            return new APIResponse("MaPhong is null", true, sv);
        }
    }

    @Override
    @Transactional
    public APIResponse edit(Integer maSinhVien, SinhVienDTO dto) {
        // Tìm kiếm phòng cần chỉnh sửa
        Sinhvien sv = SinhVienRepo.findByMaSinhVien(maSinhVien);
        if (sv == null) {
            // Nếu không tìm thấy phòng, trả về thông báo lỗi
            return new APIResponse("Không tìm thấy sinh viên", false, "");
        }

        // Cập nhật thông tin của phòng dựa trên DTO
        sv.setHoTenSinhVien(dto.getHoTenSinhVien());
        sv.setCccd(dto.getCccd());
        sv.setEmail(dto.getEmail());
        sv.setDiaChiThuongTru(dto.getDiaChiThuongTru());
        sv.setKhoa(dto.getKhoa());
        sv.setGioiTinh(dto.getGioiTinh());
        sv.setLop(dto.getLop());
        sv.setSdt(dto.getSdt());
        // Tiếp tục cập nhật các trường khác nếu cần

        // Lưu các thay đổi vào cơ sở dữ liệu
        SinhVienRepo.save(sv);

        // Trả về thông báo thành công
        return new APIResponse("success", true, sv);
    }

    @Override
    @Transactional
    public APIResponse delete(Integer maSinhVien) {

        Sinhvien sv = SinhVienRepo.findByMaSinhVien(maSinhVien);
        if (sv == null) {
            // Nếu không tìm thấy phòng, trả về thông báo lỗi
            return new APIResponse("not found", false, "");
        }

        // Xóa phòng khỏi cơ sở dữ liệu
        SinhVienRepo.delete(sv);

        // Trả về thông báo thành công
        return new APIResponse("delete success", true, "");
    }
}
