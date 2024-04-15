    package com.qlktx.qlktx.repositories;

    import com.qlktx.qlktx.entities.Hopdong;
    import com.qlktx.qlktx.entities.Phong;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
    import org.springframework.stereotype.Repository;

    import java.time.LocalDateTime;
    import java.util.List;

    @Repository

    public interface HopDongRepo extends JpaRepository<Hopdong, Integer> {
        Hopdong findByMaHopDong(Integer maHopDong);
        public  void deleteByMaHopDong(Integer MaHopDong);


        @Query("select hd from Hopdong  hd where " +
                "(:tenSinhvien is null or hd.sinhvien.hoTenSinhVien like %:tenSinhvien%) and " +
                "(:trangThai is null or hd.trangThai = :trangThai) and " +
                "(:timeStart is null or :timeEnd is null or (hd.ngayHopDong > :timeStart and hd.ngayHopDong <= :timeEnd))")
        Page<Hopdong> getHopDong(@Param("tenSinhvien") String tenSinhvien,
                                 @Param("trangThai") String trangThai,
                                 @Param("timeStart") LocalDateTime timeStart,
                                 @Param("timeEnd") LocalDateTime timeEnd,
                                 Pageable pageable);

    }