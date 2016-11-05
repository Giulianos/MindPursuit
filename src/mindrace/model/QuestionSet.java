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
import mindrace.model.*;

/**
 * 
 * @author Julian
 *
 */
public class QuestionSet {
	
private Map<Category, Set<Question>> questionMap;
	
	/**
	 * Genera un mapa donde cada categoria se asocia a un Set de preguntas de dicha categoria
	 * @throws IOException
	 */

	public QuestionSet() {
		questionMap = new TreeMap<Category,Set<Question>>();
		for(Category each : Category.values())
		{
			questionMap.put(each, createQuestionSet(each.toString()+".txt"));
			
		}
		
	}
	/**
	 * Genera el Set de preguntas para cada categoria
	 * @param text: Nombre del archivo de preguntas
	 * @return questionSet: Set con preguntas de la categoria
	 * @throws IOException
	 */
	private Set<Question> createQuestionSet(String text) {
		
		Set<Question> questionSet = new TreeSet<Question>();
		
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
				String items = currentline.substring(endofq+1,endofans);
				String aux[] = items.split(",");
				Question q = new Question(question, aux);
				questionSet.add(q);
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
		return questionSet;
	
	}
	/**
	 * Devuelve una pregunta al azar de la categoria recibida
	 * @param categoryToAsk
	 * @return 
	 */
	public Question getQuestion(Category categoryToAsk)
	{
		Set<Question> categoryQuestionSet = questionMap.get(categoryToAsk);
		int count = 0;
		int random = (int) (Math.random() * categoryQuestionSet.size());
		for(Question question : categoryQuestionSet)
		{
			if(count == random)
			{
				categoryQuestionSet.remove(question);
				return question;
			}
			count++;
		}
		
		return null; //Si no quedan mas preguntas, que excepcion lanzar?
		
	}
	

}
	
	
