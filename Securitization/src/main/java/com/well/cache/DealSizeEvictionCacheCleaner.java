package com.well.cache;

import java.util.Date;

import com.well.entity.Deal;

public class DealSizeEvictionCacheCleaner extends DealCacheCleanerTask{
	/**
	 * 
	 * @author ryada9
	 * 
	 * Task to clean the cache on basic Size eviction strategy.
	 */

	private long cacheSize = 10;
	
	@Override
	protected void cleanMap() {
		long currentTime = new Date().getTime();
		
		if(timeMap.size() > cacheSize){
		
			for (String key : timeMap.keySet()) {
				if (currentTime > (timeMap.get(key) + expiryInMillis)) {
					Deal value = dealCache.remove(key);
					timeMap.remove(key);
					System.out.println("Removing : " + sdf.format(new Date()) + " : " + key + " : " + value);
				}
			}
		}
		
	}

	public void run() {
		System.out.println("Initiating Cleaner Thread..");
		while (true) {
			cleanMap();
			try {
				Thread.sleep(cacheSize / 2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	public long getCacheSize() {
		return cacheSize;
	}

	public void setCacheSize(long cacheSize) {
		this.cacheSize = cacheSize;
	}


}
