package mindrace.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Agustin Lavarello
 *
 */
public class GameNotFoundGraphics extends JFrame {

	private JPanel contentPane;
	private JLabel label;

	public GameNotFoundGraphics() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 450, 200);
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
		closingTimer.schedule(closingTask, 1300);
		
		label = new JLabel("No hay partida para recuperar");
		label.setFont(new Font("Tekton Pro", Font.PLAIN, 26));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addComponent(label)
					.addContainerGap(83, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(102)
					.addComponent(label)
					.addContainerGap(123, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
