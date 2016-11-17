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
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.border.LineBorder;

import mindrace.controller.Controller;
import mindrace.model.Category;
import mindrace.model.Player;
import mindrace.model.Situation;
import mindrace.model.states.ThrowingDice;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.awt.event.ActionEvent;

/**
 * @author Agustin Lavarello
 *
 */
public class BoardGraphics {

	private JFrame frame;
	private JTextField playerName;
	private boolean isBtnDicepressed;
	private PlayerGraphics currentPlayer;
	private PlayerGUI currentPlayerGUI;
	private Object[] tokensOfPlayer;
	private JButton btnDice;
	private JLabel token_1;
	private JLabel token_2;
	private JLabel token_3;
	private JLabel token_4;
	private JLabel token_5;
	private JLabel token_6;
	private JLayeredPane layeredPane;
	private ImageIcon playerImg;
	private JLabel lblPlayerImg;
	private Controller controller;
	


	/**
	 * Launch the application.
	 * @param playersGraphics 
	 */

	public BoardGraphics(List<PlayerGraphics> playersGraphics, Controller controller, PlayerGUI currentPlayerGUI) {
		this.controller = controller;
		this.currentPlayerGUI = currentPlayerGUI;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setSize(1000,700);
		frame.setResizable(false);
		frame.setVisible(true);
		btnDice = new JButton("Tira el dado!!");
		btnDice.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				if(!isBtnDicepressed) {
					btnDice.setText("");
					ImageIcon diceImg = null;
					ThrowingDiceGUI dice = controller.throwDice();
					int diceNumber = dice.getDiceNumber();
					switch (diceNumber) {
					case 1: diceImg = new ImageIcon("dice1.png");
							break;
					case 2: diceImg = new ImageIcon("dice2.png"); 
							break;
					case 3: diceImg = new ImageIcon("dice3.png"); 
							break;
					case 4: diceImg = new ImageIcon("dice4.png");
							break;
					case 5: diceImg = new ImageIcon("dice5.png");
							break;
					case 6:	diceImg = new ImageIcon("dice6.png");
							break;
				}
					btnDice.setIcon(diceImg);
					btnDice.setBounds(new Rectangle(diceImg.getIconWidth(), diceImg.getIconHeight()));
					isBtnDicepressed = true;
					controller.move();
			}
		}
		});
		
		playerName = new JTextField();
		playerName.setHorizontalAlignment(SwingConstants.CENTER);
		playerName.setEditable(false);
		playerName.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		playerName.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		token_2 = new JLabel();
		token_3 = new JLabel();
		token_1 = new JLabel();
		token_4 = new JLabel();
		token_6 = new JLabel();
		token_5 = new JLabel();
	
		
		
     	
		layeredPane = new JLayeredPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 775, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(btnDice, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(token_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(token_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(token_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(token_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(6))
								.addComponent(token_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(playerName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(token_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(182, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(layeredPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnDice, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(playerName, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(token_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(token_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(token_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(token_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(token_5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(token_6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		ImageIcon boardImg = new ImageIcon("board.png");
		JLabel board = new JLabel();
		playerImg = new ImageIcon();
		lblPlayerImg = new JLabel();
		lblPlayerImg.setIcon(playerImg);
		lblPlayerImg.setBounds(0, 0, 70, 70);
		board.setIcon(boardImg);
		board.setBounds(0, 0, boardImg.getIconWidth(), boardImg.getIconHeight());
		layeredPane.add(board, 0, 0);
		layeredPane.add(lblPlayerImg, 1,0);
		
		if(playersGraphics.size() >= 1) {
			layeredPane.add(playersGraphics.get(0).getLabel(), 1, 0);
		}
		if(playersGraphics.size() >= 2) {
			layeredPane.add(playersGraphics.get(1).getLabel(), 1, 0);
		}
		if(playersGraphics.size() >= 3) {
			layeredPane.add(playersGraphics.get(2).getLabel(), 1, 0);
		}
		if(playersGraphics.size() >= 4) {
			layeredPane.add(playersGraphics.get(3).getLabel(), 1, 0);
		}
		if(playersGraphics.size() >= 5) {
			layeredPane.add(playersGraphics.get(4).getLabel(), 1, 0);
		}
		if(playersGraphics.size() >= 6) {
			layeredPane.add(playersGraphics.get(5).getLabel(), 1, 0);
		}
		
		this.currentPlayer = playersGraphics.get(0); 
		
		
		
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
				ExitWindowGraphics exitMenu = new ExitWindowGraphics();
				exitMenu.getFrame().setVisible(true);
			}
		});
		mnOptions.add(btnExit);
		
		
		
	}
	
	public void newTurn() {
		setBtnDicepressed(false);
		btnDice.setText("Tira el dado");
		btnDice.setIcon(null);
		draw();
		
	}
	
	public void setBtnDicepressed(boolean isBtnDicepressed) {
		this.isBtnDicepressed = isBtnDicepressed;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	
	public void setCurrentPlayer(PlayerGraphics player) {
		this.currentPlayer = player;
	}
	
	public void setCurrentPlayerGUI(PlayerGUI currentPlayerGUI) {
		this.currentPlayerGUI = currentPlayerGUI;
	}

	
	public void draw() {
		
		this.tokensOfPlayer =  currentPlayerGUI.getTokens().toArray();
		
		lblPlayerImg.setIcon(currentPlayer.getImg());
		
		playerName.setText(currentPlayerGUI.getName());
		
		this.tokensOfPlayer =  currentPlayerGUI.getTokens().toArray();
		
		playerName.setText(currentPlayerGUI.getName());
		
		cleanTokens();
		
		if(tokensOfPlayer.length >= 1){
			token_1.setText(tokensOfPlayer[0].toString());
		}
		if(tokensOfPlayer.length >= 2){
			token_2.setText(tokensOfPlayer[1].toString());
		}
		if(tokensOfPlayer.length >= 3){
			token_3.setText(tokensOfPlayer[2].toString());
		}
		if(tokensOfPlayer.length >= 4){
			token_4.setText(tokensOfPlayer[3].toString());
		}
		if(tokensOfPlayer.length >= 5){
			token_5.setText(tokensOfPlayer[4].toString());
		}
		if(tokensOfPlayer.length >= 6){
			token_6.setText(tokensOfPlayer[5].toString());
		}		
		frame.repaint();
		
	}

	/**
	 * 
	 */
	private void cleanTokens() {
		token_1.setText("");
		token_2.setText("");
		token_3.setText("");
		token_4.setText("");
		token_5.setText("");
		token_6.setText("");
	}
}
