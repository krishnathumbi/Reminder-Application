package Reminder;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

class View extends JFrame
{

    private JPanel topPanel ;
    private JTable table;
    private JScrollPane scrollPane;
    private String[] columnNames= new String[3];
    private String[][] dataValues=new String[10][9] ;
    Connection con;
    Statement stmt;

    public View()
    {    
        setTitle("View Reminder");
        setSize(1000,300);
        topPanel= new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        WindowListener exitListener = new WindowAdapter() 
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                int confirm = JOptionPane.showOptionDialog(
                    null, "Are You Sure to Close Application?", 
                    "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0)
                {
                    setVisible(false);
                    new Reminder();
                }
            }
        };
        addWindowListener(exitListener);
       columnNames = new String[] {"Reminder Id", "Date", "Reminder Title"};
        //create table with data
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reminderdb","root","");
            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from reminder");
            int i=0;
            while(rs.next())
            {
                dataValues[i][0]=rs.getString(1);
                dataValues[i][1]=rs.getString(2);
                dataValues[i][2]=rs.getString(3);
                i=i+1;
            }
        }
        catch(Exception e1)
        {
            System.out.println(e1);
        }
        
        TableModel model=new myTableModel();
        table =new JTable( );
        table.setRowHeight(20);
        table.setModel(model);
        scrollPane=new JScrollPane(table);
        topPanel.add(scrollPane,BorderLayout.CENTER);
        table.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent e)
           {
                int row=table.rowAtPoint(e.getPoint());
                int col= table.columnAtPoint(e.getPoint());
                JOptionPane.showMessageDialog(null," Edit Reminder :"+ " " +table.getValueAt(row,col).toString());
                InsUpd hup=new InsUpd(table.getValueAt(row,0).toString(),table.getValueAt(row,1).toString(),table.getValueAt(row,2).toString());
                hup.setVisible(true);
            }
        }
        );
        setVisible(true);
    }

    public class myTableModel extends DefaultTableModel
    {
        myTableModel( )
        {
            super(dataValues,columnNames);
            System.out.println("Inside myTableModel");
        }
        public boolean isCellEditable(int row,int cols)
        {
            return false;
        }
    }
    public static void main(String args[])
    {
        View mainFrame=new View();
        mainFrame.setVisible(true);
    }
}
