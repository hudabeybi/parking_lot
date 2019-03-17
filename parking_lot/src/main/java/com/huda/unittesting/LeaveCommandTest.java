package com.huda.unittesting;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import com.huda.command.LeaveCommand;
import com.huda.repository.Memory;

public class LeaveCommandTest extends BaseTestUnit {

	@Test
	public void testExecuteOk() {
		this.parkParkingLot();
		
		String [] parameters = new String[] { "4" };
		LeaveCommand leaveCommand = new LeaveCommand();
		String result = leaveCommand.Execute(parameters);
		System.out.println(result);
		assertEquals(null, Memory.ParkingLots.get(3).Car);
	}
	
	@Test
	public void testExecuteFail() {
		this.parkParkingLot();
		
		String [] parameters = new String[] { "8" };
		LeaveCommand leaveCommand = new LeaveCommand();
		String result = leaveCommand.Execute(parameters);
		System.out.println(result);
		assertThat(result, CoreMatchers.containsString("does not exist"));
	}

}
