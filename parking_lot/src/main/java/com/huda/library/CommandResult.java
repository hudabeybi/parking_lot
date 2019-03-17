package com.huda.library;

public class CommandResult {
	public String Message;
	public Object Data;
	
	public CommandResult()
	{
		
	}
	
	public CommandResult(String message, Object data)
	{
		this.Message = message;
		this.Data = data;
	}
}
