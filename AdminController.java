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

import com.example.demo.layer2.Admin;
import com.example.demo.layer4.AdminService;
import com.example.demo.layer4.exceptions.AdminAlreadyExistsException;
import com.example.demo.layer4.exceptions.AdminNotFoundException;

@RestController
public class AdminController {
	
    @Autowired
    AdminService adminserv;
	 

@GetMapping(path="/getAdmin/{myadmin}")
@ResponseBody
public ResponseEntity<Admin> getAdmin(@PathVariable("myadmin") Integer adminid ) throws AdminNotFoundException {
	System.out.println("Admin Controller....Understanding client and talking to service layer...");
	Admin admin = null;
	admin = adminserv.findAdminService(adminid);
	if(admin==null)
	{
		return ResponseEntity.notFound().build();
		 
	}
	else {
		
	return ResponseEntity.ok(admin);
	}
}
@GetMapping(path="/getAllAdmin")
@ResponseBody
public Set<Admin> getAllAdmins()
{
	System.out.println("Admin Controller....Understanding client and talking to service layer...");
	Set<Admin> adminSet= adminserv.findAllAdminService();
	return adminSet;
}



@PostMapping(path="/addAdmin")
public String addAdmin(@RequestBody Admin admin) throws AdminAlreadyExistsException{

	System.out.println("Admin Controller....Understanding client and talking to service layer...");
	
	String stmsg = null;
	try {
		stmsg = adminserv.addAdminService(admin);
	} catch (AdminAlreadyExistsException e) {
		return e.getMessage();
	} 
	catch(Exception e) {
		e.printStackTrace();
	}
	return stmsg;	
}


@PutMapping(path="/modifyAdmin")
public String modifyAdmin(@RequestBody Admin admin) throws AdminNotFoundException{
	System.out.println("Admin Controller....Understanding client and talking to service layer...");
	
	String stmsg = null;
	try {
		stmsg= adminserv.modifyAdminService(admin);
	} catch (AdminNotFoundException e) {
		return e.getMessage();
	} 
	catch(Exception e) {
		e.printStackTrace();
	}
	return stmsg;
}


@DeleteMapping(path="/deleteadmin")
public String removeAdmin(@RequestBody Admin admin) throws AdminNotFoundException{
	System.out.println("Admin Controller....Understanding client and talking to service layer...");
	
	String stmsg = null;
	try {
		stmsg= adminserv.removeAdminService(admin.getAdminid());
	} catch (AdminNotFoundException e) {
		return e.getMessage();
	} 
	catch(Exception e) {
		e.printStackTrace();
	}
	return stmsg;
}

}


