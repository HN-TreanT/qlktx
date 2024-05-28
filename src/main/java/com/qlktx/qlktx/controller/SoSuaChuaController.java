package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.SoSuaChuaDTO;
import com.qlktx.qlktx.dto.ThietBiDTO;
import com.qlktx.qlktx.services.SoSuaChuaService;
import com.qlktx.qlktx.services.ThietBiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/sosuachua")
public class SoSuaChuaController {
    @Autowired
    private SoSuaChuaService soSuaChuaService;
    
    @GetMapping("/list")
    public ResponseEntity<Object> list(
            @RequestParam(name = "page",required = false,defaultValue = "1") Integer page,
            @RequestParam(name = "limit",required = false,defaultValue = "10") Integer limit,
            @RequestParam(name = "soPhong", required = false) Integer soPhong,
            @RequestParam(name = "order_price", required = false) String order

    ) {
        Pageable pageable;

        // Check if order direction is specified
        if (order != null && order.equals("asc")) {
            pageable = PageRequest.of(page - 1, limit, Sort.by("thang").ascending());
        } else if (order != null && order.equals("desc")) {
            pageable = PageRequest.of(page - 1, limit, Sort.by("thang").descending());
        } else {
            pageable = PageRequest.of(page - 1, limit);
        }
        return soSuaChuaService.list(pageable, soPhong);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody @Valid SoSuaChuaDTO dto) {
        return soSuaChuaService.create(dto);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> edit(@PathVariable Integer id, @RequestBody @Valid SoSuaChuaDTO dto) {
        return soSuaChuaService.edit(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return soSuaChuaService.delete(id);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Object> detail(@PathVariable Integer id) {
        return soSuaChuaService.detail(id);
    }
}
