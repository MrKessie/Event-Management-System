package com.kessie.EventManagementSystem.Controller;

import com.kessie.EventManagementSystem.Enums.BookingStatus;
import com.kessie.EventManagementSystem.Model.Booking;
import com.kessie.EventManagementSystem.Model.Event;
import com.kessie.EventManagementSystem.Model.User;
import com.kessie.EventManagementSystem.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;
    @PostMapping("/create")
    @ResponseBody
    public Booking createBooking(@RequestParam User user, @RequestParam Event event, @RequestParam int numberOfTickets,
                                 @RequestParam /*Set<BookingStatus>*/ BookingStatus bookingStatus, @RequestParam double totalPrice){
        Booking booking = bookingService.createBooking(user, event, numberOfTickets, bookingStatus, totalPrice);
        return booking;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Booking> allBooking(){
        List<Booking> bookings = bookingService.allBookings();
        return bookings;
    }
    @PostMapping("/delete")
    @ResponseBody
    public Booking deleteBooking(@RequestParam long bookingId){
        Booking booking = bookingService.deleteBooking(bookingId);
        return booking;
    }


}
