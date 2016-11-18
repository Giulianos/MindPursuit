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

/**
 * This class is a popUp that shows the winners name
 * 
 * @author Agustin Lavallero
 *
 */
public class WinningGameGraphics extends JFrame {

	private JPanel contentPane;
/*
 * The constructor use the WinningGameGUI to print the name of the winner
 * 
 * @param winningGame 
 */
	public WinningGameGraphics(WinningGameGUI winningGame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Gano el Jugador:");
		label.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNameOfTheWinner = new JLabel("");
		lblNameOfTheWinner.setText(winningGame.getWinner().getName());
		lblNameOfTheWinner.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(140)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(176)
							.addComponent(lblNameOfTheWinner)))
					.addContainerGap(160, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(label)
					.addGap(42)
					.addComponent(lblNameOfTheWinner)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
