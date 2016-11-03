package mindrace.model;
/**
 * 
 * @author Julian
 *
 */
public class Question implements Comparable<Question> {
	
	String question;
	String[] parameters;
	int correctAnswer;
	
	public Question(String question, String[] options) 
	{
		this.question = question;
		this.parameters= new String[4];
		this.correctAnswer= new Integer(options[options.length-1]);
		for (int i=0; i<options.length-2;i++){
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
	

}
