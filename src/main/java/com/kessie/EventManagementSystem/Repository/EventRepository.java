package com.kessie.EventManagementSystem.Repository;

import com.kessie.EventManagementSystem.Module.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
    Event findById(int eventId);
    //Event findEventBy(int eventId);
}
