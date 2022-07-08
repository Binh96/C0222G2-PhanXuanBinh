package com.pxb.repository;

import com.pxb.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FacilityRepository extends JpaRepository<Facility, Integer> {

    @Query(value = "select * from dich_vu where status = 0", nativeQuery = true)
    Page<Facility> selectAll(Pageable pageable);

    @Query(value = "select * from dich_vu where status = 0 and ten_dich_vu like :name", nativeQuery = true)
    Page<Facility> selectByName(Pageable pageable, @Param("name") String name);
    @Query(value = "select * from dich_vu where id = :id", nativeQuery = true)
    Facility findById(@Param("id") int id);

    @Modifying
    @Query(value = "update dich_vu set status = 1 where id = :id", nativeQuery = true)
    void deleteById(@Param("id") int id);
}
