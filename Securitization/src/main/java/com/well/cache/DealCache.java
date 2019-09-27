package com.well.cache;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.well.datasource.DealDAO;
import com.well.entity.Deal;

@Component
public class DealCache {

	@Autowired
	DealDAO dealDao;

	@Value("${cache.eviction.strategy}")
	private String evictionStrategy;      //Eviction startegy read from property file. Time or Size.

	@Value("${cache.eviction.time}")
	private String evictionTime;   // Eviction time.
	
		

	private Map<String, Long> timeMap = new ConcurrentHashMap<String, Long>(); //Maintains the map of Deal and the time it was last accessed or added to cache.
	private Map<String, Deal> dealCache = new ConcurrentHashMap<String, Deal>(); // Maintains the Map of Deals in cache.


	public DealCache() {
		evictionStrategy = "Time"; // TODO initialize with property file
		initialize();
	}

	void initialize() {

		//loadCache();
		DealCacheCleanerTask cacheCleaner = CacheCleanerThreadFactory.createCacheStrategy(evictionStrategy);
		cacheCleaner.setDealCache(dealCache);
		cacheCleaner.setTimeMap(timeMap);
		//cacheCleaner.setCacheSize(Long.parseLong(evictionSize));  //TODO Read from property file
		//cacheCleaner.setExpiryInMillis(Long.parseLong(evictionTime));
		cacheCleaner.setCacheSize(4);
		cacheCleaner.setExpiryInMillis(20000);
		new Thread(cacheCleaner).start();
	}


	public Deal getDeal(String dealID) {
		/*
		 * Deal read time is updated in cache, so that it can be evicted by
		 * CacheCleanerThread after passing its age.
		 */

		if (dealCache.containsKey(dealID)) {
			Deal value = dealCache.get(dealID);
			timeMap.remove(dealID);

			Date date = new Date();
			timeMap.put(dealID, date.getTime());
			return value;

		} else {
			return null;
		}

	}
	
	public void addDealToCache(Deal deal){
		/*
		 * Add Deal to the cache when required after initial loading. 
		 */
		dealCache.put(deal.getDealID(), deal);
		Date date = new Date();
		timeMap.put(deal.getDealID(), date.getTime());
	}


	public String getEvictionStrategy() {
		return evictionStrategy;
	}

	public void setEvictionStrategy(String evictionStrategy) {
		this.evictionStrategy = evictionStrategy;
	}

	public String getEvictionTime() {
		return evictionTime;
	}

	public void setEvictionTime(String evictionTime) {
		this.evictionTime = evictionTime;
	}

}