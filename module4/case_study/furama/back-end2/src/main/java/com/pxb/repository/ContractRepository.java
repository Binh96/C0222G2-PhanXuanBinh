package com.pxb.repository;

import com.pxb.dto.ContractDto;
import com.pxb.model.Contract;
import com.pxb.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

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

    @Query(value = " select ma_khach_hang, ma_dich_vu, ngay_bat_dau, ngay_ket_thuc, tien_coc," +
            "dich_vu.gia +(ifnull(hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia, 0)) from hop_dong\n" +
            "left join khach_hang on khach_hang.id = hop_dong.ma_khach_hang\n"+
            "left join dich_vu on dich_vu.id = hop_dong.ma_dich_vu\n"+
            "left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.id\n"+
            "left join dich_vu_di_kem on dich_vu_di_kem.id = hop_dong_chi_tiet.ma_dich_vu_di_kem  where hop_dong.`status` = 0 ", nativeQuery = true)
    Page<ContractDto> getTotal(Pageable pageable);

}
