package com.huda.repository;

import com.huda.model.*;

public class TicketRepository {
	public Ticket FindTicketByParkingLotAndStatus(int idParkingLot, ParkingStatus parkingStatus)
	{
		for(Ticket ticket : Memory.Tickets)
		{
			if(ticket.ParkingLot.IdParkingLot == idParkingLot && ticket.ParkingLot.ParkingStatus == parkingStatus)
				return ticket;
		}
		return null;
	}
}
