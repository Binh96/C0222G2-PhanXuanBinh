package com.exam.repository;

import com.exam.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Modifying
    @Query(value = "update phong_tro set tinh_trang_thue = 1 where id = :id", nativeQuery = true)
    void updateRoom(@Param("id")int id);

    @Modifying
    @Query(value = "update phong_tro set tinh_trang_thue = 0 where id = :id", nativeQuery = true)
    void updateRoomEndRent(@Param("id")int id);

    @Query(value = " select * from phong_tro where tinh_trang_thue = 0", nativeQuery = true)
    List<Room> selectAll();
}
