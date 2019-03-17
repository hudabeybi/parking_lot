package com.huda.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.huda.library.*;

public class UserHandler {
	
	Map<String, ICommand> commands = new HashMap<String, ICommand>();
	
	/**
	 * Initialize command objects from configuration file
	 * @throws IOException
	 */
	protected void InitCommands() throws IOException
	{
		String filename = "CommandConfig.data";
		File file = new File(filename); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		String st; 
		while ((st = br.readLine()) != null) 
		{   
			String [] sCommand = st.split("=");
			if(sCommand.length >= 2)
			{
				String command = sCommand[0];
				String className = sCommand[1];
				try
				{
					ICommand commandObject = CreateCommandObject(className);
					commands.put(command, commandObject);
				}
				catch(Exception err)
				{
					err.printStackTrace();
					System.out.println(err.getMessage());
				}
			}
		}
		br.close();
	}
	
	/**
	 * Create command object dynamically from a file
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	ICommand CreateCommandObject(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		Class<?> cls = Class.forName(className);
		ICommand command = (ICommand)cls.newInstance();
		return command;
	}

	/**
	 * Run the User Handler
	 * @param args
	 * @throws IOException
	 */
	public void Run(String[] args) throws IOException {
		
		InitCommands();
		// TODO Auto-generated method stub
		if(args.length > 0)
		{
			String inputFilename = args[0];
			RunBatch(inputFilename);
		}
		else
		{
			RunInteractive();
		}
	}
	
	/**
	 * Run the program in interractive mode 
	 * @throws IOException
	 */
	void RunInteractive() throws IOException
	{
		BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			System.out.print("$$$ ");
	        String sLine = reader.readLine();
			String sCommand = ParseCommand(sLine);
			String [] sParams = ParseParameter(sLine);
			
			try {
				if(sCommand.toLowerCase().equals("exit"))
					break;
				RunCommand(sCommand, sParams);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("No such command " + sCommand);
			}    
		}
	}
	
	/**
	 * Run the command batch from file
	 * @param filename
	 * @throws IOException
	 */
	void RunBatch(String filename) throws IOException
	{
		File file = new File(filename); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String st; 
		while ((st = br.readLine()) != null) 
		{ 
			String sCommand = ParseCommand(st);
			String [] sParams = ParseParameter(st);
			try {
				RunCommand(sCommand, sParams);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("No such command " + sCommand);
			}
		}
		br.close();
	}
	
	/**
	 * Parse the command line parameter to retrieve its parameter
	 * @param sCommandLine
	 * @return array of parameter
	 */
	String [] ParseParameter(String sCommandLine)
	{
		String sCommand = ParseCommand(sCommandLine);
		String sParam = sCommandLine.replace(sCommand, "");
		sParam = sParam.trim();
		String [] sParamItems = sParam.split("\\s+", -1);
		for(int i = 0; i < sParamItems.length; i++)
		{
			sParamItems[i] = sParamItems[i].trim();
		}
		return sParamItems;
	}
	
	/**
	 * Parse the command from command line
	 * @param sCommandLine
	 * @return the command string
	 */
	String ParseCommand(String sCommandLine)
	{
		String [] sLine = sCommandLine.split("\\s+", -1);
		if(sLine.length > 0)
		{
			return sLine[0];
		}
		return null;
	}
	
	/**
	 * Run the command object
	 * @param scommand
	 * @param parameters
	 * @throws Exception 
	 */
	void RunCommand(String scommand, String [] parameters) throws Exception
	{
		ICommand command = this.commands.get(scommand);
		String result = command.Execute(parameters);
		System.out.println(result);
		System.out.println();
	}
	
	
}
