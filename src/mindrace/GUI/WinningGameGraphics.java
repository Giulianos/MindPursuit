package mindrace.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.layout.Border;

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
		frame.setLayout(new BorderLayout());
		
		JLabel label = new JLabel("Gano el Jugador:");
		label.setFont(new Font("Tekton Pro", Font.PLAIN, 70));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblNameOfTheWinner = new JLabel("");
		lblNameOfTheWinner.setFont(new Font("Tekton Pro", Font.PLAIN, 70));
		lblNameOfTheWinner.setText(winningGame.getWinner().getName());
		lblNameOfTheWinner.setHorizontalAlignment(SwingConstants.CENTER);

		
		JButton btnFinish = new JButton("Terminar");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		
		frame.add(label, BorderLayout.NORTH);
		frame.add(lblNameOfTheWinner,BorderLayout.CENTER);
		frame.add(btnFinish, BorderLayout.SOUTH);
	}
}
