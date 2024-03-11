package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.PhongDTO;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.services.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/phong")
public class PhongController {
    @Autowired
    private  PhongService PhongService;
    @GetMapping("")
    public ResponseEntity<List<Phong>> list(
            @RequestParam(name = "page",required = false,defaultValue = "1") int page,
            @RequestParam(name = "limit",required = false,defaultValue = "10") int limit,
            @RequestParam(name = "soPhong",required = false) Integer soPhong,
            @RequestParam(name = "soNha",required = false) String soNha,
            @RequestParam(name = "trangThai",required = false) String trangThai
    ) {
        List<Phong> res = PhongService.list(soPhong, soNha, trangThai);
        return  new ResponseEntity<List<Phong>>(res, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody PhongDTO dto) {
        return ResponseEntity.ok(PhongService.create(dto));
    }

    @PutMapping("/edit/{soPhong}")
    public  ResponseEntity<Object> edit(@PathVariable Integer soPhong, @RequestBody PhongDTO dto) {
        return ResponseEntity.ok(PhongService.edit(soPhong, dto));
    }

    @PutMapping("/delete/{soPhong}")
    public  ResponseEntity<Object> delete(@PathVariable Integer soPhong) {
        return ResponseEntity.ok(PhongService.delete(soPhong));
    }

}
