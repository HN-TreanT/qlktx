package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.entities.Thietbi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ThietBiRepo extends JpaRepository<Thietbi, Integer> {

    @Query("SELECT tb FROM Thietbi tb WHERE :tenThietBi IS NULL OR tb.tenThietBi LIKE %:tenThietBi%")
    Page<Thietbi> getListThietBi(
            @Param("tenThietBi") String tenThietBi,
            Pageable pageable
    );

}
