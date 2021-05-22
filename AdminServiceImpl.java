package com.example.demo.layer4;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Admin;
import com.example.demo.layer3.AdminRepository;
import com.example.demo.layer4.exceptions.AdminAlreadyExistsException;
import com.example.demo.layer4.exceptions.AdminNotFoundException;
@Service
public class AdminServiceImpl implements AdminService
{

	@Autowired
	AdminRepository adminRepo;

	@Override
	public String addAdminService(Admin aRef)  throws AdminAlreadyExistsException {
		try {
			adminRepo.addAdmin(aRef);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 throw new AdminAlreadyExistsException("Admin already exists");
		}
				return "Admin added sucessfully";
	}

	@Override
	public Admin findAdminService(int adminid) throws AdminNotFoundException {
		try {
			return adminRepo.findAdmin(adminid);
		} catch (Exception e) {
			throw new AdminNotFoundException("Admin not found");	
		}
		}

	@Override
	public Set<Admin> findAllAdminService() {
		
		return adminRepo.findAllAdmin();
	}

	@Override
	public String modifyAdminService(Admin aRef) throws AdminNotFoundException{
		Admin a= adminRepo.findAdmin(aRef.getAdminid());
		if(a!=null)
		{
			adminRepo.modifyAdmin(aRef);
		}
		else
		{
			throw new AdminNotFoundException("admin not found");
		}
	
				return "admin modified sucessfully";
	}

	@Override
	public String removeAdminService(int adminid) throws AdminNotFoundException {
		Admin a= adminRepo.findAdmin(adminid);
		if(a!=null)
		{
			adminRepo.removeAdmin(a.getAdminid());
		}
		else
		{
			throw new AdminNotFoundException("admin not found");
		}
	
			return "admin deleted sucessfully";
	}
	
}
	