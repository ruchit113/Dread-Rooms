//gameTester Class for the game Testing...


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class gameTester {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.out.println("Group No. 37, and Group members :");
		System.out.println("1.Name: Jay V. Patel");
		System.out.println("  ACCC: jpate14\n");
		System.out.println("2.Name: Shivani Pathak");
		System.out.println("  ACCC: spathak\n");
		System.out.println("3.Name: Ruchit Patel");
		System.out.println("  ACCC: rpatel1\n");
		
		//providing a file path to open the file and access it accordingly...
		//NOTE: this will not work until you put the appropriate path where the file exists.
		//"C:\\Users\\Jay Patel\\Desktop\\mystic.txt"
		File file = new File("mystic.txt");
		Scanner scan=new Scanner(file);
		Game game = new Game(scan);
		
		//playing the game.
		game.playChar();
		
	}

}
