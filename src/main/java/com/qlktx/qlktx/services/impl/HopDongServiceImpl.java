
package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.dto.HopDongDTO;
import com.qlktx.qlktx.dto.LoaiPhongDTO;
import com.qlktx.qlktx.entities.Hopdong;
import com.qlktx.qlktx.entities.Loaiphong;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.entities.Sinhvien;
import com.qlktx.qlktx.payloads.APIResponse;
import com.qlktx.qlktx.repositories.HopDongRepo;
import com.qlktx.qlktx.repositories.LoaiPhongRepo;
import com.qlktx.qlktx.repositories.PhongRepo;
import com.qlktx.qlktx.repositories.SinhVienRepo;
import com.qlktx.qlktx.services.HopDongService;
import com.qlktx.qlktx.services.LoaiPhongService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public  class HopDongServiceImpl implements HopDongService {
    @Autowired
    private HopDongRepo hopDongRepo;

    @Autowired
    private SinhVienRepo sinhVienRepo;

    @Autowired
    private PhongRepo phongRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Hopdong> list(String trangThai) {
        if (trangThai != null) {
            return hopDongRepo.findByTrangThai(trangThai);
        } else {
            return hopDongRepo.findAll();
        }
    }

    @Override
    public APIResponse create(HopDongDTO dto) {
        if (dto.getMaSinhVien() == null ) {
            return new APIResponse("MaSinhVien is null", false, "");
        }
        else if (dto.getSoPhong() == null ) {
            return new APIResponse("soPhong is null", false, "");
        }
        else {
            Sinhvien optionalSV = sinhVienRepo.getReferenceById(dto.getMaSinhVien());
            Phong optionalPhong = phongRepo.getReferenceById(dto.getSoPhong());

            Hopdong hopDong = modelMapper.map(dto, Hopdong.class);
            // Lưu phòng mới vào cơ sở dữ liệu
            hopDongRepo.save(hopDong);

            // Trả về APIResponse thông báo thành công
            return new APIResponse("success created", true, hopDong);

        }
    }

    @Override
    @Transactional
    public APIResponse edit(Integer maHopDong, HopDongDTO dto) {
        Hopdong hopdong = hopDongRepo.findByMaHopDong(maHopDong);
        if(hopdong == null) return new APIResponse("not found", false, "");

        if(dto.getNgayHopDong() != null) {
            hopdong.setNgayHopDong(dto.getNgayHopDong());
        }
        if(dto.getThoiGianChoThue() != null) {
            hopdong.setThoiGianChoThue(dto.getThoiGianChoThue());
        }
        if(dto.getThoiGianHetHan() != null) {
            hopdong.setThoiGianHetHan(dto.getThoiGianHetHan());
        }
        if(dto.getTrangThai() != null) {
            hopdong.setTrangThai(dto.getTrangThai());
        }
        if(dto.getTienCoc() != null) {
            hopdong.setTienCoc(dto.getTienCoc());
        }
        if(dto.getSoPhong() != null) {
            Phong ph = phongRepo.findBySoPhong(dto.getSoPhong());
            if (ph != null) {
                hopdong.setPhong(ph);
            }
        }

        hopDongRepo.save(hopdong);
        return new APIResponse("success edit", true, hopdong);
    }


    @Override
    @Transactional
    public APIResponse delete(Integer maHopDong) {
        Hopdong hopDong = hopDongRepo.findByMaHopDong(maHopDong);
        if(hopDong == null) return new APIResponse("not found", false, "");
        hopDongRepo.deleteByMaHopDong(maHopDong);
        return new APIResponse("delete success", true, "");
    }
}
