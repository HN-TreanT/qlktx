package com.qlktx.qlktx.component;

import com.qlktx.qlktx.entities.Phieuthanhtoan;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.repositories.PhieuThanhToanRepo;
import com.qlktx.qlktx.repositories.PhongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduledTask {
    @Autowired
    private PhieuThanhToanRepo phieuThanhToanRepo;
    @Autowired
    private PhongRepo phongRepo;
    @Scheduled(cron = "0 0 0 1 * ?")
    public void createPhieuThanhToan() {
        try {
            List<Phong> phongs = phongRepo.findAllByTrangThai(1);
            LocalDateTime now = LocalDateTime.now();
            List<Phieuthanhtoan> phieuthanhtoans = new ArrayList<>();
            for (Phong phong: phongs) {
                Phieuthanhtoan phieuthanhtoan = new Phieuthanhtoan();
                phieuthanhtoan.setHopdong(null);
                phieuthanhtoan.setPhong(phong);
                phieuthanhtoan.setTrangThai(0);
                phieuthanhtoan.setNgayThu(now);
                phieuthanhtoan.setSinhvien(null);
                phieuthanhtoan.setSoTien((float) 0);
                phieuthanhtoan.setNoiDungThu("Tiền thu  tháng");
                phieuthanhtoans.add(phieuthanhtoan);
            }
            phieuThanhToanRepo.saveAll(phieuthanhtoans);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
