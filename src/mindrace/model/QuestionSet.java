package mindrace.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * This class is in charge of loading the questions of each Category from files
 * 
 * @author Julian
 *
 */
public class QuestionSet implements Serializable {
	
private Map<Category, List<Question>> questionMap;
	
	/**
	 * Creates a map where each category is associated with an ArrayList of questions of that category
	 */

	public QuestionSet() {
		
		questionMap = new TreeMap<Category,List<Question>>();
		
		for(Category each : Category.values())
		{
			questionMap.put(each, createQuestionArray(each.toString()+".txt"));
			
		}
		
	}
	/**
	 * Creates the ArrayList of questions for each category
	 * @param text: Questions file name
	 * @return questionArray: Contains the questions for the category
	 */
	private List<Question> createQuestionArray(String text) {
		
		List<Question> questionArray = new ArrayList<Question>();
		
		try 
		{
			Reader r = new InputStreamReader(new FileInputStream(text), "UTF-8");
			BufferedReader in = new BufferedReader(r);
			String currentline = in.readLine();
			
			while (currentline != null) 
			{
				int endofq = currentline.indexOf('(');
				int endofans = currentline.indexOf(')');
				String question = currentline.substring(0, endofq);
				String items = currentline.substring(endofq+1,endofans);
				String aux[] = items.split(",");
				Question q = new Question(question, aux);
				questionArray.add(q);
				currentline = in.readLine();
			}
			
			in.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
		return questionArray;
	
	}
	/**
	 * Returns a random question of the category specified
	 * @param categoryToAsk
	 * @throws NoMoreQuestionsAvailable when the size of the array is 0
	 */
	public Question getQuestion(Category categoryToAsk)	{
		
		List<Question> categoryQuestionArray = questionMap.get(categoryToAsk);
		
		if(categoryQuestionArray.size()>0)
		{
			Random random = new Random();
			random.setSeed(System.currentTimeMillis());
			int nextInt = random.nextInt(categoryQuestionArray.size());
			Question randomQuestion = categoryQuestionArray.get(nextInt);
			categoryQuestionArray.remove(random);
			return randomQuestion;
		}
		else
		{
			return null;
		}
		
	}
	
}
	
	
