package com.huda.unittesting;

import static org.junit.Assert.*;

import org.junit.Test;

import com.huda.command.ParkingLotCreateCommand;
import com.huda.repository.Memory;

public class CreateParkLotTest {

	@Test
	public void TestCreateParkLotCommand() {
		ParkingLotCreateCommand unit = new ParkingLotCreateCommand();
		String [] parameters = new String[] { "6" };
		String result = unit.Execute(parameters);
		System.out.println(result);
		assertEquals(6, Memory.ParkingLots.size() );
	}

}
