package com.huda.command;

import com.huda.library.*;
import com.huda.repository.*;

public class LeaveCommand extends BaseCommand implements ICommand {

	public String Execute(String[] parameters) {
		String result = "";
		if(parameters.length >= 1)
		{
			
			int parkId = -1;
			
			try
			{
				parkId = Integer.parseInt(parameters[0]);
			}
			catch(Exception e)
			{
				result = "Parameter slot number is required";
				return null;
			}
					
			ParkingLotRepository parkingLotRepo = this.CreateParkingLotRepository();
			boolean exists = parkingLotRepo.LeaveParkingLot(parkId);
			if(exists)
				result = "Slot number " + parkId + " is free";
			else
				result = "Slot number " + parkId + " does not exist";
				
		}
		else
		{
			result = "Parameter slot number is required";
		}
		return result;
	}

}
