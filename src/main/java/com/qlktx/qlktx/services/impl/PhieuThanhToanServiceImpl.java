package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.dto.PhieuThanhToanDTO;
import com.qlktx.qlktx.entities.Phieuthanhtoan;
import com.qlktx.qlktx.entities.Sodiennuoc;
import com.qlktx.qlktx.mapper.PhieuThanhToanMapper;
import com.qlktx.qlktx.payloads.APIResponse;
import com.qlktx.qlktx.repositories.PhieuThanhToanRepo;
import com.qlktx.qlktx.repositories.PhongRepo;
import com.qlktx.qlktx.services.PhieuThanhToanService;
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
public class PhieuThanhToanServiceImpl implements PhieuThanhToanService {
    @Autowired
    private PhieuThanhToanRepo phieuThanhToanRepo;
    @Autowired
    private PhongRepo phongRepo;
    @Autowired
    private PhieuThanhToanMapper phieuThanhToanMapper;
    @Override
    public ResponseEntity<Object> list(Pageable pageable, Integer soPhong, LocalDateTime timeStart, LocalDateTime timeEnd) {
        Page<Phieuthanhtoan> list = phieuThanhToanRepo.getListPhieuThanhToan(soPhong, timeStart, timeEnd, pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("page", pageable.getPageNumber() + 1);
        response.put("limit", pageable.getPageSize());
        response.put("totalElements", list.getTotalElements());
        response.put("totalPage", list.getTotalPages());
        response.put("data", list.getContent());
        return  ResponseEntity.ok(response);
    }

    @Override
    @Transactional
    public ResponseEntity<Object> edit(Integer id, PhieuThanhToanDTO dto) {
        Optional<Phieuthanhtoan> record = phieuThanhToanRepo.findById(id);
        if (!record.isPresent()) {
            return  new ResponseEntity<>(new APIResponse("Không tìm thấy phiếu thanh toán", false, null), HttpStatus.NOT_FOUND);
        }
        phieuThanhToanRepo.updatePhieuThanhToan(id, dto.getNoiDungThu(),dto.getNgayThu(), dto.getSoTien(), dto.getMaHopDong(), dto.getMaPhong(),
                dto.getMaSinhVien(),dto.getMaPhieuPhat(), dto.getMaSoSuaChua(), dto.getMaSoDienNuoc());
        return ResponseEntity.ok(new APIResponse("success", true, null));
    }

    @Override
    @Transactional
    public ResponseEntity<Object> create(PhieuThanhToanDTO dto) {
        phieuThanhToanRepo.insertPhieuThanhToan(dto.getNoiDungThu(),dto.getNgayThu(), dto.getSoTien(), dto.getMaHopDong(), dto.getMaPhong(),
                dto.getMaSinhVien(),dto.getMaPhieuPhat(), dto.getMaSoSuaChua(), dto.getMaSoDienNuoc());
        return ResponseEntity.ok(new APIResponse("success", true, null));
    }

    @Override
    public ResponseEntity<Object> delete(Integer id) {
        Optional<Phieuthanhtoan> record = phieuThanhToanRepo.findById(id);
        if ( !record.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy phiếu thanh toán", false, null), HttpStatus.NOT_FOUND);
        phieuThanhToanRepo.delete(record.get());
        return ResponseEntity.ok(new APIResponse("success", true, null));
    }

    @Override
    public ResponseEntity<Object> detail(Integer id) {
        Optional<Phieuthanhtoan> record = phieuThanhToanRepo.findById(id);
        if ( !record.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy phiếu thanh toán", false, null), HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(new APIResponse("success", true, record.get()));
    }

    @Override
    public ResponseEntity<Object> thanhtoan(Integer id) {
        return null;
    }
}
