package com.huda.unittesting;

import static org.junit.Assert.*;

import org.junit.Test;

import com.huda.command.ParkCommand;
import com.huda.command.ParkingLotCreateCommand;
import com.huda.model.Car;
import com.huda.repository.Memory;

public class ParkCommandTest extends BaseTestUnit {

	@Test
	public void testExecuteParkOne() {
		ParkingLotCreateCommand unit = new ParkingLotCreateCommand();
		String [] parameters = new String[] { "6" };
		unit.Execute(parameters);
		
		ParkCommand parkCommand = new ParkCommand();
		parameters = new String[] { "KA-01-HH-1234", "White" };
		String result = parkCommand.Execute(parameters);
		System.out.println(result);
		Car car = Memory.ParkingLots.get(0).Car;
		assertNotNull(car);
	}

}
