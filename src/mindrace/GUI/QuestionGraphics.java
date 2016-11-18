package mindrace.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mindrace.controller.Controller;
import mindrace.model.Question;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

/**
 * @author Agustin Lavarello
 *
 */
public class QuestionGraphics extends JFrame {

	
	private QuestionGUI question;
	private int timeTaken;
	private final static int firstAnswer = 0;
	private final static int secondAnswer = 1;
	private final static int thirdAnswer = 2;
	private JPanel contentPane;
	private JTextField questionText;
	JButton answer1;
	JButton answer2;
	JButton answer3;
	
	private Controller controller;

	

	
	public QuestionGraphics(Controller controller, QuestionGUI q) {
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setBounds(750, 350, 450, 310);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.setResizable(false);
		this.controller=controller;
		
		
		
		this.question= q;
		questionText = new JTextField(question.getQuestion()) ;
		questionText.setColumns(10);
		questionText.setEditable(false);
		Timer closingTimer = new Timer();
		TimerTask closingTask = new TimerTask() {

			@Override
			public void run() {
				dispose();
				
			}
			
		}; 
		
		JLabel timeLabel = new JLabel();
		/*
		 * if timeShown is 0 I set a wrong answer and close the window
		 */
		TimerTask progresTask = new TimerTask() {
			int timeShown = 20;
			public void run() {
				timeLabel.setText(timeShown + "");
				if(timeShown == 0) {
					if(question.getCorrectAnswer() == firstAnswer) {
						setAnswered(secondAnswer);
					}
					else {
						setAnswered(firstAnswer);
					}
					this.cancel();
					dispose();
					
				}
				timeShown--;
				
			}
		};
	
		Timer progresTimer = new Timer();
		progresTimer.schedule(progresTask, 1000, 1000);
		
		
		
		answer1 = new JButton(question.getOptions()[firstAnswer]);
		answer2 = new JButton(question.getOptions()[secondAnswer]);
		answer3 = new JButton(question.getOptions()[thirdAnswer]);
		
		answer1.setOpaque(true);
		answer2.setOpaque(true);
		answer3.setOpaque(true);
		
		answer1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(question.getCorrectAnswer() == firstAnswer) {
					answer1.setBackground(Color.GREEN);
					answer1.setBorderPainted(true);
				}
				else {
					answer1.setBackground(Color.RED);
					answer1.setBorderPainted(true);
				}
				showCorrectAnswer();
				disableBtns();
				progresTimer.cancel();
				closingTimer.schedule(closingTask, 2000);
				setAnswered(firstAnswer);
				
				
			}
		});
		
	
		
		answer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(question.getCorrectAnswer() == secondAnswer) {
					answer2.setBackground(Color.GREEN);
					answer2.setBorderPainted(false);
				}
				else {
					answer2.setBackground(Color.RED);
					answer2.setBorderPainted(false);
				}
				showCorrectAnswer();
				disableBtns();
				progresTimer.cancel();
				closingTimer.schedule(closingTask, 2000);
				setAnswered(secondAnswer);
			}

			
		});
		
		
		answer3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(question.getCorrectAnswer() == thirdAnswer) {
					answer3.setBackground(Color.GREEN);
					answer3.setBorderPainted(true);
				}
				else {
					answer3.setBackground(Color.RED);
					answer3.setBorderPainted(true);
				}
				showCorrectAnswer();
				disableBtns();
				progresTimer.cancel();
				closingTimer.schedule(closingTask, 2000);
				setAnswered(thirdAnswer);
			}
		});
		
	
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(answer3, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addComponent(answer2, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addComponent(answer1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addComponent(questionText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(timeLabel, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(questionText, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(answer1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(answer2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(answer3, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void draw() {}
	
	public void setAnswered(Integer answer) {
		this.question.setAnswer(answer);
		controller.answered(question);
	}
	
	public void showCorrectAnswer() {
		
		switch (question.getCorrectAnswer()) {
		case 0: this.answer1.setBackground(Color.GREEN);
				break;
		case 1:answer2.setBackground(Color.GREEN);
				break;
		case 2: answer3.setBackground(Color.GREEN);
				break;
		}
	}
	
	public void disableBtns() {
		answer1.setEnabled(false);
		answer2.setEnabled(false);
		answer3.setEnabled(false);
	}

}
