package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.dto.SoSuaChuaDTO;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.entities.Sosuachua;
import com.qlktx.qlktx.entities.Thietbi;
import com.qlktx.qlktx.mapper.SoSuaChuaMapper;
import com.qlktx.qlktx.payloads.APIResponse;
import com.qlktx.qlktx.payloads.ThongKeDienNuoc;
import com.qlktx.qlktx.repositories.PhongRepo;
import com.qlktx.qlktx.repositories.SoSuaChuaRepo;
import com.qlktx.qlktx.repositories.ThietBiRepo;
import com.qlktx.qlktx.services.SoSuaChuaService;
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
public class SoSuaChuaServiceImpl implements SoSuaChuaService {
    @Autowired
    private SoSuaChuaRepo soSuaChuaRepo;
    @Autowired
    private PhongRepo phongRepo;
    @Autowired
    private SoSuaChuaMapper soSuaChuaMapper;
    @Autowired
    private ThietBiRepo thietBiRepo;
    @Override
    public ResponseEntity<Object> list(Pageable pageable, Integer soPhong) {
        Page<Sosuachua> list = soSuaChuaRepo.getListSoSuaChua(soPhong, pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("page", pageable.getPageNumber() + 1);
        response.put("limit", pageable.getPageSize());
        response.put("totalElements", list.getTotalElements());
        response.put("totalPage", list.getTotalPages());
        response.put("data", list.getContent());
        return  ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Object> edit(Integer id, SoSuaChuaDTO dto) {
        Optional<Sosuachua> sosuachua = soSuaChuaRepo.findById(id);
        if ( !sosuachua.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy số sửa chữa", false, null), HttpStatus.NOT_FOUND);
        Optional<Phong> phong = phongRepo.findById(dto.getSoPhong());
        Sosuachua sosuachuaupdate = soSuaChuaMapper.toEnity(dto);
        sosuachuaupdate.setMaSoSuaChua(sosuachua.get().getMaSoSuaChua());
        sosuachuaupdate.setMaPhieuThanhToan(dto.getMaPhieuThanhToan());
        if ( phong.isPresent()) {
            sosuachuaupdate.setPhong(phong.get());
        }
        Optional<Thietbi> thietbi = thietBiRepo.findById(dto.getMaThietBi());
        if ( thietbi.isPresent()) {
            sosuachuaupdate.setThietbi(thietbi.get());
        }
        soSuaChuaRepo.save(sosuachuaupdate);
        return ResponseEntity.ok(new APIResponse("success", true, sosuachua));
    }

    @Override
    public ResponseEntity<Object> create(SoSuaChuaDTO dto) {
        Optional<Phong> phong = phongRepo.findById(dto.getSoPhong());
        if ( !phong.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy đơn đổi phòng", false, null), HttpStatus.NOT_FOUND);
        Optional<Thietbi> thietbi = thietBiRepo.findById(dto.getMaThietBi());
        if ( !phong.isPresent())  return  new ResponseEntity<>(new APIResponse("Không tìm thấy thiết bị", false, null), HttpStatus.NOT_FOUND);
        Sosuachua sosuachua = soSuaChuaMapper.toEnity(dto);
        sosuachua.setMaPhieuThanhToan(dto.getMaPhieuThanhToan());
        sosuachua.setPhong(phong.get());
        sosuachua.setThietbi(thietbi.get());
        soSuaChuaRepo.save(sosuachua);
        return ResponseEntity.ok(new APIResponse("success", true, sosuachua));
    }

    @Override
    public ResponseEntity<Object> delete(Integer id) {
        Optional<Sosuachua> sosuachua = soSuaChuaRepo.findById(id);
        if ( !sosuachua.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy số sửa chữa", false, null), HttpStatus.NOT_FOUND);
        soSuaChuaRepo.delete(sosuachua.get());
        return ResponseEntity.ok(new APIResponse("success", true, null));
    }

    @Override
    public ResponseEntity<Object> detail(Integer id) {
        Optional<Sosuachua> sosuachua = soSuaChuaRepo.findById(id);
        if ( !sosuachua.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy số sửa chữa", false, null), HttpStatus.NOT_FOUND);
        soSuaChuaRepo.delete(sosuachua.get());
        return ResponseEntity.ok(new APIResponse("success", true, sosuachua));
    }

    @Override
    public ResponseEntity<Object> thongke() {
        Collection<ThongKeDienNuoc> thongKeDienNuocs = soSuaChuaRepo.thogke();
        return ResponseEntity.ok(thongKeDienNuocs);
    }
}
