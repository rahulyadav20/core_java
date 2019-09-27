package com.ss.elevator.task;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

import com.ss.elevator.entity.Elevator;
import com.ss.elevator.entity.LiftRequest;

public class ElevatorWorker implements Callable{
	
	private Elevator elevator;
	private LinkedBlockingQueue<LiftRequest> elevatorRequestQueueFromOut;
	private final int TIME_BETWEEN_FLOOR = 5000;
	private final int LIFT_STOPAGE_TIME = 10000;
	private final int TOTAL_FLOOR = 10;
	
	private final String FirstLift = "1";
	private final String SecondLift = "2";
	
	public ElevatorWorker(Elevator elevator, LinkedBlockingQueue<LiftRequest> elevatorRequestQueueFromOut) {
		
		this.elevator = elevator;
		this.elevatorRequestQueueFromOut = elevatorRequestQueueFromOut;
	}

	

	public Object call() throws Exception {
   
		while(true){
			
			if(! elevator.getElevatorRequestQueueFromIn().isEmpty() || ! elevatorRequestQueueFromOut.isEmpty()){
				
				
				int lastStop = moveElevatorUp();
				System.out.println("Last floor :: "+ lastStop);
				
				if(elevator.getCurrentFloor() > 0){
					moveElevatorDown(lastStop);		
				}
				
			}
			
		}
 
	}


	/**
	 * Check the Stoppage while going UP and stop if required.
	 * @throws InterruptedException
	 */
	private int moveElevatorUp() throws InterruptedException {
		elevator.setMovingDirection("UP");
		System.out.println("Elevator moving up.");
		
		for(int i=0; i<=TOTAL_FLOOR ; i++){
			
			elevator.setCurrentFloor(i);
			elevator.crossingFloor(i);
			Thread.sleep(TIME_BETWEEN_FLOOR);
			
			LiftRequest outNextFloorUP = new LiftRequest("OUT", "UP", i+1);
			LiftRequest outNextFloorDOWN = new LiftRequest("OUT", "DOWN", i+1);
			
			/*Since this worker can be either of the Lifts, we create dummy LiftRequest for both cases and then remove the both request from Queue.
			While adding the 'IN' request from console, we take care of adding the request to right elevator Queue.
			Hence If we try to remove request of Lift 1 from thread running Lift 2 ... remove method will actually remove nothing.*/
			
			
			LiftRequest inLiftOneNextFloor = new LiftRequest("IN", FirstLift, i+1); // Stop request from inside Lift one
			LiftRequest inLiftTwoNextFloor = new LiftRequest("IN", SecondLift, i+1); // Stop request from inside Lift two
			
			/*
			 * Synchronizing on elevatorRequestQueueFromOut, as this queue is shared between both the lifts.
			 */
			
			synchronized(elevatorRequestQueueFromOut){
				
				if (elevator.getElevatorRequestQueueFromIn().contains(inLiftOneNextFloor)
						|| elevator.getElevatorRequestQueueFromIn().contains(inLiftTwoNextFloor)
						|| elevatorRequestQueueFromOut.contains(outNextFloorUP)
						|| elevatorRequestQueueFromOut.contains(outNextFloorDOWN)) {
					
					elevator.stopElevator(i + 1);
					
					removeLiftRequestFromQueue(outNextFloorUP, outNextFloorDOWN, inLiftOneNextFloor, inLiftTwoNextFloor);
					Thread.sleep(LIFT_STOPAGE_TIME);

				}	
			}
			
			if(isfloorRequestQueuesEmpty() ||  noFloorRequestAbove()){
				return i+1;
			}
		}
		return TOTAL_FLOOR;
	}
	
	/**
	 * Check pending requests in OUT and IN queues
	 * @return
	 */
	private boolean isfloorRequestQueuesEmpty(){
		
		return elevator.getElevatorRequestQueueFromIn().isEmpty() && elevatorRequestQueueFromOut.isEmpty();
	}
	
	/**
	 * No FloorRequest above elevator's current floor.
	 * Elevator can move down.
	 * @return
	 */
	private boolean noFloorRequestAbove() {
		
		
		for(int i = elevator.getCurrentFloor() +1 ; i<= TOTAL_FLOOR ; i++){
			
			LiftRequest outNextFloorUpDummyRequest = new LiftRequest("OUT", "UP", i+1);
			LiftRequest outNextFloorDownDummyRequest = new LiftRequest("OUT", "DOWN", i+1);
			LiftRequest inNextFloorDummyRequest = new LiftRequest("IN", elevator.getElevatorNumber(), i+1);
			
			if(elevator.getElevatorRequestQueueFromIn().contains(inNextFloorDummyRequest) || elevatorRequestQueueFromOut.contains(outNextFloorUpDummyRequest) || elevatorRequestQueueFromOut.contains(outNextFloorDownDummyRequest)){
				return false;
			}
		}
		
		return true;
	}



	/**
	 * Check the Stoppage while going down and stop if required.
	 */
	private void moveElevatorDown(int floor) throws InterruptedException {
		elevator.setMovingDirection("DOWN");
		System.out.println("Elevator moving down.");
		
		for(int i = floor ; i>=0 ; i--){
			
			elevator.setCurrentFloor(i);
			elevator.crossingFloor(i);
			Thread.sleep(TIME_BETWEEN_FLOOR);
			
			LiftRequest outNextFloorDummyRequest = new LiftRequest("OUT", "DOWN", i-1);
			
			/*Since this worker can be either of the Lifts, we create dummy LiftRequest for both cases and then remove the both request from Queue.
			While adding the 'IN' request from console, we take care of adding the request to right elevator Queue.
			Hence If we try to remove request of Lift 1 from thread running Lift 2 ... remove method will actually remove nothing.*/
			
			
			LiftRequest inLiftOneNextFloorDummyRequest = new LiftRequest("IN", FirstLift, i-1); // Stop request from inside Lift one
			LiftRequest inLiftTwoNextFloorDummyRequest = new LiftRequest("IN", SecondLift, i-1); // Stop request from inside Lift two
			
			/*
			 * Synchronizing on elevatorRequestQueueFromOut, as this queue is shared between both the lifts.
			 */
			synchronized(elevatorRequestQueueFromOut){
				
				if (elevator.getElevatorRequestQueueFromIn().contains(inLiftOneNextFloorDummyRequest)
						|| elevator.getElevatorRequestQueueFromIn().contains(inLiftTwoNextFloorDummyRequest)
						|| elevatorRequestQueueFromOut.contains(outNextFloorDummyRequest)) {
					
					elevator.stopElevator(i - 1);
					
					removeLiftRequestFromQueue(outNextFloorDummyRequest, inLiftOneNextFloorDummyRequest, inLiftTwoNextFloorDummyRequest);
					Thread.sleep(LIFT_STOPAGE_TIME);
				}
			}

		}
	}

	
	/**
	 * Remove the stoppage from IN and OUT queues.
	 * 
	 * @param outNextFloor
	 * @param inLiftOneNextFloor
	 * @param inLiftTwoNextFloor
	 */
	private void removeLiftRequestFromQueue(LiftRequest outNextFloorDOWN, LiftRequest inLiftOneNextFloor,
			LiftRequest inLiftTwoNextFloor) {
		elevator.getElevatorRequestQueueFromIn().remove(inLiftOneNextFloor);
		elevator.getElevatorRequestQueueFromIn().remove(inLiftTwoNextFloor);
		
		elevatorRequestQueueFromOut.remove(outNextFloorDOWN);
		
		LiftRequest outNextFloorUP = new LiftRequest();
		removeLiftRequestFromQueue(outNextFloorUP, outNextFloorDOWN, inLiftOneNextFloor, inLiftTwoNextFloor);
	}
	
	/**
	 * Remove the stoppage from IN and OUT queues.
	 * 
	 * @param outNextFloor
	 * @param inLiftOneNextFloor
	 * @param inLiftTwoNextFloor
	 */
	private void removeLiftRequestFromQueue(LiftRequest outNextFloorUP, LiftRequest outNextFloorDOWN, LiftRequest inLiftOneNextFloor,
			LiftRequest inLiftTwoNextFloor) {
		elevator.getElevatorRequestQueueFromIn().remove(inLiftOneNextFloor);
		elevator.getElevatorRequestQueueFromIn().remove(inLiftTwoNextFloor);
		
		elevatorRequestQueueFromOut.remove(outNextFloorUP);
		elevatorRequestQueueFromOut.remove(outNextFloorDOWN);
	}


}
