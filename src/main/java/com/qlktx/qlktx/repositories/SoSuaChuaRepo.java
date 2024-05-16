package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.entities.Sosuachua;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SoSuaChuaRepo extends JpaRepository<Sosuachua, Integer> {

    @Query("select sosuachua from Sosuachua sosuachua  where :soPhong is null  or sosuachua.phong.soPhong = :soPhong")
    Page<Sosuachua> getListSoSuaChua(@Param("soPhong") Integer soPhong, Pageable pageable);

}
