package com.huda.main;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome" );
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);
        UserHandler userHandler = new UserHandler();
        try {
			userHandler.Run(args);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
