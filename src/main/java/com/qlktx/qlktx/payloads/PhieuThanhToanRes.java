package com.qlktx.qlktx.payloads;

import java.time.LocalDateTime;

public interface PhieuThanhToanRes {
     String getTen_phong();
     Integer getMa_phieu_thanh_toan();
     Integer getSo_phong();
     LocalDateTime getNgay_thu();
     String getNoi_dung_thu();
     Float getSo_tien();
     Integer getTrang_thai();
     Float getTongtienDiennuoc();
     Float getTongtienSuachua();
     Float getTongtienPhat();
}
