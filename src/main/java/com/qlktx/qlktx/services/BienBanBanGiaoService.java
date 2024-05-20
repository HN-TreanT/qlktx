package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.BienBanBanGiaoDTO;
import com.qlktx.qlktx.dto.DonDoiPhongDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public interface BienBanBanGiaoService {
    ResponseEntity<Object> list(Pageable pageable, Integer maSinhvien, LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc);
    ResponseEntity<Object> edit(Integer id, BienBanBanGiaoDTO dto);
    ResponseEntity<Object> create(BienBanBanGiaoDTO dto);
    ResponseEntity<Object> delete(Integer id);
    ResponseEntity<Object> detail(Integer id);
}
