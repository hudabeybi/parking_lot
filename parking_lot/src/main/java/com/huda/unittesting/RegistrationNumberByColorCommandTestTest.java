package com.huda.unittesting;

import static org.junit.Assert.*;

import org.junit.Test;

import com.huda.command.ParkCommand;
import com.huda.command.RegistrationNumberByColorCommand;

public class RegistrationNumberByColorCommandTestTest extends BaseTestUnit {

	@Test
	public void testExecute() {
		this.parkParkingLot();
		this.Leave(4);
		this.anotherPark();
		
		RegistrationNumberByColorCommand parkCommand = new RegistrationNumberByColorCommand();
		String [] parameters = new String[] { "White" };
		String result = parkCommand.Execute(parameters);
		System.out.println(result);
		assertEquals(result, "KA-01-HH-1234,KA-01-HH-9999,KA-01-P-333");
	}

}
