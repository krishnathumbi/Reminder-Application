package Reminder;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;

class InsUpd extends Frame implements ActionListener
{

    TextField rid,rdate,rdescription;
    Button b1,b2;
    
    //CONSTRUCTOR InsUpd(String remid,String remdate,String remdescription) IS USED TO DISPLAY UPDATE REMINDER FORM
    
    InsUpd(String remid,String remdate,String remdescription)
    {
        setBackground(Color.getHSBColor(45,92,100));
        setLayout(new FlowLayout());
        this.setLayout(null);
        
        setTitle("Edit Reminder");
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        
        Label id=new Label("Reminder id:",Label.LEFT);
        Label date=new Label("Reminder Date:",Label.LEFT);
        Label des=new Label("Reminder :",Label.LEFT);
        
        rid=new TextField(20);
        rdate=new TextField(20);
        rdescription=new TextField(20);

        id.setBounds(70,90,90,60);
        date.setBounds(70,130,90,60);
        des.setBounds(70,170,90,60);

        rid.setBounds(200,100,90,20);
        rdate.setBounds(200,140,90,20);
        rdescription.setBounds(200,180,90,20);

        b1=new Button("Update");
        b1.setBounds(200,240,70,40);
        b2=new Button("Close");
        b2.setBounds(280,240,70,40);
                        
        b1.addActionListener(this);
        b2.addActionListener(this);
                            
        add(rid);
        add(rdate);
        add(rdescription);
        add(b1);
        add(b2);
        this.add(id);
        this.add(date);
        this.add(des);

        setSize(700,700);
        setLayout(null);
        rid.setText(remid);
        rdate.setText(remdate);
        rdescription.setText(remdescription);
        rid.setEnabled(false);
    }
    
    //AUTOID() GENERATES REMINDER ID AUTOMATICALLY
    
    public void autoid()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reminderdb","root","");
            Statement stmt=con.createStatement();
            String qr="select max(rid) as mid from reminder";
            System.out.println(qr);
            ResultSet rs=stmt.executeQuery(qr);
            int flag=0;
            int mid=0;
            while(rs.next())
            {
                mid=rs.getInt("mid");
                mid=mid+1;
            }
            JOptionPane.showMessageDialog(null,"New id "+mid);
            rid.setText(""+mid);
            rid.setEnabled(false);
            con.close();
        }
        catch(Exception e1)
        {
            System.out.println(e1);
        }

    }

    //CONSTRUCTOR InsUpd() IS USED TO DISPLAY ADD REMINDER FORM
    
    InsUpd()
    {
        setBackground(Color.getHSBColor(97,92,247));
	setLayout(new FlowLayout());
	this.setLayout(null);
        
        setTitle("Add Reminder");
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        
        Label id=new Label("Reminder Id:",Label.LEFT);
	Label date=new Label("Reminder Date:",Label.LEFT);
	Label des=new Label("Reminder Title:",Label.LEFT);
		 
        rid=new TextField(20);
	rdate=new TextField(20);	
        rdescription=new TextField(20);
		 
        id.setBounds(70,90,90,60);
	date.setBounds(70,130,90,60);
	des.setBounds(70,170,90,60);
	
	rid.setBounds(200,110,90,20);
	rdate.setBounds(200,150,90,20);
	rdescription.setBounds(200,190,90,20);
	      

	b1=new Button("Submit");
        b1.setBounds(200,240,70,40);
	b2=new Button("Close");
	b2.setBounds(280,240,70,40);
	
        b1.addActionListener(this);
	b2.addActionListener(this);
		
        add(rid);
	add(rdate);
	add(rdescription);
	add(b1);
	add(b2);
	this.add(id);
	this.add(date);
	this.add(des);
	
	setSize(500,400);
	setLayout(null);
	setVisible(true);
        autoid();
                                
    }
			
    public void actionPerformed(ActionEvent e)
    {
        String str=e.getActionCommand();
        if(str.equals("Close"))
        {
            int confirm = JOptionPane.showOptionDialog(
            null, "Are You Sure to Close Application?", 
                "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirm == 0)
            {
                new Reminder();
                setVisible(false);
            }
        }
        if(str.equals("Submit"))
        {
            String id=rid.getText();
            String date=rdate.getText();
            String des=rdescription.getText();

            if(id.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter the id");
                rid.requestFocusInWindow();
            }
            else  if(des.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter the Description");
                rdescription.requestFocusInWindow();
            }
            else  if(date.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter the Date");
                rdate.requestFocusInWindow();
            }
            else
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reminderdb","root","");
                    Statement stmt=con.createStatement();
                    String qr="insert into reminder values('"+id+"','"+date+"','"+des+"')";
                    System.out.println(qr);
                    stmt.executeUpdate(qr);
                    JOptionPane.showMessageDialog(null,"Reminder Added");
                    con.close();
                }
                catch(Exception e1)
                {
                    System.out.println(e1);
                }
            }
        }
    
        if(str.equals("Update"))
        {
            String id=rid.getText();
            String date=rdate.getText();
            String des=rdescription.getText();
            if(id.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter the id");
                rid.requestFocusInWindow();
            }
            else  if(date.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter the Date");
                rdate.requestFocusInWindow();
            }
            else  if(des.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter the Description");
                rdescription.requestFocusInWindow();
            }
            else
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reminderdb","root","");
                    Statement stmt=con.createStatement();
                    String qr="update  reminder set rdate='"+date+"',rdescription='"+des+"' where rid='"+id+"'";
                    System.out.println(qr);
                    stmt.executeUpdate(qr);
                    JOptionPane.showMessageDialog(null,"Reminder Updated");
                    con.close();
                }
                catch(Exception e1)
                {
                    System.out.println(e1);
                }
            }
        }
    }

    public static void main(String args[])
    {
	new InsUpd();
    }
}






