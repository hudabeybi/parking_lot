package com.huda.command;

import java.util.List;

import com.huda.library.CommandResult;
import com.huda.library.ICommand;
import com.huda.model.ParkingLot;
import com.huda.repository.ParkingLotRepository;

public class SlotNumberForCarsByColorCommand extends BaseCommand  implements ICommand {

	public String Execute(String[] parameters) {
		String result = "";
		if(parameters.length < 1  || ( parameters.length >= 1 && parameters[0] == "" ))
		{
			result = "Car color parameter is required";
		}
		else
		{
			String color = parameters[0];
			ParkingLotRepository repo = this.CreateParkingLotRepository();
			List<ParkingLot> parkingLots = repo.FindParkingLotsByCarColor(color);
			if(parkingLots.size() == 0)
				result = "Parking lot for car color " + color + " does not exists";
			else
				result = this.PrintParkingLots(parkingLots);
		}
		return result;
	}

}
