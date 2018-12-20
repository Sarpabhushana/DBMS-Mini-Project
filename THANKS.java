package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class THANKS {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					THANKS window = new THANKS("Sanjay","Ballal");
					window.frame.setUndecorated(true);
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
	String res,cust;
	public THANKS(String cust,String res) {
		this.cust=cust;
		this.res=res;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 30));
		frame.setBounds(100, 100, 606, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THANK YOU");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(10, 11, 242, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblYourOrderIs = new JLabel("YOUR ORDER IS ON THE WAY, WILL BE DELIVERED SHORTLY.");
		lblYourOrderIs.setFont(new Font("Perpetua Titling MT", Font.BOLD | Font.ITALIC, 14));
		lblYourOrderIs.setForeground(new Color(255, 215, 0));
		lblYourOrderIs.setBounds(34, 71, 495, 13);
		frame.getContentPane().add(lblYourOrderIs);
		
		JLabel lblNewLabel_1 = new JLabel("THANKS FOR ORDERING DELICIOUS, HOT FOOD FROM US.");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Perpetua Titling MT", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(45, 113, 473, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("HOPE TO SEE YOU AGAIN.");
		lblNewLabel_2.setFont(new Font("Perpetua Titling MT", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setForeground(new Color(255, 215, 0));
		lblNewLabel_2.setBounds(171, 153, 358, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TO ORDER AGAIN, CLICK HERE !!!");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				w2 w2again = new w2(cust);
				w2again.frame.setUndecorated(true);
				w2again.frame.setVisible(true);
				
			}
		});
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setFont(new Font("Malgun Gothic Semilight", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(146, 198, 326, 44);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 18));
		btnExit.setBounds(233, 264, 85, 23);
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_4 = new JLabel("X");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_4.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setBounds(566, 15, 24, 30);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("-");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel_5.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setBounds(538, 15, 24, 30);
		frame.getContentPane().add(lblNewLabel_5);
	}

}
