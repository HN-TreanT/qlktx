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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("api/v1/phieuthanhtoan")
@CrossOrigin("*")
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
            @RequestParam(name = "time_start", required = false) String timeStart,
            @RequestParam(name = "time_end", required = false) String timeEnd,
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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate timeStart2 = timeStart != null ? LocalDate.parse(timeStart, formatter) : null;
        LocalDate timeEnd2 = timeEnd != null ? LocalDate.parse(timeEnd, formatter) : null;
//        LocalDateTime start = timeStart != null ?  LocalDateTime.parse(timeStart, formatter) : null;
//        LocalDateTime end = timeEnd != null ? LocalDateTime.parse(timeEnd, formatter) : null;
        if (timeStart != null && timeEnd != null && timeStart.equals(timeEnd)) {
            LocalDate time1 = LocalDate.parse(timeStart, formatter);
            LocalDateTime timeStartConvert = time1.atStartOfDay();
            LocalDateTime timeEndConvert = time1.atTime(LocalTime.MAX);
            return phieuThanhToanService.getListPhieuThanhToanTungPhong(pageable, soPhong, timeEndConvert, timeEndConvert);
        }
        return phieuThanhToanService.getListPhieuThanhToanTungPhong(pageable, soPhong, timeStart2 != null ? timeStart2.atStartOfDay() : null, timeEnd2 != null ? timeEnd2.atTime(LocalTime.MAX) : null);
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

    @GetMapping("/thanhtoan")
    public  ResponseEntity<Object> thanhtoan(@RequestParam("id") Integer id, @RequestParam("tong_tien") Float tongTien) {
        return phieuThanhToanService.thanhtoan(id, tongTien);
    }
}
