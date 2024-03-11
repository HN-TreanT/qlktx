package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.PhongDTO;
import com.qlktx.qlktx.entities.Hopdong;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.services.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hopdong")
public class HopDongController {
    @Autowired
    private  HopDongService HopDongService;
    @GetMapping("")
    public ResponseEntity<List<Hopdong>> list(
            @RequestParam(name = "page",required = false,defaultValue = "1") int page,
            @RequestParam(name = "limit",required = false,defaultValue = "10") int limit,
            @RequestParam(name = "maSinhVien",required = false) Integer,
            @RequestParam(name = "maNV",required = false) Integer,
    ) {
        List<Phong> res = HopDongService.list(maSinhVien, maNV);
        return  new ResponseEntity<List<Hopdong>>(res, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody HopDongDTO dto) {
        return ResponseEntity.ok(HopDongService.create(dto));
    }

    @PutMapping("/edit/{maHopDong}")
    public  ResponseEntity<Object> edit(@PathVariable Integer soPhong, @RequestBody HopDongDTO dto) {
        return ResponseEntity.ok(PhongService.edit(soPhong, dto));
    }

    @PutMapping("/delete/{maHopDong}")
    public  ResponseEntity<Object> delete(@PathVariable Integer maHopDong) {
        return ResponseEntity.ok(HopDongService.delete(maHopDong));
    }

}
