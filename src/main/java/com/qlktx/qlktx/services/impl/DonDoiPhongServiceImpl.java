package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.dto.DonDoiPhongDTO;
import com.qlktx.qlktx.entities.Dondoiphong;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.entities.Sinhvien;
import com.qlktx.qlktx.payloads.APIResponse;
import com.qlktx.qlktx.repositories.DonDoiPhongRepo;
import com.qlktx.qlktx.repositories.PhongRepo;
import com.qlktx.qlktx.repositories.SinhVienRepo;
import com.qlktx.qlktx.services.DonDoiPhongService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class DonDoiPhongServiceImpl implements DonDoiPhongService {
    @Autowired
    private DonDoiPhongRepo donDoiPhongRepo;

    @Autowired
    private SinhVienRepo sinhVienRepo;

    @Autowired
    private PhongRepo phongRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Object> list(Pageable pageable, Integer maPhong, Integer maSinhvien) {
        Page<Dondoiphong> list = donDoiPhongRepo.getListDonDoiPhong(maPhong, maSinhvien, pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("page", pageable.getPageNumber() + 1);
        response.put("limit", pageable.getPageSize());
        response.put("totalElements", list.getTotalElements());
        response.put("totalPage", list.getTotalPages());
        response.put("data", list.getContent());
        return  ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Object> edit(Integer id, DonDoiPhongDTO donDoiPhongDTO) {
        Optional<Dondoiphong> dondoiphong = donDoiPhongRepo.findById(id);
        if ( !dondoiphong.isPresent()) return  new ResponseEntity<>("not found  đơn đổi phòng", HttpStatus.NOT_FOUND);
        Optional<Sinhvien> sinhvien = sinhVienRepo.findById(donDoiPhongDTO.getMaSinhVien());
        if ( !sinhvien.isPresent()) return  new ResponseEntity<>("not found sinh vien", HttpStatus.NOT_FOUND);
        Optional<Phong> phong = phongRepo.findById(donDoiPhongDTO.getMaPhong());
        if ( !phong.isPresent()) return  new ResponseEntity<>("not found  phong", HttpStatus.NOT_FOUND);
        dondoiphong.get().setNgayLamDon(donDoiPhongDTO.getNgayLamDon());
        dondoiphong.get().setLyDo(donDoiPhongDTO.getLyDo());
        dondoiphong.get().setPhong(phong.get());
        dondoiphong.get().setSinhvien(sinhvien.get());
        donDoiPhongRepo.save(dondoiphong.get());
        return  ResponseEntity.ok(new APIResponse("success", true, dondoiphong));
    }

    @Override
    public ResponseEntity<Object> create(DonDoiPhongDTO donDoiPhongDTO) {
        Optional<Sinhvien> sinhvien = sinhVienRepo.findById(donDoiPhongDTO.getMaSinhVien());
        if ( !sinhvien.isPresent()) return  new ResponseEntity<>("not found sinh vien", HttpStatus.NOT_FOUND);
        Optional<Phong> phong = phongRepo.findById(donDoiPhongDTO.getMaPhong());
        if ( !phong.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy đơn đổi phòng", true, null), HttpStatus.NOT_FOUND);
       Dondoiphong dondoiphong = modelMapper.map(donDoiPhongDTO, Dondoiphong.class);
       dondoiphong.setPhong(phong.get());
       dondoiphong.setSinhvien(sinhvien.get());
       donDoiPhongRepo.save(dondoiphong);
        return ResponseEntity.ok(new APIResponse("success", true, dondoiphong));
    }

    @Override
    public ResponseEntity<Object> delete(Integer id) {
        Optional<Dondoiphong> dondoiphong = donDoiPhongRepo.findById(id);
        if ( !dondoiphong.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy đơn đổi phòng", true, null), HttpStatus.NOT_FOUND);
        donDoiPhongRepo.delete(dondoiphong.get());
        return ResponseEntity.ok("success");
    }

    @Override
    public ResponseEntity<Object> detail(Integer id) {
        Optional<Dondoiphong> dondoiphong = donDoiPhongRepo.findById(id);
        if ( !dondoiphong.isPresent()) return  new ResponseEntity<>(new APIResponse("Không tìm thấy đơn đổi phòng", true, null), HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(new APIResponse("success", true, dondoiphong.get()));
    }

    @Override
    public ResponseEntity<Object> duyetDon(Integer ma_don) {
        Optional<Dondoiphong> dondoiphong = donDoiPhongRepo.findById(ma_don);
        if ( !dondoiphong.isPresent()) return  new ResponseEntity<>("not found  đơn đổi phòng", HttpStatus.NOT_FOUND);

        Phong oldPhong = dondoiphong.get().getSinhvien().getPhong();
        if (oldPhong != null) {
            oldPhong.setSoNguoiO(oldPhong.getSoNguoiO() - 1);
        }

        // update phong moi
        Phong newPhong = dondoiphong.get().getPhong();
        newPhong.setSoNguoiO(newPhong.getSoNguoiO() + 1);
        if (newPhong.getSoNguoiO() > newPhong.getLoaiphong().getSoLuongNguoi()) {
            return  new ResponseEntity<>(new APIResponse("Phòng " + newPhong.getTenPhong() + " đã đầy" , false, null), HttpStatus.OK);
        }

        dondoiphong.get().setTrangThai(1);
        phongRepo.save(newPhong);
        if (oldPhong != null) phongRepo.save(oldPhong);
        donDoiPhongRepo.save(dondoiphong.get());
        return  new ResponseEntity<>(new APIResponse("Duyệt thành công" , false, null), HttpStatus.OK);
    }
}
