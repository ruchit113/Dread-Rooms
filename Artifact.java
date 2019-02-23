//***** Artifact function to manage Artifacts that are going to be read from the data file,
// also this will make it more managable.

import java.util.Scanner;
import java.util.Vector;

public class Artifact {
	
	
	private
	int artiVal;
	int artiSize;
	int artiID;
	int key;
	String artiName;
	String artiDesc="";
	int Aid;
	
	
	public
	
	//Constroctor for the file as an input.
	Artifact(Scanner fileIn3)
	{
		String trimmed2=null;
		//getting the trimmed line from the file.
		trimmed2=CleanLineScanner.getCleanLine(fileIn3);
		@SuppressWarnings("resource")
		//using the trimmed line as a scanner input.
		Scanner inputLine3=new Scanner(trimmed2);
		
		//String 
		int artiPlaceID;
		
		artiPlaceID=inputLine3.nextInt();
		
		String trimmed3=null;
		trimmed3=CleanLineScanner.getCleanLine(fileIn3);
		@SuppressWarnings("resource")
		Scanner inputLine4=new Scanner(trimmed3);
		
		artiID=inputLine4.nextInt();
		artiVal=inputLine4.nextInt();
		artiSize=inputLine4.nextInt();
		key=inputLine4.nextInt();
		artiName=(inputLine4.nextLine()).trim();
		
		int discNum=fileIn3.nextInt();
		
		//for loop for the discription.
		for(int l=0;l<discNum;l++)
		{
			trimmed2=CleanLineScanner.getCleanLine(fileIn3);
			Scanner temp=new Scanner(trimmed2);
			artiDesc=artiDesc+"\n"+temp.nextLine();
		}
		//adding artifacts to the artiPlace hash map.
		//System.out.println("Artifact name is " + artiName);
		if(artiPlaceID < 0)
		{
			//player possesions...
			int positiveID = Math.abs(artiPlaceID);
			Character charVec = Character.getCharacterByID(positiveID);
			charVec.charArti.add(this);
		}
		if(artiPlaceID > 0)
		{
			//
			Place artiPlace = Place.getPlaceByID(artiPlaceID);
			artiPlace.addArtifact(artiName,this);
		}
		if(artiPlaceID == 0)
		{
			//random place pick...
			Place artiPlace = Place.getPlaceByID(106);
			artiPlace.addArtifact(artiName,this);
		}
		
	}//end of the constructor.
	
	//return the movability value
	int value()
	{
		return artiVal;
	}
	//getting the size of Artifact.
	int size()
	{
		return artiSize;
	}
	
	//getting the Artifact name.
	String name()
	{
		return artiName;
	}
	
	//getting the decription..
	String ArtiDescription()
	{
		return artiDesc;
	}
	
	//helper funtion for the keyUse.
	void use(Character C, Place current)
	{
		if(key>0)
		{
			current.useKey(this);
		}
		else
		{
			System.out.println("This is not a key, you cannot use this to open the room...");
		}
	}
	
	//getting the key...
	int getKey()
	{
		return key;
	}
	
	//for debugging purposes...
	void print()
	{
		System.out.println("In artifact class");
	}
	
}//end of the Artifact class.
