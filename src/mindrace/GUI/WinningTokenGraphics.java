package mindrace.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
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

/**
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
	
   
	public WinningTokenGraphics(Controller controller,Set<Category> categories) {
		this.categories = categories; 
		this.controller=controller;
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 520, 300);
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
		
		button_1 = new JButton(Translator.translate(Category.Geography).toString());
		button_1.setVisible(true);
		button_1.setOpaque(true);
		button_2 = new JButton(Translator.translate(Category.Science).toString());
		button_2.setVisible(true);
		button_2.setOpaque(true);
		button_3 = new JButton(Translator.translate(Category.History).toString());
		button_3.setVisible(true);
		button_3.setOpaque(true);
		button_4 = new JButton(Translator.translate(Category.Sport).toString());
		button_4.setVisible(true);
		button_4.setOpaque(true);
		button_5 = new JButton(Translator.translate(Category.Art).toString());
		button_5.setVisible(true);
		button_5.setOpaque(true);
		button_6 = new JButton(Translator.translate(Category.Entertainment).toString());
		button_6.setVisible(true);
		button_6.setOpaque(true);
		
		if(!categories.contains(Category.Geography)) {
			button_1.setBackground(Color.RED);
			button_1.setEnabled(false);
		}
		if(!categories.contains(Category.Science)) {
			button_2.setBackground(Color.RED);
			button_2.setEnabled(false);
		}
		if(!categories.contains(Category.History)) {
			button_3.setBackground(Color.RED);
			button_3.setEnabled(false);
		}
		if(!categories.contains(Category.Sport)) {
			button_4.setBackground(Color.RED);
			button_4.setEnabled(false);
		}
		if(!categories.contains(Category.Art)) {
			button_5.setBackground(Color.RED);
			button_5.setEnabled(false);
		}
		if(!categories.contains(Category.Entertainment)) {
			button_6.setBackground(Color.RED);
			button_6.setEnabled(false);
		}
		
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(categories.contains(Category.Geography)) {
					category = Category.Geography;
					button_1.setBackground(Color.YELLOW);
					closingTimer.schedule(closingTask, 1000);
				}
				controller.tokenChosen(category);
		
			}
		});
		
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(categories.contains(Category.Science)) {
					category = Category.Science;
					button_2.setBackground(Color.YELLOW);
					closingTimer.schedule(closingTask, 1000);
				}
				controller.tokenChosen(category);
			}
		});
		
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(categories.contains(Category.History)) {
					category = Category.History;
					button_3.setBackground(Color.YELLOW);
					closingTimer.schedule(closingTask, 1000);
				}
				controller.tokenChosen(category);
			}
		});
		
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(categories.contains(Category.Sport)) {
					category = Category.Sport;
					button_4.setBackground(Color.YELLOW);
					closingTimer.schedule(closingTask, 1000);
				}
				controller.tokenChosen(category);
			}
		});
		
		
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(categories.contains(Category.Art)) {
					category = Category.Art;
					button_5.setBackground(Color.YELLOW);
					closingTimer.schedule(closingTask, 1000);
				}
				controller.tokenChosen(category);
			}
		});
		
		
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(categories.contains(Category.Entertainment)) {
					category = Category.Entertainment;
					button_6.setBackground(Color.YELLOW);
					closingTimer.schedule(closingTask, 1000);
				}
				controller.tokenChosen(category);
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
