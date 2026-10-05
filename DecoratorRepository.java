package com.eventdecorator.repository;

import com.eventdecorator.model.Decorator;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface DecoratorRepository extends JpaRepository<Decorator,Long> {
    @Query("""
        SELECT d FROM Decorator d
        WHERE (:eventType='' OR LOWER(d.eventTypes) LIKE LOWER(CONCAT('%',:eventType,'%')))
        AND (:location='' OR LOWER(d.location) LIKE LOWER(CONCAT('%',:location,'%')))
        AND (:service='' OR LOWER(d.services) LIKE LOWER(CONCAT('%',:service,'%')))
        AND (:budget<=0 OR d.startingPrice<=:budget)
        AND d.available=true
        ORDER BY d.rating DESC
    """)
    List<Decorator> search(@Param("eventType") String eventType,
                           @Param("location") String location,
                           @Param("service") String service,
                           @Param("budget") Double budget);
}
