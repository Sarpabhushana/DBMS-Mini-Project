package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;

public class w2 {

	public JFrame frame;
	JComboBox combo=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					w2 window = new w2("Sanjay");
					window.frame.setUndecorated(true);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	JComboBox comboBox=null;
	/**
	 * Create the application.
	 */
	String cust;
	private JTextField textField;
	public w2(String cust) {
		this.cust=cust;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(123, 104, 238));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 26));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 724, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 432, 0);
		frame.getContentPane().add(label);
		
		JLabel lblNowOrderFood = new JLabel("WELCOME!!");
		lblNowOrderFood.setForeground(new Color(255, 215, 0));
		lblNowOrderFood.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 30));
		lblNowOrderFood.setBounds(10, 13, 237, 59);
		frame.getContentPane().add(lblNowOrderFood);
		
		JLabel lblNowOrderFood_1 = new JLabel("NOW ORDER FOOD AT THE COMFORT OF YOUR HOME IN A FEW CLICKS");
		lblNowOrderFood_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
		lblNowOrderFood_1.setForeground(new Color(250, 235, 215));
		lblNowOrderFood_1.setBounds(76, 104, 589, 16);
		frame.getContentPane().add(lblNowOrderFood_1);
		
		JLabel lblSelectTheRestaurant = new JLabel("SELECT THE NEAREST AREA");
		lblSelectTheRestaurant.setForeground(Color.GREEN);
		lblSelectTheRestaurant.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 14));
		lblSelectTheRestaurant.setBounds(39, 146, 589, 16);
		frame.getContentPane().add(lblSelectTheRestaurant);
		
		JLabel lblToViewRestaurant = new JLabel("TO CONTACT RESTAURANT MANAGER , CLICK HERE :\r\n\r\n");
		lblToViewRestaurant.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
		lblToViewRestaurant.setForeground(new Color(240, 230, 140));
		lblToViewRestaurant.setBackground(new Color(240, 240, 240));
		lblToViewRestaurant.setBounds(25, 401, 444, 16);
		frame.getContentPane().add(lblToViewRestaurant);
		
		JButton btnContactUs = new JButton("CONTACT US");
		btnContactUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnContactUs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				CONTACT cont = new CONTACT(cust,comboBox.getSelectedItem().toString());
				cont.frame.setUndecorated(true);
				cont.frame.setVisible(true);
			}
		});
		btnContactUs.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		btnContactUs.setBounds(470, 396, 171, 25);
		frame.getContentPane().add(btnContactUs);
		try {
			String url = "jdbc:mysql://localhost:3306/food_order";
			String uname= "root";
			String pass = "";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT DISTINCT AREA FROM AREA_COVERED;");
			LinkedList<String> ll = new LinkedList<String>();
			while(rs.next())
				ll.addLast(rs.getString(1));
			combo = new JComboBox(ll.toArray());
			combo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					comboBox.removeAllItems();
					try {
						String url = "jdbc:mysql://localhost:3306/food_order";
						String uname= "root";
						String pass = "";
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection(url, uname, pass);
						Statement st = con.createStatement();
						String area1=combo.getSelectedItem().toString();
						System.out.println(area1);
						ResultSet rs = st.executeQuery("SELECT R.NAME,R.REST_ID FROM AREA_COVERED A,RESTAURANT R WHERE R.REST_ID=A.REST_ID AND A.AREA='"+area1+"';");
						LinkedList<String> ll = new LinkedList<String>();
						while(rs.next())
							comboBox.addItem(rs.getString(1)+"-"+rs.getString(2));
						total_orders(comboBox.getSelectedItem().toString());
					//	comboBox = new JComboBox(ll.toArray());
						//comboBox.addItem(ll);

					}catch(Exception e) {
						
					}
				}
			});
			combo.setSelectedIndex(0);
			combo.setBounds(96, 175, 320, 35);
			frame.getContentPane().add(combo);
		}catch(Exception e) {
			System.out.println(e);
			
		}
		
		try {
			String url = "jdbc:mysql://localhost:3306/food_order";
			String uname= "root";
			String pass = "";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			String area1=combo.getSelectedItem().toString();
			System.out.println(area1);
			ResultSet rs = st.executeQuery("SELECT R.NAME,R.REST_ID FROM AREA_COVERED A,RESTAURANT R WHERE R.REST_ID=A.REST_ID AND A.AREA='"+area1+"';");
			LinkedList<String> ll = new LinkedList<String>();
			while(rs.next())
				ll.addLast(rs.getString(1)+"-"+rs.getString(2));
			
			comboBox = new JComboBox(ll.toArray());
			comboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					
					total_orders(arg0.getItem().toString());
				}
			});
			comboBox.setSelectedIndex(0);
			total_orders(comboBox.getSelectedItem().toString());
			comboBox.setBounds(96, 273, 320, 35);
			frame.getContentPane().add(comboBox);
		}catch(Exception e) {
			
		}
		
		
		
		
		JLabel lblNewLabel = new JLabel("-");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(642, 15, 23, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(672, 0, 36, 42);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MENU mu=new MENU(cust,comboBox.getSelectedItem().toString());
				mu.frame.setUndecorated(true);
				frame.setVisible(false);
				mu.frame.setVisible(true);
				//MENU menu = new MENU(cust);
				frame.setVisible(false);
	
				//mu.frame.setVisible(true);
				
				
			}
		});
		btnNewButton.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(519, 243, 122, 35);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("TOTAL ORDERS SUPPLIED BY THE ABOVE RESTAURANT :");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setBounds(26, 340, 376, 27);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Arial Black", Font.BOLD, 13));
		textField.setBounds(396, 339, 47, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSelectTheRestaurant_1 = new JLabel("SELECT THE RESTAURANT IN THE ABOVE AREA.");
		lblSelectTheRestaurant_1.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 14));
		lblSelectTheRestaurant_1.setForeground(Color.GREEN);
		lblSelectTheRestaurant_1.setBounds(39, 243, 377, 19);
		frame.getContentPane().add(lblSelectTheRestaurant_1);
		total_orders(comboBox.getSelectedItem().toString());

	}
	public void total_orders(String k)
	{
		k=k.substring(k.indexOf("-")+1);
		try
		{
			String url = "jdbc:mysql://localhost:3306/food_order";
			String uname= "root";
			String pass = "";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1 = DriverManager.getConnection(url,uname,pass);
			Statement st1 = con1.createStatement();
			//String to = comboBox.getSelectedItem().toString();
			ResultSet rs1 = st1.executeQuery("Select total_orders from restaurant where rest_id='"+k+"';");	
			rs1.next();
				textField.setText(rs1.getString(1));
			
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
