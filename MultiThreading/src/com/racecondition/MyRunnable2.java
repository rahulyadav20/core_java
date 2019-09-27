package com.racecondition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyRunnable2 implements Runnable {

	RGB rgb;
	Lock myLock = new ReentrantLock();

	public MyRunnable2(RGB rgb) {
		this.rgb = rgb;
	}

	@Override
	public void run() {
		
		
		/*
		 * Most feasible solution, we have made set and get method atomic, by
		 * releasing the lock only after performing complete task. This approach
		 * is also feasible if my class is written without syncronised methods
		 * nd i done have access to source code to modify these methods.
		 */

		
		  synchronized (rgb) { rgb.setRGB(222, 111, 001);
		  rgb.invert();
		  System.out.println(" MyRunnable2 Thread :: "+rgb.getColor()); }
		 

		/*
		 * Wrong approach, lock will be on this object nd not on rgb object. For
		 * this approach to work RGB methods has to be put in Lock, check RGB
		 * class.
		 */

		/*
		 * try{ myLock.lock(); rgb.setRGB(222, 111, 001);
		 * rgb.invert();
		 * System.out.println(" MyRunnable2 Thread "+rgb.getColor()); }finally{
		 * myLock.unlock(); }
		 */

		/*
		 * Following approach will not work even if i make both methods
		 * synchronised/use Lock. becuase after executing setRGB, lock will be
		 * released and thread2 can corrupt rgb values. and thread1 will be
		 * printing corrupted rgb values after aquiring lock.
		 */
		/*rgb.setRGB(222, 111, 001);
		rgb.invert();
		System.out.println(" MyRunnable2 Thread :: " + rgb.getColor());
*/

	}

}
