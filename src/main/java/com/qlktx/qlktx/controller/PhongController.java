package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.PhongDTO;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.services.PhongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/phong")
@CrossOrigin("*")
public class PhongController {
    @Autowired
    private  PhongService PhongService;
    @GetMapping("")
    public  ResponseEntity<Map<String, Object>> list(
            @RequestParam(name = "page",required = false,defaultValue = "1") int page,
            @RequestParam(name = "limit",required = false,defaultValue = "10") int limit,
            @RequestParam(name = "soTang",required = false) Integer soTang,
            @RequestParam(name = "tenPhong",required = false) String tenPhong,
            @RequestParam(name = "soNha",required = false) String soNha,
            @RequestParam(name = "trangThai",required = false) Integer trangThai,
            @RequestParam(name = "maLoaiPhong", required = false) Integer maLoaiPhong
    ) {
        return  PhongService.list(soTang, soNha, tenPhong, trangThai, page, limit, maLoaiPhong);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody @Valid PhongDTO dto) {
        return PhongService.create(dto);
    }

    @PutMapping("/edit/{soPhong}")
    public  ResponseEntity<Object> edit(@PathVariable Integer soPhong, @RequestBody @Valid PhongDTO dto) {
        return PhongService.edit(soPhong, dto);
    }

    @PutMapping("/delete/{soPhong}")
    public  ResponseEntity<Object> delete(@PathVariable Integer soPhong) {
        return PhongService.delete(soPhong);
    }

}
