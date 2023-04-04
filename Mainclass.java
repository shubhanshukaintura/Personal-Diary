package personaldiary;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class Mainfile extends JFrame implements ActionListener
{
	Container c;
	String filename = null;
    JTextArea ta1;
    Mainfile()
    {
    	c=getContentPane();
    	c.setLayout(null);
    	
    	c.setBackground(new Color(240,240,0));
    	
        JButton b1=new JButton("Open");
        b1.setBounds(50,150,100,30);
        
        JButton b2=new JButton("Create New");
        b2.setBounds(50,200,100,30);
        
        JButton b3=new JButton("Exit");
        b3.setBounds(50,250,100,30);
        
        JButton b4=new JButton("Logout");
        b4.setBounds(50,300,100,30);
        
        JButton b5=new JButton("Save Changes");
        b5.setBounds(580,540,100,30);
        
        ta1=new JTextArea(800,800);
        ta1.setBounds(200,80,550,450);
        
        Font font = new Font("Times New Romans", Font.BOLD, 20);
        ta1.setFont(font);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(ta1);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        String s=e.getActionCommand();
        if(s.equals("Open"))
        {
	        try
	        {   
	        	JFileChooser choose = new JFileChooser("C:\\Users\\shubh\\Desktop\\personl diary files");
	         	 
	        	// Open the save dialog
	        	choose.showSaveDialog(null);
	        	File f=choose.getSelectedFile();
	        	filename=f.getAbsolutePath();
	        	FileReader fr=new FileReader(filename);
	        	BufferedReader br=new BufferedReader(fr);
	        	ta1.read(br, null);
	        	br.close();
	        	ta1.requestFocus();
	        }
	        catch(Exception e1)
	        {
	        	JOptionPane.showMessageDialog(null,e1);
	        }
        }
        
        if(s.equals("Save Changes"))
        {
	        try
	        {
	        	FileWriter fw=new FileWriter(filename);
	        	fw.write(ta1.getText());
	        	System.out.println("Saved Changes Successfully");
	        	fw.close();
	        }
	        catch(IOException e1)
	        {
	        	e1.printStackTrace();
	        }
        }
        
        if(s.equals("Create New"))
        {
        	Create x=new Create();
        	x.setSize(800,650);
            x.setLocation(350,100);
            x.setVisible(true);
            this.dispose();
        	
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
	//new update comment
    public static void main(String args[]){
        Mainfile d=new Mainfile();
        d.setSize(800,650);
        d.setLocation(350,100);
        d.setVisible(true);
    }
}
