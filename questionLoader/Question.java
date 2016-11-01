
public class Question implements Comparable<Question> {
	
	String question;
	String[] options;
	
	public Question(String question, String[] options) 
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
	public void printoptions()
	{
		for(int i=0;i<options.length;i++)
		{
			System.out.println(options[i]);
		}
	}

}
