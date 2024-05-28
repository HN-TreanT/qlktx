package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.DonDangKyDTO;
import com.qlktx.qlktx.entities.Dondangky;
import com.qlktx.qlktx.services.DonDangKyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/dondangky")
@CrossOrigin("*")
public class DonDangKyController {
    @Autowired
    private DonDangKyService donDangKyService;
    @GetMapping("")
    public ResponseEntity<Object> list(
            @RequestParam(name = "page",required = false,defaultValue = "1") int page,
            @RequestParam(name = "limit",required = false,defaultValue = "10") int limit,
            @RequestParam(name = "hoTenSinhVien", required = false) String hoTenSinhVien,
            @RequestParam(name = "doiTuongUuTien", required = false) String doiTuongUuTien

    ) {
        Pageable pageable = PageRequest.of(page - 1 , limit);
        return donDangKyService.list(hoTenSinhVien, doiTuongUuTien, pageable);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody DonDangKyDTO dto) {
        return ResponseEntity.ok(donDangKyService.create(dto));
    }

    @PutMapping("/edit/{maDonDangKy}")
    public ResponseEntity<Object> edit(@PathVariable Integer maDonDangKy, @RequestBody DonDangKyDTO dto) {
        return ResponseEntity.ok(donDangKyService.edit(maDonDangKy, dto));
    }

    @PutMapping("/delete/{maDonDangKy}")
    public ResponseEntity<Object> delete(@PathVariable Integer maDonDangKy) {
        return ResponseEntity.ok(donDangKyService.delete(maDonDangKy));
    }
}
