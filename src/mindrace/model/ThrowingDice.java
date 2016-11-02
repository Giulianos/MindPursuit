package mindrace.model;
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
	private State previousState;
	private Situation currentSituation;
	static final Integer minimalNumber = 1;
	static final Integer maximalNumber = 6; 
	
	public ThrowingDice(State previousState) {
		super(null);
		this.previousState = previousState;
	}
	public void setCurrentSituation(Situation currentSituation) {
		this.currentSituation = currentSituation;
	}

	public Integer throwDice() {
		return (int) (randomNumber.nextDouble()*maximalNumber + minimalNumber);
	}
	
	public void initialize() {
		diceNumber = throwDice();
	}

	public Integer diceNumber() {
		return diceNumber;
	}
	
	//preguntar bien como hacerlo
	public State terminate() {
		return new Move(this);
	}

}
}
