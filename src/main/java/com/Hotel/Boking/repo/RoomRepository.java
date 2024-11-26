package com.Hotel.Boking.repo;

import com.Hotel.Boking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {

    @Query("SELECT DISTINCT r.roomType FROM Room r")
    List<String> findDistinctRoomTypes();


    @Query("SELECT r FROM Room r where r.roomType LIKE %:roomType% AND r.id NOT IN " +
            "(SELECT bk.room.id  from Booking bk where(bk.checkInDate <= :checkOutDate ) AND " +
            "(bk.checkOutDate >= :checkInDate))")
    List<Room>findAvailableRoomByDataAndTypes(LocalDate checkInDate,LocalDate checkOutDate,String roomType);


    @Query("SELECT r FROM Room r where r.id NOT IN (SELECT  b.room.id  FROM Booking b)")
    List<Room>getAllAvailableRooms();
}
