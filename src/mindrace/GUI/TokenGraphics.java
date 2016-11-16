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
 * @author Agustin Lavarello
 *
 */
public class TokenGraphics extends JFrame {

	private JPanel contentPane;
	private Controller controller;

	public TokenGraphics(Category winningCategory, Controller controller) {
		this.controller=controller;
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblMessage = new JLabel("Felicitaciones Ganaste una Categoria");
		lblMessage.setFont(new Font("Tekton Pro", Font.PLAIN, 23));
		
		JLabel Category = new JLabel(winningCategory.toString());
		Category.setHorizontalAlignment(SwingConstants.CENTER);
		Category.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		
		JButton btnAcceptar = new JButton("Acceptar");
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
							.addGap(37)
							.addComponent(lblMessage))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(81)
							.addComponent(Category, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(163)
							.addComponent(btnAcceptar)))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(lblMessage)
					.addGap(39)
					.addComponent(Category, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addComponent(btnAcceptar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
