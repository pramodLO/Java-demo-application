package com.admin.scannerproject.service;

import org.aspectj.lang.reflect.CatchClauseSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.admin.scannerproject.repository.AssetRepository;
import com.admin.scannerproject.repository.UserRepository;
import com.admin.scannerproject.user.AssetEntity;
import com.admin.scannerproject.user.UserEntity;
import com.admin.scannerprojectException.UserNotFound;

@Service
public class SeatBookingService {

    @Autowired
    private UserRepository employeeRepo;

    @Autowired
    private AssetRepository assetRepo;

//    public SeatBookingResponseDto saveseat(Long empid, long seatId) throws UserNotFound {
//        UserEntity employee = employeeRepo.findUserById(empid);
//
//        if (employee == null) {
//            throw new UserNotFound("Invalid Employee Id");
//        }
//
//        AssetEntity	 seat = assetRepo.findById(seatId).orElse(null);
//
//        if (seat == null) {
//            throw new UserNotFound("Invalid Seat Id");
//        }
//
//        if (seat.getSeatIdBook() == null) {
//            seat.setSeatIdBook(employee);
//            seat.setStatus("RESERVED");
//            assetRepo.save(seat);
//
//            SeatBookingResponseDto responseDto = new SeatBookingResponseDto();
//            responseDto.setSeatId(seat.getSeatid());
//            responseDto.setMessage("Seat Successfully Allocated");
//            return responseDto;
//        } else if (seat.getSeatIdBook() != null) {
//            throw new UserNotFound("Seat already allocated for seat Number: " + seat.getSeatid());
//        } else {
//            seat.setSeatIdBook(employee);
//            seat.setStatus("RESERVED");
//            assetRepo.save(seat);
//
//            SeatBookingResponseDto responseDto = new SeatBookingResponseDto();
//            responseDto.setSeatId(seat.getSeatid());
//            responseDto.setMessage("Seat Successfully Allocated");
//            return responseDto;
//        }
//    }
    
    
    
    public SeatBookingResponseDto bookSeatForEmployee(Long empid, long seatId) throws UserNotFound  {
        UserEntity employee = employeeRepo.findUserById(empid);

        if (employee == null) {
            throw new UserNotFound("Invalid Employee Id");
        }

        AssetEntity seat = assetRepo.findById(seatId).orElse(null);

        if (seat == null) {
            throw new UserNotFound("Invalid Seat Id");
        }

        if (seat.getSeatIdBook() != null) {
            throw new UserNotFound("Seat already allocated for seat Number: " + seat.getSeatid());
        }

        seat.setSeatIdBook(employee);
        seat.setStatus("RESERVED");
        
        try {
            assetRepo.save(seat);
        } catch (DataIntegrityViolationException ex) {
            throw new UserNotFound("Seat already allocated for seat Number: " + seat.getSeatid());
        }

        SeatBookingResponseDto responseDto = new SeatBookingResponseDto();
        responseDto.setSeatId(seat.getSeatid());
        responseDto.setMessage("Seat Successfully Allocated");
        return responseDto;
    }}
