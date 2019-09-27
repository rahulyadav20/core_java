package com.ss.elevator.entity;

import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.stereotype.Component;

@Component
public class Elevator {

	String elevatorName;
	String elevatorNumber;
	Integer currentFloor;
	String movingDirection;
	String status;
	LinkedBlockingQueue<LiftRequest> elevatorRequestQueueFromIn = new LinkedBlockingQueue<LiftRequest>(10);
	
	
	
	public Elevator(String elevatorName, String elevatorNumber, LinkedBlockingQueue<LiftRequest> elevatorRequestQueueFromIn) {
    
		this.elevatorRequestQueueFromIn = elevatorRequestQueueFromIn;
		this.elevatorName = elevatorName;
		this.elevatorNumber = elevatorNumber;  
		currentFloor = 0;
		status = "STOP";
		movingDirection="UP";
	
	}

	public void crossingFloor(int floor){
		currentFloor = floor;
		System.out.println("Elevator " + elevatorName + " crossed "+ currentFloor + " floor.");
	}
	
	public void stopElevator(int floor){
		
		System.out.println("Elevator "+ elevatorName + " stopped at floor # "+ floor);
		
	}

	public Integer getCurrentFloor() {
		return currentFloor;
	}



	public String getMovingDirection() {
		return movingDirection;
	}



	public String getStatus() {
		return status;
	}



	public void setCurrentFloor(Integer currentFloor) {
		this.currentFloor = currentFloor;
	}



	public void setMovingDirection(String movingDirection) {
		this.movingDirection = movingDirection;
	}



	public void setStatus(String status) {
		this.status = status;
	}

	public LinkedBlockingQueue<LiftRequest> getElevatorRequestQueueFromIn() {
		return elevatorRequestQueueFromIn;
	}

	public String getElevatorNumber() {
		return elevatorNumber;
	}


}
