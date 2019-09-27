package com.facade;

public class ProfileFacade {
	private RingTone ringTone= new RingTone();
	private RingVolume ringVolume = new RingVolume();
	private WallPaper wallpaper = new WallPaper();
	
	public ProfileFacade(){
		
	}
	
	public void setOfficeProfile(){
		ringTone.setRingTone(RingTone.RingToneType.AIRTEL);
		ringVolume.setRingVolume(RingVolume.RingVolumeType.MEDIUM);
		wallpaper.setWallPaper(WallPaper.WallPaperType.FLOWERS);		
	}
	
	public void setOutdoorProfile(){
		ringTone.setRingTone(RingTone.RingToneType.NOKIA);
		ringVolume.setRingVolume(RingVolume.RingVolumeType.LOUD);
		wallpaper.setWallPaper(WallPaper.WallPaperType.HILLS);
	}
	
	public void setDNBProfile(){
		ringTone.setRingTone(RingTone.RingToneType.SILENT);
		ringVolume.setRingVolume(RingVolume.RingVolumeType.LOW);
		wallpaper.setWallPaper(WallPaper.WallPaperType.MOON);
	}
	

}
