package mindrace.GUI;

import mindrace.model.Category;
import mindrace.model.Question;
import mindrace.model.QuestionSet;
import mindrace.model.Situation;

/**
 * @author Agu
 *
 */
public class TestGUI {
	
	public static void main(String[] args) {
		QuestionSet questionSet = new QuestionSet();
		Question question = questionSet.getQuestion(Category.Art);
		QuestionGUI questionGUI = new QuestionGUI(question);
		
	}
}
