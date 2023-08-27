package com.admin.scannerproject.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.scannerproject.repository.BookSeatRepo;
import com.admin.scannerproject.user.BookSeatEntity;

import java.util.List;
import java.util.Optional;

@Service
public class BookSeatService {

    private final BookSeatRepo bookSeatRepository;

    @Autowired
    public BookSeatService(BookSeatRepo bookSeatRepository) {
        this.bookSeatRepository = bookSeatRepository;
    }

    public List<BookSeatEntity> getAllBookedSeats() {
        return bookSeatRepository.findAll();
    }

    public Optional<BookSeatEntity> getBookedSeatById(long seatId) {
        return bookSeatRepository.findById(seatId);
    }

    public BookSeatEntity bookSeat(BookSeatEntity seat) {
        return bookSeatRepository.save(seat);
    }

    public void unbookSeat(long seatId) {
        Optional<BookSeatEntity> optionalSeat = bookSeatRepository.findById(seatId);
        optionalSeat.ifPresent(seat -> {
            seat.setIsBooked((byte) 0);
            bookSeatRepository.save(seat);
        });
    }
    
    // You can add more methods as needed, like updating seat status, deleting seats, etc.
}



