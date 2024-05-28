package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.HopDongDTO;
import com.qlktx.qlktx.entities.Hopdong;
import com.qlktx.qlktx.services.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/hopdong")
@CrossOrigin("*")
public class HopDongController {
    @Autowired
    private HopDongService hopDongService;

    @GetMapping("")
    public ResponseEntity<Map<String, Object>> list(
            @RequestParam(name = "page",required = false,defaultValue = "1") int page,
            @RequestParam(name = "limit",required = false,defaultValue = "10") int limit,
            @RequestParam(name = "tenSinhVien", required = false) String tenSinhVien,
            @RequestParam(name = "trangThai", required = false) String trangThai,
            @RequestParam(name = "timeStart", required = false) String timeStart,
            @RequestParam(name = "timeEnd", required = false) String timeEnd
    ) {
        return  hopDongService.list(tenSinhVien, trangThai, timeStart, timeEnd, page, limit);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody HopDongDTO dto) {
        return ResponseEntity.ok(hopDongService.create(dto));
    }

    @PutMapping("/edit/{maHopDong}")
    public ResponseEntity<Object> edit(@PathVariable Integer maHopDong, @RequestBody HopDongDTO dto) {
        return ResponseEntity.ok(hopDongService.edit(maHopDong, dto));
    }

    @PutMapping("/delete/{maHopDong}")
    public ResponseEntity<Object> delete(@PathVariable Integer maHopDong) {
        return ResponseEntity.ok(hopDongService.delete(maHopDong));
    }
}
