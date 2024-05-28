package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.NguoiDungDTO;
import com.qlktx.qlktx.dto.RefreshTokenDTO;
import com.qlktx.qlktx.dto.TaiKhoanDTO;
import com.qlktx.qlktx.services.NguoiDungService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/nguoidung")
@CrossOrigin("*")
public class NguoiDungController {
    @Autowired
    private NguoiDungService nguoiDungService;
    @GetMapping("/list")
    public  ResponseEntity<Map<String, Object>> list(
            @RequestParam(name = "page",required = false,defaultValue = "1") int page,
            @RequestParam(name = "limit",required = false,defaultValue = "10") int limit,
            @RequestParam(name = "idNhom",required = false) Integer idNhom,
            @RequestParam(name = "tenNv",required = false) String tenNv,
            @RequestParam(name = "chucVu",required = false) String chucVu
    ) {
        return  nguoiDungService.list(idNhom, tenNv, chucVu, page, limit);
    }
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid NguoiDungDTO dto) {
        return nguoiDungService.register(dto);
    }

    @PostMapping("/login")
    public  ResponseEntity<Object> login(@RequestBody @Valid TaiKhoanDTO taiKhoanDTO) {
        return nguoiDungService.login(taiKhoanDTO);
    }

    @PostMapping("/refresh")
    public  ResponseEntity<Object> refresh(@RequestBody RefreshTokenDTO refresh_token) {
        return nguoiDungService.refresh(refresh_token.getRefresh_token());
    }


}
