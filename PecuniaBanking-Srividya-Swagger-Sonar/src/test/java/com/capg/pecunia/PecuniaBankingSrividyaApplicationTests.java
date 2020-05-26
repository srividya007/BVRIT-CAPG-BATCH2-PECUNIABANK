
package com.capg.pecunia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.pecunia.dao.IAccountDao;
import com.capg.pecunia.entity.AccountBean;
import com.capg.pecunia.service.IAccountService;


//@RunWith(SpringRunner.class)
@SpringBootTest
class PecuniaBankingSrividyaApplicationTests {
	
	@Autowired
    IAccountService accountservice;
	
	@MockBean 
	IAccountDao accountDao;

	@Test
	public void addAccount() {
		AccountBean bean= new AccountBean();
		bean.setAccNumber(8L);
		bean.setCustomerName("Srividya");
		bean.setCustomerPhno( 9177894094L);
		bean.setCustomerAddress1("Alwal");
		bean.setCustomerAddress2("Hyderabad");
		bean.setAccType("savings");
		bean.setCity("Secundrabad");
		bean.setState("telangana");
		bean.setCountry("india");
		bean.setPincode(506002);
		bean.setBalance(500.50);
		
		Mockito.when(accountDao.addAccount(bean)).thenReturn(bean);
		assertThat(accountservice.addAccount(bean)).isEqualTo(bean);
	}
	
	
	@Test
    public void deleteAccount() {
		AccountBean bean= new AccountBean();
		bean.setAccNumber(8L);
		bean.setCustomerName("Srividya");
		bean.setCustomerPhno( 9177894094L);
		bean.setCustomerAddress1("Alwal");
		bean.setCustomerAddress2("Hyderabad");
		bean.setAccType("savings");
		bean.setCity("Secundrabad");
		bean.setState("telangana");
		bean.setCountry("india");
		bean.setPincode(506002);
		bean.setBalance(500.50);
	}
	
	
	@Test
	public void viewAll() {
		AccountBean bean= new AccountBean();
		bean.setAccNumber(8L);
		bean.setCustomerName("Srividya");
		bean.setCustomerPhno( 9177894094L);
		bean.setCustomerAddress1("Alwal");
		bean.setCustomerAddress2("Hyderabad");
		bean.setAccType("savings");
		bean.setCity("Secundrabad");
		bean.setState("telangana");
		bean.setCountry("india");
		bean.setPincode(506002);
		bean.setBalance(500.50);

		AccountBean bean2= new AccountBean();
		bean2.setAccNumber(8L);
		bean2.setCustomerName("Srividya");
		bean2.setCustomerPhno( 9177894094L);
		bean2.setCustomerAddress1("Alwal");
		bean2.setCustomerAddress2("Hyderabad");
		bean2.setAccType("savings");
		bean2.setCity("Secundrabad");
		bean2.setState("telangana");
		bean2.setCountry("india");
		bean2.setPincode(506002);
		bean2.setBalance(500.50);
		List<AccountBean> list = new ArrayList<>();
		list.add(bean);
		list.add(bean2);
		Mockito.when(accountDao.viewAll()).thenReturn(list);
		assertThat(accountservice.viewAll()).isEqualTo(list);
	}

	
	
	
	
	/*
	 * @Test public void viewAll() { List<AccountBean> list =
	 * accountservice.viewAll(); assertEquals(list.size(),0);
	 * 
	 * }
	 */
}