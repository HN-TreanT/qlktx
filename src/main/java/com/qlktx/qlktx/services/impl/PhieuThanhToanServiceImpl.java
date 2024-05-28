package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.dto.PhieuThanhToanDTO;
import com.qlktx.qlktx.entities.Hopdong;
import com.qlktx.qlktx.entities.Phieuthanhtoan;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.entities.Sodiennuoc;
import com.qlktx.qlktx.mapper.PhieuThanhToanMapper;
import com.qlktx.qlktx.payloads.APIResponse;
import com.qlktx.qlktx.payloads.PhieuThanhToanRes;
import com.qlktx.qlktx.payloads.ThongKeDienNuoc;
import com.qlktx.qlktx.repositories.*;
import com.qlktx.qlktx.services.PhieuThanhToanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class PhieuThanhToanServiceImpl implements PhieuThanhToanService {
    @Autowired
    private PhieuThanhToanRepo phieuThanhToanRepo;
    @Autowired
    private PhongRepo phongRepo;
    @Autowired
    private HopDongRepo hopDongRepo;
    @Autowired
    private PhieuThanhToanMapper phieuThanhToanMapper;
    @Autowired
    private SoSuaChuaRepo soSuaChuaRepo;
    @Autowired
    private SoDienNuocRepo soDienNuocRepo;
    @Autowired
    private PhieuPhatRepo phieuPhatRepo;
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
    public ResponseEntity<Object> getListPhieuThanhToanTungPhong(Pageable pageable, Integer soPhong, LocalDateTime timeStart, LocalDateTime timeEnd){
        Page<PhieuThanhToanRes> list = phieuThanhToanRepo.getPhieuThanhToanPhong(soPhong, timeStart, timeEnd, pageable);
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
        Optional<Phong> phong = phongRepo.findById(dto.getMaPhong());
        if (!phong.isPresent())  return  new ResponseEntity<>(new APIResponse("Không tìm thấy phòng", false, null), HttpStatus.NOT_FOUND);
        Phieuthanhtoan phieuthanhtoan = phieuThanhToanMapper.toEntity(dto);
        phieuthanhtoan.setPhong(phong.get());
        if(dto.getMaHopDong() != null) {
            Optional<Hopdong> hopdong = hopDongRepo.findById(dto.getMaHopDong());
            if (hopdong.isPresent()) phieuthanhtoan.setHopdong(hopdong.get());
        }
        phieuthanhtoan.setMaPhieuThanhToan(record.get().getMaPhieuThanhToan());
        phieuThanhToanRepo.save(phieuthanhtoan);
//        phieuThanhToanRepo.updatePhieuThanhToan(id, dto.getNoiDungThu(),dto.getNgayThu(), dto.getSoTien(), dto.getMaHopDong(), dto.getMaPhong(),
//                dto.getMaSinhVien(),dto.getMaPhieuPhat(), dto.getMaSoSuaChua(), dto.getMaSoDienNuoc());
        return ResponseEntity.ok(new APIResponse("success", true, null));
    }

    @Override
    @Transactional
    public ResponseEntity<Object> create(PhieuThanhToanDTO dto) {
//        phieuThanhToanRepo.insertPhieuThanhToan(dto.getNoiDungThu(),dto.getNgayThu(), dto.getSoTien(), dto.getMaHopDong(), dto.getMaPhong(),
//                dto.getMaSinhVien(),dto.getMaPhieuPhat(), dto.getMaSoSuaChua(), dto.getMaSoDienNuoc());
        Optional<Phong> phong = phongRepo.findById(dto.getMaPhong());
        if (!phong.isPresent())  return  new ResponseEntity<>(new APIResponse("Không tìm thấy phòng", false, null), HttpStatus.NOT_FOUND);
        Phieuthanhtoan phieuthanhtoan = phieuThanhToanMapper.toEntity(dto);
        phieuthanhtoan.setPhong(phong.get());
        if(dto.getMaHopDong() != null) {
            Optional<Hopdong> hopdong = hopDongRepo.findById(dto.getMaHopDong());
            if (hopdong.isPresent()) phieuthanhtoan.setHopdong(hopdong.get());
        }
        phieuThanhToanRepo.save(phieuthanhtoan);
        return ResponseEntity.ok(new APIResponse("success", true, phieuthanhtoan));
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
    @Transactional
    public ResponseEntity<Object> thanhtoan(Integer id, Float tongTien) {
        Optional<Phieuthanhtoan> phieuthanhtoan = Optional.ofNullable(id)
                .flatMap(phieuThanhToanRepo::findById);
        if (!phieuthanhtoan.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy phiếu thanh toán", false, null), HttpStatus.NOT_FOUND);
        soDienNuocRepo.updateThanhToan(id);
        soSuaChuaRepo.updateThanhToan(id);
        phieuPhatRepo.updateThanhToan(id);
        phieuthanhtoan.get().setTrangThai(1);
        phieuthanhtoan.get().setSoTien(tongTien);
        phieuThanhToanRepo.save(phieuthanhtoan.get());
        return new ResponseEntity<>(new APIResponse("Thanh toán thành công", true, null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getPhieuThanhToanCuaThanhNayTheoPhong(Integer soPhong) {
        Phieuthanhtoan phieuthanhtoan = phieuThanhToanRepo.getPhieuthanhtoanByPhong(soPhong);
        return ResponseEntity.ok(new APIResponse("success", true, phieuthanhtoan));
    }

    @Override
    public ResponseEntity<Object> thongke() {
        Collection<ThongKeDienNuoc> thongKeDienNuocs = phieuThanhToanRepo.thongke();
        return ResponseEntity.ok(thongKeDienNuocs);
    }
}
