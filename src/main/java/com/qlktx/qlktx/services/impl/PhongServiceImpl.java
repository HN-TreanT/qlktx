package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.dto.LoaiPhongDTO;
import com.qlktx.qlktx.dto.PhongDTO;
    import com.qlktx.qlktx.entities.Phong;
    import com.qlktx.qlktx.entities.Loaiphong;
    import com.qlktx.qlktx.payloads.APIResponse;
    import com.qlktx.qlktx.repositories.PhongRepo;
    import com.qlktx.qlktx.repositories.LoaiPhongRepo;
    import com.qlktx.qlktx.services.PhongService;
    import org.modelmapper.ModelMapper;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;
    import java.util.Optional;

    import java.util.List;

    @Service
    public class PhongServiceImpl implements PhongService {
        @Autowired
        private PhongRepo phongRepo;

        @Autowired
        private LoaiPhongRepo loaiPhongRepo;

        @Autowired
        private ModelMapper modelMapper;

        @Override
        public List<Phong> list(Integer soPhong, String soNha, String trangThai) {
            List<Phong> danhSachPhongs = phongRepo.findAll();
            return danhSachPhongs;
        }

        @Override
        public APIResponse create(PhongDTO dto) {
            Loaiphong optionalLoaiPhong = loaiPhongRepo.getReferenceById(dto.getMaLoaiPhong());

            Phong phong = modelMapper.map(dto, Phong.class);
            phong.setLoaiphong(optionalLoaiPhong);

            phongRepo.save(phong);

            return new APIResponse("success created", true);
        }

        @Override
        @Transactional
        public APIResponse edit(Integer soPhong, PhongDTO dto) {
            // Tìm kiếm phòng cần chỉnh sửa
            Phong phong = phongRepo.findBySoPhong(soPhong);
            if (phong == null) {
                // Nếu không tìm thấy phòng, trả về thông báo lỗi
                return new APIResponse("Không tìm thấy phòng", false);
            }

            // Cập nhật thông tin của phòng dựa trên DTO
            phong.setTenPhong(dto.getTenPhong());
            phong.setSoTang(dto.getSoTang());
            phong.setSoNha(dto.getSoNha());
            phong.setTrangThai(dto.getTrangThai());
            // Tiếp tục cập nhật các trường khác nếu cần

            // Lưu các thay đổi vào cơ sở dữ liệu
            phongRepo.save(phong);

            // Trả về thông báo thành công
            return new APIResponse("Chỉnh sửa phòng thành công", true);
        }

        @Override
        @Transactional
        public APIResponse delete(Integer soPhong) {
            // Tìm kiếm phòng cần xóa
            Phong phong = phongRepo.findBySoPhong(soPhong);
            if (phong == null) {
                // Nếu không tìm thấy phòng, trả về thông báo lỗi
                return new APIResponse("Không tìm thấy phòng", false);
            }

            // Xóa phòng khỏi cơ sở dữ liệu
            phongRepo.delete(phong);

            // Trả về thông báo thành công
            return new APIResponse("Xóa phòng thành công", true);
        }
    }
