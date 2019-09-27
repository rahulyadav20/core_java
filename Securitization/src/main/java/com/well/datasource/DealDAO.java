package com.well.datasource;

import java.util.List;

import com.well.entity.Deal;

public interface DealDAO {
	
	public Deal loadDeal(String dealID);

	public List<Deal> loadAllDeals();

}
