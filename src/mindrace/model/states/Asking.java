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
public class Asking extends State {
	
	Question questionToAsk;
	QuestionSet questionSet;
	Integer selectedAnswer;
	Integer timeTaken;

	/**
	 * @see mindrace.model.states.State#initialize()
	 */
	@Override
	public void initialize() {
		Category categoryToAsk;
		if( (this.getPreviousState().getClass().equals(Moving.class)) ||
			(this.getPreviousState().getClass().equals(WinningToken.class)) ) {
			
			/* Si el estado anterior es Moving o WinningToken puedo asegurar que el casillero del juagdor
			 * es con categoria y sacarla del tile.
			 */
			TileWithCategory playersTile = (TileWithCategory)getSituation().getCurrentPlayer().getTile();
			categoryToAsk = playersTile.getCategory();
			
		} else {
			ChoosingCategory auxiliaryPreviousState = (ChoosingCategory)this.getPreviousState();
			categoryToAsk = auxiliaryPreviousState.getCategory(); 
		}
		
		questionToAsk = questionSet.getQuestion(categoryToAsk);
	}
	
	/**
	 * Metodo llamado por el controller para saber que pregunta realizarle al jugador.
	 * 
	 * @return Question
	 */
	public Question getQuestion() {
		return questionToAsk;
	}
	
	/**
	 * Metodo llamado por el controller para pasarle al estado la respuesta
	 * del jugador.
	 * 
	 */
	public void setAnswer(Integer option, Integer timeTaken) {
		if(option==null || timeTaken==null)
			throw new IllegalArgumentException();
		this.selectedAnswer = option;
		this.timeTaken = timeTaken;
	}
	
	public void addQuestionSet(QuestionSet questionSet) {
		if(questionSet == null)
			throw new IllegalArgumentException();
		this.questionSet = questionSet;
	}

	/**
	 * @see mindrace.model.states.State#terminate()
	 */
	@Override
	public State terminate() {
		if(questionToAsk.getCorrectAnswer().equals(selectedAnswer)) {
			System.out.println(this.getSituation().getCurrentPlayer().getTile().getClass() );
			if(timeTaken<15){ //constante de tiempo
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
	public int getTimeTaken(){
		return timeTaken;
	}
	public void setQuestionSet(QuestionSet questions){
		this.questionSet=questions;
	}

}
