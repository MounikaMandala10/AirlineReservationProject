package com.example.demo.layer3;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import com.example.demo.layer2.Reservation;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

	@PersistenceContext
    EntityManager entityManager;
	
	@Transactional
	public void addReservation(Reservation rRef) {
		entityManager.persist(rRef);

	}

	@Transactional
	public Reservation findReservation(int tno) {
		
		return entityManager.find(Reservation.class, tno);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public Set<Reservation> findAllReservation() {
		Set<Reservation> tSet;
		Query query = entityManager.createQuery("from Reservation");
		tSet = new HashSet(query.getResultList());
		return tSet;
		
	}

	@Transactional
	public void modifyReservation(Reservation rRef) {
		entityManager.merge(rRef);
		
	}

	@SuppressWarnings("unused")
	@Transactional
	public void removeReservation(int tno) {
		Reservation r = entityManager.find(Reservation.class,tno);
		entityManager.remove(tno);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public Set<Reservation> findTicketDetails(int tno) {
		Set<Reservation> tSet;
		Query query = entityManager.createNativeQuery("select * from Reservation where ticketno = "+tno,Reservation.class);
		tSet = new HashSet(query.getResultList());
		return tSet;
	}

}
