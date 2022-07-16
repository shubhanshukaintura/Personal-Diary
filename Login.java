package personaldiary;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Loginform extends JFrame implements ActionListener
{
	Connection con;
    JTextField tf1;
    Container c;
    JPasswordField tf2;
    Loginform()
    {
    	c=getContentPane();
    	c.setLayout(null);
    	
    	c.setBackground(new Color(42,170,225));
    	
        JLabel l1=new JLabel("Username");
        l1.setFont(new Font("Times New Romans", Font.BOLD, 14));
        l1.setForeground(Color.WHITE);
        l1.setBounds(50,50,100,30);
        
        tf1=new JTextField(20);
        tf1.setBounds(140,50,200,30);
        
        JLabel l2=new JLabel("Password");
        l2.setFont(new Font("Times New Romans", Font.BOLD, 14));
        l2.setForeground(Color.WHITE);
        l2.setBounds(50,100,100,30);
        
        tf2=new JPasswordField(20);
        tf2.setBounds(140,100,200,30);
        
        JButton b1=new JButton("Login");
        b1.setBounds(100,200,200,30);
        
        b1.addActionListener(this);
        add(l1);
        add(tf1);
        add(l2);
        add(tf2);
        add(b1);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
    	String query="select * from loginpersonaldiary";
    	String name = null,pass=null;
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shubhanshudb","root","shubh");
    		Statement st=con.createStatement();
    		ResultSet rs=st.executeQuery(query);
    		while(rs.next()) {
    			if(rs.getString("username").equals(tf1.getText())) {
    				name=rs.getString("username");
    				pass=rs.getString("password");
    			}
    		}
    	}
    	catch(Exception e1) {
    		System.out.println("Statement related issue");
    	}
    	
    	if(name==null) {
    		System.out.println("Invalid Username");
    	}
    	else if(name.equals(tf1.getText())){
	    	Mainfile x=new Mainfile();
	    	x.setSize(800,650);
	        x.setLocation(350,100);
	        x.setVisible(true);
	        this.dispose();
    	}
    	else{
    		System.out.println("Invalid Username or Password");
    	}
    }
        
    public static void main(String args[]) throws Exception
    {
            Loginform d=new Loginform();
            d.setTitle("LOGIN FORM");
            d.setSize(400,400);
            d.setLocation(600,200);
            d.setVisible(true);
            
    }
}