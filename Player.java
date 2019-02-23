//Another extension from the Character class...Allowing control over the characters...Players.
import java.util.Scanner;

public class Player extends Character 
{	
	PlayerInterface UI;
	public Player(Scanner game, double version) 
	{
		super(game, version);
	    UI = new PlayerInterface() ;   // P object reference to UI 
		// TODO Auto-generated constructor stub
	}
	void displayInstructions()
	{
		//Future Enhancement: This will be helpful, when we add powers and specific limits to the players.
		//to display any specific Player related information or instructions.
	}
	void makePlayerMove()
	{
		//Future enhancement: this will allow player to make an indipendent move as per user instructions.
	}
	
}//End of the player class...
