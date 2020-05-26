package com.capg.pecunia.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.pecunia.entity.AccountBean;
import com.capg.pecunia.service.*;
import com.capg.pecunia.exception.*;



@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class AccountRestController {

	@Autowired
     IAccountService accountservice;
	
	
	/*
	 * @Author:Srividya 
	 * this method addAccount() is used to add an account and
	 * insert details into entity of AccountBean
	 */
	@PostMapping(path="/add")
	public ResponseEntity<String> addAccount(@RequestBody AccountBean bean) {
		accountservice.addAccount(bean);
		ResponseEntity<String> responseEntity = new ResponseEntity("Hello, Your Account is created successfully with Account Number "+ bean.getAccNumber(),HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
	}

	/*
	 * @Author:Srividya 
	 * this method findById() is used to find an account and
	 * return details into entity of AccountBean
	 */
	
	@GetMapping("/find/{accNumber}")
	public ResponseEntity<AccountBean> findById(@PathVariable long accNumber){
	
		AccountBean bean = accountservice.findById(accNumber);
		if(bean==null) {
			throw new AccountNotFoundException("Account not found with Account Number :"+accNumber);
		}
		return new ResponseEntity<AccountBean>(bean, HttpStatus.OK);
	}
	
	/*
	 * @Author:Srividya 
	 * this method updateAccount() is used to update an existing account and
	 * update details into entity of AccountBean
	 */
	
	@PutMapping(path="/update/{accNumber}")
	public ResponseEntity<AccountBean> updateAccount( @RequestBody AccountBean bean, @PathVariable long accNumber){
		bean= accountservice.updateAccount(bean, accNumber);
		return new ResponseEntity<AccountBean>(bean,new HttpHeaders(),HttpStatus.OK);
	}
	
	/*
	 * @Author:Srividya
	 * this method deleteAccount() is used to delete an account and
	 * remove details into entity of AccountBean
	 */
	
	@DeleteMapping(path="/delete/{accNumber}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long accNumber) {
		 accountservice.deleteAccount(accNumber);
			
		ResponseEntity<String> responseEntity = new ResponseEntity("Hello Your Account is Deleted Successfully" ,HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity ;
	}
	
	/*
	 * @Author:Srividya 
	 * this method viewAll() is used to view 
	 * all the accounts
	 */
	
	@GetMapping("/viewall")   //GET:         
	public ResponseEntity<List<AccountBean>> viewAll() {

		List<AccountBean> list = accountservice.viewAll();
		return new ResponseEntity<List<AccountBean>>(list,new HttpHeaders(),HttpStatus.OK);
		
}
}
