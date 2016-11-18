package mindrace.model;

import java.io.Serializable;

/**
 * 
 * @author Julian
 *
 */
public class Question implements Serializable {
	
	private String question;
	private String[] options;
	private int correctAnswer;
	
	/**
	 * Constructs a new Question
	 * @param question
	 * @param parameters, contains the three possible options and the correct option
	 */
	public Question(String question, String[] parameters) 
	{
		this.question = question;
		this.options= new String[3];
		this.correctAnswer= new Integer(parameters[parameters.length-1]);
		for (int i=0; i<parameters.length-1;i++){
			this.options[i]=parameters[i];
		}
	}
	@Override
	public String toString() {
		return question.toString();
	}

	public String getQuestion() {
		return question;
	}
	public Integer getCorrectAnswer()
	{
		return correctAnswer;
	}
	public String[] getOptions(){
		return options.clone();
	}
	public boolean isCorrect(int optionNumber){
		return optionNumber==correctAnswer;
	}
	
	
	
}
