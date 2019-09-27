package com.well.cache;

public class CacheCleanerThreadFactory {
	
	
	
	 public static DealCacheCleanerTask createCacheStrategy (String evictionType) {
		 
	       if (evictionType. equalsIgnoreCase ("Time")){
	              return new DealTimeEvictionCacheCleaner();
	       }else if(evictionType. equalsIgnoreCase ("Size")){
	              return new DealSizeEvictionCacheCleaner();
	       }
	       throw new IllegalArgumentException("No such Eviction Startegy to initialise Cache");
	       }


}
