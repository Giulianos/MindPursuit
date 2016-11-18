package mindrace.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
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
public class GameNotFoundGraphics {

	private JFrame frame;
	private JLabel label;

	public GameNotFoundGraphics() {
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 200);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		label = new JLabel("No se guardo ningun juego");
		label.setFont(new Font("Tekton Pro", Font.PLAIN, 27));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addComponent(label)
					.addContainerGap(78, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(68, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(66))
		);
		frame.getContentPane().setLayout(groupLayout);
		Timer closingTimer = new Timer();
		TimerTask closingTask = new TimerTask() {

			@Override
			public void run() {
				frame.dispose();
				
			}
			
		}; 
		closingTimer.schedule(closingTask, 3000);
		
	}
}
