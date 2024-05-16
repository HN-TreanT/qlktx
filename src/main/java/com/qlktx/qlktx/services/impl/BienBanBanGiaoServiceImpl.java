package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.dto.BienBanBanGiaoDTO;
import com.qlktx.qlktx.entities.Bienbanbangiao;
import com.qlktx.qlktx.entities.Dondoiphong;
import com.qlktx.qlktx.entities.Sinhvien;
import com.qlktx.qlktx.payloads.APIResponse;
import com.qlktx.qlktx.repositories.BienBanBanGiaoRepo;
import com.qlktx.qlktx.repositories.SinhVienRepo;
import com.qlktx.qlktx.services.BienBanBanGiaoService;
import org.modelmapper.ModelMapper;
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
public class BienBanBanGiaoServiceImpl implements BienBanBanGiaoService {
    @Autowired
    private BienBanBanGiaoRepo bienBanBanGiaoRepo;
    @Autowired
    private SinhVienRepo sinhVienRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ResponseEntity<Object> list(Pageable pageable, Integer maSinhvien, LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc) {
        System.out.println(maSinhvien);
        Page<Bienbanbangiao> list = bienBanBanGiaoRepo.getListBienBanBanGiao(maSinhvien, ngayBatDau, ngayKetThuc, pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("page", pageable.getPageNumber() + 1);
        response.put("limit", pageable.getPageSize());
        response.put("totalElements", list.getTotalElements());
        response.put("totalPage", list.getTotalPages());
        response.put("data", list.getContent());
        return  ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Object> edit(Integer id, BienBanBanGiaoDTO dto) {
        Optional<Bienbanbangiao> bienbanbangiao = bienBanBanGiaoRepo.findById(id);
        if ( !bienbanbangiao.isPresent())    return  new ResponseEntity<>(new APIResponse("Không tìm thấy biên bản bàn giao", false, null), HttpStatus.NOT_FOUND);
        Optional<Sinhvien> sinhvien = sinhVienRepo.findById(dto.getMaSinhVien());
        if ( !sinhvien.isPresent())  return  new ResponseEntity<>(new APIResponse("Không tìm thấy sinh viên", false, null), HttpStatus.NOT_FOUND);;
        bienbanbangiao.get().setMaSinhVien(sinhvien.get());
        bienbanbangiao.get().setHoTenNguoiBanGiao(dto.getHoTenNguoiBanGiao());
        bienbanbangiao.get().setHoTenSinhVien(dto.getHoTenSinhVien());
        bienbanbangiao.get().setNgayBanGiao(dto.getNgayBanGiao());
        bienBanBanGiaoRepo.save(bienbanbangiao.get());
        return ResponseEntity.ok(new APIResponse("success", true, bienbanbangiao.get()));
    }

    @Override
    public ResponseEntity<Object> create(BienBanBanGiaoDTO dto) {
        Optional<Sinhvien> sinhvien = sinhVienRepo.findById(dto.getMaSinhVien());
        if ( !sinhvien.isPresent())  return  new ResponseEntity<>(new APIResponse("Không tìm thấy sinh viên", false, null), HttpStatus.NOT_FOUND);;
        Bienbanbangiao bienbanBanGiao = modelMapper.map(dto, Bienbanbangiao.class);
        bienbanBanGiao.setMaSinhVien(sinhvien.get());
        bienBanBanGiaoRepo.save(bienbanBanGiao);
        return ResponseEntity.ok(new APIResponse("success", true, bienbanBanGiao));
    }

    @Override
    public ResponseEntity<Object> delete(Integer id) {
        Optional<Bienbanbangiao> bienbanbangiao = bienBanBanGiaoRepo.findById(id);
        if ( !bienbanbangiao.isPresent())   return  new ResponseEntity<>(new APIResponse("Không tìm thấy biên bản bàn giao", false, null), HttpStatus.NOT_FOUND);
        bienBanBanGiaoRepo.delete(bienbanbangiao.get());
        return  new ResponseEntity<>(new APIResponse("success", true, null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> detail(Integer id) {
        Optional<Bienbanbangiao> bienbanbangiao = bienBanBanGiaoRepo.findById(id);
        if ( !bienbanbangiao.isPresent())   return  new ResponseEntity<>(new APIResponse("Không tìm thấy biên bản bàn giao", false, null), HttpStatus.NOT_FOUND);
        return  new ResponseEntity<>(new APIResponse("success", true, bienbanbangiao.get()), HttpStatus.OK);
    }
}
