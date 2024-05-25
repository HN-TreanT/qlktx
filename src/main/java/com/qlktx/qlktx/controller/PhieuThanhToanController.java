package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.PhieuThanhToanDTO;
import com.qlktx.qlktx.dto.SoSuaChuaDTO;
import com.qlktx.qlktx.services.PhieuThanhToanService;
import com.qlktx.qlktx.services.SoSuaChuaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/phieuthanhtoan")
public class PhieuThanhToanController {
    @Autowired
    private PhieuThanhToanService phieuThanhToanService;

    @GetMapping("/list")
    public ResponseEntity<Object> list(
            @RequestParam(name = "page",required = false,defaultValue = "1") Integer page,
            @RequestParam(name = "limit",required = false,defaultValue = "10") Integer limit,
            @RequestParam(name = "soPhong", required = false) Integer soPhong,
            @RequestParam(name = "time_start", required = false) LocalDateTime timeStart,
            @RequestParam(name = "time_end", required = false) LocalDateTime timeEnd,
            @RequestParam(name = "order_price", required = false) String order

    ) {
        Pageable pageable;
        // Check if order direction is specified
        if (order != null && order.equals("asc")) {
            pageable = PageRequest.of(page - 1, limit, Sort.by("soTien").ascending());
        } else if (order != null && order.equals("desc")) {
            pageable = PageRequest.of(page - 1, limit, Sort.by("soTien").descending());
        } else {
            pageable = PageRequest.of(page - 1, limit);
        }
        return phieuThanhToanService.list(pageable, soPhong, timeStart, timeEnd);
    }

    @GetMapping("/list-phieu-thang-toan-phong")
    public ResponseEntity<Object> listPhieuThanhToanPhong(
            @RequestParam(name = "page",required = false,defaultValue = "1") Integer page,
            @RequestParam(name = "limit",required = false,defaultValue = "10") Integer limit,
            @RequestParam(name = "soPhong", required = false) Integer soPhong,
            @RequestParam(name = "time_start", required = false) LocalDateTime timeStart,
            @RequestParam(name = "time_end", required = false) LocalDateTime timeEnd,
            @RequestParam(name = "order_price", required = false) String order

    ) {
        Pageable pageable;
        // Check if order direction is specified
        if (order != null && order.equals("asc")) {
            pageable = PageRequest.of(page - 1, limit, Sort.by("soTien").ascending());
        } else if (order != null && order.equals("desc")) {
            pageable = PageRequest.of(page - 1, limit, Sort.by("soTien").descending());
        } else {
            pageable = PageRequest.of(page - 1, limit);
        }
        return phieuThanhToanService.getListPhieuThanhToanTungPhong(pageable, soPhong, timeStart, timeEnd);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody @Valid PhieuThanhToanDTO dto) {
        return phieuThanhToanService.create(dto);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> edit(@PathVariable Integer id, @RequestBody @Valid PhieuThanhToanDTO dto) {
        return phieuThanhToanService.edit(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return phieuThanhToanService.delete(id);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Object> detail(@PathVariable Integer id) {
        return phieuThanhToanService.detail(id);
    }

    @GetMapping("/phieuthanhtoanthangnay")
    public ResponseEntity<Object> getPhieuThanhToanThangNay(@RequestParam("maPhong") Integer maPhong){
        return phieuThanhToanService.getPhieuThanhToanCuaThanhNayTheoPhong(maPhong);
    }
}
