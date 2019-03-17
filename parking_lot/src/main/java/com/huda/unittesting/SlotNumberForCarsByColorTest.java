package com.huda.unittesting;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.huda.command.SlotNumberByRegistrationNumberCommand;
import com.huda.command.SlotNumberForCarsByColorCommand;
import com.huda.model.ParkingLot;
import com.huda.repository.Memory;

public class SlotNumberForCarsByColorTest extends BaseTestUnit {

	@Test
	public void testExecute() {
		this.parkParkingLot();
		this.Leave(4);
		this.anotherPark();
		
		SlotNumberForCarsByColorCommand parkCommand = new SlotNumberForCarsByColorCommand();
		String [] parameters = new String[] { "White" };
		String result = parkCommand.Execute(parameters);
		System.out.println(result);
		assertEquals(result, "1,2,4");
	}

}
