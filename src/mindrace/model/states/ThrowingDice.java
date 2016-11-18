package mindrace.model.states;

import java.util.Random;
/**
 * 
 * @author Agustin Lavarello
 *
 */
public class ThrowingDice extends State implements Constants{

	private Integer diceNumber;
	private static  Random randomNumber =  new Random(); 

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

	public boolean isModifier() {
		return false;
	}

}

