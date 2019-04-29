package com.wipro.elevator.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;



import com.wipro.elevator.constants.Constants;
import com.wipro.elevator.dto.RequestDTO;
import com.wipro.elevator.exception.InvalidDirectionException;
import com.wipro.elevator.manager.InputValidator;

public class ElevatorImpl implements Elevator {
	
	private int source=getCurrentFloor();
	
	private int currentFloor;
	
	private static ElevatorImpl elevator;
	
	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	


	
	
	private ElevatorImpl(){
		
	}
	
	public static  ElevatorImpl   getInstance(){
		if(elevator == null){
			elevator = new ElevatorImpl();			
		}
		return elevator;
		
	}

		
	@Override
	/* method to move the lift downwards */
	public void moveDown(RequestDTO request)  {
		// TODO Auto-generated method stub
		if(getCurrentFloor()==Constants.MIN_FLOOR){			
			  try {
				throw new InvalidDirectionException("You cannot move downwards");
			} catch (InvalidDirectionException e) {
				// TODO Auto-generated catch block
				System.err.println("Information given to move only downstairs");
			}
		}
		
		if(request.getSourceFloor() != getCurrentFloor()){
			System.out.println(" Currently Lift is in " + getCurrentFloor() + " Please Wait" );
			try {
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Lift reached your destination , please get in and go down  to your desired floor which is" +request.getDestinationFloor());
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				
			}
		}
		else {
			System.out.println("Lift is in your floor " +request.getSourceFloor()+ " Enter into the elevator");
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		source=request.getSourceFloor();
		System.out.println("Lift starting at " + request.getSourceFloor() + " and reached his destination (down) " +  request.getDestinationFloor() );
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		source= request.getDestinationFloor();
		setCurrentFloor(source);

	}

	

	@Override
	/* method to validate the request for user weight and to check the direction to move based on source and destination*/
	public void moveNext(RequestDTO request)   {
		InputValidator validator = new InputValidator();
		if(validator.isFullyLoaded(request.getUserWeight()))
			{
				System.out.println("Warning: Maximun weight of 100KG attained please unload");
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return;
			}
		
		int direction=directionCheck(request.getSourceFloor(),request.getDestinationFloor());
		
			if (direction == 1) {
				moveUp(request);
			} else if (direction == -1) {
				moveDown(request);
			} else {
				System.out.println("source and destination cant be same");
			}
	}
	
	/* method to check if Lift need to go towards upwards or downwards*/
	
	public int directionCheck (int source ,int destination)
	{
		
		if((destination-source)>0)
		{
			return 1;
		}
		else if((destination-source)<0)
		{
			return -1;
		}
		return 0;
	}

	@Override
	/* method to move the lift upwards */
	public void moveUp(RequestDTO request)  {
		
		
		if(getCurrentFloor()==Constants.MAX_FLOOR){			
			  try {
				throw new InvalidDirectionException("You cannot move upwards");
			} catch (InvalidDirectionException e) {
				// TODO Auto-generated catch block
				System.err.println("Information given to move only upwards");
			}
		}
		
		/*
		 * 
		 * nextFloor = currentFloor + 1;
		 * 
		 */
	
		
		if(request.getSourceFloor() != getCurrentFloor()){
			System.out.println(" Currently Lift is in " + getCurrentFloor() + " Please Wait" );
			try {
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Lift reached your destination  " +request.getSourceFloor()+ " please get in and go to your desired floor which is" +request.getDestinationFloor());
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				
			}
			
		}else {
			System.out.println("Lift is in your floor " +request.getSourceFloor()+ " Enter into the elevator");
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		source=request.getSourceFloor();
		System.out.println("Lift starting at " + request.getSourceFloor() + " and reached his destination (upward) " +  request.getDestinationFloor() );
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		source= request.getDestinationFloor();
		setCurrentFloor(source);
		
	}
	
	

}
