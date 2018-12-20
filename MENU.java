package database;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import oracle.jrockit.jfr.events.DynamicValueDescriptor;

public class MENU {
	String k="Name Qty Total";
	JComboBox comboBox;
	public JFrame frame;
	int count=2;
	JLabel lbl;
	JTextArea txt;
	DefaultTableModel p;
	Object itms[][];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MENU window = new MENU("Sanjay","Ballal");
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
	public MENU(String cust,String res) {
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
		frame.getContentPane().setForeground(new Color(255, 245, 238));
		frame.setBounds(100, 100, 733, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setForeground(new Color(255, 255, 0));
		lblMenu.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 39));
		lblMenu.setBounds(39, 24, 153, 26);
		frame.getContentPane().add(lblMenu);
		
		JButton btnAddToCart = new JButton("ADD TO CART");
		btnAddToCart.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println(comboBox.getSelectedIndex());
				String q=comboBox.getSelectedItem().toString();
				System.out.println(q);
				String des=q.substring(0,q.indexOf("-"));
				String cost=q.substring(q.lastIndexOf("-")+1);
				System.out.println(des+cost);
				lbl.setText(Double.parseDouble(lbl.getText())+Double.parseDouble(cost)+"");
				txt.append("\n"+des+"               "+cost);
				
			}
		});
		btnAddToCart.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 13));
		btnAddToCart.setBounds(39, 383, 199, 25);
		frame.getContentPane().add(btnAddToCart);
		
		JLabel lblTheseAreThefood = new JLabel("THESE ARE THE FOOD ITEMS THAT YOU CAN ADD TO YOUR CART!!");
		lblTheseAreThefood.setForeground(Color.GREEN);
		lblTheseAreThefood.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 13));
		lblTheseAreThefood.setBounds(175, 51, 459, 26);
		frame.getContentPane().add(lblTheseAreThefood);
		
		JLabel lblWouldYoulikeTo = new JLabel("WOULD YOU LIKE TO CHECK OUT!!\r\n");
		lblWouldYoulikeTo.setBackground(new Color(240, 230, 140));
		lblWouldYoulikeTo.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		lblWouldYoulikeTo.setForeground(new Color(240, 230, 140));
		lblWouldYoulikeTo.setBounds(462, 355, 251, 16);
		frame.getContentPane().add(lblWouldYoulikeTo);
		
		JLabel lblAmountrs = new JLabel("AMOUNT :RS.");
		lblAmountrs.setForeground(new Color(240, 230, 140));
		lblAmountrs.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		lblAmountrs.setBounds(364, 314, 95, 16);
		frame.getContentPane().add(lblAmountrs);
		
		JButton btnCheckOut = new JButton("CHECK OUT");
		btnCheckOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				YOUR_ORDER YO = new YOUR_ORDER(cust,res,txt.getText(),lbl.getText());														
				YO.frame.setUndecorated(true);
				YO.frame.setVisible(true);
			}
		});
		btnCheckOut.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		btnCheckOut.setBounds(504, 382, 142, 25);
		frame.getContentPane().add(btnCheckOut);
		
		JLabel minim = new JLabel("-");
		minim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		minim.setForeground(Color.RED);
		minim.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 35));
		minim.setBounds(664, 11, 27, 26);
		frame.getContentPane().add(minim);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				w2 w = new w2(cust);
				w.frame.setUndecorated(true);
				w.frame.setVisible(true);
			}
		});
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(690, 11, 27, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		String p[]=null;
		LinkedList<String> ll=null;
		try {
			String url = "jdbc:mysql://localhost:3306/food_order";
			String uname= "root";
			String pass = "";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			CallableStatement cs=con.prepareCall("{call GetAllProducts}");
			ResultSet rs = cs.executeQuery();
			ll = new LinkedList<String>();
			while(rs.next()) {
				ll.add(rs.getString(2)+"---"+rs.getString(3));
			}
			p=new String[10];
			p=ll.toArray(p);
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		System.out.println(p[0]);
		comboBox = new JComboBox(p);
		comboBox.setEditable(false);
		//comboBox.setModel(new DefaultComboBoxModel(p));
		comboBox.setSelectedIndex(0);
		comboBox.setFont(new Font("Rockwell Extra Bold", Font.BOLD | Font.ITALIC, 12));
		comboBox.setBounds(39, 106, 212, 26);
		frame.getContentPane().add(comboBox);
		
		txt = new JTextArea();
		txt.setText("Description                   Cost");
		txt.setEditable(false);
		txt.setBounds(330, 88, 253, 215);
		frame.getContentPane().add(txt);
		
		lbl = new JLabel("0.0");
		lbl.setFont(new Font("Arial Black", Font.BOLD, 14));
		lbl.setForeground(Color.WHITE);
		lbl.setBackground(Color.RED);
		lbl.setBounds(463, 307, 75, 26);
		frame.getContentPane().add(lbl);
		
		itms=new Object[30][2];
		itms[0][0]=new String("Description");
		itms[0][1]=new String("Cost");
		
	}
}

