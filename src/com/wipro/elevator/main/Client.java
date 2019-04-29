
package com.wipro.elevator.main;





import com.wipro.elevator.dto.RequestDTO;

import com.wipro.elevator.entity.ElevatorImpl;
import com.wipro.elevator.manager.ElevatorManager;

/**
 * @author Amreen Nazeer
 */

/* client code to test Elevator System */
public class Client {

	public static void main(String[] args) {
		
				
		  ElevatorImpl elevator = ElevatorImpl.getInstance();
		  elevator.setCurrentFloor(0); // assumption that lift is in ground floor initially
		 
		
		  ElevatorManager elevatorManager = new ElevatorManager(elevator);
		  elevatorManager.addPickUp(new RequestDTO(1,10,30)); // first user access the lift at ground floor and want to go to 10th floor
	      elevatorManager.addPickUp(new RequestDTO(5,0,50));
	      elevatorManager.addPickUp(new RequestDTO(2,4,400));
	      elevatorManager.addPickUp(new RequestDTO(4,3,60));
	      elevatorManager.execute();
		
		
		
		
		

	}

}
