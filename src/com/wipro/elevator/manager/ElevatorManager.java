package com.wipro.elevator.manager;

import java.util.ArrayList;
import java.util.List;

import com.wipro.elevator.dto.RequestDTO;
import com.wipro.elevator.entity.ElevatorImpl;
import com.wipro.elevator.exception.InvalidDirectionException;

public class ElevatorManager {
	
	public  List<RequestDTO> requestList;
	private ElevatorImpl elevator;
	
	public ElevatorManager(ElevatorImpl elevator) {
					this.elevator=elevator;
					this.requestList = new ArrayList<>();
	}
	
	/* method to add userRequests to List */

	public void addPickUp(RequestDTO request){			
		
		requestList.add(request);
					
	}
	
	/* method which redirects the request to move Up and Down*/
	
	 public void execute() {
		                
						try {
							requestList.stream().forEach(req -> this.elevator.moveNext(req));
						} catch (Exception e) {
							e.printStackTrace();
						}
		                
					
	  }

}
