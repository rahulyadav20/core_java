package com.racecondition;

import java.awt.Color;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RGB {
	int red;
	int blue;
	int green;

	Lock myLock = new ReentrantLock();

	public RGB(int red, int blue, int green) {
		this.red = red;
		this.blue = blue;
		this.green = green;
	}

	public void setRGBLock(int red, int blue, int green) {
		/*
		 * This approach is same as making setRGB() synchronised.
		 * or
		 * putting code of setRGB() in synchronised block.
		 */
		try {
			myLock.lock();
			checkclrs(red, blue, green);
			this.red = red;
			this.blue = blue;
			this.green = green;
		} finally {
			myLock.unlock();
		}

	}

	public void setRGB(int red, int blue, int green) {
		checkclrs(red, blue, green);
		this.red = red;
		this.blue = blue;
		this.green = green;
	}

	private void checkclrs(int red, int blue, int green) {
		if ((red < 0 || red > 255) || (blue < 0 || blue > 255)
				|| (green < 0 || green > 255)) {
			throw new IllegalArgumentException();
		}
	}

	public String getColorLock() {
		/*
		 * This approach is same as making getColor() synchronised.
		 * or
		 * putting code of getColor() in synchronised block.
		 */
		Color myColor = null;
		try {
			myLock.lock();
			myColor = new Color(red, green, blue);
		} finally {
			myLock.unlock();
		}
		return myColor.toString();
	}

	public String getColor() {
		Color myColor = new Color(red, green, blue);
		return myColor.toString();
	}

	public void invert() {
		red = 255 - red;
		green = 255 - green;
		blue = 255 - blue;
	}
}
