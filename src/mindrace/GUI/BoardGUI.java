package mindrace.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.border.LineBorder;

import mindrace.model.states.ThrowingDice;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

/**
 * @author Agustin Lavarello
 *
 */
public class BoardGUI {

	private JFrame frame;
	private JTextField playerName;
	private ThrowingDice dice;
	private boolean isBtnDicepressed;
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardGUI window = new BoardGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BoardGUI(//ThrowingDice dice, tendria que recibir la situation en vez de throwing dice
			) {
		//this.dice = dice;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setResizable(false);
		
		JButton btnDice = new JButton("Roll the dice!!");
		btnDice.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(!isBtnDicepressed) {
					btnDice.setText("");
					Image dice = null;
					//es de prueba
					Random randomNumber = new Random();
					Integer diceNumber = (int) (randomNumber.nextDouble()*6 + 1); //dice.diceNumber();
					switch (diceNumber) {
					case 1: dice = new ImageIcon(this.getClass().getResource("/dice1.png")).getImage(); 
							break;
					case 2: dice = new ImageIcon(this.getClass().getResource("/dice2.png")).getImage(); 
							break;
					case 3: dice = new ImageIcon(this.getClass().getResource("/dice3.png")).getImage(); 
							break;
					case 4: dice = new ImageIcon(this.getClass().getResource("/dice4.png")).getImage(); 
							break;
					case 5: dice = new ImageIcon(this.getClass().getResource("/dice5.png")).getImage(); 
							break;
					case 6:	dice = new ImageIcon(this.getClass().getResource("/dice6.png")).getImage(); 
							break;
				}
					btnDice.setIcon(new ImageIcon(dice));
					isBtnDicepressed = true;
					
			}
		}
		});
		
		playerName = new JTextField();
		playerName.setHorizontalAlignment(SwingConstants.CENTER);
		playerName.setEditable(false);
		playerName.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		playerName.setText("PlayerName");
		playerName.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		//codigo para escribir que categorias tiene 
		JLabel label_2 = new JLabel("Biologia");
		
		JLabel label = new JLabel("No tiene");
		
		JLabel label_1 = new JLabel("No tiene");
		
		JLabel label_3 = new JLabel("No tiene");
		
		JLabel label_5 = new JLabel("No tiene");
		
		JLabel label_4 = new JLabel("No tiene");
		
		JLayeredPane layeredPane = new JLayeredPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 566, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnDice, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(playerName, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(label_5, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
									.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
									.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(label, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
									.addComponent(label_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnDice, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(playerName, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		
		JLabel board = new JLabel();
		board.setIcon(new ImageIcon("C:\\Users\\Agu\\ITBA\\Workspace\\TPPOO\\resources\\board.jpg"));
		board.setBounds(0, 0, 410, 393);
		layeredPane.add(board, 0);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnOptions = new JMenu("opciones");
		menuBar.add(mnOptions);
		
		JButton btnSave = new JButton("guardar");
		mnOptions.add(btnSave);
		
		JButton btnExit = new JButton("salir");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExitWindowGUI exitMenu = new ExitWindowGUI();
				exitMenu.getFrame().setVisible(true);
			}
		});
		mnOptions.add(btnExit);
		
	}
	
	public void setBtnDicepressed(boolean isBtnDicepressed) {
		this.isBtnDicepressed = isBtnDicepressed;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
