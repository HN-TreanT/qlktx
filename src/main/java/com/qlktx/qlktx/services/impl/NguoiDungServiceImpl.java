package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.Custom.CustomUserDetails;
import com.qlktx.qlktx.dto.NguoiDungDTO;
import com.qlktx.qlktx.dto.TaiKhoanDTO;
import com.qlktx.qlktx.entities.Nguoidung;
import com.qlktx.qlktx.entities.Nhomnguoidung;
import com.qlktx.qlktx.repositories.NguoiDungRepo;
import com.qlktx.qlktx.repositories.NhomNguoiDungRepo;
import com.qlktx.qlktx.services.NguoiDungService;
import com.qlktx.qlktx.utils.jwt.IJwtService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {
    @Autowired
    private NguoiDungRepo nguoiDungRepo;
    @Autowired
    private NhomNguoiDungRepo nhomNguoiDungRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IJwtService iJwtService;

    @Override
    public ResponseEntity<Map<String, Object>> list(Integer idNhom, String tenNv, String chucVu, int page, int limit) {
        Pageable pageable = PageRequest.of(page -1 , limit);
        Page<Nguoidung> danhSachNguois = nguoiDungRepo.getNguoiDung(idNhom, tenNv, chucVu, pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("page", pageable.getPageNumber() + 1);
        response.put("limit", pageable.getPageSize());
        response.put("totalElements", danhSachNguois.getTotalElements());
        response.put("totalPage", danhSachNguois.getTotalPages());
        response.put("data", danhSachNguois.getContent());
        return  ResponseEntity.ok(response);
    }
    @Override
    public ResponseEntity<Object> register(NguoiDungDTO dto) {
        BCryptPasswordEncoder bcypt = new BCryptPasswordEncoder();
        Optional<Nguoidung> optionalNguoidung = Optional.ofNullable(nguoiDungRepo.findTopByTenDangNhap(dto.getTenDangNhap()));
        if (optionalNguoidung.isPresent()) {
            return new ResponseEntity<>("Đã tồn tại tên đăng nhập", HttpStatus.BAD_REQUEST);
        }
        String encryptedPwd = bcypt.encode(dto.getMatKhau());
        Nhomnguoidung nhomnguoidung = nhomNguoiDungRepo.getReferenceById(dto.getId_nhom());
        Nguoidung nguoidung = modelMapper.map(dto, Nguoidung.class);
        System.out.println(nguoidung);
        nguoidung.setNhomnguoidung(nhomnguoidung);
        nguoidung.setMatKhau(encryptedPwd);
        nguoiDungRepo.save(nguoidung);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<Object> login(TaiKhoanDTO taiKhoanDTO) {
        BCryptPasswordEncoder bcypt = new BCryptPasswordEncoder();

        Optional<Nguoidung> opNguoidung = Optional.ofNullable(nguoiDungRepo.findTopByTenDangNhap(taiKhoanDTO.getUsername()));
        if (opNguoidung.isEmpty()) {
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }

        String jwtToken = iJwtService.generateToken(opNguoidung.get());

        if (bcypt.matches(taiKhoanDTO.getPassword(), opNguoidung.get().getMatKhau())) {
            Map<String, Object> res = new HashMap<>();
            res.put("access_token", jwtToken);
            res.put("nguoidung", opNguoidung.get());
            return  new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("login fail", HttpStatus.BAD_REQUEST);
        }


    }
}
