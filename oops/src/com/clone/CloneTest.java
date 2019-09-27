package com.clone;

public class CloneTest implements Cloneable {

	int i = 10;

	protected Object clone() {
		try {
			super.clone();
			return new CloneTest();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Even if clone method is not overridden, shallow cloning will be done, but
	 * call to clone will required to be nested in try/catch.
	 * 
	 * If Clonable is not implemented call to clone() will throw ClonNotSuportedException.
	 */
	public static void main(String args[]) {
		CloneTest obj = new CloneTest();
		System.out.println(obj.hashCode());
		CloneTest objClone;

		objClone = (CloneTest) obj.clone();
		System.out.println(objClone.i);
		System.out.println(objClone.hashCode());
	}
}
