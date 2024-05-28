package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.LoaiPhongDTO;
import com.qlktx.qlktx.entities.Loaiphong;
import com.qlktx.qlktx.entities.Nhomnguoidung;
import com.qlktx.qlktx.repositories.NhomNguoiDungRepo;
import com.qlktx.qlktx.services.LoaiPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/nhomNguoiDung")
@CrossOrigin("*")
public class NhomNguoiDungController {
    @Autowired
    private NhomNguoiDungRepo nhomNguoiDungRepo;
    @GetMapping("")
    public ResponseEntity<Object> list() {
        return ResponseEntity.ok(nhomNguoiDungRepo.findAll());
    }

//    @Autowired
//    private  LoaiPhongService loaiPhongService;
//    @GetMapping("")
//    public ResponseEntity<List<Loaiphong>> list(
//            @RequestParam(name = "page",required = false,defaultValue = "1") int page,
//            @RequestParam(name = "limit",required = false,defaultValue = "10") int limit,
//            @RequestParam(name = "tenLoaiPhong",required = false) String tenLoaiPhong,
//            @RequestParam(name = "soLuongNguoi",required = false) Integer soLuongNguoi
//    ) {
//        List<Loaiphong> res = loaiPhongService.list(tenLoaiPhong, soLuongNguoi);
//        return  new ResponseEntity<List<Loaiphong>>(res, HttpStatus.OK);
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<Object> create(@RequestBody LoaiPhongDTO dto) {
//        return ResponseEntity.ok(loaiPhongService.create(dto));
//    }
//
//    @PutMapping("/edit/{maLoaiPhong}")
//    public  ResponseEntity<Object> edit(@PathVariable Integer maLoaiPhong, @RequestBody LoaiPhongDTO dto) {
//        return ResponseEntity.ok(loaiPhongService.edit(maLoaiPhong, dto));
//    }
//
//    @PutMapping("/delete/{maLoaiPhong}")
//    public  ResponseEntity<Object> delete(@PathVariable Integer maLoaiPhong) {
//        return ResponseEntity.ok(loaiPhongService.delete(maLoaiPhong));
//    }

}
