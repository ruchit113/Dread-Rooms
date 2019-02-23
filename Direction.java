//Direction class for the possible direction from each place.
//This class preety much remained unchanged after the implementation of Project 3.

import java.util.Scanner;
import java.util.Vector;

public class Direction 
{
	
	
	private boolean roomstatus=false;
	private Place from;
	private Place to;
	private String defaultDir;
	private int lockNum;
	private int dirNum=0;
	
	//Enumerated Direction type for the possible combinations of user input...
	public enum DirType
	{
		// NONE, N, S, E, W, U, D, NE, NW, SE,
		//SW, NNE, NNW, ENE, WNW, ESE, WSW, SSE, and SSW. 
		none("NONE","None"),
		//---------------------------------------------1.
		north("N","North"),
		south("S","South"),
		east("E","East"),
		west("W","West"),
		//---------------------------------------------5.
		up("U","Up"),
		down("D","Down"),
		//---------------------------------------------7.
		northNorthEast("NNE","North-NorthEast"),
		northNorthWest("NNW","North-NorthWest"),
		eastNorthEast("ENE","East-NorthEast"),
		eastSouthEast("ESE","East-SouthEast"),
		southSouthEast("SSE","South-SouthEast"),
		southSouthWest("SSW","South-SouthWest"),
		westNorthWest("WNW","West-NorthWest"),
		westSouthWest("WSW","West-SouthWest"),
		//---------------------------------------------15.
		northEast("NE","NorthEast"),
		northWest("NW","NorthWest"),
		southEast("SE","SouthEast"),
		southWest("SW","SouthWest");
		//---------------------------------------------19.
		private String fullDir;
		private String sortDir;
		//constructor for DirType.
		DirType(String first, String two)
		{
			fullDir=first;
			sortDir=two;
		}
		public String toString()
		{
			return fullDir;
		}
		public boolean match(String user)
		{
			if(fullDir.equalsIgnoreCase(user)||
				sortDir.equalsIgnoreCase(user))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}//Enum ends here...
	
	//Direction class constructor which will get the directions from the Mystic.txt file...
	Direction(Scanner fileIn2)
	{
		String trimmed2=null;
		int fromID=0;
		int toID=0;
		
		//getting the trimmed line from the file...
		trimmed2=CleanLineScanner.getCleanLine(fileIn2);
		@SuppressWarnings("resource")
		
		//using the trimmed line as Scanner input...
		Scanner inputLine2=new Scanner(trimmed2);
		dirNum=inputLine2.nextInt();
		
		fromID=inputLine2.nextInt();
		from=Place.getPlaceByID(fromID);
		defaultDir=inputLine2.next();
		toID=inputLine2.nextInt();
		
		//if the ID is negative this will lock the room.
		//-----------------------------------------------
		if(toID < 0)
		{
			lock();
		}
		toID=Math.abs(toID);
		
		to = Place.getPlaceByID(toID);
		lockNum=inputLine2.nextInt();
		//storing direction objects into direction vector.
		from.addDirection(this);
	}//Drection constructor ends here.
	
	
	
	//Match function to check whether the user direction matches the default direction.
	public boolean match(String S)
	{
		if(S.equals(defaultDir))
		{
			return true;
		}
		else
		{
			return false;
		}
	}//end of Match function.
	
	//function to get the default direction for the place.
	String getdefaultDir()
	{
		return defaultDir;
	}

	//function to lock the room...
	public void lock()
	{
		roomstatus=true;
	}
	
	//function to unlock the room...
	public void unlock()
	{
		roomstatus=false;
	}
	
	//private function to check if the room is locked or not. 
	private boolean isLocked()
	{
		if(roomstatus)
		{
			return true;
		}
		else
		{
			return false;
		}
	}//isLocked() ends here
	
	
	//useKey function to use the key i.e. if the player already has the key and wants to check,
	//Whether the key opens the door user wants to open or not.
	public void useKey(Artifact artifact1)
	{
		if ( lockNum == artifact1.getKey())
		{
			System.out.println("Good job using the key here ! it opned..." + to.name());
			unlock();
			System.out.println("Room Status True(Locked) False(Unlocked) : " + roomstatus);
		}
		
		else
		{
			if(roomstatus)
			{
				System.out.println("Oops! This key did not work for : " + from.name());
			}
		}
	}//useKey ends here...
	
	//follow function to return the appropriate place name i.e. if the place is locked then return the from place,
	//Otherwise return the to place.
	public Place follow()
	{
		if(isLocked())
		{
			System.out.println("Sorry the room from this direction is locked.");
			return from;
		}
		else
		{
			return to;
		}
	}//follow function ends here...
	
}//Direction Class ends here.
