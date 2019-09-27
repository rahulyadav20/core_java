package com.javainuse.producer;

public class MyFlag {

	volatile boolean flag = true;

	public MyFlag(boolean flag) {
		super();
		this.flag = flag;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
