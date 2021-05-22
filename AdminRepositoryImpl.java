package com.example.demo.layer3;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.Admin;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

	@PersistenceContext
    EntityManager entityManager;
	
	@Transactional
	public void addAdmin(Admin aRef) {
		entityManager.persist(aRef);
		
		
	}
	@Transactional
	public Admin findAdmin(int adminid) {
		return entityManager.find(Admin.class,adminid);
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public Set<Admin> findAllAdmin() {
		Set<Admin> adminSet;
		Query query = entityManager.createQuery("from Admin");
		adminSet = new HashSet(query.getResultList());
		return adminSet;
	
	}

	@Transactional
	public void modifyAdmin(Admin aRef) {
		entityManager.merge(aRef);
	}

	@Transactional
	public void removeAdmin(int adminid) {
		@SuppressWarnings("unused")
		Admin sTemp = entityManager.find(Admin.class,adminid);
		entityManager.remove(sTemp);
	
	}

}
