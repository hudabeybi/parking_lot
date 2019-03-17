package com.huda.command;

import java.util.List;

import com.huda.model.Car;
import com.huda.model.ParkingLot;
import com.huda.repository.ParkingLotRepository;

public class BaseCommand {

	protected String PrintParkingLots(List<ParkingLot> parkingLots)
	{
		String result = "";
		int counter = 0;
		for(ParkingLot parkingLot : parkingLots)
		{
			result += parkingLot.IdParkingLot;
			if(counter < parkingLots.size() - 1)
				result += ",";
			counter++;
		}
		return result;
	}
	
	protected String PrintCars(List<Car> cars)
	{
		String result = "";
		int counter = 0;
		for(Car car : cars)
		{
			result += car.RegistrationNo;
			if(counter < cars.size() - 1)
				result += ",";
			counter++;
		}
		return result;
	}
	
	protected ParkingLotRepository CreateParkingLotRepository()
	{
		ParkingLotRepository repo = new ParkingLotRepository();
		return repo;
	}

}
