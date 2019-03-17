package com.huda.unittesting;

import static org.junit.Assert.*;

import org.junit.Test;

import com.huda.command.RegistrationNumberByColorCommand;
import com.huda.command.SlotNumberByRegistrationNumberCommand;

public class SlotNumberByColorRegistrationNumberTest extends BaseTestUnit {

	@Test
	public void testExecute() {
		this.parkParkingLot();
		this.Leave(4);
		this.anotherPark();
		
		SlotNumberByRegistrationNumberCommand parkCommand = new SlotNumberByRegistrationNumberCommand();
		String [] parameters = new String[] { "KA-01-HH-3141" };
		String result = parkCommand.Execute(parameters);
		System.out.println(result);
		assertEquals(result, "6");
	}

}
