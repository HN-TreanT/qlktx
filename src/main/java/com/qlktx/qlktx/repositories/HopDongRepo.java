    package com.qlktx.qlktx.repositories;

    import com.qlktx.qlktx.entities.Hopdong;
    import com.qlktx.qlktx.entities.Phong;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    import java.util.List;

    @Repository

    public interface HopDongRepo extends JpaRepository<Hopdong, Long> {
        Hopdong findByMaSinhVien(Integer maSinhVien);
        List<Phong> findByMaSinhVienAndMaNV(Integer maSinhVien, Integer maNV);

        public  void deleteByMaHopDong(Integer MaHopDong);
    }