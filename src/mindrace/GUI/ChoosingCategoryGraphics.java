package mindrace.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import mindrace.model.Category;
import mindrace.model.Situation;
import mindrace.controller.*;

/**
 * This class extends from a frame and displays all the categories.
 * When the player choose a category, this class calls the controller with the chosen Category.
 * Note: After pressing the button the class will close. 
 * 
 * @author Agustin Lavarello
 *
 */
public class ChoosingCategoryGraphics extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private Category category;
	private Controller controller;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private Category categoria1 = Category.Art;
	private Category categoria2 = Category.Entertainment;
	private Category categoria3 = Category.Geography;
	private Category categoria4 = Category.History;
	private Category categoria5 = Category.Science;
	private Category categoria6 = Category.Sport;

	
	/*
	 * This is the constructor
	 * This method will set visible the class and creats all the buttons with the categories name
	 * When a button is pressed it will call the controller with the corresponding method and with the category
	 * chosen
	 * 
	 * @param controller The controller that the class will call 
	 */
	public ChoosingCategoryGraphics(Controller controller) {
		this.controller = controller;
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Timer closingTimer = new Timer();
		TimerTask closingTask = new TimerTask() {

			@Override
			public void run() {
				dispose();
				
			}
			
		};
		/**
		 * the colors asigned to the buttons have been measured in RGB.
		 */
		
		button_1 = new JButton(Translator.translate(categoria1).toString());
		button_1.setBackground(new Color(255,77,158));
		button_1.setOpaque(true);
		button_1.setBorderPainted(true);
		button_2 = new JButton(Translator.translate(categoria2).toString());
		button_2.setBackground(new Color(249,236,0));
		button_2.setOpaque(true);
		button_2.setBorderPainted(true);
		button_3 = new JButton(Translator.translate(categoria3).toString());
		button_3.setBackground(new Color(0,164,255));
		button_3.setOpaque(true);
		button_3.setBorderPainted(true);
		button_4 = new JButton(Translator.translate(categoria4).toString());
		button_4.setBackground(new Color(198,132,0));
		button_4.setOpaque(true);
		button_4.setBorderPainted(true);
		button_5 = new JButton(Translator.translate(categoria5).toString());
		button_5.setBackground(new Color(255,176,0));
		button_5.setOpaque(true);
		button_5.setBorderPainted(true);
		button_6 = new JButton(Translator.translate(categoria6).toString());
		button_6.setBackground(new Color(97,191,58));
		button_6.setOpaque(true);
		button_6.setBorderPainted(true);
		
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					category = categoria1;
					button_1.setBackground(Color.YELLOW);
					closingTimer.schedule(closingTask, 1000);
					controller.chosenCategory(category);
			}
		});
		
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				category = categoria2;
				button_2.setBackground(Color.YELLOW);
				closingTimer.schedule(closingTask, 1000);
				controller.chosenCategory(category);
			}
		});
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				category = categoria3;
				button_3.setBackground(Color.YELLOW);
				closingTimer.schedule(closingTask, 1000);
				controller.chosenCategory(category);
			}
		});
		
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				category = categoria4;
				button_4.setBackground(Color.YELLOW);
				closingTimer.schedule(closingTask, 1000);
				controller.chosenCategory(category);
			}
		});
		
		
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				category = categoria5;
				button_5.setBackground(Color.YELLOW);
				closingTimer.schedule(closingTask, 1000);
				controller.chosenCategory(category);
			}
		});
		
		
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				category = categoria6;
				button_6.setBackground(Color.YELLOW);
				closingTimer.schedule(closingTask, 1000);
				controller.chosenCategory(category);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
							.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button_6, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(230))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	/**
	 * 
	 */
	

	public Category getCategory() {
		return category;
	}

	
}

