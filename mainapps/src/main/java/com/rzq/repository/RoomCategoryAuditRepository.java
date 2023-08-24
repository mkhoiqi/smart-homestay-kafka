package com.rzq.repository;

import com.rzq.entity.Room;
import com.rzq.entity.RoomAudit;
import com.rzq.entity.RoomCategory;
import com.rzq.entity.RoomCategoryAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RoomCategoryAuditRepository extends JpaRepository<RoomCategoryAudit, String> {
    @Query("SELECT " +
            "rca " +
            "FROM RoomCategoryAudit rca " +
            "JOIN rca.roomCategory rc " +
            "WHERE rca.roomCategory = :roomCategory " +
            "AND rca.createdAt < :createdAt "+
            "ORDER BY rca.createdAt DESC ")
    public List<RoomCategoryAudit> getRoomCategoryAuditBeforeTransaction(RoomCategory roomCategory, LocalDateTime createdAt);
}
