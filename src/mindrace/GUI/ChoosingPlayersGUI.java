package mindrace.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.JComboBox;

/**
 * @author AgusTin Lavarello
 *
 */
public class ChoosingPlayersGUI {

	private JFrame frame;
	private int NumberOfPlayers;
	private JButton btn1 = new JButton("1");
	private JButton btn2 = new JButton("2");
	private JButton btn3 = new JButton("3");
	private JButton btn4 = new JButton("4");
	private JButton btn5 = new JButton("5");
	private JButton btn6 = new JButton("6");
	private Set<PlayerGUI> players = new HashSet<PlayerGUI>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoosingPlayersGUI window = new ChoosingPlayersGUI();
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
	public ChoosingPlayersGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setName("");
		frame.setResizable(false);
		frame.setBounds(100, 100, 350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNumeroDeJugadores = new JLabel("Numero de Jugadores");
		
		
		
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumberOfPlayers = 1;
				deactivateButtons();
				creatPlayers(1);
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumberOfPlayers = 2;
				deactivateButtons();
				creatPlayers(2);
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumberOfPlayers = 3;
				deactivateButtons();
				creatPlayers(3);
			}
		});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumberOfPlayers = 4;
				deactivateButtons();
				creatPlayers(4);
			}
		});
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumberOfPlayers = 5;
				deactivateButtons();
				creatPlayers(5);
			}
		});
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumberOfPlayers = 6;
				deactivateButtons();
				creatPlayers(6);
			}
		});
	
	
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn3, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btn6, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(93)
							.addComponent(lblNumeroDeJugadores, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(69, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNumeroDeJugadores, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn1)
						.addComponent(btn3)
						.addComponent(btn5))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn6)
						.addComponent(btn2)
						.addComponent(btn4))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	/**
	 * @param i
	 */
	protected void creatPlayers(int numDeJugadores) {
		
			SettingPlayersGUI setPlayer = new SettingPlayersGUI();

			
		
	}

	/**
	 * 
	 */
	public void deactivateButtons() {
		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		btn4.setEnabled(false);
		btn5.setEnabled(false);
		btn6.setEnabled(false);
	}
}
