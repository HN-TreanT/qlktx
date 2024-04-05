    package com.qlktx.qlktx.repositories;

    import com.qlktx.qlktx.entities.Hopdong;
    import com.qlktx.qlktx.entities.Sinhvien;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    import java.util.List;

    @Repository

    public interface SinhVienRepo extends JpaRepository<Sinhvien, Integer> {
        Sinhvien findByMaSinhVien(Integer maSinhVien);
        List<Hopdong> findByHoTenSinhVienAndGioiTinhAndKhoa(String hoTenSinhVien, String GioiTinh, String Khoa);

        public  void deleteByMaSinhVien(Integer MaSinhVien);

    }