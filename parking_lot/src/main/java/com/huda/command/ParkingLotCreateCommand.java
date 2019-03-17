package com.huda.command;

import com.huda.library.CommandResult;
import com.huda.library.ICommand;
import com.huda.repository.ParkingLotRepository;

public class ParkingLotCreateCommand extends BaseCommand implements ICommand {

	public String Execute(String[] parameters) {
		// TODO Auto-generated method stub
		String result = "";
		if(parameters.length == 0 || (parameters.length > 0 && parameters[0] == ""))
			result = "Parameter total of lots is required";
		else
		{
			int total = Integer.parseInt(parameters[0]);
			ParkingLotRepository parkingLotRepository = this.CreateParkingLotRepository();
			parkingLotRepository.CreateParkingLot(total);
			result = "Created a parking lot with " + total + " slots";
		}
		return result;
	}

}
