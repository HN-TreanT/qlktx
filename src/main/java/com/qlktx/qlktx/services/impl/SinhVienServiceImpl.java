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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SinhVienServiceImpl implements SinhVienService {
    @Autowired
    private SinhVienRepo sinhVienRepo;

    @Autowired
    private PhongRepo phongRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Map<String, Object>> list(int page, int limit , String hoTenSinhVien , String GioiTinh, String Khoa, Integer soPhong) {
        Pageable pageable = PageRequest.of(page -1 , limit);
        Map<String, Object> response = new HashMap<>();
        Page<Sinhvien> list = sinhVienRepo.getSinhVien(hoTenSinhVien, GioiTinh, Khoa, soPhong, pageable);
        response.put("page", pageable.getPageNumber() + 1);
        response.put("limit", pageable.getPageSize());
        response.put("totalElements", list.getTotalElements());
        response.put("totalPage", list.getTotalPages());
        response.put("data", list.getContent());
        return  ResponseEntity.ok(response);
    }
    @Override
    public APIResponse create(SinhVienDTO dto) {
        System.out.println(dto);
        if (dto.getSoPhong() != null) {
            Phong optionalPhong = phongRepo.getReferenceById(dto.getSoPhong());
            Sinhvien sv = modelMapper.map(dto, Sinhvien.class);
            sv.setPhong(optionalPhong);
            sinhVienRepo.save(sv);
            return new APIResponse("success created", true, sv);
        } else {
            Sinhvien sv = modelMapper.map(dto, Sinhvien.class);
            sinhVienRepo.save(sv);
            return new APIResponse("MaPhong is null", true, sv);
        }
    }

    @Override
    @Transactional
    public APIResponse edit(Integer maSinhVien, SinhVienDTO dto) {

        Sinhvien sv = sinhVienRepo.findByMaSinhVien(maSinhVien);
        if (sv == null) {
            return new APIResponse("Không tìm thấy sinh viên", false, "");
        }

        if (dto.getSoPhong() != sv.getPhong().getSoPhong()) {
             Optional<Phong> phong = phongRepo.findById(dto.getSoPhong());
             if (!phong.isPresent()) return new APIResponse("Không tìm thấy phòng", false, "");
             sv.setPhong(phong.get());
        }
        sv.setHoTenSinhVien(dto.getHoTenSinhVien());
        sv.setCccd(dto.getCccd());
        sv.setEmail(dto.getEmail());
        sv.setDiaChiThuongTru(dto.getDiaChiThuongTru());
        sv.setKhoa(dto.getKhoa());
        sv.setGioiTinh(dto.getGioiTinh());
        sv.setLop(dto.getLop());
        sv.setSdt(dto.getSdt());
        sinhVienRepo.save(sv);
        return new APIResponse("success", true, sv);
    }

    @Override
    @Transactional
    public APIResponse delete(Integer maSinhVien) {

        Sinhvien sv = sinhVienRepo.findByMaSinhVien(maSinhVien);
        if (sv == null) {
            // Nếu không tìm thấy phòng, trả về thông báo lỗi
            return new APIResponse("not found", false, "");
        }

        // Xóa phòng khỏi cơ sở dữ liệu
        sinhVienRepo.delete(sv);

        // Trả về thông báo thành công
        return new APIResponse("delete success", true, "");
    }
}
