package mindrace.GUI;

import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mindrace.model.Category;
import mindrace.model.Player;


/**
 * @author Agustin Lavarello
 *
 */
public class PlayerGraphics extends JPanel {
	
	private int x,y;
	private String name;
	private JLabel label = new JLabel();
	private ImageIcon img;
	
	public String getName() {
		return name;
	}

	public PlayerGraphics(ImageIcon img, String name) {
		this.name = name;
		this.img = img;
		this.label.setIcon(img);
		Point p = TilesGUI.getTilesPositions().get(0);
		this.label.setBounds((int)p.getX(), (int)p.getY(), img.getIconHeight(), img.getIconWidth());
	}
	
	public void setCoordinates(Point  p) {
		this.x = (int)p.getX();
		this.y = (int)p.getY();
	}

	public void update() {
		this.label.setBounds(x, y, img.getIconHeight(), img.getIconWidth());
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public JLabel getLabel() {
		return label;
	}
	
	/**
	 * @return the img
	 */
	public ImageIcon getImg() {
		return img;
	}

	
	
	
}
