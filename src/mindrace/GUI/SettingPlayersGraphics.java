package mindrace.GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Agu
 *
 */
public class SettingPlayersGraphics {

	private JFrame frame;
	private JTextField nombreDelJugador;

	
	public SettingPlayersGraphics(View view) {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		nombreDelJugador = new JTextField();
		nombreDelJugador.setBounds(159, 27, 214, 31);
		frame.getContentPane().add(nombreDelJugador);
		nombreDelJugador.setColumns(10);
		
		JLabel lblNombreDelJugador = new JLabel("Nombre del Jugador");
		lblNombreDelJugador.setBounds(22, 21, 154, 42);
		frame.getContentPane().add(lblNombreDelJugador);
		
		JButton green = new JButton("");
		green.setBounds(22, 113, 89, 23);
		green.setBackground(new Color(102, 204, 102));
		frame.getContentPane().add(green);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblColor.setBounds(22, 88, 46, 14);
		frame.getContentPane().add(lblColor);
		
		JButton black = new JButton("");
		black.setBackground(new Color(0, 0, 0));
		black.setBounds(169, 113, 89, 23);
		frame.getContentPane().add(black);
		
		JButton blue = new JButton("");
		blue.setBackground(new Color(0, 0, 204));
		blue.setBounds(313, 113, 89, 23);
		frame.getContentPane().add(blue);
		
		JButton purple = new JButton("");
		purple.setBackground(new Color(102, 0, 102));
		purple.setBounds(22, 187, 89, 23);
		frame.getContentPane().add(purple);
		
		JButton red = new JButton("");
		red.setBackground(new Color(255, 0, 0));
		red.setBounds(169, 187, 89, 23);
		frame.getContentPane().add(red);
		
		JButton yellow = new JButton("");
		yellow.setBackground(new Color(255, 255, 0));
		yellow.setBounds(313, 187, 89, 23);
		frame.getContentPane().add(yellow);
		
		JButton btnAcceptar = new JButton("Acceptar");
		btnAcceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.addPlayersGrapgics(playerGraphics);
				view.enteringNames();
			}
		});
		btnAcceptar.setBounds(345, 239, 89, 23);
		frame.getContentPane().add(btnAcceptar);
	}
}
