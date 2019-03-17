package com.huda.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.huda.model.*;

public class ParkingLotRepository {
	public void CreateParkingLot(int parkingLotTotal)
	{
		Memory.ParkingLots.clear();
		for(int i = 0; i < parkingLotTotal; i++)
		{
			ParkingLot parkingLot = new ParkingLot(i + 1);
			parkingLot.ParkingStatus = ParkingStatus.AVAILABLE;
			Memory.ParkingLots.add(parkingLot);
		}
	}
	
	public int ReserveParkingLot(Car car)
	{
		for(ParkingLot parkingLot : Memory.ParkingLots)
		{
			if(parkingLot.ParkingStatus == ParkingStatus.AVAILABLE)
			{
				parkingLot.Car = car;
				parkingLot.ParkingStatus = ParkingStatus.TAKEN;
				return parkingLot.IdParkingLot;
			}
		}
		
		return -1;
	}
	
	Ticket CreateTicket(Car car, ParkingLot parkingLot)
	{
		Ticket ticket = new Ticket();
		ticket.ParkInDate = new Date();
		ticket.ParkedCar = car;
		ticket.ParkingLot = parkingLot;
		return ticket;
	}
	
	public boolean LeaveParkingLot(int idParkingLot)
	{
		for(ParkingLot parkingLot : Memory.ParkingLots)
		{
			if(parkingLot.IdParkingLot == idParkingLot)
			{
				parkingLot.ParkingStatus = ParkingStatus.AVAILABLE;
				parkingLot.Car = null;
				return true;
			}
		}
		
		return false;
	}
	
	public List<ParkingLot> FindAllParkingLot()
	{
		return Memory.ParkingLots;
	}
	
	public List<ParkingLot> FindParkingLotsByCarColor(String color)
	{
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		for(ParkingLot parkingLot : Memory.ParkingLots)
		{
			if(parkingLot.Car != null && parkingLot.Car.CarColor.trim().equalsIgnoreCase(color.trim()))
			{
				parkingLots.add(parkingLot);
			}
		}
		return parkingLots;
	}
	
	public List<ParkingLot> FindParkingLotsByCarRegNumber(String regno)
	{
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		for(ParkingLot parkingLot : Memory.ParkingLots)
		{
			if(parkingLot.Car != null && parkingLot.Car.RegistrationNo.trim().equalsIgnoreCase(regno.trim()))
			{
				parkingLots.add(parkingLot);
			}
		}
		return parkingLots;
	}
	
	public List<Car> FindCarsByColor(String color)
	{
		List<Car> cars = new ArrayList<Car>();
		for(ParkingLot parkingLot : Memory.ParkingLots)
		{
			if(parkingLot.Car != null && parkingLot.Car.CarColor.trim().equalsIgnoreCase(color.trim()))
				cars.add(parkingLot.Car);
		}
		return cars;
	}
	
}
