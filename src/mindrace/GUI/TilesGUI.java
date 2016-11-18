package mindrace.GUI;


import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Agustin Lavarello
 *
 */
public class TilesGUI {
	
	private Integer tilesQuantity = 42;
	private static List<Point> tilesPositions = new LinkedList<Point>() ;
	
	public TilesGUI(){
		try {
			loadPositionsFromXML("boardGUI.xml");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadPositionsFromXML(String URI) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(URI);
		NodeList tilesList = doc.getElementsByTagName("tile");
		for(int i = 0; i < tilesQuantity; i++) {
			Node tileNode = tilesList.item(i);
			NamedNodeMap attributesMap = tileNode.getAttributes();
			Integer xCoord = new Integer(attributesMap.getNamedItem("x").getNodeValue());
			Integer yCoord = new Integer(attributesMap.getNamedItem("y").getNodeValue());
			Integer tileID = new Integer(attributesMap.getNamedItem("id").getNodeValue());
			tilesPositions.add(tileID, new Point(xCoord, yCoord));
		}
	}
	
	/**
	 * @return the tilesPositions
	 */
	public static List<Point> getTilesPositions() {
		return tilesPositions;
	}
}
