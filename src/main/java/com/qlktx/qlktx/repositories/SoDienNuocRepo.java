package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.entities.Sodiennuoc;
import com.qlktx.qlktx.entities.Sosuachua;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SoDienNuocRepo extends JpaRepository<Sodiennuoc, Integer> {
    @Query("select so from Sodiennuoc so  where :soPhong is null  or so.phong.soPhong = :soPhong")
    Page<Sodiennuoc> getListSoDieNuoc(@Param("soPhong") Integer soPhong, Pageable pageable);
}
