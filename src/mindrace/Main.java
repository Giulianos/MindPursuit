package mindrace;

import java.io.IOException;

import mindrace.GUI.MenuGraphics;
import mindrace.GUI.View;
import mindrace.controller.Controller;
import mindrace.model.QuestionSet;

public class Main {

	public static void main(String[] args) {
		Controller controller= new Controller();
		View view= new View();
		controller.setView(view);
		view.setController(controller);
		view.openMenu();
		
	}

}