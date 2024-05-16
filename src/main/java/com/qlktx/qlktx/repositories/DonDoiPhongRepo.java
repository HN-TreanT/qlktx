package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.entities.Dondoiphong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface DonDoiPhongRepo extends JpaRepository<Dondoiphong, Integer> {

    @Query("select ddp from Dondoiphong ddp " +
            "where (:maPhong is null or ddp.phong.soPhong = :maPhong) and " +
            "(:maSinhvien is null or ddp.sinhvien.maSinhVien = :maSinhvien)")
    Page<Dondoiphong> getListDonDoiPhong(@Param("maPhong") Integer maPhong, @Param("maSinhvien") Integer maSinhvien, Pageable pageable);

}
