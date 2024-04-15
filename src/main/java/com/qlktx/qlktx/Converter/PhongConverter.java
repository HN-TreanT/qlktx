package com.qlktx.qlktx.Converter;

import com.qlktx.qlktx.dto.PhongDTO;
import com.qlktx.qlktx.entities.Phong;
import org.springframework.stereotype.Component;

@Component
public class PhongConverter {
    public Phong toEntity(PhongDTO dto){
        Phong phong = new Phong();
        phong.setSoNguoiO(dto.getSoNguoiO());
        phong.setSoNha(dto.getSoNha());
        phong.setTenPhong(dto.getTenPhong());
        phong.setTrangThai(dto.getTrangThai());
        phong.setSoTang(dto.getSoTang());
        return  phong;
    }
}
