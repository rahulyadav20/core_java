package com.well.cache;

import java.text.SimpleDateFormat;
import java.util.Map;

import com.well.entity.Deal;

public abstract class DealCacheCleanerTask implements Runnable{
	
	protected Map<String, Long> timeMap;
	protected Map<String, Deal> dealCache;
	protected long expiryInMillis = 1000;
	protected long cacheSize = 10;
	
	protected static final SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss:SSS");
	
	protected abstract void cleanMap();

	public Map<String, Long> getTimeMap() {
		return timeMap;
	}

	public void setTimeMap(Map<String, Long> timeMap) {
		this.timeMap = timeMap;
	}

	public void setDealCache(Map<String, Deal> dealCache) {
		this.dealCache = dealCache;
	}

	public long getExpiryInMillis() {
		return expiryInMillis;
	}

	public void setExpiryInMillis(long expiryInMillis) {
		this.expiryInMillis = expiryInMillis;
	}

	public long getCacheSize() {
		return cacheSize;
	}

	public void setCacheSize(long cacheSize) {
		this.cacheSize = cacheSize;
	}
	
	
	
	

}
