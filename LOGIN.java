package database;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LOGIN {
	
	public JFrame frame;
	private JTextField userfield;
	private JPasswordField passwordField;
	class lbtn implements ActionListener
	{
		ResultSet rs;
				public void actionPerformed(ActionEvent arg0) {
					String url = "jdbc:mysql://localhost:3306/food_order";
					String uname= "root";
					String pass = "";
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection(url, uname, pass);
						Statement st=con.createStatement();
						rs=st.executeQuery("SELECT * from customer where NAME ='"+userfield.getText()+"' AND PWD = '"+passwordField.getText()+"'");
						rs.next();
					}catch(Exception e) {
							System.out.println(e.getMessage());
					}
					
						
				try {		
					if(userfield.getText().isEmpty() || passwordField.getText().isEmpty()) 
						JOptionPane.showMessageDialog(null, "Please Enter UserName and PassWord Correctly.");
		
					else if (userfield.getText().equals(rs.getString(3)) && passwordField.getText().equals(rs.getString(2))) {
						w2 window1 = new w2(userfield.getText());
						window1.frame.setUndecorated(true);
						window1.frame.setVisible(true);
						
						frame.setVisible(false);
					}
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid UserName or Password");
				}
				}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN window = new LOGIN();
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
	public LOGIN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 605, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("LOGIN");
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 30));
		label.setBounds(0, 0, 140, 54);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("LOGIN NOW WITH YOUR REGISTERED ACCOUNT AND GET FOOD DELIVERED");
		label_1.setForeground(Color.ORANGE);
		label_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 12));
		label_1.setBounds(58, 69, 501, 20);
		frame.getContentPane().add(label_1);
		
		JLabel lblToYourDoorstep = new JLabel("TO YOUR DOORSTEP FROM YOUR FAVOURITE RESTAURANT.");
		lblToYourDoorstep.setForeground(Color.ORANGE);
		lblToYourDoorstep.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 12));
		lblToYourDoorstep.setBounds(108, 100, 382, 14);
		frame.getContentPane().add(lblToYourDoorstep);
		
		JLabel USER = new JLabel(" USERNAME : ");
		USER.setForeground(new Color(124, 252, 0));
		USER.setFont(new Font("Perpetua Titling MT", Font.BOLD | Font.ITALIC, 15));
		USER.setBounds(89, 125, 113, 40);
		frame.getContentPane().add(USER);
		
		userfield = new JTextField();
		userfield.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		userfield.setColumns(10);
		userfield.setBounds(229, 133, 200, 20);
		frame.getContentPane().add(userfield);
		
		JLabel Pwd = new JLabel("PASSWORD :");
		Pwd.setForeground(new Color(124, 252, 0));
		Pwd.setFont(new Font("Perpetua Titling MT", Font.BOLD | Font.ITALIC, 15));
		Pwd.setBounds(93, 163, 123, 37);
		frame.getContentPane().add(Pwd);
		
		JLabel label_5 = new JLabel("CAN'T LOGIN ? CREATE NEW ACCOUNT");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			REGISTER rg = new REGISTER();
			frame.setVisible(false);
			rg.frame.setUndecorated(true);
			rg.frame.setVisible(true);
			}
		});
		label_5.setForeground(new Color(255, 0, 0));
		label_5.setFont(new Font("Malgun Gothic Semilight", Font.BOLD | Font.ITALIC, 14));
		label_5.setBounds(175, 280, 297, 20);
		frame.getContentPane().add(label_5);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new lbtn());{
			
		}
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 17));
		btnLogin.setBounds(283, 230, 94, 23);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(229, 171, 200, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel jminimize = new JLabel("-");
		jminimize.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		jminimize.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 35));
		jminimize.setForeground(Color.RED);
		jminimize.setBounds(539, 11, 20, 29);
		frame.getContentPane().add(jminimize);
		
		JLabel jclose = new JLabel("X");
		jclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				welcomepage wcp = new welcomepage();
				frame.setVisible(false);
				wcp.frame.setUndecorated(true);
				wcp.frame.setVisible(true);
			}
		});
		jclose.setForeground(Color.RED);
		jclose.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 30));
		jclose.setBounds(563, 11, 26, 29);
		frame.getContentPane().add(jclose);
	}

}
