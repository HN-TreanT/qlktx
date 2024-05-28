package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.dto.SoDienNuocDTO;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.entities.Sodiennuoc;
import com.qlktx.qlktx.entities.Sosuachua;
import com.qlktx.qlktx.mapper.SoDienNuocMapper;
import com.qlktx.qlktx.payloads.APIResponse;
import com.qlktx.qlktx.payloads.ThongKeDienNuoc;
import com.qlktx.qlktx.repositories.PhongRepo;
import com.qlktx.qlktx.repositories.SoDienNuocRepo;
import com.qlktx.qlktx.services.SoDienNuocSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Service
public class SoDienNuocSerivceImpl  implements SoDienNuocSerivce {
    @Autowired
    private PhongRepo phongRepo;
    @Autowired
    private SoDienNuocRepo soDienNuocRepo;
    @Autowired
    private SoDienNuocMapper soDienNuocMapper;

    @Override
    public ResponseEntity<Object> list(Pageable pageable, Integer soPhong) {
        Page<Sodiennuoc> list = soDienNuocRepo.getListSoDieNuoc(soPhong, pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("page", pageable.getPageNumber() + 1);
        response.put("limit", pageable.getPageSize());
        response.put("totalElements", list.getTotalElements());
        response.put("totalPage", list.getTotalPages());
        response.put("data", list.getContent());
        return  ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Object> edit(Integer id, SoDienNuocDTO dto) {
        Optional<Sodiennuoc> sodiennuoc = soDienNuocRepo.findById(id);
        if ( !sodiennuoc.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy số sửa chữa", false, null), HttpStatus.NOT_FOUND);
        Optional<Phong> phong = phongRepo.findById(dto.getSoPhong());
        Sodiennuoc sodiennuocupdate = soDienNuocMapper.toEntity(dto);
        sodiennuocupdate.setMaSoDienNuoc(sodiennuoc.get().getMaSoDienNuoc());
        sodiennuocupdate.setMaPhieuThanhToan(dto.getMaPhieuThanhToan());
        if ( phong.isPresent()) {
            sodiennuocupdate.setPhong(phong.get());
        }
        soDienNuocRepo.save(sodiennuocupdate);
        return ResponseEntity.ok(new APIResponse("success", true, sodiennuocupdate));
    }

    @Override
    public ResponseEntity<Object> create(SoDienNuocDTO dto) {
        Optional<Phong> phong = phongRepo.findById(dto.getSoPhong());
        if ( !phong.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy phòng ", true, null), HttpStatus.NOT_FOUND);
        Sodiennuoc sodiennuoc = soDienNuocMapper.toEntity(dto);
        sodiennuoc.setPhong(phong.get());
        soDienNuocRepo.save(sodiennuoc);
        return ResponseEntity.ok(new APIResponse("success", true, sodiennuoc));
    }

    @Override
    public ResponseEntity<Object> delete(Integer id) {
        Optional<Sodiennuoc> sosuachua = soDienNuocRepo.findById(id);
        if ( !sosuachua.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy số điện nước", false, null), HttpStatus.NOT_FOUND);
        soDienNuocRepo.delete(sosuachua.get());
        return ResponseEntity.ok(new APIResponse("success", true, null));
    }

    @Override
    public ResponseEntity<Object> detail(Integer id) {
        Optional<Sodiennuoc> sodiennuoc = soDienNuocRepo.findById(id);
        if ( !sodiennuoc.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy số điện nước", false, null), HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(new APIResponse("success", true, sodiennuoc));
    }

    @Override
    public ResponseEntity<Object> thongke() {
        Collection<ThongKeDienNuoc> thongke = soDienNuocRepo.thongkediennuoc();
        return ResponseEntity.ok(thongke);
    }
}
