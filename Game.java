//Game class for the control of the entire game functions.

import java.util.Vector;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
	
	
	private String gameName;
	//----------------------------------------------------
	//private Place currentPlace;
	//place vector that contains all the place objects.
	//--------------------------------------------------------------
	private static Vector<Place> placeVector=new Vector<Place>();
	//new place vector that conatins all the places except EXIT and Knowhere...
	private static Vector<Place> placeVector2 = new Vector<Place>();
	//direction vector that contains all the direction objects.
	private Vector<Direction> directVect=new Vector<Direction>();
	//Artifact vector that contains all the artifact objects.
	private Vector<Artifact>artiVect=new Vector<Artifact>();
	//Character vector...
	private Vector<Character>charVect=new Vector<Character>();
	//Artifact Hashmap to look for the appropriate Artifact.
	public static HashMap<String,Artifact>artiHMap2=new HashMap<String,Artifact>();
	static int artiNum=0;
	private float num=0;
	private String trimmed=null;
	private String firstString=null;
	private String nameGame=null;
	
	//using the whole file as a scanner in Game constroctor...
	Game(Scanner fileIn)
	{	
		while(fileIn.hasNextLine())
		{
			//getting the trimmed line from the file.
			trimmed= CleanLineScanner.getCleanLine(fileIn);
			
			if(trimmed == null)
			{
				break;
			}
			@SuppressWarnings("resource")
			//using the trimmed line as a scanner input.
			Scanner inputLine= new Scanner(trimmed);
			
			firstString=inputLine.next();
			
			if("GDF".equalsIgnoreCase(firstString))
				{
					num=inputLine.nextFloat();
					nameGame=inputLine.nextLine();
				}
			
			//Checking for the file data if it contains Place informations.
			if("PLACES".equalsIgnoreCase(firstString))
			{
				int placeNum=0;
				placeNum=inputLine.nextInt();
				
				Place Exit=new Place(1,"EXIT","This is the exit place");
				placeVector.add(Exit);
				
				Place Knowhere=new Place(0,"Knowhere","There is no way out from here.");
				placeVector.add(Knowhere);
				
				for(int i=0;i<placeNum;i++)
				{	
					Place object=new Place(fileIn);
					placeVector.add(object);
					placeVector2.add(object);
				}
			}
			
			//Checking for the file data if it contains Directions' informations.
			if("DIRECTIONS".equalsIgnoreCase(firstString))
			{
				int dirNum=0;
				dirNum=inputLine.nextInt();
				for(int j=0;j<dirNum;j++)
				{
					Direction object1=new Direction(fileIn);
					directVect.add(object1);
				}
			}
			if("CHARACTERS".equalsIgnoreCase(firstString))
			{
				int cNum=0;
				cNum=inputLine.nextInt();
				
				for(int a=0; a<cNum; a++)
				{
					Character object1 = new Character(fileIn);
					charVect.add(object1);
				}
			}
			//Chceking for the file data if it contains Artifacts' informations.
			if("ARTIFACTS".equalsIgnoreCase(firstString))
			{
				int artiNum=0;
				artiNum=inputLine.nextInt();
				
				for(int k=0;k<artiNum;k++)
				{
					Artifact object2=new Artifact(fileIn);
					artiVect.add(object2);
				}
			}//end if()	
		}//end while loop to read the file till the end.
	}//end of the Game constroctor.
	
	//---------------------------------------------------------
	public static Vector<Place> getPlaceVec()
	{
		return placeVector;
	}
	
	public static Vector<Place> getPlaceVec2()
	{
		return placeVector2;
	}
	
	//Printing the vector information from the placeVector.
	void printVec()
	{
		for(int i=0;i<placeVector.size();i++)
		{
			System.out.println(placeVector.get(i).getRoomID());
			System.out.println(placeVector.get(i).name());
			System.out.println(placeVector.get(i).description());
			//System.out.println(placeVector.get(i).getRoomID());
		}
	}

	//getting the gameName.
	public String getGameName()
	{
		return gameName;
	}
	
	//getting current Place.
	//--------------------------------------------------
	//public Place getCurrentPlace()
	//{
		//return currentPlace;
	//}
	
	//adding the places to the place vector using the inbuilt function for vectors.(addElement()).
	public void addPlace(Place place)
	{
		placeVector.add(place);
	}
	
	//function to display the instructions of the game.
	public void Instructions()
	{
		System.out.println("Welcome to the 'Mystic City'..good luck");
		System.out.println("");
		
		System.out.println("Here are the Choices: ");
		System.out.println("1. Enter QUIT or EXIT : to exit or stop plaing the game at anytime. ");
		System.out.println("2. Enter LOOK : to see where you are in the game board. Also to see the details of the room.");
		System.out.println("3. Enter Directions : like N,S,E,W,U,D to play the game. ");
		System.out.println("4. Enter GET <keyname> : to Pick up the key from the room.");
		System.out.println("5. Enter USE <keyname> : to use the Key from your bag and open the room.");
		System.out.println("6. Enter DROP <keyname> : to drop the key from your bag.");
		System.out.println("7. Enter INVE or INVENTORY: to see what you have in your bag.");
	}
	
	public void playChar()
	{
		Instructions();
		System.out.println("");
		System.out.println("");
		boolean flag1 = false;
		
		System.out.println("You have two options: Enter 1 to play the game with existing players.");
		System.out.println("                      Enter 2 to Create your own Character and Play the game.");
		Scanner userOption = new Scanner(System.in);
		int optionNum = userOption.nextInt();
		
		if(optionNum == 2)
		{
		
			System.out.println("Okay, Lets create Your Own Character : -> \n");
			System.out.println("Pick random three digits, this will become your character ID : -> ");
			Scanner newPlayer= new Scanner(System.in);
			int newPlayerID = newPlayer.nextInt();
			System.out.println("Name of The Character : -> ");
			Scanner newPlayerName= new Scanner(System.in);
			String newPlayerName1 = newPlayerName.nextLine();
			System.out.println("Write something about your Character : -> ");
			Scanner newPlayerDisc= new Scanner(System.in);
			String newPlayerDisc1 = newPlayerDisc.nextLine();
			
			Character newObj = new Character(newPlayerID,newPlayerName1,newPlayerDisc1);
			charVect.add(newObj);
			flag1 = true;
			
		}
		
		if((optionNum == 1) || flag1 == true)
		{
			System.out.println("The List of the Players Available to Play the Game : \n");
			//while ((charVect.size())<5)
			//{
				for (int i =0; i< charVect.size(); i++)
				{
					if("PLAYER".matches(charVect.get(i).getcharType()))
					{
						System.out.println("Player No. " + (i+1));
						System.out.println("The name of the Player Playing is : " + charVect.get(i).getCharName());
						System.out.println("The Character ID is : " + charVect.get(i).getcID() );
						System.out.println("Discription of the Character : " + charVect.get(i).getcDisc());
						System.out.println("");
					}
					//charVect.get(i).makeMove();
				}
				System.out.println("Type in the Player number you want to play with : -> ");
				Scanner userPlayer= new Scanner(System.in);
				int number = userPlayer.nextInt();
				if(number > 0)
				{
					System.out.println("Alright, So you chose the Player No. " + number);
					System.out.println("The name of the Player Playing is : " + charVect.get(number-1).getCharName());
					System.out.println("The Character ID is : " + charVect.get(number-1).getcID() );
					System.out.println("Discription of the Character : " + charVect.get(number-1).getcDisc());
					System.out.println("");
				}
				else
				{
					System.out.println("Sorry Not a valid Player No. \n");
				}
				
				while(true)
				{
					charVect.get(number-1).makeMove();
				}
		 }
		else
		{
			System.out.println("That is not a Valid Option Number...Please try again.");
		}
	}
}//end of the Game Class.
