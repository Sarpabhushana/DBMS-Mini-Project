package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class CONTACT {
	public ResultSet rs;
	public JFrame frame;
	private JTextField name;
	private JTextField id;
	private JTextField phno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CONTACT window = new CONTACT("Sanjay","Ballal");
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
	String cust,res;
	public CONTACT(String cust,String res) {
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
		frame.setBounds(100, 100, 712, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblContactUs = new JLabel("CONTACT US");
		lblContactUs.setForeground(new Color(255, 215, 0));
		lblContactUs.setFont(new Font("Arial Black", Font.ITALIC, 22));
		lblContactUs.setBounds(12, 13, 277, 25);
		frame.getContentPane().add(lblContactUs);
		
		JLabel lblselectRestaurantYou = new JLabel("SELECT RESTAURANT YOU LIKE TO CONTACT:");
		lblselectRestaurantYou.setForeground(new Color(255, 245, 238));
		lblselectRestaurantYou.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 16));
		lblselectRestaurantYou.setBounds(12, 41, 470, 36);
		frame.getContentPane().add(lblselectRestaurantYou);
		
		JLabel lblManagerName = new JLabel("MANAGER NAME:");
		lblManagerName.setForeground(new Color(253, 245, 230));
		lblManagerName.setFont(new Font("Rockwell Extra Bold", Font.ITALIC, 15));
		lblManagerName.setBounds(332, 163, 183, 16);
		frame.getContentPane().add(lblManagerName);
		
		JLabel lblManagerId = new JLabel("MANAGER ID:");
		lblManagerId.setForeground(new Color(253, 245, 230));
		lblManagerId.setFont(new Font("Rockwell Extra Bold", Font.ITALIC, 15));
		lblManagerId.setBounds(332, 211, 183, 16);
		frame.getContentPane().add(lblManagerId);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO:");
		lblPhoneNo.setForeground(new Color(253, 245, 230));
		lblPhoneNo.setFont(new Font("Rockwell Extra Bold", Font.ITALIC, 15));
		lblPhoneNo.setBounds(332, 264, 183, 16);
		frame.getContentPane().add(lblPhoneNo);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				w2 wel = new w2(cust);
				frame.setVisible(false);
				wel.frame.setUndecorated(true);
				wel.frame.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Stencil", Font.BOLD, 16));
		btnBack.setBounds(443, 363, 97, 25);
		frame.getContentPane().add(btnBack);
		
		JComboBox comboBox ;
		try {
//			ResultSet rs;
			String url = "jdbc:mysql://localhost:3306/food_order";
			String uname= "root";
			String pass = "";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			rs = st.executeQuery("select name,rest_id from restaurant order by rest_id;");
			LinkedList<String> ll = new LinkedList<String>();
			while(rs.next())
				ll.add(rs.getString(1)+"-"+rs.getString(2));
			comboBox = new JComboBox(ll.toArray());
			comboBox.setSelectedIndex(0);
			comboBox.setBounds(12, 88, 241, 30);
			frame.getContentPane().add(comboBox);
			JButton btnNewButton = new JButton("ENTER");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					try {
						String rest;
						rest=comboBox.getSelectedItem().toString();
						rest=rest.substring(rest.indexOf("-")+1);
						PreparedStatement pst = con.prepareStatement("SELECT NAME,MAN_ID,PHONE FROM MANAGER WHERE REST_ID=?");
						pst.setString(1,rest);
						pst.execute();
						//ResultSet rs;
						rs=pst.getResultSet();
//						System.out.println(comboBox.getSelectedIndex());
						while(rs.next()) {
							name.setText(rs.getString(1));
							id.setText(rs.getString(2));
							phno.setText(rs.getString(3));
						}
					}catch(Exception e) {
						System.out.println(e);
					}
				}
			});
			btnNewButton.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 15));
			btnNewButton.setBounds(88, 264, 89, 23);
			frame.getContentPane().add(btnNewButton);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	
		name = new JTextField();
		name.setEditable(false);
		name.setFont(new Font("Rockwell", Font.ITALIC, 13));
		name.setBounds(512, 162, 106, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		id = new JTextField();
		id.setEditable(false);
		id.setFont(new Font("Rockwell", Font.ITALIC, 13));
		id.setBounds(512, 211, 106, 20);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		phno = new JTextField();
		phno.setEditable(false);
		phno.setFont(new Font("Rockwell", Font.ITALIC, 13));
		phno.setBounds(512, 264, 106, 20);
		frame.getContentPane().add(phno);
		phno.setColumns(10);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblX.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 30));
		lblX.setForeground(Color.RED);
		lblX.setBackground(Color.BLACK);
		lblX.setBounds(671, 11, 25, 36);
		frame.getContentPane().add(lblX);
		
		JLabel label = new JLabel("-");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		label.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 35));
		label.setBackground(Color.BLACK);
		label.setForeground(Color.RED);
		label.setBounds(644, 24, 25, 14);
		frame.getContentPane().add(label);
	}
}
