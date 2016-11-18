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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

/**
 * This class is a popUp that shows the winners name
 * 
 * @author Agustin Lavallero
 *
 */
public class WinningGameGraphics{

	private JPanel contentPane;
	private JFrame frame;
/*
 * The constructor use the WinningGameGUI to print the name of the winner
 * 
 * @param winningGame 
 */
	public WinningGameGraphics(WinningGameGUI winningGame) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		
		JLabel label = new JLabel("Gano el Jugador:");
		label.setFont(new Font("Tekton Pro", Font.PLAIN, 25));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNameOfTheWinner = new JLabel("");
		lblNameOfTheWinner.setFont(new Font("Tekton Pro", Font.PLAIN, 26));
		lblNameOfTheWinner.setText(winningGame.getWinner().getName());
		lblNameOfTheWinner.setHorizontalAlignment(SwingConstants.CENTER);

		
		JButton btnFinish = new JButton("Terminar");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});
		lblNameOfTheWinner.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(142)
							.addComponent(btnFinish, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNameOfTheWinner, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(33, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(158, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(143))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addComponent(label)
					.addGap(18)
					.addComponent(lblNameOfTheWinner, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addGap(51)
					.addComponent(btnFinish, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
