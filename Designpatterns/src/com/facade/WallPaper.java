package com.facade;

public class WallPaper {
	
	public enum WallPaperType {
		FLOWERS, MOON, HILLS,RIVER
	}
	
	WallPaperType wallPaper;
	
	public WallPaper() {

	}
	
	public void setWallPaper(WallPaperType wallPaperType){
		wallPaper = wallPaperType;
	}
	
	public WallPaperType getWallPaper(){
		return wallPaper;
	}

}
