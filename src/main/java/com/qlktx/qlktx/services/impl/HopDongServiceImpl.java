//package com.qlktx.qlktx.services.impl;
//
//import com.qlktx.qlktx.dto.HopDongDTO;
//import com.qlktx.qlktx.dto.LoaiPhongDTO;
//import com.qlktx.qlktx.entities.Hopdong;
//import com.qlktx.qlktx.entities.Loaiphong;
//import com.qlktx.qlktx.payloads.APIResponse;
//import com.qlktx.qlktx.repositories.HopDongRepo;
//import com.qlktx.qlktx.repositories.LoaiPhongRepo;
//import com.qlktx.qlktx.services.HopDongService;
//import com.qlktx.qlktx.services.LoaiPhongService;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public  class HopDongServiceImpl implements HopDongService {
//    @Autowired
//    private HopDongRepo hopDongRepo;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    @Override
//    public List<Hopdong> list(Integer maSinhVien, Integer maNV) {
////        List<Loaiphong> loaiphongs = HopDong.findByTenLoaiPhongLikeAndSoLuongNguoi(tenLoaiPhong, soNguoi);
//        List<Hopdong> hopdongs = hopDongRepo.findAll();
//
//        return  hopdongs;
//    }
//
//    @Override
//    public APIResponse create(HopDongDTO dto) {
//        Hopdong hopDong =modelMapper.map(dto, Hopdong.class);
//        hopDongRepo.save(hopDong);
//        return new APIResponse("success created", true);
//    }
//
//    @Override
//    @Transactional
//    public APIResponse edit(Integer maSinhVien, Integer maNV) {
//        Hopdong hopdong = loaiPhongRepo.findByMaSinhVien(maSinhVien);
//        if(hopdong == null) return new APIResponse("not found", false);
////        Loaiphong maploaiphong  = modelMapper.map(dto, loaiphong.getClass());
//        hopdong.setTenLoaiPhong(dto.getTenLoaiPhong());
//        hopdong.setGhiChu(dto.getGhichu());
//        hopdong.setSoLuongNguoi(dto.getSoLuongNguoi());
//        hopdong.save(loaiphong);
//        return null;
//    }
//
//    @Override
//    @Transactional
//    public APIResponse delete(Integer maLoaiPhong) {
//        Loaiphong loaiphong = loaiPhongRepo.findByMaLoaiPhong(maLoaiPhong);
//        if(loaiphong == null) return new APIResponse("not found", false);
//        loaiPhongRepo.deleteLoaiphongByMaLoaiPhong(maLoaiPhong);
//        return new APIResponse("delete success", true);
//    }
//}
