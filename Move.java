import java.util.Vector;

//This class takes user Input as Type and Argumanet and converts it into,
//Move object for further assesment...

public class Move {

	public Vector<Move> MoveVec = new Vector<Move>();
	
	Move ( String one, String two)
	{
		 
		String moveString = two.trim();
		
		System.out.println("Here is the move object " +one +" "+moveString);
		Move object = new Move(one, moveString);
		MoveVec.addElement(object);
	}
	
	public Vector<Move> getMoveVector()
	{
		return MoveVec;
	}
	
}
