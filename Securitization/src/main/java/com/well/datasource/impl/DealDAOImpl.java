package com.well.datasource.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.well.datasource.DealDAO;
import com.well.entity.Deal;


@Repository("dealDao")
public class DealDAOImpl implements DealDAO{

	public Deal loadDeal(String dealID) {
		return new Deal("1","newDeal");
	}

	public List<Deal> loadAllDeals(){
		List<Deal> dealList = new ArrayList<Deal>();
		dealList.add(new Deal("1","Deal_One"));
		dealList.add(new Deal("2","Deal_Two"));
		dealList.add(new Deal("3","Deal_Three"));
		dealList.add(new Deal("4","Deal_Four"));
		dealList.add(new Deal("5","Deal_Five"));
		return dealList;
	}

}
