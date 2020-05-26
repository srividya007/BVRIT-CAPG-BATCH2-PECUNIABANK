package com.capg.pecunia.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.pecunia.dao.IAccountDao;
import com.capg.pecunia.entity.AccountBean;

@Service
public class AccountServiceImpl implements IAccountService {
	
	 @Autowired
	 IAccountDao accountDao;
	 
	 
		/*
		 * this method will insert details into entity of account bean
		 */	 
	 @Override
		public AccountBean addAccount(AccountBean bean) {
			
			return accountDao.addAccount(bean);
		}
	 
	    /*
		 * this method will update the inserted details into entity of account bean
		 */
	    @Override
		public AccountBean updateAccount(AccountBean bean, long accNumber) {
			return accountDao.updateAccount(bean, accNumber);
		}
	   
	    /*
		 * this method will delete details from entity of account bean
		 */
	    
	    @Override
		public void deleteAccount(long accNumber) {
			accountDao.deleteAccount(accNumber);
		}
	    
	    /*
		 * this method will show details of all accounts from entity of account bean
		 */

		@Override
		public List<AccountBean> viewAll() {
			 
			return accountDao.viewAll();
		}

		@Override
		public AccountBean findById(long accNumber) {
			
			return accountDao.findById(accNumber);
		}
}