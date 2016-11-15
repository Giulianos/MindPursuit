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
 * @author Agustin Lavarello
 *
 */
public class MenuGraphics {

	private JFrame frame;
	JButton startBotton;
	JButton saveBotton;
	JButton exitBotton;
	private Controller controller;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGraphics window = new MenuGraphics();
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
	public MenuGraphics() {

		frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 545, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		saveBotton = new JButton("Recuperar partida");
		startBotton = new JButton("Empezar");
		exitBotton = new JButton("Salir");
		
		startBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.initialize();
				frame.dispose();
				
			}
		});
		
		
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
