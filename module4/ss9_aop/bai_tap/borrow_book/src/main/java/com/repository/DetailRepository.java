package com.repository;

import com.model.DetailBook;
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
public interface DetailRepository extends JpaRepository<DetailBook, Integer> {
    @Query(value = "select * from detail_book", nativeQuery = true)
    List<DetailBook> selectAll();

    @Query(value = "select * from detail_book", nativeQuery = true)
    Page<DetailBook> selectAllPage(Pageable pageable);

    @Query(value = "select * from detail_book where id = :id", nativeQuery = true)
    DetailBook selectById(@Param("id") int id);

//    @Modifying
//    @Transactional
//    @Query(value = "update detail_book set status = 1 where id =:id", nativeQuery = true)
//    void updateBookBorrow(@Param("id") int id);

}
