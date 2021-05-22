package com.example.demo.layer3;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Admin;

@Repository
public interface AdminRepository {
	void addAdmin(Admin aRef);   //C - add/create
	Admin findAdmin(int adminid);     //R - find/reading
	Set<Admin> findAllAdmin();     //R - find all/reading all
	void modifyAdmin(Admin aRef); //U - modify/update
	void removeAdmin(int adminid);

}
