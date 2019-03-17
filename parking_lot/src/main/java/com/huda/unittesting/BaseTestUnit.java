package com.huda.unittesting;

import com.huda.command.LeaveCommand;
import com.huda.command.ParkCommand;
import com.huda.command.ParkingLotCreateCommand;

public class BaseTestUnit {
	
	protected void parkParkingLot()
	{
		ParkingLotCreateCommand unit = new ParkingLotCreateCommand();
		String [] parameters = new String[] { "6" };
		unit.Execute(parameters);
		
		ParkCommand parkCommand = new ParkCommand();
		parameters = new String[] {  "KA-01-HH-1234", "White" };
		parkCommand.Execute(parameters);
		
		parameters = new String[] { "KA-01-HH-9999", "White" };
		parkCommand.Execute(parameters);
		
		parameters = new String[] {  "KA-01-BB-0001", "Black" };
		parkCommand.Execute(parameters);
		
		parameters = new String[] {  "KA-01-HH-7777", "Red" };
		parkCommand.Execute(parameters);
		
		parameters = new String[] {  "KA-01-HH-2701", "Blue" };
		parkCommand.Execute(parameters);
		
		parameters = new String[] { "KA-01-HH-3141 ", "Black" };
		parkCommand.Execute(parameters);
	}
	
	protected void Leave(int slotId)
	{
		LeaveCommand parkCommand = new LeaveCommand();
		String [] parameters = new String[] {  slotId + "" };
		parkCommand.Execute(parameters);
	}
	
	protected void anotherPark()
	{
		ParkCommand parkCommand = new ParkCommand();
		String [] parameters = new String[] {  "KA-01-P-333", "White" };
		parkCommand.Execute(parameters);
		
		parameters = new String[] {  "DL-12-AA-9999", "White" };
		parkCommand.Execute(parameters);
	}
}
