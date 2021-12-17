
package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.*;

public class Room extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2;
            
    Room(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(480,10,550,600);
        add(icon);
        t1 = new JTable();
        t1.setBounds(0,40,500,400);
        add(t1);
        
        b1 = new JButton("Load Data");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100,460,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250,460,120,30);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        
        
        setLayout(null);
        setBounds(200,50,1000,650);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                conn c = new conn();
                String str = "select * from room";
                
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){}
            
        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
        
    }
    public static void main(String[] args){
        new Room().setVisible(true);
        
    }
}
