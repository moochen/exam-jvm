package com.yintai.exam.test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yintai.exam.entity.Customer;
import com.yintai.exam.entity.Deal;
import com.yintai.exam.entity.DealCurrency;
import com.yintai.exam.entity.DealStatus;
import com.yintai.exam.entity.DealType;
import com.yintai.exam.service.DealService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class DealServiceTest {
	
	@Configuration
	@ComponentScan(basePackages={"com.yintai.exam"})
	static class ContextConfiguration{}
	@Resource
	private DealService dealService;
	
	@Test
    public void testCreate(){
        Deal deal1=new Deal();
        deal1.setStatus(DealStatus.Success);
        deal1.setId(UUID.randomUUID().toString());
        deal1.setCreateTime(new Date());
        deal1.setCurrency(DealCurrency.RMB);
        deal1.setAmount(55.5);
        deal1.setType(DealType.Pay);
        Customer customer1 = new Customer();
        customer1.setId("1");
        customer1.setName("张三");
        deal1.setCustomer(customer1);
        dealService.createDeal(deal1);

        Deal deal2=new Deal();
        deal2.setStatus(DealStatus.Success);
        deal2.setId(UUID.randomUUID().toString());
        deal2.setCreateTime(new Date());
        deal2.setCurrency(DealCurrency.RMB);
        deal2.setAmount(55.5);
        deal2.setType(DealType.Pay);
        Customer customer2 = new Customer();
        customer2.setId("1");
        customer2.setName("张三");
        deal2.setCustomer(customer2);
        dealService.createDeal(deal2);

        Deal deal3=new Deal();
        deal3.setStatus(DealStatus.Success);
        deal3.setId(UUID.randomUUID().toString());
        deal3.setCreateTime(new Date());
        deal3.setCurrency(DealCurrency.RMB);
        deal3.setAmount(55.5);
        deal3.setType(DealType.Pay);
        Customer customer3 = new Customer();
        customer3.setId("1");
        customer3.setName("张三");
        deal3.setCustomer(customer3);
        dealService.createDeal(deal3);

        Deal deal4=new Deal();
        deal4.setStatus(DealStatus.Failed);
        deal4.setId(UUID.randomUUID().toString());
        deal4.setCreateTime(new Date());
        deal4.setCurrency(DealCurrency.RMB);
        deal4.setAmount(55.5);
        deal4.setType(DealType.Refund);
        Customer customer4 = new Customer();
        customer4.setId("1");
        customer4.setName("张三");
        deal4.setCustomer(customer4);
        dealService.createDeal(deal4);

        Deal deal5=new Deal();
        deal5.setStatus(DealStatus.Failed);
        deal5.setId(UUID.randomUUID().toString());
        deal5.setCreateTime(new Date());
        deal5.setCurrency(DealCurrency.RMB);
        deal5.setAmount(55.5);
        deal5.setType(DealType.Refund);
        Customer customer5 = new Customer();
        customer5.setId("1");
        customer5.setName("张三");
        deal5.setCustomer(customer5);
        dealService.createDeal(deal5);
    }
	

	@Test
	 public void testByStatus(){
        Deal deal=new Deal();
        deal.setStatus(DealStatus.Success);;
       List<Deal> list= dealService.findByStatus(deal.getStatus());
        for(Deal deals:list){
          System.out.println(deals.toString());
        }
    }
	
	@Test
	 public void testFindAll(){
        Deal deal=new Deal();
        deal.setStatus(DealStatus.Success);;
       List<Deal> list= dealService.findAll();
        for(Deal deals:list){
          System.out.println(deals.toString());
        }
    }
}
