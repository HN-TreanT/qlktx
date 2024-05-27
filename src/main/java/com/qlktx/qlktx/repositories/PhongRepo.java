    package com.qlktx.qlktx.repositories;

    import com.qlktx.qlktx.entities.Phong;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
    import org.springframework.stereotype.Repository;

    import java.util.List;

    @Repository

    public interface PhongRepo extends JpaRepository<Phong, Integer> {
        Phong findBySoPhong(Integer loaiPhong);
        @Query("select p from Phong p  where " +
                "(:soTang is null  or p.soTang = :soTang) and " +
                "(:soNha is null  or p.soNha = :soNha)  and " +
                "(:trangThai is null  or p.trangThai = :trangThai) and " +
                "(:tenPhong is null  or p.tenPhong = :tenPhong) and " +
                "(:maLoaiPhong is null or p.loaiphong.maLoaiPhong = :maLoaiPhong )")
        Page<Phong> getListPhong(@Param("soTang") Integer soTang,
                                 @Param("soNha") String soNha,
                                 @Param("tenPhong") String tenPhong,
                                 @Param("trangThai") Integer trangThai,
                                 @Param("maLoaiPhong") Integer maLoaiPhong,
                                 Pageable pageable);

        List<Phong> findAllByTrangThai(Integer trangThai);

    }