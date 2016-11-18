package mindrace.GUI;
import java.util.HashMap;
import java.util.Map;

import mindrace.model.Category;

/**
 * @author Julian
 * This class translates the Categories from English to Spanish
 *
 */
public class Translator {
	
	private static Map<Category,String> translations = new HashMap<Category,String>();
	
	public static String translate(Category category)
	{
		switch(category)
		{
			case Geography:
			{
				return "Geografia";
			}
			case Science:
			{
				return "Ciencia";
			}
			case History:
			{
				return "Historia";
			}
			case Sport:
			{
				return "Deportes";
			}
			case Art:
			{
				return "Arte";
			}
			case Entertainment:
			{
				return "Entretenimiento";
			}
			default:
			{
				return "";
			}
				
		}
		
	}
	

}
