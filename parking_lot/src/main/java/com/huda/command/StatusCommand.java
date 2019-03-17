package com.huda.command;

import java.util.List;

import com.huda.library.CommandResult;
import com.huda.library.ICommand;
import com.huda.model.ParkingLot;
import com.huda.repository.ParkingLotRepository;

public class StatusCommand extends BaseCommand implements ICommand {

	public String Execute(String[] parameters) {
		String result = "";
		ParkingLotRepository parkingLotRepository = this.CreateParkingLotRepository();
		List<ParkingLot> parkingLots =  parkingLotRepository.FindAllParkingLot();
		
		result += "Slot. No\tRegistration No\tColour";
		for(ParkingLot parkingLot : parkingLots)
		{
			
			String registrationNumber = "-";
			String color = "-";
			if(parkingLot.Car != null)
			{
				registrationNumber = parkingLot.Car.RegistrationNo;
				color = parkingLot.Car.CarColor;
			}
			result += parkingLot.IdParkingLot + "\t" + registrationNumber + "\t" + color + "\r\n";
		}
		return result;
	}

}
