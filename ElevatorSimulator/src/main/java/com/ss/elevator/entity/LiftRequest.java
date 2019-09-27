package com.ss.elevator.entity;

public class LiftRequest {
	
	String direction;
	int floor;
	String inputSource;
	
	public LiftRequest(){
		super();
	}
	
	
	public LiftRequest(String inputSource, String direction, int floor) {
		super();
		
		this.inputSource = inputSource;
		this.direction = direction;
		this.floor = floor;
	}


	public String getDirection() {
		return direction;
	}


	public int getFloor() {
		return floor;
	}


	public String getInputSource() {
		return inputSource;
	}


	@Override
	public boolean equals(Object obj) {
		
        if (obj == this) {
            return true;
        }
 
        if (!(obj instanceof LiftRequest)) {
            return false;
        }
        
        LiftRequest liftRequest = (LiftRequest) obj;
         
        // Compare the data members and return accordingly 
        return inputSource.equalsIgnoreCase(liftRequest.getInputSource())
                && direction.equalsIgnoreCase(liftRequest.getDirection()) && Integer.compare(floor, liftRequest.getFloor()) == 0;
	}
	
	
	

}
