package com.pxb.repository;

import com.pxb.model.Contract;
import com.pxb.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value="select * from hop_dong where status = 0", nativeQuery = true)
    Page<Contract> selectAll(Pageable pageable);

    @Query(value = "select * from hop_dong where status = 0 and ma_khach_hang like :id", nativeQuery = true)
    Page<Contract> selectByCustomerId(Pageable pageable, @Param("id") int id);

    @Query(value = "select * from hop_dong where id = :id and status = 0", nativeQuery = true)
    Contract findById(@Param("id") int id);

    @Modifying
    @Query(value = "update hop_dong set status = 1 where id = :id", nativeQuery = true)
    void deleteById(@Param("id") int id);
}
