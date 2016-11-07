package mindrace.GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * @author Agu
 *
 */
public class MenuGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGUI window = new MenuGUI();
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
	public MenuGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 545, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton saveBotton = new JButton("Recuperar partida");
		
		JButton startBotton = new JButton("Empezar");
		startBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoardGUI boardGUI = new BoardGUI();// hay que pasarle el dado y todo
				boardGUI.getFrame().setVisible(true);
				frame.dispose();
				//empieza el juego
				
			}
		});
		
		JButton exitBotton = new JButton("Salir");
		exitBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JLabel menuTitle = new JLabel("Carrera de mentes");
		menuTitle.setFont(new Font("Traditional Arabic", Font.BOLD, 29));
		menuTitle.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(90)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(menuTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(exitBotton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
						.addComponent(startBotton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
						.addComponent(saveBotton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
					.addContainerGap(99, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(menuTitle, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(startBotton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(saveBotton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(exitBotton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
