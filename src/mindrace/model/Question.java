package mindrace.model;

import java.io.Serializable;

/**
 * 
 * @author Julian
 *
 */
public class Question implements Comparable<Question>, Serializable {
	
	private String question;
	private String[] parameters;
	private int correctAnswer;
	
	public Question(String question, String[] options) 
	{
		this.question = question;
		this.parameters= new String[3];
		this.correctAnswer= new Integer(options[options.length-1]);
		for (int i=0; i<options.length-1;i++){
			this.parameters[i]=options[i];
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
	public String[] getParameters(){
		return parameters;
	}
	public void printParameters(){
		for(int i=0; i<parameters.length;i++){
			System.out.println(parameters[i]);
		}
	
	}
}
