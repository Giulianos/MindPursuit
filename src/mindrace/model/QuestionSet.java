package mindrace.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class QuestionSet {
	
private Map<QType, Set<Question>> questionset;
	
	public QuestionSet() throws IOException
	{
		questionset = new TreeMap<QType,Set<Question>>();
		questionset.put(QType.ART, createQSet("/Users/Julian/Desktop/art.txt"));
	}
	private Set<Question> createQSet(String text) throws IOException {
		
		Set<Question> questions = new TreeSet<Question>();
		
		try 
		{
			Reader r = new FileReader(text);
			BufferedReader in = new BufferedReader(r);
			String currentline = in.readLine();
			
			while (currentline != null) 
			{
				int endofq = currentline.indexOf('(');
				int endofans = currentline.indexOf(')');
				String question = currentline.substring(0, endofq);
				String options = currentline.substring(endofq+1,endofans);
				String [] items = options.split(",");
				Question q = new Question(question,items);
				questions.add(q);
				currentline = in.readLine();
			}
			
			in.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return questions;
	
	}
	public void printAnswers()
	{
		for(Question each : questionset.get(QType.ART))
		{
			System.out.println(each.toString());
			each.printoptions();
		}
	}
	public Question getQuestion(Category category){
		Question[] questions= (Question[]) questionset.get(category).toArray();
		int index= (int) (Math.random()*questions.length);
		Question question= questions[index];
		return question;
		
		
	}

}
	
	
