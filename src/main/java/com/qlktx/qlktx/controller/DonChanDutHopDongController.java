package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.DonChamDutHopDongDTO;
import com.qlktx.qlktx.services.DonChamDutHopDongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/donchamduthopdong")
public class DonChanDutHopDongController {

    @Autowired
    private DonChamDutHopDongService donChamDutHopDongService;
    @GetMapping("/list")
    public ResponseEntity<Object> list(
            @RequestParam(name = "page",required = false,defaultValue = "1") Integer page,
            @RequestParam(name = "limit",required = false,defaultValue = "10") Integer limit,
            @RequestParam(name = "maPhong", required = false) Integer maPhong,
            @RequestParam(name = "maSinhvien", required = false) Integer maSinhvien

    ) {
        Pageable pageable = PageRequest.of(page - 1 , limit);
        return donChamDutHopDongService.list(pageable, maPhong, maSinhvien);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody @Valid DonChamDutHopDongDTO dto) {
        return donChamDutHopDongService.create(dto);
    }

    @PutMapping("/edit/{maDonDoiPhong}")
    public ResponseEntity<Object> edit(@PathVariable Integer maDonDoiPhong, @RequestBody @Valid DonChamDutHopDongDTO dto) {
        return donChamDutHopDongService.edit(maDonDoiPhong, dto);
    }

    @DeleteMapping("/delete/{maDonDoiPhong}")
    public ResponseEntity<Object> delete(@PathVariable Integer maDonDoiPhong) {
        return donChamDutHopDongService.delete(maDonDoiPhong);
    }

    @GetMapping("/detail/{maDonDoiPhong}")
    public ResponseEntity<Object> detail(@PathVariable Integer maDonDoiPhong) {
        return donChamDutHopDongService.detail(maDonDoiPhong);
    }
}
