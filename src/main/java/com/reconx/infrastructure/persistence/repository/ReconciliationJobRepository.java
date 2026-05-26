package com.reconx.infrastructure.persistence.repository;

import com.reconx.infrastructure.persistence.entity
        .ReconciliationJobEntity;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.UUID;

public interface ReconciliationJobRepository
        extends JpaRepository<
        ReconciliationJobEntity,
        UUID
        > {

    long countByStatus(String status);

    @Query("""
        SELECT COALESCE(SUM(r.matched), 0)
        FROM ReconciliationJobEntity r
    """)
    long sumMatchedRecords();

    @Query("""
        SELECT COALESCE(SUM(r.unmatched), 0)
        FROM ReconciliationJobEntity r
    """)
    long sumUnmatchedRecords();

    @Query("""
        SELECT COUNT(r)
        FROM ReconciliationJobEntity r
        WHERE DATE(r.createdAt) = :date
    """)
    long countJobsByDate(
            @Param("date")
            LocalDate date
    );
}