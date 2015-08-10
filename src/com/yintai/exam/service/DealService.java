package com.yintai.exam.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.yintai.exam.entity.Deal;
import com.yintai.exam.entity.DealStatus;

@Service
public class DealService {

	public static Map<String, Deal> dealMap = new HashMap<String, Deal>();

	public Deal createDeal(Deal deal){
		deal.setId(UUID.randomUUID().toString());
		deal.setCreateTime(new Date());
		dealMap.put(deal.getId(), deal);
		return deal;
	}
	
	public List<Deal> findByStatus(DealStatus dealStatus){
		List<Deal> deals = new ArrayList<Deal>();
		for(Deal deal : deals){
			if(deal.getStatus().equals(dealStatus)){
				deals.add(deal);
			}
		}
		return deals;
	}
	
	public List<Deal> findAll(){
		List<Deal> deals = new ArrayList<Deal>();
		deals.addAll(deals);
		return deals;
	}
}
