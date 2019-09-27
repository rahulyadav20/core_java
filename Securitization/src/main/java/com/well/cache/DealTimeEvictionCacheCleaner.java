package com.well.cache;

import java.util.Date;

import com.well.entity.Deal;

/**
 * 
 * @author ryada9
 * 
 * Task to clean the cache on basic Time eviction strategy.
 */
public class DealTimeEvictionCacheCleaner extends DealCacheCleanerTask{

	@Override
	protected void cleanMap() {
		long currentTime = new Date().getTime();
		for (String key : timeMap.keySet()) {
			if (currentTime > (timeMap.get(key) + expiryInMillis)) {
				Deal value = dealCache.remove(key);
				timeMap.remove(key);
				System.out.println("Removing : " + sdf.format(new Date()) + " : " + key + " : " + value);
			}
		}
	}

	public void run() {
		System.out.println("Initiating Cleaner Thread..");
		while (true) {
			cleanMap();
			try {
				System.out.println("Cleaner thread running");
				Thread.sleep(expiryInMillis / 2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	
}
