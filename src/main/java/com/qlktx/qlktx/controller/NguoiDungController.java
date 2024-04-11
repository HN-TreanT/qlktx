package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.NguoiDungDTO;
import com.qlktx.qlktx.dto.TaiKhoanDTO;
import com.qlktx.qlktx.services.NguoiDungService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/nguoidung")
public class NguoiDungController {
    @Autowired
    private NguoiDungService nguoiDungService;
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid NguoiDungDTO dto) {
        return nguoiDungService.register(dto);
    }

    @PostMapping("/login")
    public  ResponseEntity<Object> login(@RequestBody @Valid TaiKhoanDTO taiKhoanDTO) {
        return nguoiDungService.login(taiKhoanDTO);
    }
}
