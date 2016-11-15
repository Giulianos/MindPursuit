package mindrace.model;

import mindrace.model.Tile;
import mindrace.model.TileWithCategory;
import mindrace.model.Category;
import java.io.Serializable;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Daniella, Giuliano
 *
 */
public class Board implements Serializable{
	/*
	 * Constantes
	 */
	private final Integer tilesQuantity = 42;
	
	private CircularList<Tile> tiles = new CircularList<Tile>();
	private String tilesXMLFile = "boardTiles.xml";
	
	/**
	 * 
	 * @see http://stackoverflow.com/a/24910935
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public Board() throws ParserConfigurationException, SAXException, IOException {
		
		//Cargo los tiles desde un XML
		loadTilesFromXML(tilesXMLFile);
		
	}
	
	private void loadTilesFromXML(String URI) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(URI);
		NodeList tilesList = doc.getElementsByTagName("tile");
		for(int i = 0; i < tilesQuantity; i++) {
			Tile tileToAdd;
			Node tileNode = tilesList.item(i);
			NamedNodeMap attributesMap = tileNode.getAttributes();
			Node categoryAttributeNode = attributesMap.getNamedItem("category");
			if(categoryAttributeNode == null) {
				tileToAdd = new Tile(i);
			} else {
				Category categoryToAdd;
				switch(categoryAttributeNode.getNodeValue()) {
					case "Geography": categoryToAdd = Category.Geography; break;
					case "Science": categoryToAdd = Category.Science; break;
					case "History": categoryToAdd = Category.History; break;
					case "Sport": categoryToAdd = Category.Sport; break;
					case "Art": categoryToAdd = Category.Art; break;
					default: categoryToAdd = Category.Entertainment; break;
				}
				tileToAdd = new TileWithCategory(i,
						attributesMap.getNamedItem("star").getNodeValue().equals("true"),
						categoryToAdd);
			}
			tiles.add(tileToAdd);
		}
	}
	public Tile getNext(Tile t){
		Tile ret= tiles.getNext(t);
		if (ret==null){
			throw new IllegalArgumentException();
		}
		return ret;
	}
	
	public Tile getTileAt(Integer index){
		return tiles.get(index);
	}
	/**
	 * @return
	 */
	public Tile startingTile() {
		return tiles.get(0);
	}
	
}
