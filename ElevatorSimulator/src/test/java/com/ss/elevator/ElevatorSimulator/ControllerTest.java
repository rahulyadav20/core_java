package com.ss.elevator.ElevatorSimulator;


import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ss.elevator.config.AppConfig;
import com.ss.elevator.controller.ElevatorController;

import junit.framework.TestCase;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class ControllerTest extends TestCase {
	
	
	@Autowired
	ElevatorController elevatorController;
		
	
	@BeforeClass
    public static void createMockDeals() {
		
	
    }
	
	@Test
	public void testConsoleInput() {
		
		ElevatorController elevatorController = new ElevatorController();
			
		

	}
	

}
