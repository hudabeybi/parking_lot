package com.huda.command;

import java.util.List;

import com.huda.library.CommandResult;
import com.huda.library.ICommand;
import com.huda.model.Car;
import com.huda.model.ParkingLot;
import com.huda.repository.*;;

public class ParkCommand extends BaseCommand implements ICommand {

	public String Execute(String[] parameters) {
		String result = "";
		if(parameters.length >= 2  && parameters[0] != ""  && parameters[1] != "")
		{
			String registrationNo = parameters[0];
			String color = parameters[1];
			Car car = new Car(registrationNo, color);
			
			ParkingLotRepository parkingLotRepo = this.CreateParkingLotRepository();
			
			List<ParkingLot> parkingLots = parkingLotRepo.FindAllParkingLot();
			if(parkingLots.size() == 0)
				result = "Please create parking lots first";
			else
			{
				int parkLotId = parkingLotRepo.ReserveParkingLot(car);
				if(parkLotId == -1)
					result = "Sorry, parking lot is full";
				else
				{
					result = "Allocated slot number: " + parkLotId;
				}
			}
				
		}
		else
		{
			result = "Parameter 'Registration number' and 'Color' are required!";
		}
		
		return result;
	}

	
}
