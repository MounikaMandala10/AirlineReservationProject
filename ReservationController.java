package com.example.demo.layer5;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.layer2.Reservation;
import com.example.demo.layer4.ReservationService;
import com.example.demo.layer4.exceptions.ReservationAlreadyExistsException;
import com.example.demo.layer4.exceptions.ReservationNotFoundException;

@RestController
public class ReservationController {

	@Autowired
	ReservationService reservServe;
	
	@GetMapping(path="/getReservation/{myTicketNo}")
	@ResponseBody
	public ResponseEntity<Reservation> getFlight(@PathVariable("myTicketNo") int ticketNo){
		System.out.println("Reservation Controller....Understanding client and talking to service layer...");
		Reservation reservationObj=null;
		
		try {
			reservationObj = reservServe.findReservationService(ticketNo);
		} catch (ReservationNotFoundException e) {
			
			e.printStackTrace();
		}
		
		if(reservationObj==null)
		{ return ResponseEntity.notFound().build();
		
		}
		else {
			return ResponseEntity.ok(reservationObj);
		} 
	}
	
	
	@GetMapping(path="/getAllReservation")
	@ResponseBody
	public Set<Reservation> getAllReservation()
	{
		System.out.println("Reservation Controller....Understanding client and talking to service layer...");
		Set<Reservation> reservationSet= reservServe.findAllReservationService();
		return reservationSet;
	}
	
	
	@PostMapping(path="/addReservation")
	public String addReservation(@RequestBody Reservation reservationObj) throws ReservationAlreadyExistsException {

		System.out.println("Reservation Controller....Understanding client and talking to service layer...");
		
		String stmsg = null;
		try {
			stmsg = reservServe.addReservationService(reservationObj);
		}
		catch(ReservationAlreadyExistsException e) {
			return(e.getMessage());
		} catch(Exception e) {
			e.printStackTrace();
		}
		return stmsg;	
	}

	@PutMapping(path="/modifyReservation")
	public String modifyReservation(@RequestBody Reservation reservationObj) throws ReservationNotFoundException {
		System.out.println("Reservation Controller....Understanding client and talking to service layer...");
		
		String stmsg = null;
		try {
			stmsg= reservServe.modifyReservationService(reservationObj);
		} catch (ReservationNotFoundException e) {
			return e.getMessage();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		return stmsg;
	}


	@DeleteMapping(path="/deleteReservation")
	public String removeAdmin(@RequestBody Reservation reservationObj) throws ReservationNotFoundException{
		System.out.println("Reservation Controller....Understanding client and talking to service layer...");
		
		String stmsg = null;
		try {
			stmsg= reservServe.removeReservationService(reservationObj.getTicketno());
		} catch (ReservationNotFoundException e) {
			return e.getMessage();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		return stmsg;
	}
	@GetMapping(path="/getTicketDetail/{myticketNo}")
	@ResponseBody
	public ResponseEntity<Reservation> findTicketDetail(@PathVariable("myticketNo")int tno){
		System.out.println("Reservation Controller....Understanding client and talking to service layer...");
		Reservation reservationObj=null;
		
		try {
			reservationObj = reservServe.findReservationService(tno);
		} catch (ReservationNotFoundException e) {
			
			e.printStackTrace();
		}
		
		if(reservationObj==null)
		{ return ResponseEntity.notFound().build();
		
		}
		else {
			return ResponseEntity.ok(reservationObj);
		} 
	}
	
	}



	
	
	

