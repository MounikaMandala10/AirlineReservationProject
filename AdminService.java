package com.example.demo.layer4;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Admin;
import com.example.demo.layer4.exceptions.AdminAlreadyExistsException;
import com.example.demo.layer4.exceptions.AdminNotFoundException;
@Service
public interface AdminService {
	String addAdminService(Admin aRef) throws AdminAlreadyExistsException;   
	Admin findAdminService(int adminid) throws AdminNotFoundException;     
	Set<Admin> findAllAdminService();     
	String modifyAdminService(Admin aRef) throws AdminNotFoundException; 
	String removeAdminService(int adminid) throws AdminNotFoundException;


}
