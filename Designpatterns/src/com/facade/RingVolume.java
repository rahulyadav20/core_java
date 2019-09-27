package com.facade;

public class RingVolume {

	public enum RingVolumeType {
		LOW, MEDIUM, HIGH, LOUD
	}

	RingVolumeType ringVolume;

	public RingVolume() {

	}

	public void setRingVolume(RingVolumeType ringVolume) {
		this.ringVolume = ringVolume;
	}

	public RingVolumeType getRingVolume() {
		return ringVolume;
	}

}
