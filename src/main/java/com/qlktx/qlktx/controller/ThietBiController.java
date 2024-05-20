package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.BienBanBanGiaoDTO;
import com.qlktx.qlktx.dto.ThietBiDTO;
import com.qlktx.qlktx.services.ThietBiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("api/v1/thietbi")
public class ThietBiController {
    @Autowired
    private ThietBiService thietBiService;

    @GetMapping("/list")
    public ResponseEntity<Object> list(
            @RequestParam(name = "page",required = false,defaultValue = "1") Integer page,
            @RequestParam(name = "limit",required = false,defaultValue = "10") Integer limit,
            @RequestParam(name = "soPhong", required = false) Integer soPhong,
            @RequestParam(name = "tenThietBi", required = false) String tenThietBi,
            @RequestParam(name = "order_price", required = false) String order
    ) {
        Pageable pageable;

        // Check if order direction is specified
        if (order != null && order.equals("asc")) {
            pageable = PageRequest.of(page - 1, limit, Sort.by("giaSuaChua").ascending());
        } else if (order != null && order.equals("desc")) {
            pageable = PageRequest.of(page - 1, limit, Sort.by("giaSuaChua").descending());
        } else {
            pageable = PageRequest.of(page - 1, limit);
        }

        return thietBiService.list(pageable, soPhong, tenThietBi);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody @Valid ThietBiDTO dto) {
        return thietBiService.create(dto);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> edit(@PathVariable Integer id, @RequestBody @Valid ThietBiDTO dto) {
        return thietBiService.edit(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return thietBiService.delete(id);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Object> detail(@PathVariable Integer id) {
        return thietBiService.detail(id);
    }
}
