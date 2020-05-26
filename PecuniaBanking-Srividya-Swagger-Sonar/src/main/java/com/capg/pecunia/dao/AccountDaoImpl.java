package com.capg.pecunia.dao;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capg.pecunia.entity.AccountBean;

@Repository
@Transactional
public class AccountDaoImpl implements IAccountDao{

	@PersistenceContext
	EntityManager entityManager;

	/* This method creates an account and returns bean to service layer */
	
	@Override
	public AccountBean addAccount(AccountBean bean) {
		bean.setAccNumber(Long.parseLong(String.valueOf(Math.abs(new Random().nextLong())).substring(0,12)));
		entityManager.merge(bean);
		return bean;
	}

	/* This method updates an existing account and returns bean to service layer */
	@Transactional
	public AccountBean updateAccount(AccountBean bean, long accNumber) {
	
		  entityManager.merge(bean);
		return bean;
	}
	
	/* This method deletes an account and returns to service layer */
	@Override
	public void deleteAccount(long accNumber) {
		AccountBean bean=entityManager.find(AccountBean.class, accNumber);
		entityManager.remove(bean);
	}

	/* This method shows all accounts and returns to service layer */
	@Override
	public List<AccountBean> viewAll() {
		Query query = entityManager.createQuery("select e from AccountBean e");
		List<AccountBean> list= query.getResultList();
		return list;
	}

	@Override
	public AccountBean findById(long accNumber) {
		AccountBean bean = entityManager.find(AccountBean.class, accNumber);
		return bean;
	}


}