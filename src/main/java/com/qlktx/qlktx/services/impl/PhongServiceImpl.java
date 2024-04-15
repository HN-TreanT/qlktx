package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.Converter.PhongConverter;
import com.qlktx.qlktx.dto.LoaiPhongDTO;
import com.qlktx.qlktx.dto.PhongDTO;
    import com.qlktx.qlktx.entities.Phong;
    import com.qlktx.qlktx.entities.Loaiphong;
    import com.qlktx.qlktx.payloads.APIResponse;
    import com.qlktx.qlktx.repositories.PhongRepo;
    import com.qlktx.qlktx.repositories.LoaiPhongRepo;
    import com.qlktx.qlktx.services.PhongService;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
    public class PhongServiceImpl implements PhongService {
        @Autowired
        private PhongRepo phongRepo;
        @Autowired
        private LoaiPhongRepo loaiPhongRepo;

        @Autowired
        private PhongConverter phongConverter;

        @Autowired
        private ModelMapper modelMapper;

        @Override
        public ResponseEntity<Map<String, Object>> list(Integer soTang, String soNha, String tenPhong, Integer trangThai, int page, int limit) {
            Pageable pageable = PageRequest.of(page -1 , limit, Sort.by("tenPhong"));
            Page<Phong> danhSachPhongs = phongRepo.getListPhong(soTang, soNha, tenPhong, trangThai, pageable);
            Map<String, Object> response = new HashMap<>();
            response.put("page", pageable.getPageNumber() + 1);
            response.put("limit", pageable.getPageSize());
            response.put("totalElements", danhSachPhongs.getTotalElements());
            response.put("totalPage", danhSachPhongs.getTotalPages());
            response.put("data", danhSachPhongs.getContent());
            return  ResponseEntity.ok(response);
        }
        @Override
        public ResponseEntity<Object> create(PhongDTO dto) {
            Optional<Loaiphong> optionalLoaiPhong = Optional.of(loaiPhongRepo.getReferenceById(dto.getMaLoaiPhong()));
            if (!optionalLoaiPhong.isPresent())  return new ResponseEntity<>("Không tìm thấy loại phòng", HttpStatus.NOT_FOUND);

            Phong phong = phongConverter.toEntity(dto);
            phong.setLoaiphong(optionalLoaiPhong.get());
            phongRepo.save(phong);
            APIResponse resposne = new APIResponse("Thêm mới phòng thành công", true, null);
            return new ResponseEntity<>(resposne, HttpStatus.CREATED);
        }


        @Override
        @Transactional
        public ResponseEntity<Object> edit(Integer soPhong, PhongDTO dto) {
            // Tìm kiếm phòng cần chỉnh sửa
            Phong phong = phongRepo.findBySoPhong(soPhong);
            if (phong == null) {
                return new ResponseEntity<>("Khoogn tìm thấy phòng", HttpStatus.NOT_FOUND);
            }
            phong.setTenPhong(dto.getTenPhong());
            phong.setSoTang(dto.getSoTang());
            phong.setSoNha(dto.getSoNha());
            phong.setTrangThai(dto.getTrangThai());
            phongRepo.save(phong);
            APIResponse resposne = new APIResponse("Chỉnh sửa phòng thành công", true, phong);
            return new ResponseEntity<Object>(resposne, HttpStatus.CREATED);
        }

        @Override
        @Transactional
        public ResponseEntity<Object> delete(Integer soPhong) {
            Phong phong = phongRepo.findBySoPhong(soPhong);
            if (phong == null) {
                return new ResponseEntity<>("Khoogn tìm thấy phòng", HttpStatus.NOT_FOUND);
            }
            phongRepo.delete(phong);
            APIResponse resposne = new APIResponse("Xóa phòng thành công", true, phong);
            return new ResponseEntity<Object>(resposne, HttpStatus.CREATED);
        }
    }
