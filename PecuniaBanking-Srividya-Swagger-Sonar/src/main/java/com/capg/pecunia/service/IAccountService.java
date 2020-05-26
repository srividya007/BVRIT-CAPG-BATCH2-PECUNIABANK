package com.capg.pecunia.service;

import java.util.List;

import com.capg.pecunia.entity.AccountBean;

public interface IAccountService  {
	
	//in this, we are designing methods and will be implemented in AccountServiceImpl class
	
	public AccountBean addAccount(AccountBean bean);
	
	public AccountBean updateAccount(AccountBean bean,long accNumber); 
	
	public void deleteAccount(long accNumber);

    public List<AccountBean> viewAll();

	public AccountBean findById(long accNumber);

	

}
