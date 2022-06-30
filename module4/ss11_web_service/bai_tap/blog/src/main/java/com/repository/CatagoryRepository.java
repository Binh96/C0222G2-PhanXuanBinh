package com.repository;

import com.model.Catagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatagoryRepository extends JpaRepository<Catagory, Integer> {
    @Query(value= "select * from catagory", nativeQuery = true)
    List<Catagory> selectAll();
}
