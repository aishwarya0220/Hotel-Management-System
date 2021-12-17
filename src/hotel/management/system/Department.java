
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.*;

public class Department extends JFrame implements ActionListener{
    
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;
    
    Department(){
        
        JLabel l1 = new JLabel("Department");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l1.setBounds(400,30,200,30);
    //    add(l1);
    
        
        t1 = new JTable();
        t1.setBounds(0,50,500,200);
        add(t1);
        
        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(150,400,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(350,400,120,30);
        b2.addActionListener(this);
        add(b2);
        
        JLabel l3 = new JLabel("Department");
        l3.setBounds(100,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Budget");
        l4.setBounds(300,10,100,20);
        add(l4);
        
        
        
        
        setLayout(null);
        setBounds(200,100,700,550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                String str = "select * from department";
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){}
            
        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Department().setVisible(true);
    }
    
}
