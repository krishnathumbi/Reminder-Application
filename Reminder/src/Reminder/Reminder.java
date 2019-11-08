package Reminder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Reminder extends JFrame implements ActionListener
{
    JButton b1,b2,b3,b4;
    JLabel l1;
    public Reminder()
    {
            setTitle("Home Page");
            setSize(500,500);
            setLocationRelativeTo(null);
            setVisible(true);

            setLayout(new BorderLayout());
            setLayout(null);
            setVisible(true);
        
            l1=new JLabel("REMINDER MANAGEMENT SYSTEM");
            l1.setFont(new Font("Courier New", Font.BOLD, 30));
            l1.setBounds(120, 10, 680, 30);
            l1.setForeground(Color.BLUE);
            b1=new JButton("Add Reminder");
            b1.setBounds(250,80,180,30);
            b2=new JButton("View Reminder");
            b2.setBounds(250,140,180,30);

            add(b1);
            add(b2);
            add(l1);

            b1.addActionListener(this);
            b2.addActionListener(this);

            setSize(700,380);
            
            //CODE TO EXIT APPLICATION WHN CLICK THE CLOSE (X) BUTTON
            
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
                    }
                }
            };
            addWindowListener(exitListener);
    }
    
    
    public void actionPerformed(ActionEvent e)
    {
        String str=e.getActionCommand();
        if(str.equals("Add Reminder"))
        {
            InsUpd mainFrame=new InsUpd();

            mainFrame.setVisible(true);
            setVisible(false);
        }
        else if(str.equals("View Reminder"))
        {
            View mainFrame=new View();
            mainFrame.setVisible(true);
            setVisible(false); 
        }
    }
    public static void main(String args[])
    {
        new Reminder();
    }
}