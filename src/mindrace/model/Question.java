package mindrace.model;

import java.io.Serializable;

/**
 * 
 * @author Julian
 *
 */
public class Question implements Comparable<Question>, Serializable {
	
	private String question;
	private String[] options;
	private int correctAnswer;
	
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
	public int compareTo(Question o) {
		return question.compareTo(o.getQuestion());
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
