package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.SoDienNuocDTO;
import com.qlktx.qlktx.dto.SoSuaChuaDTO;
import com.qlktx.qlktx.services.SoDienNuocSerivce;
import com.qlktx.qlktx.services.SoSuaChuaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sodiennuoc")
@CrossOrigin("*")
public class SoDienNuocController {
    @Autowired
    private SoDienNuocSerivce soDienNuocSerivce;

    @GetMapping("/list")
    public ResponseEntity<Object> list(
            @RequestParam(name = "page",required = false,defaultValue = "1") Integer page,
            @RequestParam(name = "limit",required = false,defaultValue = "10") Integer limit,
            @RequestParam(name = "soPhong", required = false) Integer soPhong
    ) {
        Pageable pageable = PageRequest.of(page - 1, limit);;
        return soDienNuocSerivce.list(pageable, soPhong);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody @Valid SoDienNuocDTO dto) {
        return soDienNuocSerivce.create(dto);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> edit(@PathVariable Integer id, @RequestBody @Valid SoDienNuocDTO dto) {
        return soDienNuocSerivce.edit(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return soDienNuocSerivce.delete(id);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Object> detail(@PathVariable Integer id) {
        return soDienNuocSerivce.detail(id);
    }

    @GetMapping("/thongke")
    public ResponseEntity<Object> thongke() {
        return soDienNuocSerivce.thongke();
    }
}
