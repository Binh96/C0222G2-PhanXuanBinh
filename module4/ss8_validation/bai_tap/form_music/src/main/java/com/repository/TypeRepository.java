package com.repository;

import com.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {

    @Query(value="select * from the_loai", nativeQuery= true)
    List<Type> selectAll();
}
