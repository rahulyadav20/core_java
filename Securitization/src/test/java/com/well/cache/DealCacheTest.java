package com.well.cache;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.well.config.AppConfig;
import com.well.entity.Deal;

import junit.framework.TestCase;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class DealCacheTest extends TestCase {
	
	
	@Autowired
	DealCache dealCache;
	
	
	private static Map<String,Deal> dealMap = new HashMap<String,Deal>();
	
	
	@BeforeClass
    public static void createMockDeals() {
		
		dealMap.put("1", new Deal("1","Deal_One"));
		dealMap.put("2", new Deal("2","Deal_Two"));
		dealMap.put("3", new Deal("3","Deal_Three"));
		dealMap.put("4", new Deal("4","Deal_Four"));
		dealMap.put("5", new Deal("5","Deal_Five"));
    }
	
	@Test
	public void testConsoleInput() {
		
			
		/*Scanner sc=new Scanner(System.in); 
		System.out.println("Enter your rollno");  
		int rollno=sc.nextInt();  
		System.out.println(rollno);*/
		System.out.println("Enter your rollno");
		Scanner dis=new Scanner(System.in);
		dis.useDelimiter("\\D");
		int a,c;
		a=dis.nextInt();
		String b=dis.next();
		c=dis.nextInt();
		System.out.println(a + " " + b + " " + c);
		

	}
	
	
	@Test
	public void testGetDeal() {
		
		assertNotNull(dealCache);
		Deal deal = dealCache.getDeal("ID");
		
		/*Scanner sc=new Scanner(System.in); 
		System.out.println("Enter your rollno");  
		int rollno=sc.nextInt();  
		System.out.println(rollno);*/
		
		Scanner dis=new Scanner(System.in);
		dis.useDelimiter("\\D");
		int a,c;
		a=dis.nextInt();
		String b=dis.next();
		c=dis.nextInt();
		System.out.println(a + " " + b + " " + c);
		
		Assert.assertEquals("1", deal.getDealID());

	}
	
	@Test
	public void testEvictionStrategyTime() {
		
		assertNotNull(dealCache);
		
		dealCache.addDealToCache(dealMap.get("1"));
		dealCache.addDealToCache(dealMap.get("2"));
		dealCache.addDealToCache(dealMap.get("3"));
		
		Deal deal = dealCache.getDeal("1");
		Assert.assertEquals("1", deal.getDealID());
		try {
			deal = dealCache.getDeal("2");
			assertNotNull(deal);
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		deal = dealCache.getDeal("2"); 
		assertNull(deal);
		

	}
	
	
	
	

}
