package com.ss.elevator.controller;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.stereotype.Component;

import com.ss.elevator.entity.Elevator;
import com.ss.elevator.entity.LiftRequest;
import com.ss.elevator.task.ConsoleReaderTask;
import com.ss.elevator.task.ElevatorWorker;


/**
 * Elevator Controller thread, responsible for initializing and starting the system. 
 * 
 * @author ryada9
 *
 */
@Component
public class ElevatorController {
	
	
	private final int numberOfTotalFloors = 10;
	Elevator elevatorOne;
	Elevator elevatorTwo;
	
	LinkedBlockingQueue<LiftRequest> elevatorRequestQueueFromOut = new LinkedBlockingQueue<LiftRequest>(numberOfTotalFloors);
	LinkedBlockingQueue<LiftRequest> elevatorOneRequestQueueFromIn = new LinkedBlockingQueue<LiftRequest>(numberOfTotalFloors);
	LinkedBlockingQueue<LiftRequest> elevatorTwoRequestQueueFromIn = new LinkedBlockingQueue<LiftRequest>(numberOfTotalFloors);
	
	public ElevatorController(){
		elevatorOne = new Elevator("One","1",elevatorOneRequestQueueFromIn);
		elevatorTwo = new Elevator("Two","2",elevatorTwoRequestQueueFromIn);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		ConsoleReaderTask consoleReaderTask = new ConsoleReaderTask(elevatorRequestQueueFromOut, elevatorOneRequestQueueFromIn, elevatorTwoRequestQueueFromIn);
		ElevatorWorker firstElevatorWorker = new ElevatorWorker(elevatorOne, elevatorRequestQueueFromOut);
		ElevatorWorker secondElevatorWorker = new ElevatorWorker(elevatorTwo, elevatorRequestQueueFromOut);
		executor.submit(consoleReaderTask);
		executor.submit(firstElevatorWorker);
		executor.submit(secondElevatorWorker);
		
		System.out.println("All tasks submitted, Elevator Controller initialised.");
		
		
	}

}

