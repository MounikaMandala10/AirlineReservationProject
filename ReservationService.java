package com.example.demo.layer4;

import java.util.Set;
import org.springframework.stereotype.Service;
import com.example.demo.layer2.Reservation;
import com.example.demo.layer4.exceptions.ReservationAlreadyExistsException;
import com.example.demo.layer4.exceptions.ReservationNotFoundException;
import com.example.demo.layer4.exceptions.TicketDetailsNotFoundException;

@Service
public interface ReservationService {
	String addReservationService(Reservation rRef)throws ReservationAlreadyExistsException;   //C - add/create
	Reservation findReservationService(int tno) throws ReservationNotFoundException;     //R - find/reading
	Set<Reservation> findAllReservationService();     //R - find all/reading all
	String modifyReservationService(Reservation rRef) throws ReservationNotFoundException; //U - modify/update
	String removeReservationService(int tno) throws ReservationNotFoundException;
	Set<Reservation> findTicketDetailService(int tno) throws TicketDetailsNotFoundException; 
}