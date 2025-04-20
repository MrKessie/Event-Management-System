package com.kessie.EventManagementSystem.Repository;

import com.kessie.EventManagementSystem.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Event findByEventId(Long eventId);

    boolean existsByEventId(Long eventId);
}
