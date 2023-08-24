package com.rzq.repository;

import com.rzq.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, String>, JpaSpecificationExecutor<Room> {
    public Optional<Room> findByIdAndDeletedAtIsNull(String id);
    public Optional<Room> findByIdAndDeletedAtIsNotNull(String id);
}
