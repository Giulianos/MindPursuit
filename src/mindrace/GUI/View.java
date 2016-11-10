package mindrace.GUI;

import java.util.List;
import java.util.Set;

import mindrace.model.Category;
import mindrace.model.Question;

/**
 * @author Giuliano, Daniella
 *
 */
public class View {
	public int start(){
		return 0;
	}
	public List<String> enteringNames(){
		return null;
	}
	public void newTurn(PlayerGUI player){
	
	}
	public void throwDice(ThrowingDiceGUI stateDice){
		
	}
	public void move(MovingGUI moving){
		
	}
	public Category chooseCategory(){
		return null;
	}
	public Theft stealling(StealingTokenGUI stealingToken){
		return null;
	}
	public Category chooseTokenToWin(Set<Category> possibleTokens){
		return null;
	}
	public int ask(QuestionGUI2 question){
		return 0;
	}
	public void endAsk(Question question, int option, boolean isCorrect){
		
	}
	public void winning(WinningGameGUI winningGame){
		
	}
}
