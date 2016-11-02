package mindrace.model;
/**
 * 
 * @author Julian
 *
 */
public class Question implements Comparable<Question> {
	
	String question;
	String[] options;
	int correctAnswer;
	
	public Question(String question, String[] options, int correctAnswer) 
	{
		this.question = question;
		this.options = options;
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
	public String getCorrectAnswer()
	{
		return options[correctAnswer];
	}
	

}
