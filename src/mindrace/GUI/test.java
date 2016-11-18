package mindrace.GUI;

import java.util.HashSet;
import java.util.Set;

import mindrace.model.Category;

/**
 * @author francisco
 *
 */
public class test {
public static void main(String[] args) {
	new WinningGameGraphics(new WinningGameGUI(new PlayerGUI("a", new HashSet<Category>())));
}
}
