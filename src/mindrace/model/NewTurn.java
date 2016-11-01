package mindRace;
/**
 * 
 * @author francisco
 *
 */
public class NewTurn extends State {
	public NewTurn(State previousState){
		super(previousState);
	}
	public void initialize(){
		
	}
	public State terminate(){
		return new ThrowingDice(this);
	}

}
