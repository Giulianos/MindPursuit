package mindrace.GUI;

import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mindrace.model.Category;
import mindrace.model.Player;


/**
 * This class has all the element to draw a player: the position and the image;
 * The class add the image into a label and set the bounds of the label with the image 
 * height and width and the coordinates
 * 
 * @author Agustin Lavarello
 *
 */
public class PlayerGraphics extends JPanel implements Serializable {
	
	private int x,y;
	private String name;
	private JLabel label = new JLabel();
	private ImageIcon img;
	
/*
* this method is the constructor and receives an image and a string
*/
	public PlayerGraphics(ImageIcon img, String name) {
		this.name = name;
		this.img = img;
		this.label.setIcon(img);
		Point p = TilesGUI.getTilesPositions().get(0);
		this.label.setBounds((int)p.getX(), (int)p.getY(), img.getIconHeight(), img.getIconWidth());
	}
	
	/*
	 * this method receives a point and set the X and Y 
	 * coordinates with the X and Y coordinates of the point
	 */
	public void setCoordinates(Point  p) {
		this.x = (int)p.getX();
		this.y = (int)p.getY();
	}

	/*
	 * this method updates the JLabel of the player with the new coordinates
	 */
	public void update() {
		this.label.setBounds(x, y, img.getIconHeight(), img.getIconWidth());
	}
	
	/*
	 * this method returns the JLabel so that BoardGUI can draw the player
	 */
	public JLabel getLabel() {
		return label;
	}
	
	public String getName() {
		return name;
	}

	
	public ImageIcon getImg() {
		return img;
	}

	
	
	
}
