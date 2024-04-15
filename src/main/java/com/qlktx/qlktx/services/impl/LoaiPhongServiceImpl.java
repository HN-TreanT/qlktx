package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.dto.LoaiPhongDTO;
import com.qlktx.qlktx.entities.Loaiphong;
import com.qlktx.qlktx.payloads.APIResponse;
import com.qlktx.qlktx.repositories.LoaiPhongRepo;
import com.qlktx.qlktx.services.LoaiPhongService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public  class LoaiPhongServiceImpl implements LoaiPhongService {
    @Autowired
    private LoaiPhongRepo loaiPhongRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Loaiphong> list() {
        List<Loaiphong> loaiphongs = loaiPhongRepo.findAll();
        return  loaiphongs;
    }

    @Override
    public APIResponse create(LoaiPhongDTO dto) {
        Loaiphong loaiPhong =modelMapper.map(dto, Loaiphong.class);
        loaiPhongRepo.save(loaiPhong);
        return new APIResponse("success created", true, loaiPhong);
    }

    @Override
    @Transactional
    public APIResponse edit(Integer maLoaiPhong, LoaiPhongDTO dto) {
        Loaiphong loaiphong = loaiPhongRepo.findByMaLoaiPhong(maLoaiPhong);
        if(loaiphong == null) return new APIResponse("not found", false, "");
        loaiphong.setTenLoaiPhong(dto.getTenLoaiPhong());
        loaiphong.setGhiChu(dto.getGhichu());
        loaiphong.setSoLuongNguoi(dto.getSoLuongNguoi());
        loaiPhongRepo.save(loaiphong);
        return new APIResponse("delete success", true, "");
    }

    @Override
    @Transactional
    public APIResponse delete(Integer maLoaiPhong) {
        Loaiphong loaiphong = loaiPhongRepo.findByMaLoaiPhong(maLoaiPhong);
        if(loaiphong == null) return new APIResponse("not found", false, "");
        loaiPhongRepo.deleteLoaiphongByMaLoaiPhong(maLoaiPhong);
        return new APIResponse("delete success", true, "");
    }
}
