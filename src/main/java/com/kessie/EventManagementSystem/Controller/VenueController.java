package com.kessie.EventManagementSystem.Controller;

import com.kessie.EventManagementSystem.Model.Venue;
import com.kessie.EventManagementSystem.Service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/setup/venue")
public class VenueController {
    @Autowired
    VenueService venueService;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<?> createVenue(@RequestParam String venueName, @RequestParam String venueAddress, @RequestParam int venueCapacity) {
        try {
            if (venueService.existByVenueName(venueName)) {
                return ResponseEntity.status(HttpStatus.CONFLICT). body("Venue with name " + venueName + " already exists!");
            }
            Venue venue = venueService.createVenue(venueName, venueAddress, venueCapacity);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Venue created successfully!");
            response.put("data", venue);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Error creating venue: " + e.getMessage());
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/all/venues")
    @ResponseBody
    public List<Venue> venueList() {
        List<Venue> venueList = venueService.venueList();
        return venueList;
    }

    @DeleteMapping("/delete/venue/{venueId}")
    @ResponseBody
    public ResponseEntity<?> deleteVenue(@PathVariable Long venueId) {
        try {
            if (venueService.existByVenueId(venueId)) {
                boolean deletedVenue = venueService.deleteVenue(venueId);
                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                response.put("message", "Venue with ID: " + venueId + " deleted successfully!");
                response.put("data", deletedVenue);
                return ResponseEntity.ok(response);
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venue with ID: " + venueId + " not found.");
            }
        }
        catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Error deleting venue: " + e.getMessage());
            return ResponseEntity.ok(response);
        }
    }

    @PutMapping("/update/venue/{venueId}")
    @ResponseBody
    public ResponseEntity<?> updateVenue(@PathVariable Long venueId, @RequestBody Venue updatedVenue) {
        try {
            Venue deletedVenue = venueService.updateVenue(venueId, updatedVenue);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Venue with ID: " + venueId + " deleted successfully!");
            response.put("data", deletedVenue);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Error deleting venue: " + e.getMessage());
            return ResponseEntity.ok(response);
        }
    }

}