package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.entities.Thietbi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ThietBiRepo extends JpaRepository<Thietbi, Integer> {

    @Query("select tb from Thietbi  tb where (:soPhong is null or tb.phong.soPhong = :soPhong) " +
            "and (:tenThietBi is null or tb.tenThietBi like %:tenThietBi%)")
    Page<Thietbi> getListThietBi(
            @Param("soPhong") Integer soPhong,
            @Param("tenThietBi") String tenThietBi,
            Pageable pageable
    );

}
