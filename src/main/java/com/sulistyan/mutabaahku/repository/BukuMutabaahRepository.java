package com.sulistyan.mutabaahku.repository;

import com.sulistyan.mutabaahku.entity.BukuMutabaah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BukuMutabaahRepository extends JpaRepository<BukuMutabaah, Integer> {

    @Query("SELECT bkmt from BukuMutabaah bkmt where bkmt.user.id = ?1")
    BukuMutabaah findBkmtByUserId(Integer idUser);
}
