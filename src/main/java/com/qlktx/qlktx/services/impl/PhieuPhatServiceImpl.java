package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.dto.PhieuPhatDTO;
import com.qlktx.qlktx.dto.PhieuThanhToanDTO;
import com.qlktx.qlktx.entities.*;
import com.qlktx.qlktx.mapper.PhieuPhatMapper;
import com.qlktx.qlktx.payloads.APIResponse;
import com.qlktx.qlktx.repositories.NguoiDungRepo;
import com.qlktx.qlktx.repositories.PhieuPhatRepo;
import com.qlktx.qlktx.repositories.PhongRepo;
import com.qlktx.qlktx.repositories.ThietBiRepo;
import com.qlktx.qlktx.services.PhieuPhatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PhieuPhatServiceImpl implements PhieuPhatService {
    @Autowired
    private PhieuPhatRepo phieuPhatRepo;
    @Autowired
    private PhieuPhatMapper phieuPhatMapper;
    @Autowired
    private PhongRepo phongRepo;
    @Autowired
    private NguoiDungRepo nguoiDungRepo;
    @Autowired
    private ThietBiRepo thietBiRepo;
    @Override
    public ResponseEntity<Object> list(Pageable pageable, Integer maPhong, LocalDateTime timeStart, LocalDateTime timeEnd) {
        Page<Phieuphat> list = phieuPhatRepo.getListPhieuPhat(maPhong, timeStart, timeEnd, pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("page", pageable.getPageNumber() + 1);
        response.put("limit", pageable.getPageSize());
        response.put("totalElements", list.getTotalElements());
        response.put("totalPage", list.getTotalPages());
        response.put("data", list.getContent());
        return  ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Object> edit(Integer id, PhieuPhatDTO dto) {
        Optional<Phieuphat> record = phieuPhatRepo.findById(id);
        if ( !record.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy phiếu phạt", false, null), HttpStatus.NOT_FOUND);
        Phieuphat phieuphat = phieuPhatMapper.toEntity(dto);
        Optional<Nguoidung> nguoidung = nguoiDungRepo.findById(dto.getIdNV());
        if (nguoidung.isPresent()) phieuphat.setNguoidung(nguoidung.get());
        Optional<Phong> phong = phongRepo.findById(dto.getMaPhong());
        if ( phong.isPresent()) phieuphat.setPhong(phong.get());
//        Thietbi thietbi = thietBiRepo.findById(dto.getMaThietbi()).orElseThrow(null);
//        phieuphat.setThietbi(thietbi);
        phieuphat.setMaPhieuPhat(record.get().getMaPhieuPhat());
        phieuPhatRepo.save(phieuphat);
        return ResponseEntity.ok(new APIResponse("success", true, phieuphat));
    }

    @Override
    public ResponseEntity<Object> create(PhieuPhatDTO dto) {
        System.out.println(dto);
        Optional<Nguoidung> record = nguoiDungRepo.findById(dto.getIdNV());
        if ( !record.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy nhân viên", false, null), HttpStatus.NOT_FOUND);
        Optional<Phong> phong = phongRepo.findById(dto.getMaPhong());
        if ( !phong.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy phopngf", false, null), HttpStatus.NOT_FOUND);
        Phieuphat phieuphat = phieuPhatMapper.toEntity(dto);
        phieuphat.setMaPhieuThanhToan(dto.getMaPhieuThanhToan());
        phieuphat.setPhong(phong.get());
        phieuphat.setNguoidung(record.get());

        Optional<Thietbi> thietbi = thietBiRepo.findById(dto.getMaThietbi());
        if ( thietbi.isPresent()) phieuphat.setThietbi(thietbi.get());
        phieuPhatRepo.save(phieuphat);
        return ResponseEntity.ok(new APIResponse("success", true, phieuphat));
    }

    @Override
    public ResponseEntity<Object> delete(Integer id) {
        Optional<Phieuphat> record = phieuPhatRepo.findById(id);
        if ( !record.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy phiếu phạt", false, null), HttpStatus.NOT_FOUND);
        phieuPhatRepo.delete(record.get());
        return ResponseEntity.ok(new APIResponse("success", true, null));
    }

    @Override
    public ResponseEntity<Object> detail(Integer id) {
        Optional<Phieuphat> record = phieuPhatRepo.findById(id);
        if ( !record.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy phiếu phạt", false, null), HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(new APIResponse("success", true, record.get()));
    }
}
