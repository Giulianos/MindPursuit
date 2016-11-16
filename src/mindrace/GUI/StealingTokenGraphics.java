package mindrace.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;

import mindrace.controller.Controller;
import mindrace.model.Category;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

/**
 * @author Agustin Lavarello
 *
 */
public class StealingTokenGraphics {

	private JFrame frame;
	private Controller controller;
	private StealingTokenGUI stealingTokensGUI;
	private Map<PlayerGUI,Set<Category>> mapOfPlayers;
	private Set<PlayerGUI> setPlayers;
	private JLabel lblName;
	private JButton btnCategoria1;
	private JButton btnCategoria2;
	private JButton btnCategoria3;
	private JButton btnCategoria4;
	private JButton btnCategoria5;
	private JButton btnCategoria6;
	private Category categoria1 = Category.Art;
	private Category categoria2 = Category.Entertainment;
	private Category categoria3 = Category.Geography;
	private Category categoria4 = Category.History;
	private Category categoria5 = Category.Science;
	private Category categoria6 = Category.Sport;
	

	/**
	 * 
	 * 
	 * Faltan las llamadas a controller con lo que gano el jugador
	 */
	public StealingTokenGraphics(Controller controller, StealingTokenGUI stealingToken) {
		this.controller = controller;
		this.stealingTokensGUI = stealingToken;
		this.mapOfPlayers = stealingToken.getPlayersWithTokensToSteal();
		this.setPlayers = mapOfPlayers.keySet();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Timer closingTimer = new Timer();
		TimerTask closingTask = new TimerTask() {

			@Override
			public void run() {
				frame.dispose();
				
			}
			
		};
		
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
		btnChangePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePlayer(setPlayers.iterator().next());
				
			}
		});
		btnChangePlayer.setBounds(10, 11, 148, 42);
		layeredPane.add(btnChangePlayer);
		
		lblName = new JLabel();
		lblName.setBounds(20, 71, 46, 14);
		layeredPane.add(lblName);
		
		btnCategoria1 = new JButton(categoria1.toString());
		btnCategoria1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				closingTimer.schedule(closingTask, 1000);
			}
		});
		btnCategoria1.setBounds(10, 108, 89, 23);
		layeredPane.add(btnCategoria1);
		
		btnCategoria2 = new JButton(categoria2.toString());
		btnCategoria2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				closingTimer.schedule(closingTask, 1000);
			}
		});
		btnCategoria2.setBounds(10, 170, 101, 23);
		layeredPane.add(btnCategoria2);
		
		btnCategoria3 = new JButton(categoria3.toString());
		btnCategoria3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				closingTimer.schedule(closingTask, 1000);
			}
		});
		btnCategoria3.setBounds(176, 108, 89, 23);
		layeredPane.add(btnCategoria3);
		
		btnCategoria5 = new JButton(categoria5.toString());
		btnCategoria5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				closingTimer.schedule(closingTask, 1000);
			}
		});
		btnCategoria5.setBounds(335, 108, 89, 23);
		layeredPane.add(btnCategoria5);
		
		btnCategoria4 = new JButton(categoria4.toString());
		btnCategoria4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				closingTimer.schedule(closingTask, 1000);
			}
		});
		btnCategoria4.setBounds(176, 170, 89, 23);
		layeredPane.add(btnCategoria4);
		
		btnCategoria6 = new JButton(categoria6.toString());
		btnCategoria6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				closingTimer.schedule(closingTask, 1000);
			}
		});
		btnCategoria6.setBounds(335, 170, 89, 23);
		layeredPane.add(btnCategoria6);
		frame.getContentPane().setLayout(groupLayout);
		
		changePlayer(setPlayers.iterator().next());
	}

	/**
	 * @param next
	 */
	public void changePlayer(PlayerGUI player) {
		//metodos de playerGUI
		lblName.setText(player.getName());
		
		
		
		if(!mapOfPlayers.get(player).contains(categoria1)){
			btnCategoria1.setEnabled(false);
		}
		if(!mapOfPlayers.get(player).contains(categoria2)){
			btnCategoria2.setEnabled(false);
		}
		if(!mapOfPlayers.get(player).contains(categoria3)){
			btnCategoria3.setEnabled(false);
		}
		if(!mapOfPlayers.get(player).contains(categoria4)){
			btnCategoria4.setEnabled(false);
		}
		if(!mapOfPlayers.get(player).contains(categoria5)){
			btnCategoria5.setEnabled(false);
		}
		if(!mapOfPlayers.get(player).contains(categoria6)){
			btnCategoria6.setEnabled(false);
		}
		frame.repaint();
	}
		
}
