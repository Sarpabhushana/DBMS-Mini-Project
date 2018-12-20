package database;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Address {

	public JFrame frame;
	private JTextField HOUSE;
	private JTextField STREET;
	private JTextField PIN;
	private JTextField AREA;
	private JTextField CONTAC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Address window = new Address("","","","");
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
	String cust,res,bill_id,amt;
	String addr="";
	public Address(String cust,String res,String bill_id,String amt) 
	{
		this.cust=cust;
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
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 650, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 25));
		lblAddress.setForeground(Color.RED);
		lblAddress.setBounds(10, 11, 136, 33);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblEnterTheAddress = new JLabel("ENTER THE ADDRESS YOU WANT THE FOOD DELIVERED TO.");
		lblEnterTheAddress.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 13));
		lblEnterTheAddress.setForeground(Color.YELLOW);
		lblEnterTheAddress.setBounds(20, 55, 386, 14);
		frame.getContentPane().add(lblEnterTheAddress);
		
		JLabel lblHouseNo = new JLabel("HOUSE NO.");
		lblHouseNo.setForeground(Color.GREEN);
		lblHouseNo.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 13));
		lblHouseNo.setBounds(45, 103, 101, 14);
		frame.getContentPane().add(lblHouseNo);
		
		JLabel lblStreet = new JLabel("STREET");
		lblStreet.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 13));
		lblStreet.setForeground(Color.GREEN);
		lblStreet.setBounds(63, 141, 76, 14);
		frame.getContentPane().add(lblStreet);
		
		JLabel lblArea = new JLabel("AREA");
		lblArea.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 13));
		lblArea.setForeground(Color.GREEN);
		lblArea.setBounds(74, 179, 46, 14);
		frame.getContentPane().add(lblArea);
		
		JLabel lblPinCode = new JLabel("PIN CODE");
		lblPinCode.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 13));
		lblPinCode.setForeground(Color.GREEN);
		lblPinCode.setBounds(45, 222, 76, 14);
		frame.getContentPane().add(lblPinCode);
		
		JLabel lblContactNumber = new JLabel("CONTACT NO.");
		lblContactNumber.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 13));
		lblContactNumber.setForeground(Color.GREEN);
		lblContactNumber.setBounds(20, 257, 101, 14);
		frame.getContentPane().add(lblContactNumber);
		
		HOUSE = new JTextField();
		HOUSE.setBounds(141, 101, 182, 20);
		frame.getContentPane().add(HOUSE);
		HOUSE.setColumns(10);
		
		STREET = new JTextField();
		STREET.setBounds(141, 139, 182, 20);
		frame.getContentPane().add(STREET);
		STREET.setColumns(10);
		
		PIN = new JTextField();
		PIN.setBounds(141, 220, 86, 20);
		frame.getContentPane().add(PIN);
		PIN.setColumns(10);
		
		AREA = new JTextField();
		AREA.setBounds(141, 177, 182, 20);
		frame.getContentPane().add(AREA);
		AREA.setColumns(10);
		
		CONTAC = new JTextField();
		CONTAC.setBounds(141, 255, 147, 20);
		frame.getContentPane().add(CONTAC);
		CONTAC.setColumns(10);
		
		JButton btnConfirmOrder = new JButton("PAY NOW");
		btnConfirmOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				}
		});
		btnConfirmOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String url = "jdbc:mysql://localhost:3306/food_order";
				String uname= "root";
				String pass = "";
				addr=HOUSE.getText()+"\n"+STREET.getText()+"\n"+AREA.getText()+"\n"+PIN.getText()+"\n"+CONTAC.getText();
				if(!(HOUSE.getText().isEmpty() || STREET.getText().isEmpty() || AREA.getText().isEmpty() || PIN.getText().isEmpty() || CONTAC.getText().isEmpty()))
				{
				PAYMENT pay=new PAYMENT(cust,res,bill_id,amt,addr);
				frame.setVisible(false);
				pay.frame.setUndecorated(true);
				pay.frame.setVisible(true);
			}
				else
					JOptionPane.showMessageDialog(null, "PLEASE FILL ALL THE DETAILS.");
			}
		});
		btnConfirmOrder.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		btnConfirmOrder.setBounds(436, 119, 130, 23);
		frame.getContentPane().add(btnConfirmOrder);
		
		JButton btnNewButton = new JButton("CANCEL");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Your order will be Terminated");
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBounds(444, 217, 111, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("-");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		label.setForeground(Color.RED);
		label.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 35));
		label.setBounds(566, 11, 17, 33);
		frame.getContentPane().add(label);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Your order will be Terminated");
				System.exit(0);
			}
		});
		lblX.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 30));
		lblX.setForeground(Color.RED);
		lblX.setBounds(593, 11, 31, 33);
		frame.getContentPane().add(lblX);
	}
}
