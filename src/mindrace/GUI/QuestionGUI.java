package mindrace.GUI;

import java.util.Set;

/**
 * @author francisco
 *
 */
public class QuestionGUI {
	private String question;
	private String[] options;
	private int correctAnswer;
	private int answer;
	
	public QuestionGUI(String question, String[] options, int correctAnswer){
		this.question=question;
		this.options=options;
		this.correctAnswer=correctAnswer;
	}
	
	public int getanswer(){
		return answer;
	}
	
	public void setAnswer(int answer){
		this.answer=answer;
	}
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * @return the options
	 */
	public String[] getOptions() {
		return options;
	}
	/**
	 * @return the correctAnswer
	 */
	public Integer getCorrectAnswer() {
		return correctAnswer;
	}

}
