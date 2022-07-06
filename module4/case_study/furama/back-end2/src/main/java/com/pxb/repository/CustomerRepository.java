package com.pxb.repository;

import com.pxb.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from khach_hang where status = 0", nativeQuery = true)
    Page<Customer> selectAll(Pageable pageable);

    @Query(value = "select * from khach_hang where status = 0 and ten_khach_hang like :name", nativeQuery = true)
    Page<Customer> selectByName(Pageable pageable, @Param("name") String name);

    @Query(value = "select * from khach_hang where id = :id and status = 0", nativeQuery = true)
    Customer findById(@Param("id") int id);

    @Modifying
    @Query(value = "update khach_hang set status = 1 where id = :id", nativeQuery = true)
    void deleteById(@Param("id") int id);
}
