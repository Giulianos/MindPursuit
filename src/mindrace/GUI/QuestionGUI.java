package mindrace.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
public class QuestionGUI extends JFrame {

	
	private Integer answered;
	private Question question;
	private int timeTaken;
	private final static int firstAnswer = 0;
	private final static int secondAnswer = 1;
	private final static int thirdAnswer = 2;
	private final static int fourthAnswer = 0;
	private JPanel contentPane;
	private JTextField questionText;
	JButton answer1;
	JButton answer2;
	JButton answer3;
	JButton answer4;

	

	
	public QuestionGUI(Question q) {
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 402);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.setResizable(false);
		
		question = q;
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
		
		
		
		answer1 = new JButton(question.getParameters()[firstAnswer]);
		answer2 = new JButton(question.getParameters()[secondAnswer]);
		answer3 = new JButton(question.getParameters()[thirdAnswer]);
		answer4 = new JButton(question.getParameters()[fourthAnswer]);
		
		answer1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionGUI.this.setAnswered(firstAnswer);
				if(question.getCorrectAnswer().equals(firstAnswer)) {
					answer1.setBackground(Color.GREEN);
				}
				else {
					answer1.setBackground(Color.RED);
				}
				showCorrectAnswer();
				disableBtns();
				closingTimer.schedule(closingTask, 2000);
				
				
			}
		});
		
	
		
		answer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionGUI.this.setAnswered(secondAnswer);
				if(question.getCorrectAnswer().equals(secondAnswer)) {
					answer2.setBackground(Color.GREEN);
				}
				else {
					answer2.setBackground(Color.RED);
				}
				showCorrectAnswer();
				disableBtns();
				closingTimer.schedule(closingTask, 2000);
			}

			
		});
		
		
		answer3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionGUI.this.setAnswered(thirdAnswer);
				if(question.getCorrectAnswer().equals(thirdAnswer)) {
					answer3.setBackground(Color.GREEN);
				}
				else {
					answer3.setBackground(Color.RED);
				}
				showCorrectAnswer();
				disableBtns();
				closingTimer.schedule(closingTask, 2000);
			}
		});
		
	
		answer4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswered(fourthAnswer);
				if(question.getCorrectAnswer().equals(fourthAnswer)) {
					answer4.setBackground(Color.GREEN);
				}
				else {
					answer4.setBackground(Color.RED);
				}
				showCorrectAnswer();
				disableBtns();
				closingTimer.schedule(closingTask, 2000);
			}

		
		});
		
	
	
		JLabel timeLabel = new JLabel();
		
		TimerTask progresTask = new TimerTask() {
			int timeShown = 20;
			public void run() {
				timeLabel.setText(timeShown + "");
				timeShown--;
			}
		};
	
		Timer progresTimer = new Timer();
		progresTimer.schedule(progresTask, 1000, 1000);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(questionText, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(answer4, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(answer3, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(answer2, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(answer1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(timeLabel, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(questionText, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(answer1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(answer2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(answer3, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(answer4, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void draw() {}
	
	public void setAnswered(Integer answered) {
		this.answered = answered;
	}
	
	public Integer getAnswered() {
		return answered;
	}
	public void showCorrectAnswer() {
		
		switch (question.getCorrectAnswer()) {
		case 0: this.answer1.setBackground(Color.GREEN);
				break;
		case 1:answer2.setBackground(Color.GREEN);
				break;
		case 2: answer3.setBackground(Color.GREEN);
				break;
		case 3: answer4.setBackground(Color.GREEN);
				break;
		}
	}
	
	public void disableBtns() {
		answer1.setEnabled(false);
		answer2.setEnabled(false);
		answer3.setEnabled(false);
		answer4.setEnabled(false);
	}

}
