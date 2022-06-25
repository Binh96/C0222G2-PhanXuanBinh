package com.repositoryy;

import com.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value="select * from san_pham", nativeQuery = true)
    List<Product> selectAll();

    @Query(value="select * from san_pham where id = :id", nativeQuery = true)
    Product selectOne(int id);

    @Query(value="select * from san_pham where name_product like :name", nativeQuery = true)
    List<Product> selectByName(String name);
}
