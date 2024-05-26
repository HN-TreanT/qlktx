package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.dto.DonChamDutHopDongDTO;
import com.qlktx.qlktx.entities.Donchamduthopdong;
import com.qlktx.qlktx.entities.Dondoiphong;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.entities.Sinhvien;
import com.qlktx.qlktx.mapper.DonchamduthopdongMapper;
import com.qlktx.qlktx.payloads.APIResponse;
import com.qlktx.qlktx.repositories.DonChamDutHopDongRepo;
import com.qlktx.qlktx.repositories.PhongRepo;
import com.qlktx.qlktx.repositories.SinhVienRepo;
import com.qlktx.qlktx.services.DonChamDutHopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class DonChamDutHopDongImpl implements DonChamDutHopDongService {
    @Autowired
    private DonChamDutHopDongRepo donChamDutHopDongRepo;
    @Autowired
    private SinhVienRepo sinhVienRepo;
    @Autowired
    private PhongRepo phongRepo;
    @Autowired
    private DonchamduthopdongMapper donchamduthopdongMapper;
    @Override
    public ResponseEntity<Object> list(Pageable pageable, Integer maPhong, Integer maSinhvien) {
        Page<Donchamduthopdong> list = donChamDutHopDongRepo.getList(maPhong, maSinhvien, pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("page", pageable.getPageNumber() + 1);
        response.put("limit", pageable.getPageSize());
        response.put("totalElements", list.getTotalElements());
        response.put("totalPage", list.getTotalPages());
        response.put("data", list.getContent());
        return  ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Object> edit(Integer id, DonChamDutHopDongDTO dto) {
        Optional<Donchamduthopdong> donchamduthopdong = donChamDutHopDongRepo.findById(id);
        if (!donchamduthopdong.isPresent()) return  new ResponseEntity<>("Không tìm thấy đơn chấm dứt hợp đồng", HttpStatus.NOT_FOUND);
        Donchamduthopdong donchamduthopdongUpdate = donchamduthopdongMapper.toEntity(dto);
        donchamduthopdongUpdate.setMaDonChamDut(id);
        Optional<Sinhvien> sinhvien = Optional.ofNullable(dto.getMaSinhVien()).flatMap(sinhVienRepo::findById);
        if (sinhvien.isPresent()) donchamduthopdongUpdate.setSinhvien(sinhvien.get());
        Optional<Phong> phong = Optional.ofNullable(dto.getSoPhong()).flatMap(phongRepo::findById);
        if (phong.isPresent()) donchamduthopdongUpdate.setPhong(phong.get());
        donChamDutHopDongRepo.save(donchamduthopdongUpdate);
        return ResponseEntity.ok(new APIResponse("success", true, donchamduthopdongUpdate));
    }

    @Override
    public ResponseEntity<Object> create(DonChamDutHopDongDTO dto) {
        Optional<Sinhvien> sinhvien = Optional.ofNullable(dto.getMaSinhVien()).flatMap(sinhVienRepo::findById);
        if (!sinhvien.isPresent())   return  new ResponseEntity<>("not found sinh vien", HttpStatus.NOT_FOUND);
        Donchamduthopdong donchamduthopdong = donchamduthopdongMapper.toEntity(dto);
        donchamduthopdong.setSinhvien(sinhvien.get());
        Optional<Phong> phong = Optional.ofNullable(dto.getSoPhong()).flatMap(phongRepo::findById);
        if (phong.isPresent()) donchamduthopdong.setPhong(phong.get());
        donChamDutHopDongRepo.save(donchamduthopdong);
        return ResponseEntity.ok(new APIResponse("success", true, donchamduthopdong));
    }

    @Override
    public ResponseEntity<Object> delete(Integer id) {
        Optional<Donchamduthopdong> record = donChamDutHopDongRepo.findById(id);
        if ( !record.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy đơn đổi phòng", true, null), HttpStatus.NOT_FOUND);
        donChamDutHopDongRepo.delete(record.get());
        return ResponseEntity.ok("success");
    }

    @Override
    public ResponseEntity<Object> detail(Integer id) {
        Optional<Donchamduthopdong> record = donChamDutHopDongRepo.findById(id);
        if ( !record.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy đơn đổi phòng", true, null), HttpStatus.NOT_FOUND);
        return  ResponseEntity.ok(new APIResponse("success", true, record.get()));
    }
}
