package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.DonDangKyDTO;
import com.qlktx.qlktx.dto.DonDoiPhongDTO;
import com.qlktx.qlktx.entities.Dondangky;
import com.qlktx.qlktx.services.DonDangKyService;
import com.qlktx.qlktx.services.DonDoiPhongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1/dondoiphong")
@CrossOrigin
public class DonDoiPhongController {

    @Autowired
    private DonDoiPhongService donDoiPhongService;
    @GetMapping("/list")
    public ResponseEntity<Object> list(
            @RequestParam(name = "page",required = false,defaultValue = "1") Integer page,
            @RequestParam(name = "limit",required = false,defaultValue = "10") Integer limit,
            @RequestParam(name = "maPhong", required = false) Integer maPhong,
            @RequestParam(name = "maSinhvien", required = false) Integer maSinhvien

    ) {
        Pageable pageable = PageRequest.of(page - 1 , limit);
        return donDoiPhongService.list(pageable, maPhong, maSinhvien);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody @Valid DonDoiPhongDTO dto) {
        return donDoiPhongService.create(dto);
    }

    @PutMapping("/edit/{maDonDoiPhong}")
    public ResponseEntity<Object> edit(@PathVariable Integer maDonDoiPhong, @RequestBody @Valid DonDoiPhongDTO dto) {
        return donDoiPhongService.edit(maDonDoiPhong, dto);
    }

    @DeleteMapping("/delete/{maDonDoiPhong}")
    public ResponseEntity<Object> delete(@PathVariable Integer maDonDoiPhong) {
        return donDoiPhongService.delete(maDonDoiPhong);
    }

    @GetMapping("/detail/{maDonDoiPhong}")
    public ResponseEntity<Object> detail(@PathVariable Integer maDonDoiPhong) {
        return donDoiPhongService.detail(maDonDoiPhong);
    }
}
