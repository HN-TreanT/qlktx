package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.dto.ThietBiDTO;
import com.qlktx.qlktx.entities.Dondoiphong;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.entities.Thietbi;
import com.qlktx.qlktx.mapper.ThietBiMapper;
import com.qlktx.qlktx.payloads.APIResponse;
import com.qlktx.qlktx.repositories.PhongRepo;
import com.qlktx.qlktx.repositories.ThietBiRepo;
import com.qlktx.qlktx.services.ThietBiService;
import org.modelmapper.ModelMapper;
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
public class ThietBiServiceImpl implements ThietBiService {
    @Autowired
    private PhongRepo phongRepo;
    @Autowired
    private ThietBiRepo thietBiRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ThietBiMapper thietBiMapper;
    @Override
    public ResponseEntity<Object> list(Pageable pageable, Integer soPhong, String tenThietBi) {
        Page<Thietbi> list = thietBiRepo.getListThietBi(soPhong, tenThietBi, pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("page", pageable.getPageNumber() + 1);
        response.put("limit", pageable.getPageSize());
        response.put("totalElements", list.getTotalElements());
        response.put("totalPage", list.getTotalPages());
        response.put("data", list.getContent());
        return  ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Object> edit(Integer id, ThietBiDTO dto) {
        Optional<Thietbi> thietbi = thietBiRepo.findById(id);
        if ( !thietbi.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy thiết bị", false, null), HttpStatus.NOT_FOUND);
        Thietbi thietbiUpdate = thietBiMapper.toEntity(dto);
        thietbiUpdate.setMaThietBi(thietbi.get().getMaThietBi());
        Optional<Phong> phong = phongRepo.findById(dto.getSoPhong());
        if ( phong.isPresent()) {
            thietbiUpdate.setPhong(phong.get());
        }
        thietBiRepo.save(thietbiUpdate);
        return ResponseEntity.ok(new APIResponse("success", true, thietbiUpdate));
    }

    @Override
    public ResponseEntity<Object> create(ThietBiDTO dto) {
        Optional<Phong> phong = phongRepo.findById(dto.getSoPhong());
        if ( !phong.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy đơn đổi phòng", true, null), HttpStatus.NOT_FOUND);
        Thietbi thietbi = modelMapper.map(dto, Thietbi.class);
        thietbi.setPhong(phong.get());
        thietBiRepo.save(thietbi);
        return ResponseEntity.ok(new APIResponse("success", true, thietbi));
    }

    @Override
    public ResponseEntity<Object> delete(Integer id) {
        Optional<Thietbi> thietbi = thietBiRepo.findById(id);
        if ( !thietbi.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy thiết bị", false, null), HttpStatus.NOT_FOUND);
        thietBiRepo.delete(thietbi.get());
        return ResponseEntity.ok(new APIResponse("success", true, null));
    }

    @Override
    public ResponseEntity<Object> detail(Integer id) {
        Optional<Thietbi> thietbi = thietBiRepo.findById(id);
        if ( !thietbi.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy thiết bị", false, null), HttpStatus.NOT_FOUND);
        thietBiRepo.delete(thietbi.get());
        return ResponseEntity.ok(new APIResponse("success", true, thietbi));
    }
}
