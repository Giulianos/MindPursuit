package mindrace.model.states;

import mindrace.model.states.State;
import mindrace.model.QuestionSet;
import mindrace.model.states.WinningToken;
import mindrace.model.Category;
import mindrace.model.Question;
import mindrace.model.TileWithCategory;

/**
 * @author Giuliano
 *
 */
public class Asking extends State implements Constants {
	
	private Question questionToAsk;
	private static QuestionSet questionSet= new QuestionSet();
	private Integer selectedAnswer;
	private Long timeTaken;

	/**
	 * @see mindrace.model.states.State#initialize()
	 */
	@Override
	public void initialize() {
		
		Category categoryToAsk;
		
		if((this.getPreviousState().getClass().equals(Moving.class)) ||
			(this.getPreviousState().getClass().equals(WinningToken.class)) ) {
			
			/**
			 *  If previous state is WinningToken or Moving, it means the tile has category
			 * 
			 */
			TileWithCategory playersTile = (TileWithCategory)getSituation().getCurrentPlayer().getTile();
			categoryToAsk = playersTile.getCategory();
			
		} 
		else {
			
			ChoosingCategory auxiliaryPreviousState = (ChoosingCategory)this.getPreviousState();
			categoryToAsk = auxiliaryPreviousState.getCategory(); 
		}
		
		questionToAsk = questionSet.getQuestion(categoryToAsk);
		
		if(questionToAsk==null) {
			
			questionSet=new QuestionSet();
			questionToAsk= questionSet.getQuestion(categoryToAsk);
		}
		
		timeTaken=System.currentTimeMillis();
	}
	
	/**
	 * Method called by controller
	 * 
	 * @return Question
	 */
	public Question getQuestion() {
		return questionToAsk;
	}
	
	public void setAnswer(Integer option) {
		if(option==null )
			throw new IllegalArgumentException();
		this.selectedAnswer = option;
		timeTaken = System.currentTimeMillis() - timeTaken;
	}

	/**
	 * @see mindrace.model.states.State#terminate()
	 */
	@Override
	public State terminate() {
		if(selectedAnswer == null){
			return new NewTurn();
		}
		if(questionToAsk.getCorrectAnswer().equals(selectedAnswer) && timeTaken<=SLOW_TIME) {
			if(timeTaken<FAST_TIME){ 
				if(this.getSituation().getCurrentPlayer().getTile().isSpecial()) {
					return new WinningToken();	
				} else if (getSituation().getCurrentPlayer().getTile().stealablePlayers(getSituation().getCurrentPlayer()).size() > 0) {
					return new StealingToken();
				}
			}
			return new Moving();
		}
		return new NewTurn();
	}
	public Long getTimeTaken(){
		return timeTaken;
	}

	@Override
	public boolean isModifier() {
		return false;
	}
	
	/**
	 * 
	 * Method only to be used when serializing
	 * @return the questionSet
	 */
	public static QuestionSet getQuestionSet() {
		return questionSet;
	}
	
	/**
	 * @param questionSet the questionSet to set
	 */
	public static void setQuestionSet(QuestionSet questionSet) {
		Asking.questionSet = questionSet;
	}



}
