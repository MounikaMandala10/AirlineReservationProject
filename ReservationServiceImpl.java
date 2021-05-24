package com.example.demo.layer4;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Reservation;
import com.example.demo.layer3.ReservationRepository;
import com.example.demo.layer4.exceptions.ReservationAlreadyExistsException;
import com.example.demo.layer4.exceptions.ReservationNotFoundException;
import com.example.demo.layer4.exceptions.TicketDetailsNotFoundException;


@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationRepository resRepo;
	
	@Override
	public String addReservationService(Reservation rRef)  throws ReservationAlreadyExistsException {
		System.out.println("Reservation Service....Some scope of bussiness logic here...");
		try {
			resRepo.addReservation(rRef);
		} catch (Exception e) {
		 throw new  ReservationAlreadyExistsException("Reservation already exists");
		}
		
		return "reservation added sucessfully";
	}

	@Override
	public Reservation findReservationService(int tno) throws ReservationNotFoundException {
		System.out.println("Reservation Service....Some scope of bussiness logic here...");
		try {
			return resRepo.findReservation(tno);

		} catch (Exception e) {
			throw new ReservationNotFoundException("Rservation not found");
		}
		
	}

	@Override
	public Set<Reservation> findAllReservationService() {
		System.out.println("Reservation Service....Some scope of bussiness logic here...");
		
			return resRepo.findAllReservation();
		}

	@Override
	public String modifyReservationService(Reservation rRef) throws ReservationNotFoundException {
		System.out.println("Reservation Service....Some scope of bussiness logic here...");
		Reservation reser= resRepo.findReservation(rRef.getTicketno());
		if(reser!=null)
		{
			resRepo.modifyReservation(rRef);
		}
		else
		{
			throw new ReservationNotFoundException("Reservation not found");
		}
	
				return "Reservation modified sucessfully";
	}

	@Override
	public String removeReservationService(int tno) throws ReservationNotFoundException {
		System.out.println("Reservation Service....Some scope of bussiness logic here...");
		Reservation reser= resRepo.findReservation(tno);
		if(reser!=null)
		{
			resRepo.removeReservation(tno);
			
		}
		else
		{
			throw new ReservationNotFoundException("Reservation not found");
		}
	
				return "Reservation deleted sucessfully";
		
	}

	@Override
	public Set<Reservation> findTicketDetailService(int tno) throws TicketDetailsNotFoundException {
		System.out.println("Reservation Service....Some scope of bussiness logic here...");
		Set<Reservation> reser= resRepo.findTicketDetails(tno);
		if(reser!=null)
		{
			resRepo.findTicketDetails(tno);
		}
		else 
		{
			throw new TicketDetailsNotFoundException("Ticket not found");
		}
		return reser;
	         
	}
	

}