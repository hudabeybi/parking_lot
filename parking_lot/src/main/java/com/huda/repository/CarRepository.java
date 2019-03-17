package com.huda.repository;

import java.util.ArrayList;
import java.util.List;
import com.huda.model.*;

public class CarRepository {
	public List<Car> FindCarByColor(String color)
	{
		List<Car> cars = new ArrayList<Car>();
		for(ParkingLot parkingLot : Memory.ParkingLots)
		{
			if(parkingLot.Car != null)
			{
				if(parkingLot.Car.CarColor == color)
				{
					cars.add(parkingLot.Car);
				}
			}
		}
		return cars;
	}
	
	public Car findCarByRegistrationNo(String registrationNo)
	{
		for(ParkingLot parkingLot : Memory.ParkingLots)
		{
			if(parkingLot.Car != null)
			{
				if(parkingLot.Car.RegistrationNo == registrationNo)
				{
					return parkingLot.Car;
				}
			}
		}
		return null;
	}
}
