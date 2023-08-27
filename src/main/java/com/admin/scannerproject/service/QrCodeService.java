package com.admin.scannerproject.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.admin.scannerproject.repository.BookSeatRepo;
import com.admin.scannerproject.repository.UserRepository;
import com.admin.scannerproject.user.BookSeatEntity;
//import com.admin.scannerproject.user.BookSeatEntity;
import com.admin.scannerproject.user.UserEntity;

@Service
public class QrCodeService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BookSeatRepo bookSeatRepo;


   public UserEntity isQrCodeAvailable(UserEntity user) {
       return userRepository.findById(user.getId()).orElse(null);
    }
    public ResponseEntity<String> bookSeat(BookSeatEntity userId) {
        Optional<BookSeatEntity> userOptional = bookSeatRepo.findById(userId.getSeatid());

        if (userOptional.isPresent()) {
            BookSeatEntity book=userOptional.get();
            
            
            
         //   user = userOptional.get();

            if (book.getIsBooked() == 0) {
                book.setIsBooked((byte) 1);
                bookSeatRepo.save(book);

                return ResponseEntity.ok("Seat booked successfully for user with ID: " + book.getSeatid());
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Seat is already booked for user with ID: " + book.getSeatid());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    public void assignQrCode(long userId, Long qrCodeName) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isPresent()) {
            UserEntity userEntity = user.get();
           // userEntity.setEmployeeId(qrCodeName);
            userRepository.save(userEntity);
        }
    }
}

