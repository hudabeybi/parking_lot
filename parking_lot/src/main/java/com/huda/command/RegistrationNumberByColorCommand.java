package com.huda.command;

import java.util.List;

import com.huda.library.CommandResult;
import com.huda.library.ICommand;
import com.huda.model.*;
import com.huda.repository.*;

public class RegistrationNumberByColorCommand extends BaseCommand implements ICommand {

	public String Execute(String[] parameters) {
		String result = "";
		if(parameters.length < 1 || ( parameters.length >= 1 && parameters[0] == "" ))
		{
			result = "Color parameter is required";
		}
		else
		{
			String color = parameters[0];
			ParkingLotRepository repo = this.CreateParkingLotRepository();
			List<Car> cars = repo.FindCarsByColor(color);
			if(cars.size() == 0)
				result = "Cars with " + color + " does not exists";
			else
				result = this.PrintCars(cars);
		}
		
		return result;
	}

}
