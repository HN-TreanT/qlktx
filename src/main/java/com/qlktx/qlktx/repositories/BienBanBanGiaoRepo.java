package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.entities.Bienbanbangiao;
import com.qlktx.qlktx.entities.Dondoiphong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface BienBanBanGiaoRepo extends JpaRepository<Bienbanbangiao, Integer > {

    @Query("select bbg from Bienbanbangiao bbg " +
            "where (:maSinhvien is null or bbg.maSinhVien.maSinhVien = :maSinhvien) and " +
            "(:ngayBatDau is null or :ngayBatDau is null or bbg.ngayBanGiao >= :ngayBatDau and bbg.ngayBanGiao <= :ngayKetThuc)")
    Page<Bienbanbangiao> getListBienBanBanGiao(@Param("maSinhvien") Integer maSinhvien,
                                               @Param("ngayBatDau") LocalDateTime ngayBatDau,
                                               @Param("ngayKetThuc") LocalDateTime ngayKetThuc,
                                               Pageable pageable);
}
