package database;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class REGISTER {

	public JFrame frame;
	private JTextField mail;
	private JTextField pwd;
	private JTextField name;
	private JTextField adr;
	private JTextField ph;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					REGISTER window = new REGISTER();
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
	public REGISTER() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTER");
		lblNewLabel.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(0, 0, 175, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel namelbl = new JLabel("NAME : ");
		namelbl.setFont(new Font("Perpetua Titling MT", Font.BOLD | Font.ITALIC, 15));
		namelbl.setForeground(new Color(173, 255, 47));
		namelbl.setBounds(100, 165, 75, 14);
		frame.getContentPane().add(namelbl);
		
		JLabel maillbl = new JLabel("EMAIL ID : ");
		maillbl.setFont(new Font("Perpetua Titling MT", Font.BOLD | Font.ITALIC, 15));
		maillbl.setForeground(new Color(173, 255, 47));
		maillbl.setBounds(78, 88, 87, 14);
		frame.getContentPane().add(maillbl);
		
		mail = new JTextField();
		mail.setBounds(190, 87, 175, 20);
		frame.getContentPane().add(mail);
		mail.setColumns(10);
		
		pwd = new JTextField();
		pwd.setBounds(190, 124, 175, 20);
		frame.getContentPane().add(pwd);
		pwd.setColumns(10);
		
		JLabel pwdlbl = new JLabel("PASSWORD : ");
		pwdlbl.setForeground(new Color(173, 255, 47));
		pwdlbl.setFont(new Font("Perpetua Titling MT", Font.BOLD | Font.ITALIC, 15));
		pwdlbl.setBounds(60, 127, 105, 14);
		frame.getContentPane().add(pwdlbl);
		
		name = new JTextField();
		name.setBounds(190, 162, 175, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel phlbl = new JLabel("PHONE : ");
		phlbl.setFont(new Font("Perpetua Titling MT", Font.BOLD | Font.ITALIC, 15));
		phlbl.setForeground(new Color(173, 255, 47));
		phlbl.setBounds(90, 241, 75, 14);
		frame.getContentPane().add(phlbl);
		
		adr = new JTextField();
		adr.setBounds(190, 203, 175, 20);
		frame.getContentPane().add(adr);
		adr.setColumns(10);
		
		JLabel addrlbl = new JLabel("  ADDRESS : ");
		addrlbl.setForeground(new Color(173, 255, 47));
		addrlbl.setFont(new Font("Perpetua Titling MT", Font.BOLD | Font.ITALIC, 15));
		addrlbl.setBounds(60, 206, 105, 14);
		frame.getContentPane().add(addrlbl);
		
		ph = new JTextField();
		ph.setBounds(190, 238, 175, 20);
		frame.getContentPane().add(ph);
		ph.setColumns(10);
		
		JButton btnNewButton = new JButton("CANCEL");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LOGIN lo=new LOGIN();
				frame.setVisible(false);
				lo.frame.setUndecorated(true);
				lo.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		btnNewButton.setBounds(422, 200, 104, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url = "jdbc:mysql://localhost:3306/food_order";
				String uname= "root";
				String pass = "";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, uname, pass);
					String query="Insert into customer(email_id,pwd,name,address,phone)"+"values(?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1,mail.getText());
					pst.setString(2,pwd.getText());
					pst.setString(3,name.getText());
					pst.setString(4,adr.getText());
					pst.setString(5,ph.getText());
					pst.execute();
					PreparedStatement pst1;
					pst1 = con.prepareStatement("COMMIT");
				}catch(Exception e) {
						System.out.println(e.getMessage());
				}
				if(!(mail.getText().isEmpty() || pwd.getText().isEmpty() || name.getText().isEmpty() || adr.getText().isEmpty() || ph.getText().isEmpty()))
				{
					JOptionPane.showMessageDialog(null, "Registration Successful.");
					w2 wel1 = new w2(name.getText());
					frame.setVisible(false);
					wel1.frame.setUndecorated(true);
					wel1.frame.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "Please fill all the Details.");
			}
		});
		btnRegister.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 17));
		btnRegister.setBounds(413, 121, 125, 23);
		frame.getContentPane().add(btnRegister);
		
		JLabel minimize = new JLabel("-");
		minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		minimize.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 35));
		minimize.setForeground(Color.RED);
		minimize.setBounds(527, 10, 31, 28);
		frame.getContentPane().add(minimize);
		
		JLabel close = new JLabel("X");
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				welcomepage wcp = new welcomepage();
				frame.setVisible(false);
				wcp.frame.setUndecorated(true);
				wcp.frame.setVisible(true);
			}
		});
		close.setForeground(Color.RED);
		close.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 30));
		close.setBounds(552, 5, 31, 39);
		frame.getContentPane().add(close);
		frame.setBounds(100, 100, 599, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
