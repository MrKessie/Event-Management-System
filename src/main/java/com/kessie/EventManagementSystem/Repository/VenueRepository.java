package com.kessie.EventManagementSystem.Repository;

import com.kessie.EventManagementSystem.Model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
    boolean existsByVenueId(Long venueId);

    boolean existsByVenueName(String venueName);
}
