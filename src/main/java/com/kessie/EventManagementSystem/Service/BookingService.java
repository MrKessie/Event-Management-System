package com.kessie.EventManagementSystem.Service;

import com.kessie.EventManagementSystem.Enums.BookingStatus;
import com.kessie.EventManagementSystem.Module.Booking;
import com.kessie.EventManagementSystem.Module.Event;
import com.kessie.EventManagementSystem.Module.User;
import com.kessie.EventManagementSystem.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    public Booking createBooking(User user, Event event, int numberOfTickets,
                                 /*Set<BookingStatus>*/ BookingStatus bookingStatus, double totalPrice){
        long bookingId = randomNumbers();
        Booking booking = new Booking();
        booking.setBookingId(bookingId);
        booking.setUser(user);
        booking.setEvent(event);
        booking.setNumberOfTickets(numberOfTickets);
        booking.setBookingStatus(bookingStatus);
        booking.setTotalPrice(totalPrice);

        bookingRepository.save(booking);

        return booking;
    }

    public List<Booking> allBookings(){
        List<Booking> bookings = (List<Booking>) bookingRepository.findAll();
        return bookings;
    }

    public Booking deleteBooking(long bookingId){
        Booking booking = bookingRepository.findById(bookingId);
        bookingRepository.delete(booking);
        return booking;
    }

    public long randomNumbers(){
        Random random = new Random();
        long max = 99999L;
        long min = 10000L;
        return random.nextLong(max - min + 1) + min;
    }
}
