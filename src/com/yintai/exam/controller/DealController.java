package com.yintai.exam.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yintai.exam.entity.Deal;
import com.yintai.exam.entity.DealStatus;
import com.yintai.exam.service.DealService;
import com.yintai.exam.util.RetData;

@Controller
@RequestMapping(value="/deal")
public class DealController {

	static Logger logger = Logger.getLogger(DealController.class);
	@Autowired
	private DealService dealService;
	
	@RequestMapping(value = { "/create" }, method = { RequestMethod.GET })
    public RetData createDeal( Deal deal ,  HttpServletRequest request) {
        RetData data=new RetData();
              try{
                  if(deal.getId()==null){
                      data.setCode("error");
                      data.setMessage("id not is null");
                  }
                  if(deal.getType()==null){
                      data.setCode("error");
                      data.setMessage("type not is null");
                  }
                  if(deal.getId()==null){
                      data.setCode("error");
                      data.setMessage("customer not is null");
                  }
                  if(deal.getCurrency()==null){
                      data.setCode("error");
                      data.setMessage("currency not is null");
                  }
                  if(deal.getStatus()==null){
                      data.setCode("error");
                      data.setMessage("status not is null");
                  }
             dealService.createDeal(deal);
              }catch (Exception e){
                  data.setCode("error");
                  data.setMessage("system error");
              }
             return data;
    }
	
	@RequestMapping(value = { "/findByStatu" }, method = {RequestMethod.GET })
    public RetData findByStatus(   HttpServletRequest request) {
        RetData data=new RetData();
        Deal deal =new Deal();
         try{
             String status=request.getParameter("status");
             if(status==null){
                 data.setCode("error");
                 data.setMessage("status is not null");
             }
             deal.setStatus(deal.getStatus());
             data.setResult( dealService.findByStatus(deal.getStatus())) ;
         }catch (Exception e){
             data.setCode("error");
             data.setMessage("system error");
         }
        return data;
    }
	
	   @RequestMapping(value = { "/findAll" }, method = {RequestMethod.GET })
	       public RetData findAll(   HttpServletRequest request) {
	           RetData data=new RetData();
	           Deal deal =new Deal();
	            try{
	                String status=request.getParameter("status");
	                if(status==null){
	                    data.setCode("error");
	                    data.setMessage("status is not null");
	                }
	                deal.setStatus(DealStatus.Success);
	                data.setResult( dealService.findAll()) ;
	            }catch (Exception e){
	                data.setCode("error");
	                data.setMessage("system error");
	            }
	           return data;
	       }
	
}
