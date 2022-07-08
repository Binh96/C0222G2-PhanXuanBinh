package com.pxb.repository;

import com.pxb.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from nhan_vien where status = 0", nativeQuery = true,
    countQuery = "select count(*) from(select * from nhan_vien where status = 0) nhan_vien")
    Page<Employee> selectAll(Pageable pageable);

    @Query(value = "select * from nhan_vien where status = 0 and ten_nhan_vien like :name", nativeQuery = true)
    Page<Employee> selectByName(Pageable pageable, @Param("name") String name);

    @Query(value = "select * from nhan_vien where id = :id and status = 0", nativeQuery = true)
    Employee findById(@Param("id") int id);

    @Modifying
    @Query(value = "update nhan_vien set status = 1 where id = :id", nativeQuery = true)
    void deleteById(@Param("id") int id);
}
