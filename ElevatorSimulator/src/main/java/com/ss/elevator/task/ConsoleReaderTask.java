package com.ss.elevator.task;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

import com.ss.elevator.entity.LiftRequest;


/**
 * 
 * This Class represents the task which take user input.
 * 
 * @author ryada9
 *
 */
public class ConsoleReaderTask implements Callable<Integer>{
	 
	 LinkedBlockingQueue<LiftRequest> elevatorRequestQueueFromOut;
	 LinkedBlockingQueue<LiftRequest> elevatorOneRequestQueueFromIn;
	 LinkedBlockingQueue<LiftRequest> elevatorTwoRequestQueueFromIn;
	 
	 
	 public ConsoleReaderTask(LinkedBlockingQueue<LiftRequest> elevatorRequestQueueFromOut,  LinkedBlockingQueue<LiftRequest> elevatorOneRequestQueueFromIn, LinkedBlockingQueue<LiftRequest> elevatorTwoRequestQueueFromIn){
		 this.elevatorRequestQueueFromOut = elevatorRequestQueueFromOut;
		 this.elevatorOneRequestQueueFromIn = elevatorOneRequestQueueFromIn;
		 this.elevatorTwoRequestQueueFromIn = elevatorTwoRequestQueueFromIn;
	 }

	public Integer call() throws Exception {
		
		Scanner sc=new Scanner(System.in);  
        
		String inputSource = null;
		String direction = null;
		Integer requestedFloorNumber = null;
		   
		while(true){
			System.out.println("Request Elevator, enter Mode Direction Floor# seprated by space  e.g. ... OUT UP 4");
			
			
			try{
				inputSource = sc.next();
				direction = sc.next();
				requestedFloorNumber=sc.nextInt();	
			}catch(Exception ex){
				System.out.println("Error in input data, please try again..");
			}
			
			if(inputSource != null && direction != null && requestedFloorNumber != null){
				
				LiftRequest request = new LiftRequest(inputSource,direction, requestedFloorNumber);
				
				System.out.println("Request recieved");
				
				if(inputSource.equalsIgnoreCase("OUT")){
					elevatorRequestQueueFromOut.put(request); // Request made from outside
				}else{
					
					//Request made from Inside the Lift
					
					if(direction.equalsIgnoreCase("1")){ //Request for Lift 1
						elevatorOneRequestQueueFromIn.put(request);
					}else{
						//Request for Lift 2
						elevatorTwoRequestQueueFromIn.put(request);
					}
				}
			}
			
		}
		
	}
	 
 }