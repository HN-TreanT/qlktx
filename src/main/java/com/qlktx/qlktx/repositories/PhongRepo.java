    package com.qlktx.qlktx.repositories;

    import com.qlktx.qlktx.entities.Phong;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    import java.util.List;

    @Repository

    public interface PhongRepo extends JpaRepository<Phong, Integer> {
        Phong findBySoPhong(Integer soPhong);
        List<Phong> findBySoPhongAndSoNhaAndTrangThai(Integer soPhong, String soNha, String trangThai);

        public  void deleteBySoPhong(Integer soPhong);
    }