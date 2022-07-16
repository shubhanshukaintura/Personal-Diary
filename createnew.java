package personaldiary;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class Create extends JFrame implements ActionListener
{
	Container c;
    JTextArea ta1;
    JTextField tf1;
    Create()
    {
    	c=getContentPane();
    	c.setLayout(null);
    	
    	c.setBackground(new Color(115,0,216));
    	
    	JButton b1=new JButton("<<Back");
    	b1.setBounds(50,150,100,30);
    	
        JButton b2=new JButton("Save");
        b2.setBounds(50,200,100,30);
        
        JButton b3=new JButton("Exit");
        b3.setBounds(50,250,100,30);
        
        JButton b4=new JButton("Logout");
        b4.setBounds(50,300,100,30);
        
        JLabel l1=new JLabel("Title");
        l1.setFont(new Font("Times New Romans", Font.BOLD, 18));
        l1.setForeground(Color.WHITE);
        l1.setBounds(300,30,100,30);
        
        tf1=new JTextField(30);
        tf1.setBounds(350,30,200,30);
        
        ta1=new JTextArea(800,800);
        ta1.setBounds(200,80,550,450);
        
        Font font = new Font("Times New Romans", Font.BOLD, 20);
        ta1.setFont(font);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(l1);
        add(tf1);
        add(ta1);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        String s=e.getActionCommand();
        
        if(s.equals("<<Back")) {
        	Mainfile x=new Mainfile();
        	x.setSize(800,650);
            x.setLocation(350,100);
            x.setVisible(true);
            this.dispose();
        	
        }
        
        if(s.equals("Save"))
        {
        	String title=tf1.getText();
        	File file = new File("C:\\Users\\shubh\\Desktop\\personl diary files\\"+title+".txt");
            try {
                if (file.createNewFile()) {
                    System.out.println("New Text File is created!");
                } else {
                    System.out.println("File already exists.");
                }
                
                FileWriter writer = new FileWriter(file);
                writer.write(ta1.getText());
                writer.close();
            } 
            catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        
        if(s.equals("Logout")) {
        	Loginform x=new Loginform();
        	x.setVisible(true);
        	x.setSize(400,400);
        	x.setLocation(600,200);
        	this.dispose();
        }
            
        
        if(s.equals("Exit"))
        {
            System.exit(0);
        }
    }

    public static void main(String args[]){
        Create d=new Create();
        d.setSize(800,650);
        d.setLocation(350,100);
        d.setVisible(true);
    }
}