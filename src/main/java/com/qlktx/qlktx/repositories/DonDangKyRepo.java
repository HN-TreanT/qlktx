    package com.qlktx.qlktx.repositories;

    import com.qlktx.qlktx.entities.Dondangky;
    import com.qlktx.qlktx.entities.Hopdong;
    import com.qlktx.qlktx.entities.Sinhvien;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.stereotype.Repository;
    import org.springframework.web.bind.annotation.RequestParam;

    import java.util.List;

    @Repository
    public interface DonDangKyRepo extends JpaRepository<Dondangky, Integer> {
        Dondangky findByMaDonDangKy(Integer maDonDangKy);

        @Query("select ddk from Dondangky ddk where :trangThai is null or ddk.trangThai = :trangThai")
        Page<Dondangky> findAllDon(@RequestParam("trangThai") String trangThai,  Pageable pageable);

    }