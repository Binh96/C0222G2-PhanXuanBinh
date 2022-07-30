package com.pxb.backendexam.repository;

import com.pxb.backendexam.model.Consignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ConsignmentRepository extends JpaRepository<Consignment, Integer> {
    @Query(value = "select * from lo_hang where id = :id", nativeQuery = true)
    Consignment findById(@Param("id") int id);

    @Modifying
    @Query(value = "delete from lo_hang where id = :id", nativeQuery = true)
    Integer delete(@Param("id") int id);

    @Query(value = "select * from lo_hang where id = :id", nativeQuery = true)
    List<Consignment> findByName(@Param("id") int id);
}
