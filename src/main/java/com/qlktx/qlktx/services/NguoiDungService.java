package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.NguoiDungDTO;
import com.qlktx.qlktx.dto.TaiKhoanDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface NguoiDungService {
//    UserDetails loadUserByUserName(String username);
    ResponseEntity<Object> register(NguoiDungDTO dto);
    ResponseEntity<Object> login(TaiKhoanDTO taiKhoanDTO);
}
