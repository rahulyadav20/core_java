package com.collections;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
	
	public static void main(String args[]){
		
		TreeSet<Loan> loanTreeSet = new TreeSet<Loan>();
		
		loanTreeSet.add(new Loan(100));
		loanTreeSet.add(new Loan(10));
		loanTreeSet.add(new Loan(900));
		loanTreeSet.add(new Loan(90));
		
		System.out.println("Last node in Tree :: "+ loanTreeSet.last());
		
		System.out.println("Print all nodes(default sorted) ::"+ loanTreeSet);
		
		Iterator<Loan> iterator = loanTreeSet.iterator(); // Return assending order Iterator.
		System.out.println("--------- Print Ascending order ---------");
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
        Iterator<Loan> descIterator = loanTreeSet.descendingIterator(); // Return descending order Iterator.
		
        System.out.println("--------- Print descending order ---------");
		while(descIterator.hasNext()){
			System.out.println(descIterator.next());
		}
		
		System.out.println("--------- Print Ceiling, Immediate Loan > 20 ---------");
		System.out.println(loanTreeSet.ceiling(new Loan(20)));
		
		System.out.println("HeadSet : Returns a view of the portion of this set whose elements are strictly less than toElement.");
		System.out.println(loanTreeSet.headSet(new Loan(900)));		
	}

}

class Loan implements Comparable<Loan>{
	
	Integer loanID;
	
	

	public Loan(Integer loanID) {
		super();
		this.loanID = loanID;
	}

	public Integer getLoanID() {
		return loanID;
	}

	public void setLoanID(Integer loanID) {
		this.loanID = loanID;
	}
		

	@Override
	public String toString() {
		return "Loan ID : "+ this.getLoanID();
	}

	@Override
	public int compareTo(Loan compareLoan) {
		
		int compareQuantity = compareLoan.getLoanID();

		//ascending order
		return this.loanID - compareQuantity;

		//descending order
		//return compareQuantity - this.quantity;
	}
	
	
}
