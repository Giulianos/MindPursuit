package mindrace.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * @author Agu
 *
 */
public class StealingTokenGraphics {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StealingTokenGraphics window = new StealingTokenGraphics();
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
	public StealingTokenGraphics() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(layeredPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
		);
		
		JButton btnChangePlayer = new JButton("Ver otro Jugador");
		btnChangePlayer.setBounds(10, 11, 148, 42);
		layeredPane.add(btnChangePlayer);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(20, 71, 46, 14);
		layeredPane.add(lblName);
		
		JButton btnNewButton = new JButton("Categoria1");
		btnNewButton.setBounds(10, 108, 89, 23);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Categoria2");
		btnNewButton_1.setBounds(10, 170, 89, 23);
		layeredPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Categoria3");
		btnNewButton_2.setBounds(176, 108, 89, 23);
		layeredPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Categoria5");
		btnNewButton_3.setBounds(335, 108, 89, 23);
		layeredPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("categoria4");
		btnNewButton_4.setBounds(176, 170, 89, 23);
		layeredPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Categoria6");
		btnNewButton_5.setBounds(335, 170, 89, 23);
		layeredPane.add(btnNewButton_5);
		frame.getContentPane().setLayout(groupLayout);
	}
}
