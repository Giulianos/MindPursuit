package mindrace.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import mindrace.controller.Controller;
import mindrace.model.Category;

/**
 * This class displays the winning token. It is call when a player win a token by answering 
 * correctly a question.
 * 
 * @author Agustin Lavarello
 *
 */
public class TokenGraphics extends JFrame {

	private JPanel contentPane;
	private Controller controller;

	public TokenGraphics(Category winningCategory, Controller controller) {
		this.controller=controller;
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(170, 195, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblMessage = new JLabel("Felicitaciones Ganaste una Categoria:");
		lblMessage.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		
		JLabel Category = new JLabel(Translator.translate(winningCategory).toString());
		Category.setHorizontalAlignment(SwingConstants.CENTER);
		Category.setFont(new Font("Tekton Pro", Font.PLAIN, 24));
		
		JButton btnAcceptar = new JButton("Aceptar");
		btnAcceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.move();
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addComponent(lblMessage, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(102)
							.addComponent(Category, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(195)
							.addComponent(btnAcceptar)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(lblMessage)
					.addGap(39)
					.addComponent(Category, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addComponent(btnAcceptar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
