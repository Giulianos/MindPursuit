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
import java.util.Iterator;
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
	private Iterator<PlayerGUI> it;
	private JLabel lblName;
	private JButton btnCategoria1;
	private JButton btnCategoria2;
	private JButton btnCategoria3;
	private JButton btnCategoria4;
	private JButton btnCategoria5;
	private PlayerGUI playerToSteal;
	private JButton btnCategoria6;
	private Category category1 = Category.Art;
	private Category category2 = Category.Entertainment;
	private Category category3 = Category.Geography;
	private Category category4 = Category.History;
	private Category category5 = Category.Science;
	private Category category6 = Category.Sport;
	

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
		this.it = setPlayers.iterator();
		this.playerToSteal= it.next();
		frame = new JFrame();
		frame.setBounds(150, 190, 450, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
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
				if(it.hasNext()) {
					playerToSteal=it.next();
				}
				else {
					it =setPlayers.iterator();
					playerToSteal = it.next();
				}
				
				changePlayer(playerToSteal);
				
			}
		});
		btnChangePlayer.setBounds(10, 11, 148, 42);
		layeredPane.add(btnChangePlayer);
		
		lblName = new JLabel();
		lblName.setBounds(20, 71, 46, 14);
		layeredPane.add(lblName);
		
		btnCategoria1 = new JButton(Translator.translate(category1).toString());
		btnCategoria1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closingTimer.schedule(closingTask, 1000);
				stealingTokensGUI.setStolenPlayer(playerToSteal);
				stealingTokensGUI.setStolenToken(category1);
				controller.tokenStolen(stealingTokensGUI);
				
				
			}
		});
		btnCategoria1.setBounds(10, 108, 89, 23);
		layeredPane.add(btnCategoria1);
		
		btnCategoria2 = new JButton(Translator.translate(category2).toString());
		btnCategoria2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closingTimer.schedule(closingTask, 1000);
				stealingTokensGUI.setStolenPlayer(playerToSteal);
				stealingTokensGUI.setStolenToken(category2);
				controller.tokenStolen(stealingTokensGUI);
			
			}
		});
		btnCategoria2.setBounds(10, 170, 101, 23);
		layeredPane.add(btnCategoria2);
		
		btnCategoria3 = new JButton(Translator.translate(category3).toString());
		btnCategoria3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closingTimer.schedule(closingTask, 1000);
				stealingTokensGUI.setStolenPlayer(playerToSteal);
				stealingTokensGUI.setStolenToken(category3);
				controller.tokenStolen(stealingTokensGUI);
				
			}
		});
		btnCategoria3.setBounds(176, 108, 89, 23);
		layeredPane.add(btnCategoria3);
		
		btnCategoria5 = new JButton(Translator.translate(category5).toString());
		btnCategoria5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closingTimer.schedule(closingTask, 1000);
				stealingTokensGUI.setStolenPlayer(playerToSteal);
				stealingTokensGUI.setStolenToken(category5);
				controller.tokenStolen(stealingTokensGUI);
				
			}
		});
		btnCategoria5.setBounds(335, 108, 89, 23);
		layeredPane.add(btnCategoria5);
		
		btnCategoria4 = new JButton(Translator.translate(category4).toString());
		btnCategoria4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closingTimer.schedule(closingTask, 1000);
				stealingTokensGUI.setStolenPlayer(playerToSteal);
				stealingTokensGUI.setStolenToken(category4);
				controller.tokenStolen(stealingTokensGUI);
				
			}
		});
		btnCategoria4.setBounds(176, 170, 89, 23);
		layeredPane.add(btnCategoria4);
		
		btnCategoria6 = new JButton(Translator.translate(category6).toString());
		btnCategoria6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closingTimer.schedule(closingTask, 1000);
				stealingTokensGUI.setStolenPlayer(playerToSteal);
				stealingTokensGUI.setStolenToken(category6);
				controller.tokenStolen(stealingTokensGUI);
				
			}
		});
		btnCategoria6.setBounds(335, 170, 89, 23);
		layeredPane.add(btnCategoria6);
		
		
		frame.getContentPane().setLayout(groupLayout);
		
		changePlayer(playerToSteal);
		
		
	}

	/**
	 * @param next
	 */
	public void changePlayer(PlayerGUI player) {
		lblName.setText(player.getName());
		
		btnCategoria1.setEnabled(true);
		btnCategoria2.setEnabled(true);
		btnCategoria3.setEnabled(true);
		btnCategoria4.setEnabled(true);
		btnCategoria5.setEnabled(true);
		btnCategoria6.setEnabled(true);
		
		if(!mapOfPlayers.get(player).contains(category1)){
			btnCategoria1.setEnabled(false);
		}
		if(!mapOfPlayers.get(player).contains(category2)){
			btnCategoria2.setEnabled(false);
		}
		if(!mapOfPlayers.get(player).contains(category3)){
			btnCategoria3.setEnabled(false);
		}
		if(!mapOfPlayers.get(player).contains(category4)){
			btnCategoria4.setEnabled(false);
		}
		if(!mapOfPlayers.get(player).contains(category5)){
			btnCategoria5.setEnabled(false);
		}
		if(!mapOfPlayers.get(player).contains(category6)){
			btnCategoria6.setEnabled(false);
		}
		frame.repaint();
	}
}
