package com.admin.scannerproject.controller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.admin.scannerproject.repository.UserRepository;
import com.admin.scannerproject.service.QrCodeService;
import com.admin.scannerproject.service.SeatBookingResponseDto;
import com.admin.scannerproject.service.SeatBookingService;
import com.admin.scannerproject.service.UserService;
//import com.admin.scannerproject.user.BookSeatEntity;
import com.admin.scannerproject.user.QrCodeAssignmentRequest;
import com.admin.scannerproject.user.UserEntity;
import com.admin.scannerprojectException.UserNotFound;
import com.google.zxing.WriterException;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")

@CrossOrigin("*")
public class UserController {
 
	 @Autowired
    private  UserService userService;

	 @Autowired
	  private  UserRepository userRepository;

   

//    @PostMapping
//    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
//        UserEntity createdUser = userService.createUser(user);
//        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UserEntity> getUserById(@PathVariable long id) {
//        UserEntity user = userService.getUserById(id);
//        if (user != null) {
//            return new ResponseEntity<>(user, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

//    @GetMapping
//    public ResponseEntity<List<UserEntity>> getAllUsers() {
//        List<UserEntity> users = userService.getAllUsers();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<UserEntity> updateUser(@PathVariable long id, @RequestBody UserEntity user) {
//        if (userService.getUserById(id) != null) {
//            user.setId(id);
//            UserEntity updatedUser = userService.updateUser(user);
//            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
//        UserEntity user = userService.getUserById(id);
//        if (user != null) {
//            userService.deleteUserById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    
    @Autowired
    private QrCodeService qrCodeService;

    @GetMapping("/{id}")
    public ResponseEntity<String> Check(@PathVariable Long id) throws UserNotFound {
        UserEntity userEntity = userRepository.findUserById(id);
        
        if (userEntity == null) {
            return new ResponseEntity<>("Qr is Not Available for Id: " + id, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>("Qr is Available For Id: " + userEntity.getId() +
                    " Qr is Available For EmailId: " + userEntity.getEmailid() +
                    " Qr is Available For EmployeeDesignation: " + userEntity.getEmployeedesignation() , HttpStatus.OK);
        }
    }


    
    @PostMapping("/assign-qr-code")
    public ResponseEntity<UserEntity> assignQrCode(@RequestBody UserEntity user) throws WriterException, IOException {
    	UserEntity saveQr=userRepository.save(user);
    	//com.admin.scannerproject.utils.QrCodeGenerator.generateQrCode(saveQr, null);
    	com.admin.scannerproject.utils.QrCodeGenerator.generateQrCode(saveQr);
        try {
          //  qrCodeService.assignQrCode(user.getId(), user.getEmployeeId());
            return new ResponseEntity<UserEntity>(saveQr,HttpStatus.CREATED);
        } catch (Exception e) {
            return new  ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
//    @PostMapping("/book-seat")
//    public ResponseEntity<String> bookSeat(@RequestBody BookSeatEntity seatId) {
//        return qrCodeService.bookSeat(seatId);
//    }
    
 
    

        @Autowired
        private SeatBookingService seatBookingService;

//        @PostMapping("/book-seat")
//        public ResponseEntity<SeatBookingResponseDto> bookSeat(@RequestParam Long empid, @RequestParam Long seatId) {
//            try {
//                SeatBookingResponseDto response = seatBookingService.saveseat(empid, seatId);
//                return ResponseEntity.ok(response);
//            } catch (UserNotFound e) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//            }
//        }

//        @PostMapping("/book-seat")
//        public ResponseEntity<?> bookSeat(@RequestParam Long empid, @RequestParam Long seatId) {
//            try {
//                SeatBookingResponseDto response = seatBookingService.saveseat(empid, seatId);
//                return ResponseEntity.ok(response);
//            } catch (UserNotFound e) {
//                if (e.getMessage().contains("Duplicate entry")) {
//                    return ResponseEntity.status(HttpStatus.CONFLICT).body("Seat already booked by another employee.");
//                }
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request: " + e.getMessage());
//            }
//        }
        
        @PostMapping("/book/{empid}/{seatId}")
        public ResponseEntity<SeatBookingResponseDto> bookSeatForEmployee(
                @PathVariable Long empid,
                @PathVariable long seatId) throws UserNotFound {
        	  try {
                  SeatBookingResponseDto response = seatBookingService.bookSeatForEmployee(empid, seatId);
                  return ResponseEntity.ok(response);
              } catch (UserNotFound e) {
                  return ResponseEntity.badRequest().body(new SeatBookingResponseDto());
              }
          }
 
   
}


