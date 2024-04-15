    package com.qlktx.qlktx.repositories;

    import com.qlktx.qlktx.entities.Hopdong;
    import com.qlktx.qlktx.entities.Sinhvien;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
    import org.springframework.stereotype.Repository;

    import java.util.List;

    @Repository

    public interface SinhVienRepo extends JpaRepository<Sinhvien, Integer> {
        Sinhvien findByMaSinhVien(Integer maSinhVien);


        @Query("select sv from Sinhvien sv where " +
                "(:GioiTinh is null  or sv.gioiTinh = :GioiTinh) and " +
                "(:Khoa is null  or sv.khoa = :Khoa) and " +
                "(:hoTenSinhVien is null  or sv.hoTenSinhVien like %:hoTenSinhVien%) and " +
                "(:soPhong is null  or sv.phong.soPhong = :soPhong )")
        Page<Sinhvien> getSinhVien(@Param("hoTenSinhVien") String hoTenSinhVien ,
                                      @Param("GioiTinh") String GioiTinh,
                                      @Param("Khoa") String Khoa,
                                      @Param("soPhong") Integer soPhong, Pageable pageable);

    }