package com.equals;


public class CheckEquals {
	private long crmID;
	private int nameSpace;

	public CheckEquals(long crmID, int nameSpace) {
		super();
		this.crmID = crmID;
		this.nameSpace = nameSpace;
	}

	/*public boolean equals(Object obj) {
		if (!(obj instanceof CheckEquals))
			return false;
		if (obj == this)
			return true;
		return this.crmID == ((CheckEquals) obj).crmID
				&& this.nameSpace == ((CheckEquals) obj).nameSpace;
	}*/

	public static void main(String[] args) {
		CheckEquals obj1 = new CheckEquals(12, 10);
		CheckEquals obj2 = new CheckEquals(22, 11);

		if (obj1 == obj2) {
			System.out.println("obj ref same object");
		}

		if (obj1.equals(obj2)) {
			/**
			 * Equals by default do comparison on ref exactly like obj1 == obj2.
			 * if we want to compare values held by objects we need to override
			 * equals method.
			 * 
			 * O/P : false
			 */
			System.out.println("true");
		} else {
			System.out.println("false");
		}

		if (obj1.equals(obj1)) {
			/**
			 * Equals by default do comparison on ref exactly like obj1 == obj2.
			 * if we want to compare values held by objects we need to override
			 * equals method.
			 * 
			 * O/P : True
			 */
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
