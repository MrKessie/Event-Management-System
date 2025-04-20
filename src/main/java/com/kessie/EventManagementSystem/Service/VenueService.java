package com.kessie.EventManagementSystem.Service;

import com.kessie.EventManagementSystem.Model.Venue;
import com.kessie.EventManagementSystem.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class VenueService {
    @Autowired
    VenueRepository venueRepository;

    public Venue createVenue(String venueName, String venueAddress, int venueCapacity) {
        Long venueId = randomNumbers();
        Venue venue = new Venue();
        venue.setVenueId(venueId);
        venue.setVenueName(venueName);
        venue.setVenueAddress(venueAddress);
        venue.setVenueCapacity(venueCapacity);
        venue.setDateCreated(LocalDateTime.now());
        venue.setDateUpdated(LocalDateTime.now());

        venueRepository.save(venue);

        return venue;
    }

    public List<Venue> venueList() {
        List<Venue> venueList = (List<Venue>) venueRepository.findAll();
        return venueList;
    }

    public boolean existByVenueId(Long venueId) {
        return venueRepository.existsByVenueId(venueId);
    }

    public boolean existByVenueName(String venueName) {
        return venueRepository.existsByVenueName(venueName);
    }

    public boolean deleteVenue(Long venueId) {
        if (venueRepository.existsByVenueId(venueId)) {
            venueRepository.deleteById(venueId);
            return true;
        }
        return false;
    }

    public Venue updateVenue (Long venueId, Venue updatedVenue) {
        Optional<Venue> optionalVenue = venueRepository.findById(venueId);
        if (optionalVenue.isPresent()) {
            Venue existingVenue = optionalVenue.get();

            if (updatedVenue.getVenueName() != null) {
                existingVenue.setVenueName(updatedVenue.getVenueName());
            }
            if (updatedVenue.getVenueAddress() != null) {
                existingVenue.setVenueAddress(updatedVenue.getVenueAddress());
            }
            if (updatedVenue.getVenueCapacity() != 0) {
                existingVenue.setVenueCapacity(updatedVenue.getVenueCapacity());
            }
            if(updatedVenue.getDateUpdated() != null) {
                existingVenue.setDateUpdated(LocalDateTime.now());
            }
            return venueRepository.save(existingVenue);
        }
        else {
            throw new RuntimeException("Venue not found!");
        }
    }

    public Long randomNumbers(){
        Random random = new Random();
        long max = 99999;
        long min = 10000;
        return random.nextLong(max - min + 1) + min;
    }
}
