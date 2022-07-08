package com.pxb.repository;

import com.pxb.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    @Query(value = "select * from hop_dong_chi_tiet where ma_hop_dong = :id", nativeQuery = true)
    List<ContractDetail> selectById(int id);

}
