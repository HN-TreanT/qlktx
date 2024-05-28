package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.LoaiPhongDTO;
import com.qlktx.qlktx.entities.Loaiphong;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.payloads.APIResponse;
import com.qlktx.qlktx.repositories.PhongRepo;
import com.qlktx.qlktx.services.LoaiPhongService;
import com.qlktx.qlktx.services.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/loaiphong")
@CrossOrigin("*")
public class LoaiPhongController {
    @Autowired
    private  LoaiPhongService loaiPhongService;

    @Autowired
    private PhongService phongService;

    @GetMapping("")
    public ResponseEntity<List<Loaiphong>> list(
    ) {
        List<Loaiphong> res = loaiPhongService.list();
        return  new ResponseEntity<List<Loaiphong>>(res, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody LoaiPhongDTO dto) {
        return ResponseEntity.ok(loaiPhongService.create(dto));
    }

    @PutMapping("/edit/{maLoaiPhong}")
    public  ResponseEntity<Object> edit(@PathVariable Integer maLoaiPhong, @RequestBody LoaiPhongDTO dto) {
        return ResponseEntity.ok(loaiPhongService.edit(maLoaiPhong, dto));
    }

    @DeleteMapping("/delete/{maLoaiPhong}")
    public  ResponseEntity<Object> delete(@PathVariable Integer maLoaiPhong) {
        return ResponseEntity.ok(loaiPhongService.delete(maLoaiPhong));
    }

}
