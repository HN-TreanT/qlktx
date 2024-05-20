package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.entities.Phieuphat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PhieuPhatRepo extends JpaRepository<Phieuphat, Integer> {
    @Query("select pp from Phieuphat pp where " +
            "(:maPhong is null  or pp.phong.soPhong = :maPhong) and " +
            "(:timeStart is null  or :timeEnd is null  or (pp.ngayLapPhieu >= :timeStart and pp.ngayLapPhieu <= :timeEnd))")
    Page<Phieuphat> getListPhieuPhat(@Param("maPhong") Integer maPhong,
                                     @Param("timeStart") LocalDateTime timeStart,
                                     @Param("timeEnd") LocalDateTime timeEnd,
                                     Pageable pageable
                                     );
}
