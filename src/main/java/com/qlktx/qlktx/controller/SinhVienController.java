package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.HopDongDTO;
import com.qlktx.qlktx.dto.SinhVienDTO;
import com.qlktx.qlktx.entities.Hopdong;
import com.qlktx.qlktx.entities.Sinhvien;
import com.qlktx.qlktx.services.HopDongService;
import com.qlktx.qlktx.services.SinhVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/sinhvien")
public class SinhVienController {
    @Autowired
    private SinhVienService sinhVienService;

    @GetMapping("")
    public  ResponseEntity<Map<String, Object>> list(
            @RequestParam(name = "page",required = false,defaultValue = "1") int page,
            @RequestParam(name = "limit",required = false,defaultValue = "10") int limit,
            @RequestParam(name = "hoTenSinhVien", required = false) String hoTenSinhVien,
            @RequestParam(name = "GioiTinh", required = false) String GioiTinh,
            @RequestParam(name = "Khoa", required = false) String Khoa,
            @RequestParam(name = "soPhong", required = false) Integer soPhong
    ) {

        return  sinhVienService.list(page, limit, hoTenSinhVien, GioiTinh, Khoa, soPhong);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody @Valid SinhVienDTO dto) {
        return ResponseEntity.ok(sinhVienService.create(dto));
    }

    @PutMapping("/edit/{maSinhVien}")
    public ResponseEntity<Object> edit(@PathVariable Integer maSinhVien, @RequestBody SinhVienDTO dto) {
        return ResponseEntity.ok(sinhVienService.edit(maSinhVien, dto));
    }

    @DeleteMapping("/delete/{maSinhVien}")
    public ResponseEntity<Object> delete(@PathVariable Integer maSinhVien) {
        return ResponseEntity.ok(sinhVienService.delete(maSinhVien));
    }
}
