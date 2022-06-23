package com.repository;

import com.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query(value="select * from post where id = :id", nativeQuery = true)
    Post findById(@Param("id") int id);

    @Query(value="select * from post where tieu_de = :title", nativeQuery = true)
    List<Post> findByTitle(@Param("title") String title);

    @Query(value="select * from post where tieu_de = :title", nativeQuery = true)
    Page<Post> findByTitle(@Param("title") String title, Pageable pageable);

    @Query(value="select * from post", nativeQuery = true)
    Page<Post> getAll(Pageable pageable);

    @Query(value="select * from post where tieu_de like :title", nativeQuery = true)
    Page<Post> getAllByTitle(@Param("title") String title, Pageable pageable);
}
