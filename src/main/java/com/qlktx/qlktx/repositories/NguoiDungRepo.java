package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.dto.TaiKhoanDTO;
import com.qlktx.qlktx.entities.Nguoidung;
import com.qlktx.qlktx.entities.Sinhvien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiDungRepo extends JpaRepository<Nguoidung, Integer> {
    Nguoidung findByIdNv(Integer idNv);
    Nguoidung findTopByTenDangNhap(String TenDangNhap);

    @Query("select sv from Nguoidung sv where " +
            "(:idNhom is null  or sv.nhomnguoidung.idNhom = :idNhom) and " +
            "(:chucVu is null  or sv.chucVu = :chucVu) and " +
            "(:tenNv is null  or sv.tenNv = :tenNv)")
    Page<Nguoidung> getNguoiDung(@Param("idNhom") Integer idNhom,
                                 @Param("tenNv") String tenNv ,
                                 @Param("chucVu") String chucVu,
                                 Pageable pageable);

}