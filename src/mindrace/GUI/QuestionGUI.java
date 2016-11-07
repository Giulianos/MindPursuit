package mindrace.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

/**
 * @author Agu
 *
 */
public class QuestionGUI extends JFrame {

	private JPanel contentPane;
	private JTextField question;
	private Integer answered;
	private Timer timer;

	public void setAnswered(Integer answered) {
		this.answered = answered;
	}
	
	public Integer getAnswered() {
		return answered;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionGUI frame = new QuestionGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//recibe una question
	public QuestionGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		question = new JTextField("hola");
		question.setColumns(10);
		question.setEditable(false);
		Timer closingTimer = new Timer();
		TimerTask closingTask = new TimerTask() {

			@Override
			public void run() {
				dispose();
				
			}
			
		};
		//No anda la prgres bar
		JProgressBar timeBar = new JProgressBar(0,20);
		timeBar.setStringPainted(true);
		TimerTask progresTask = new TimerTask() {
			public void run() {
				timeBar.setValue(timeBar.getValue() + 1);
				timeBar.setString(((Integer)timeBar.getValue()).toString());
			}
		};
		Timer progresTimer = new Timer();
		progresTimer.schedule(progresTask, 1000);
		progresTimer.schedule(progresTask, 1000);	
				
		
		JButton answer1 = new JButton("1");
		answer1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionGUI.this.setAnswered(1);
				//el if para ver si es o no 
				closingTimer.schedule(closingTask, 2000);
				
				
			}
		});
		
		JButton answer2 = new JButton("2");
		answer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionGUI.this.setAnswered(2);
				answer2.setBackground(Color.green);
				closingTimer.schedule(closingTask, 2000);
			}
		});
		
		JButton answer3 = new JButton("3");
		answer3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionGUI.this.setAnswered(3);
				closingTimer.schedule(closingTask, 2000);
			}
		});
		
		JButton answer4 = new JButton("4");
		answer4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionGUI.this.setAnswered(4);
				closingTimer.schedule(closingTask, 2000);
			}
		});

		JProgressBar TimeBar = new JProgressBar();
		TimeBar.setStringPainted(true);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(question, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(answer4, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(answer3, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(answer2, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(answer1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(TimeBar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(TimeBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(question, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
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
}
