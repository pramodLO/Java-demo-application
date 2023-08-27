package com.admin.scannerproject.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.admin.scannerproject.service.BookSeatService;
import com.admin.scannerproject.user.BookSeatEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookseats")
@CrossOrigin("*")
public class BookSeatController {

    private final BookSeatService bookSeatService;

    @Autowired
    public BookSeatController(BookSeatService bookSeatService) {
        this.bookSeatService = bookSeatService;
    }

    @GetMapping
    public List<BookSeatEntity> getAllBookedSeats() {
        return bookSeatService.getAllBookedSeats();
    }

    @GetMapping("/{seatId}")
    public ResponseEntity<BookSeatEntity> getBookedSeatById(@PathVariable long seatId) {
        Optional<BookSeatEntity> seat = bookSeatService.getBookedSeatById(seatId);
        return seat.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

//    @PostMapping
//    public ResponseEntity<BookSeatEntity> bookSeat(@RequestBody BookSeatEntity seat) {
//        BookSeatEntity bookedSeat = bookSeatService.bookSeat(seat);
//        return ResponseEntity.ok(bookedSeat);
//    }

    @PutMapping("/{seatId}/unbook")
    public ResponseEntity<Void> unbookSeat(@PathVariable long seatId) {
        bookSeatService.unbookSeat(seatId);
        return ResponseEntity.noContent().build();
    }
    
    // You can add more endpoints as needed, like updating seat status, deleting seats, etc.
}



