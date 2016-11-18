package mindrace.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mindrace.controller.Controller;
import mindrace.model.Category;
import mindrace.model.Situation;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * This class display all the categories for the player to choose.
 * It only allows the player to choose the token that he can. 
 * After the player choose the token the class calls the controller with the respective method.
 * Note: After choosing a token the class will be dispose.   
 * @author Agustin Lavarello
 *
 */
public class WinningTokenGraphics extends JFrame {

	private JPanel contentPane;
	private Category category;
	private Set<Category> categories;
	private Controller controller;
	JButton button_1;
	JButton button_2;
	JButton button_3;
	JButton button_4;
	JButton button_5;
	JButton button_6;
	private static final Category category1 = Category.Art;
	private static final Category category2 = Category.Entertainment;
	private static final Category category3 = Category.Geography;
	private static final Category category4 = Category.History;
	private static final Category category5 = Category.Science;
	private static final Category category6 = Category.Sport;
	
  /*
   * this method is the constructor 
   * 
   * @param categories this are the tokens that the player is missing.
   */
	public WinningTokenGraphics(Controller controller,Set<Category> categories) {
		this.categories = categories; 
		this.controller=controller;
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(150, 190, 450, 350);
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
		
		button_1 = new JButton(Translator.translate(category1));
		button_1.setBackground(new Color(255,77,158));
		button_1.setVisible(true);
		button_1.setOpaque(true);
		button_2 = new JButton(Translator.translate(category2));
		button_2.setBackground(new Color(249,236,0));
		button_2.setVisible(true);
		button_2.setOpaque(true);
		button_3 = new JButton(Translator.translate(category3));
		button_3.setBackground(new Color(0,164,255));
		button_3.setVisible(true);
		button_3.setOpaque(true);
		button_4 = new JButton(Translator.translate(category4));
		button_4.setBackground(new Color(198,132,0));
		button_4.setVisible(true);
		button_4.setOpaque(true);
		button_5 = new JButton(Translator.translate(category5));
		button_5.setBackground(new Color(255,176,0));
		button_5.setVisible(true);
		button_5.setOpaque(true);
		button_6 = new JButton(Translator.translate(category6));
		button_6.setBackground(new Color(97,191,58));
		button_6.setVisible(true);
		button_6.setOpaque(true);
		
		if(!categories.contains(category1)) {
			button_1.setBackground(Color.RED);
			button_1.setEnabled(false);
		}
		if(!categories.contains(category2)) {
			button_2.setBackground(Color.RED);
			button_2.setEnabled(false);
		}
		if(!categories.contains(category3)) {
			button_3.setBackground(Color.RED);
			button_3.setEnabled(false);
		}
		if(!categories.contains(category4)) {
			button_4.setBackground(Color.RED);
			button_4.setEnabled(false);
		}
		if(!categories.contains(category5)) {
			button_5.setBackground(Color.RED);
			button_5.setEnabled(false);
		}
		if(!categories.contains(category6)) {
			button_6.setBackground(Color.RED);
			button_6.setEnabled(false);
		}
		
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(categories.contains(category1)) {
					category = category1;
					button_1.setBackground(Color.YELLOW);
					closingTimer.schedule(closingTask, 1000);
				}
				controller.tokenChosen(category);
		
			}
		});
		
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(categories.contains(category2)) {
					category = category2;
					button_2.setBackground(Color.YELLOW);
					closingTimer.schedule(closingTask, 1000);
				}
				controller.tokenChosen(category);
			}
		});
		
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(categories.contains(category3)) {
					category =category3;
					button_3.setBackground(Color.YELLOW);
					closingTimer.schedule(closingTask, 1000);
				}
				controller.tokenChosen(category);
			}
		});
		
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(categories.contains(category4)) {
					category = category4;
					button_4.setBackground(Color.YELLOW);
					closingTimer.schedule(closingTask, 1000);
				}
				controller.tokenChosen(category);
			}
		});
		
		
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(categories.contains(category5)) {
					category = category5;
					button_5.setBackground(Color.YELLOW);
					closingTimer.schedule(closingTask, 1000);
				}
				controller.tokenChosen(category);
			}
		});
		
		
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(categories.contains(category6)) {
					category = category6;
					button_6.setBackground(Color.YELLOW);
					closingTimer.schedule(closingTask, 1000);
				}
				controller.tokenChosen(category);
			}
		});
		
		JLabel lblText = new JLabel("Has pasado por salida: Elige una Categoria para Ganar ");
		lblText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblText, GroupLayout.PREFERRED_SIZE, 424, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
									.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
									.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
									.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
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
					.addGap(33)
					.addComponent(lblText, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(148))
		);
		contentPane.setLayout(gl_contentPane);
	}
	

	public Category getCategory() {
		return category;
	}
}
