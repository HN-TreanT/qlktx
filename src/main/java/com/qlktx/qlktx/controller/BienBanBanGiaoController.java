package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.BienBanBanGiaoDTO;
import com.qlktx.qlktx.dto.DonDoiPhongDTO;
import com.qlktx.qlktx.services.BienBanBanGiaoService;
import com.qlktx.qlktx.services.DonDoiPhongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("api/v1/bienbanbangiao")
public class BienBanBanGiaoController {
    @Autowired
    private BienBanBanGiaoService bienBanBanGiaoService;
    @GetMapping("/list")
    public ResponseEntity<Object> list(
            @RequestParam(name = "page",required = false,defaultValue = "1") Integer page,
            @RequestParam(name = "limit",required = false,defaultValue = "10") Integer limit,
            @RequestParam(name = "maSinhvien", required = false) Integer maSinhvien,
            @RequestParam(name = "ngayBatDau", required = false) String ngayBatDau,
            @RequestParam(name = "ngayKetThuc", required = false) String ngayKetThuc

    ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime timeStart2 = ngayBatDau != null ? LocalDateTime.parse(ngayBatDau, formatter) : null;
        LocalDateTime timeEnd2 = ngayBatDau != null ? LocalDateTime.parse(ngayKetThuc, formatter) : null;
        Pageable pageable = PageRequest.of(page - 1 , limit);
        return bienBanBanGiaoService.list(pageable, maSinhvien, timeStart2, timeEnd2);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody @Valid BienBanBanGiaoDTO dto) {
        return bienBanBanGiaoService.create(dto);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> edit(@PathVariable Integer id, @RequestBody @Valid BienBanBanGiaoDTO dto) {
        return bienBanBanGiaoService.edit(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return bienBanBanGiaoService.delete(id);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Object> detail(@PathVariable Integer id) {
        return bienBanBanGiaoService.detail(id);
    }
}
