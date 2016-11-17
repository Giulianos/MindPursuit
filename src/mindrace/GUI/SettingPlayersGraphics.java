package mindrace.GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import mindrace.model.Category;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

/**
 * @author Agu
 *
 */
public class SettingPlayersGraphics {

	private JFrame frame;
	private ImageIcon img;
	private JTextField nombreDelJugador;
	private View view;
	private boolean isColorChosen;
	private JButton btnColorChosen;
	private JLabel lblChosenColor;
	private static Set<String> names = new HashSet<String>();
	private static Set<String> colors = new HashSet<String>();
	
	public SettingPlayersGraphics(View view) {
		this.view = view;
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
		
		Timer closingTimer = new Timer();
		TimerTask closingTask = new TimerTask() {

			@Override
			public void run() {
				frame.dispose();
				
			}
			
		};
		
		nombreDelJugador = new JTextField();
		nombreDelJugador.setBounds(159, 27, 214, 31);
		frame.getContentPane().add(nombreDelJugador);
		nombreDelJugador.setColumns(10);
		
		lblChosenColor = new JLabel("");
		lblChosenColor.setOpaque(true);
		lblChosenColor.setBounds(383, 27, 51, 31);
		frame.getContentPane().add(lblChosenColor);
		
		JLabel lblNombreDelJugador = new JLabel("Nombre del Jugador");
		lblNombreDelJugador.setBounds(22, 21, 154, 42);
		frame.getContentPane().add(lblNombreDelJugador);
		
		JButton green = new JButton("Verde");
		green.setOpaque(true);
		green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				img = new ImageIcon("pieceGreen.png");
				isColorChosen = true;
				btnColorChosen = green;
				lblChosenColor.setBackground(new Color(102, 204, 102));
			}
		});
		green.setBounds(22, 113, 89, 23);
		green.setBackground(new Color(102, 204, 102));
		frame.getContentPane().add(green);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblColor.setBounds(22, 88, 46, 14);
		frame.getContentPane().add(lblColor);
		
		JButton black = new JButton("Negro");
		black.setOpaque(true);
		black.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				img = new ImageIcon("pieceBlack.png");
				isColorChosen = true;
				btnColorChosen = black;
				lblChosenColor.setBackground(new Color(0, 0, 0));
			}
		});
		black.setBackground(new Color(0, 0, 0));
		black.setBounds(169, 113, 89, 23);
		frame.getContentPane().add(black);
		
		JButton blue = new JButton("Azul");
		blue.setOpaque(true);
		blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				img = new ImageIcon("pieceBlue.png");
				isColorChosen = true;
				btnColorChosen = blue;
				lblChosenColor.setBackground(new Color(0, 0, 204));
			}
		});
		blue.setBackground(new Color(0, 0, 204));
		blue.setBounds(313, 113, 89, 23);
		frame.getContentPane().add(blue);
		
		JButton purple = new JButton("Violeta");
		purple.setOpaque(true);
		purple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				img = new ImageIcon("piecePurple.png");
				isColorChosen = true;
				btnColorChosen = purple;
				lblChosenColor.setBackground(new Color(102, 0, 102));
			}
		});
		purple.setBackground(new Color(102, 0, 102));
		purple.setBounds(22, 187, 89, 23);
		frame.getContentPane().add(purple);
		
		JButton red = new JButton("Rojo");
		red.setOpaque(true);
		red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				img = new ImageIcon("pieceRed.png");
				isColorChosen = true;
				btnColorChosen = red;
				lblChosenColor.setBackground(new Color(255, 0, 0));
			}
		});
		red.setBackground(new Color(255, 0, 0));
		red.setBounds(169, 187, 89, 23);
		frame.getContentPane().add(red);
		
		JButton yellow = new JButton("Amarillo");
		yellow.setOpaque(true);
		yellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				img = new ImageIcon("pieceYellow.png");
				isColorChosen = true;
				btnColorChosen = yellow;
				lblChosenColor.setBackground(new Color(255, 255, 0));
				
			}
		});
		yellow.setBackground(new Color(255, 255, 0));
		yellow.setBounds(313, 187, 89, 23);
		frame.getContentPane().add(yellow);
		
		JButton btnAcceptar = new JButton("Aceptar");
		btnAcceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isColorChosen && !names.contains(nombreDelJugador.getText()) && !colors.contains(btnColorChosen.getText())){	
				names.add(nombreDelJugador.getText());
				colors.add(btnColorChosen.getText());
				view.addPlayersGraphics(creatPlayersGraphics());
				try {
					view.enteringNames();
				} catch (IOException | ParserConfigurationException | SAXException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				closingTimer.schedule(closingTask, 1000);
				}
			}	
		});
		btnAcceptar.setBounds(345, 239, 89, 23);
		frame.getContentPane().add(btnAcceptar);
		
		
	}

	/**
	 * @return
	 */
	public PlayerGraphics creatPlayersGraphics() {
		return new PlayerGraphics(img, nombreDelJugador.getText());
	}
}
