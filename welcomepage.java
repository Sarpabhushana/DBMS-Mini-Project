package database;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class welcomepage {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcomepage wind = new welcomepage();
					wind.frame.setUndecorated(true);
					wind.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public welcomepage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 508, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOnlineFoodOrdering = new JLabel("ONLINE FOOD ORDERING SYSTEM");
		lblOnlineFoodOrdering.setForeground(new Color(255, 255, 0));
		lblOnlineFoodOrdering.setBackground(new Color(240, 240, 240));
		lblOnlineFoodOrdering.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 20));
		lblOnlineFoodOrdering.setBounds(0, 0, 352, 38);
		frame.getContentPane().add(lblOnlineFoodOrdering);
		
		JLabel lblFoodAtYour = new JLabel("FOOD AT YOUR DOOR STEP IN NO TIME!!");
		lblFoodAtYour.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 17));
		lblFoodAtYour.setForeground(Color.WHITE);
		lblFoodAtYour.setBounds(34, 49, 379, 22);
		frame.getContentPane().add(lblFoodAtYour);
		
		JLabel lblCreate = new JLabel(" CREATE NEW ACCOUNT NOW!");
		lblCreate.setForeground(new Color(255, 218, 185));
		lblCreate.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 10));
		lblCreate.setBounds(18, 202, 181, 16);
		frame.getContentPane().add(lblCreate);
		
		JLabel lblLoginAndStart = new JLabel("LOGIN AND START ORDERING!!");
		lblLoginAndStart.setForeground(new Color(255, 228, 196));
		lblLoginAndStart.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 10));
		lblLoginAndStart.setBounds(275, 202, 181, 16);
		frame.getContentPane().add(lblLoginAndStart);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				REGISTER rgwindow = new REGISTER();
				frame.setVisible(false);
				rgwindow.frame.setUndecorated(true);
				rgwindow.frame.setVisible(true);
			}
		});
		btnRegister.setBackground(new Color(253, 245, 230));
		btnRegister.setForeground(new Color(0, 0, 0));
		btnRegister.setFont(new Font("Wide Latin", Font.PLAIN, 13));
		btnRegister.setBounds(28, 240, 171, 22);
		frame.getContentPane().add(btnRegister);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LOGIN lg = new LOGIN();
				frame.setVisible(false);
				lg.frame.setUndecorated(true);
				lg.frame.setVisible(true);
			}
		});
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBackground(new Color(255, 255, 204));
		btnLogin.setFont(new Font("Wide Latin", Font.PLAIN, 13));
		btnLogin.setBounds(296, 240, 160, 22);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblEargt = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/img.png")).getImage();
		lblEargt.setIcon(new ImageIcon(img));
		lblEargt.setForeground(new Color(233, 150, 122));
		lblEargt.setBackground(Color.WHITE);
		lblEargt.setBounds(174, 76, 128, 129);
		frame.getContentPane().add(lblEargt);
		
		JLabel lblNewLabel = new JLabel("-");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(436, 10, 20, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblX.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 30));
		lblX.setForeground(Color.RED);
		lblX.setBounds(465, 6, 27, 22);
		frame.getContentPane().add(lblX);
	}
}