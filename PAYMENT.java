package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import com.mysql.cj.protocol.Resultset;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PAYMENT {
	public JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PAYMENT window = new PAYMENT("SANJAY S","Ballal","sanjay123","100","");
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
	String cust,res,bill_id,amt,addr;
	public PAYMENT(String cust,String res,String bill_id,String amt,String addr) {
		this.cust=cust;
		this.addr=addr;
		this.res=res;
		this.bill_id=bill_id;
		this.amt=amt;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 612, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPayNow = new JLabel("PAY NOW !");
		lblPayNow.setForeground(Color.YELLOW);
		lblPayNow.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 30));
		lblPayNow.setBounds(23, 11, 181, 38);
		frame.getContentPane().add(lblPayNow);
		
		JLabel lblSelectYourMode = new JLabel("SELECT YOUR MODE OF PAYMENT !");
		lblSelectYourMode.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 20));
		lblSelectYourMode.setForeground(Color.ORANGE);
		lblSelectYourMode.setBounds(111, 71, 438, 14);
		frame.getContentPane().add(lblSelectYourMode);
		
		JButton btnPay = new JButton("PAY");
		btnPay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ResultSet rs1=null;
				String url = "jdbc:mysql://localhost:3306/food_order";
				String uname= "root";
				String pass = "";
				String q2 = "Select email_id from customer where name='"+cust+"'";
				String query = "Insert into bill(bill_id,email,customer,amount,address,rest_id) values(?,?,?,?,?,?) ";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, uname, pass);
					Statement st = con.createStatement();
					rs1=st.executeQuery(q2);
					rs1.next();
					//String email = rs1.getNextResultset().toString();
					String email = rs1.getString(1);
					System.out.println(email+bill_id);
					PreparedStatement pst = con.prepareStatement(query);
					System.out.println(res.substring(res.indexOf('-')+1));
					pst.setString(1,bill_id);
					pst.setString(2,email);
					pst.setString(3,cust);
					pst.setString(4,amt);
					pst.setString(5,addr);
					pst.setString(6,res.substring(res.indexOf('-')+1));
					pst.execute();
					PreparedStatement pst1 = con.prepareStatement("COMMIT");
				}catch(Exception e1) {
						System.out.println(e1);
				}
				frame.setVisible(false);
				THANKS TNKS = new THANKS(cust,res);
				TNKS.frame.setUndecorated(true);
				TNKS.frame.setVisible(true);
			}
		});
		btnPay.setForeground(Color.BLACK);
		btnPay.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 20));
		btnPay.setBounds(258, 270, 79, 23);
		frame.getContentPane().add(btnPay);
		
		JLabel lblNewLabel = new JLabel("-");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(536, 11, 22, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(567, 3, 29, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton COD = new JRadioButton("CASH ON DELIVERY");
		COD.setSelected(true);
		buttonGroup.add(COD);
		COD.setForeground(new Color(0, 0, 128));
		COD.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 15));
		COD.setBounds(207, 111, 187, 23);
		frame.getContentPane().add(COD);
		
		JRadioButton CC = new JRadioButton("CREDIT CARD");
		buttonGroup.add(CC);
		CC.setForeground(new Color(0, 0, 128));
		CC.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 15));
		CC.setBounds(207, 147, 187, 23);
		frame.getContentPane().add(CC);
		
		JRadioButton PAYTM = new JRadioButton("PAYTM");
		buttonGroup.add(PAYTM);
		PAYTM.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 15));
		PAYTM.setForeground(new Color(0, 0, 128));
		PAYTM.setBounds(207, 187, 187, 23);
		frame.getContentPane().add(PAYTM);
		
		JRadioButton DC = new JRadioButton("DEBIT CARD");
		buttonGroup.add(DC);
		DC.setForeground(new Color(0, 0, 128));
		DC.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 15));
		DC.setBounds(207, 224, 187, 23);
		frame.getContentPane().add(DC);
	}
}
