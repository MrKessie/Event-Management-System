package com.kessie.EventManagementSystem.Repository;

import com.kessie.EventManagementSystem.Module.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    Booking findById(long bookingId);
}
