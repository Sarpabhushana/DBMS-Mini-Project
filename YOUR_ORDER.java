package database;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.Scrollbar;
import javax.swing.JSplitPane;
import java.util.*;
public class YOUR_ORDER {
	public JFrame frame;
	private JTextField amt;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	String itms,cost,cust,res;
	private JTextField bill_id;
	private JTextField rest_id;
	private JTextField customer;
	String p="";
	public YOUR_ORDER(String cust,String res,String itms,String cost) {
		this.itms=itms;
		this.cust=cust;
		this.res=res;
		this.cost=cost;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 596, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblYourOrder = new JLabel("YOUR ORDER");
		lblYourOrder.setBounds(0, 11, 188, 38);
		lblYourOrder.setForeground(Color.YELLOW);
		lblYourOrder.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 24));
		frame.getContentPane().add(lblYourOrder);
		
		JLabel lblBillNo = new JLabel("BILL NO : ");
		lblBillNo.setBounds(70, 57, 78, 14);
		lblBillNo.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 14));
		lblBillNo.setForeground(Color.WHITE);
		frame.getContentPane().add(lblBillNo);
		
		JLabel lblRestaurantId = new JLabel("RESTAURANT ID :");
		lblRestaurantId.setBounds(10, 82, 132, 14);
		lblRestaurantId.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 14));
		lblRestaurantId.setForeground(Color.WHITE);
		frame.getContentPane().add(lblRestaurantId);
		
		JLabel lblItems = new JLabel("   YOUR ITEMS :");
		lblItems.setBounds(0, 113, 132, 14);
		lblItems.setForeground(Color.WHITE);
		lblItems.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 14));
		frame.getContentPane().add(lblItems);
		
		JLabel lblTotalAmount = new JLabel("TOTAL AMOUNT : ");
		lblTotalAmount.setBounds(144, 252, 193, 14);
		lblTotalAmount.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 13));
		lblTotalAmount.setForeground(Color.WHITE);
		frame.getContentPane().add(lblTotalAmount);
		
		JLabel lblHaveAnAmazing = new JLabel("HAVE AN AMAZING MEAL !!!");
		lblHaveAnAmazing.setBounds(132, 277, 262, 14);
		lblHaveAnAmazing.setForeground(Color.GREEN);
		lblHaveAnAmazing.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 18));
		frame.getContentPane().add(lblHaveAnAmazing);
		
		JButton btnPayNow = new JButton("CONFIRM");
		btnPayNow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Address add = new Address(cust,res,p,cost);
				frame.setVisible(false);
				add.frame.setUndecorated(true);
				add.frame.setVisible(true);
			}
		});
		btnPayNow.setBounds(438, 219, 112, 23);
		btnPayNow.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 14));
		frame.getContentPane().add(btnPayNow);
		
		JLabel lblCustomer = new JLabel("CUSTOMER : ");
		lblCustomer.setBounds(414, 57, 112, 14);
		lblCustomer.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 14));
		lblCustomer.setForeground(Color.WHITE);
		frame.getContentPane().add(lblCustomer);
		
		amt = new JTextField("RS:"+cost);
		amt.setEditable(false);
		amt.setBackground(new Color(220, 220, 220));
		amt.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		amt.setBounds(269, 248, 95, 20);
		frame.getContentPane().add(amt);
		amt.setColumns(10);
		
		JLabel minim = new JLabel("-");
		minim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		minim.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 35));
		minim.setForeground(Color.RED);
		minim.setBounds(521, 11, 29, 23);
		frame.getContentPane().add(minim);
		
		JLabel close = new JLabel("X");
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"Your Items in the cart will be discarded");
				System.exit(0);
			}
		});
		close.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 35));
		close.setForeground(Color.RED);
		close.setBounds(545, 2, 35, 45);
		frame.getContentPane().add(close);
		
		JTextArea textArea = new JTextArea(itms);
		textArea.setEditable(false);
		textArea.setBounds(144, 109, 194, 132);
		frame.getContentPane().add(textArea);
		
		Random R=new Random();
		p=res.substring(0,2)+R.nextInt(1000);
		bill_id = new JTextField(p.toUpperCase());
		bill_id.setFont(new Font("Arial Black", Font.BOLD, 13));
		bill_id.setEditable(false);
		bill_id.setBounds(151, 51, 78, 20);
		frame.getContentPane().add(bill_id);
		bill_id.setColumns(10);
		
		rest_id = new JTextField(res);
		rest_id.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 13));
		rest_id.setEditable(false);
		rest_id.setBounds(150, 80, 141, 20);
		frame.getContentPane().add(rest_id);
		rest_id.setColumns(10);
		
		customer = new JTextField(cust);
		customer.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 12));
		customer.setEditable(false);
		customer.setBounds(424, 80, 86, 20);
		frame.getContentPane().add(customer);
		customer.setColumns(10);
	}
}
