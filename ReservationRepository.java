package com.example.demo.layer3;

import java.util.Set;
import com.example.demo.layer2.Reservation;

public interface ReservationRepository {
	void addReservation(Reservation rRef);   //C - add/create
	Reservation findReservation(int tno);     //R - find/reading
	Set<Reservation> findAllReservation();     //R - find all/reading all
	void modifyReservation(Reservation rRef); //U - modify/update
	void removeReservation(int tno);
	Set<Reservation> findTicketDetails(int tno); 
}
