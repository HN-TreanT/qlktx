package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.PhieuPhatDTO;
import com.qlktx.qlktx.dto.PhieuThanhToanDTO;
import com.qlktx.qlktx.services.PhieuPhatService;
import com.qlktx.qlktx.services.PhieuThanhToanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/phieuphat")
@CrossOrigin("*")
public class PhieuPhatController {
    @Autowired
    private PhieuPhatService phieuPhatService;

    @GetMapping("/list")
    public ResponseEntity<Object> list(
            @RequestParam(name = "page",required = false,defaultValue = "1") Integer page,
            @RequestParam(name = "limit",required = false,defaultValue = "10") Integer limit,
            @RequestParam(name = "soPhong", required = false) Integer soPhong,
            @RequestParam(name = "time_start", required = false) LocalDateTime timeStart,
            @RequestParam(name = "time_end", required = false) LocalDateTime timeEnd

    ) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        return phieuPhatService.list(pageable, soPhong, timeStart, timeEnd);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody @Valid PhieuPhatDTO dto) {
        return phieuPhatService.create(dto);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> edit(@PathVariable Integer id, @RequestBody @Valid PhieuPhatDTO dto) {
        return phieuPhatService.edit(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return phieuPhatService.delete(id);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Object> detail(@PathVariable Integer id) {
        return phieuPhatService.detail(id);
    }

    @GetMapping("/thongke")
    public  ResponseEntity<Object> thongke() {
        return phieuPhatService.thongke();
    }
}
