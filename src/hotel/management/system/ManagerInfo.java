
package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

import net.proteanit.sql.*;


public class ManagerInfo extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2;
    
    ManagerInfo(){
        t1 = new JTable();
        t1.setBounds(0,40,1000,500);
        add(t1);
        
        b1 = new JButton("Load Data");
        b1.setBounds(350,560,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(530,560,120,30);
        b2.addActionListener(this);
        add(b2);
        
        
        setLayout(null);
        setBounds(200,50,1000,650);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1){
            try{
                conn c = new conn();
                String str = "select * from employee where job = 'Manager'";
                ResultSet rs = c.s.executeQuery(str);    
                
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
                
            }catch(Exception e){}
            
        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
        
    }
    
    public static void main(String[] args){
        new ManagerInfo().setVisible(true);
    }
}
