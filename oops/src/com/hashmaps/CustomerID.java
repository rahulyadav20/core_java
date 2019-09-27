package com.hashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * If either of HashCode or equals is not overridden hashMap.get will return null.
 * @author ryada9
 *
 */
public class CustomerID {
	private long crmID;
	private int nameSpace;

	public CustomerID(long crmID, int nameSpace) {
		super();
		this.crmID = crmID;
		this.nameSpace = nameSpace;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof CustomerID))
			return false;
		if (obj == this)
			return true;
		return this.crmID == ((CustomerID) obj).crmID
				&& this.nameSpace == ((CustomerID) obj).nameSpace;
	}

	public int hashCode() {
		int result = 0;
		result = (int) (crmID / 12) + nameSpace;
		return result;
	}

	public static void main(String[] args) {
		Map m = new HashMap();
		m.put(new CustomerID(2345891234L, 0), "Jeff Smith");
		System.out.println(m.get(new CustomerID(2345891234L, 0)));
		
		ConcurrentHashMap<Integer, String> dummyMap = new ConcurrentHashMap<Integer,String>();
		dummyMap.put(10, "Rahul");
		dummyMap.put(20, "Ajay");
		
		System.out.println(dummyMap.contains(10)); // Be carefull with this method it check for Value not key.
		System.out.println(dummyMap.get(20));
		
	}
}
