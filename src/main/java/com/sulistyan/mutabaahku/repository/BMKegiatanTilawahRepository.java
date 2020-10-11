package com.sulistyan.mutabaahku.repository;

import com.sulistyan.mutabaahku.entity.BMKegiatanTilawah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BMKegiatanTilawahRepository extends JpaRepository<BMKegiatanTilawah, Integer> {

    @Query("SELECT bmkt from BMKegiatanTilawah bmkt where bmkt.idUser = ?1 order by bmkt.tanggal desc")
    List<BMKegiatanTilawah> findBmktByUserId(Integer bkmtId);

}
