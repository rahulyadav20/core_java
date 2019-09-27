package com.facade;

public class RingTone {
	public enum RingToneType {
		SILENT, NOKIA, AIRTEL,IPL
	}
	
	RingToneType ringTone;
	
	public RingTone() {

	}
	
	public void setRingTone(RingToneType ringToneType){
		ringTone = ringToneType;
	}
	
	public RingToneType getRingTone(){
		return ringTone;
	}
}
