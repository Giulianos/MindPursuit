package mindrace.model.states;
import mindrace.model.*;
import mindrace.model.states.*;
import java.util.Random;
/**
 * 
 * @author Agustin Lavarello
 *
 */
public class ThrowingDice extends State {

	private Integer diceNumber;
	private Random randomNumber = new Random();
	private static final int  MINIMALNUMBER = 1;
	private static final int MAXIMALNUMBER = 6; 

	public Integer throwDice() {
		return (int) (randomNumber.nextDouble()*MAXIMALNUMBER + MINIMALNUMBER);
	}
	
	public void initialize() {
		diceNumber = throwDice();
	}

	public Integer diceNumber() {
		return diceNumber;
	}

	public State terminate() {
		return new Moving();
	}

}

