package com.rzq.repository;

import com.rzq.entity.Facility;
import com.rzq.entity.FacilityAudit;
import com.rzq.entity.RoomCategory;
import com.rzq.entity.RoomCategoryAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FacilityAuditRepository extends JpaRepository<FacilityAudit, String> {
    @Query("SELECT " +
            "fa " +
            "FROM FacilityAudit fa " +
            "JOIN fa.facility f " +
            "WHERE fa.facility = :facility " +
            "AND fa.createdAt < :createdAt "+
            "ORDER BY fa.createdAt DESC ")
    public List<FacilityAudit> getFacilityAuditBeforeTransaction(Facility facility, LocalDateTime createdAt);
}
