package ams;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.Random;

public class BookFlight extends JFrame implements ActionListener {
    JButton bt1, bt2;
    JPanel jp1, jp2, jp3;
    Font f1, f2;
    Choice ch1, ch2, ch3, ch4, ch5, ch6;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
    JTextField tf1, tf2, tf3, tf4, tf5;
    public BookFlight() throws HeadlessException {
        super("Book Your Flight !!");
        setLocation(50, 10);
        setSize(1100, 650);

        f1 = new Font("Arial", Font.BOLD, 25);
        f2 = new Font("Arial", Font.BOLD, 18);

        ch1 = new Choice();
        ch2 = new Choice();
        ch3 = new Choice();
        ch4 = new Choice();
        ch5 = new Choice();
        ch6 = new Choice();
        try {
            ConnectionsClass obj = new ConnectionsClass();
            String q = "select distinct source from flight";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()){
                ch1.add(rest.getString("source"));
            }
            rest.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        try {
            ConnectionsClass obj = new ConnectionsClass();
            String q1 = "select username from passenger";
            ResultSet rest1 = obj.stm.executeQuery(q1);
            while (rest1.next()){
                ch6.add(rest1.getString("username"));
            }
            rest1.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        l1 = new JLabel("Book Your Flight Ticket !!");
        l2 = new JLabel("Ticket Id");
        l3 = new JLabel("Source");
        l4 = new JLabel("Destination");
        l5 = new JLabel("Class Name");
        l6 = new JLabel("Price");
        l7 = new JLabel("Flight Code");
        l8 = new JLabel("Flight Name");
        l9 = new JLabel("Journey Date");
        l10 = new JLabel("Journey Time");
        l11 = new JLabel("Username");
        l12 = new JLabel("Name");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();

        tf1.setEditable(false);
        tf2.setEditable(false);
        tf5.setEditable(false);

        Random  r = new Random();
        tf1.setText(" " +Math.abs(r.nextInt() * 100000));
        tf1.setForeground(Color.RED);

        bt1 = new JButton("Book Flight");
        bt2 = new JButton("Back");
        bt1.addActionListener(this);
        bt2.addActionListener(this);

        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setBackground(new java.awt.Color(240, 2, 125));
        l1.setForeground(new java.awt.Color(250, 250, 250));

        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);
        l7.setFont(f2);
        l8.setFont(f2);
        l9.setFont(f2);
        l10.setFont(f2);
        l11.setFont(f2);
        l12.setFont(f2);
        ch1.setFont(f2);
        ch2.setFont(f2);
        ch3.setFont(f2);
        ch4.setFont(f2);
        ch5.setFont(f2);
        ch6.setFont(f2);
        tf1.setFont(f2);
        tf2.setFont(f2);
        tf3.setFont(f2);
        tf4.setFont(f2);
        tf5.setFont(f2);
        bt1.setFont(f2);
        bt2.setFont(f2);
        //color
        l1.setForeground(new java.awt.Color(193, 3, 173));
        l2.setForeground(new java.awt.Color(193, 3, 173));
        l3.setForeground(new java.awt.Color(193, 3, 173));
        l4.setForeground(new java.awt.Color(193, 3, 173));
        l5.setForeground(new java.awt.Color(193, 3, 173));
        l6.setForeground(new java.awt.Color(193, 3, 173));
        l7.setForeground(new java.awt.Color(193, 3, 173));
        l8.setForeground(new java.awt.Color(193, 3, 173));
        l9.setForeground(new java.awt.Color(193, 3, 173));
        l10.setForeground(new java.awt.Color(193, 3, 173));
        l11.setForeground(new java.awt.Color(193, 3, 173));
        l12.setForeground(new java.awt.Color(193, 3, 173));
        //button
        bt1.setBackground(new java.awt.Color(173, 3, 173));
        bt1.setForeground(new java.awt.Color(100, 3, 173));
        bt2.setBackground(new java.awt.Color(203, 3, 173));
        bt2.setForeground(new java.awt.Color(150, 3, 173));
        //panels
        jp1 = new JPanel();
        jp1.setLayout(new GridLayout(1, 1, 10, 10));
        jp1.add(l1); //book your flight ticket

        jp2 = new JPanel();
        jp2.setLayout(new GridLayout(12, 2, 10, 10));
        jp2.add(l2);    //ticket id
        jp2.add(tf1);
        jp2.add(l3); //source
        jp2.add(ch1);
        jp2.add(l4); //destination
        jp2.add(ch2);
        jp2.add(l5); //class
        jp2.add(ch3);
        jp2.add(l6); //price
        jp2.add(ch4);
        jp2.add(l7); //flight code
        jp2.add(ch5);
        jp2.add(l8); //flight name
        jp2.add(tf2);
        jp2.add(l9); //journey date
        jp2.add(tf3);
        jp2.add(l10); // journey time
        jp2.add(tf4);
        jp2.add(l11); //username
        jp2.add(ch6);
        jp2.add(l12); // name
        jp2.add(tf5);
        jp2.add(bt1);  //book flight
        jp2.add(bt2); // back

        //image
        jp3 = new JPanel();
        jp3.setLayout(new GridLayout(1,1,10, 10));
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("ams/icon/3.jpg"));
        Image img1 = img.getImage().getScaledInstance(600, 470, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img1);
        l13 = new JLabel(ic1);
        jp3.add(l13);
        //layout
        setLayout(new BorderLayout(10, 10));
        add(jp1, "North");
        add(jp2, "Center");
        add(jp3, "West");

       //destination getting
        ch1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ch2.removeAll();
                try {
                    ConnectionsClass obj = new ConnectionsClass();
                    String source = ch1.getSelectedItem();
                    String q3 = "select distinct destination from flight where source = ' " +source +" ' ";
                    ResultSet rest3 = obj.stm.executeQuery(q3);
                    while (rest3.next()){
                        ch2.add(rest3.getString("destination"));
                    }
                    rest3.close();
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        //class name getting
        ch2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                ch3.removeAll();
                try {
                    ConnectionsClass obj = new ConnectionsClass();
                    String source = ch1.getSelectedItem();
                    String destination = ch2.getSelectedItem();
                    String q4 = "select class_name from flight where source = ' " + source + " ' and destination= ' " +destination +" ' ";
                    ResultSet rest4 = obj.stm.executeQuery(q4);
                    while (rest4.next()){
                        ch3.add(rest4.getString("class_name"));
                    }
                    rest4.close();
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
       //price getting
        ch3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ch4.removeAll();
                try {
                    ConnectionsClass obj = new ConnectionsClass();
                    String source = ch1.getSelectedItem();
                    String destination = ch2.getSelectedItem();
                    String classname  = ch3.getSelectedItem();
                    String q5 = "select distinct price from flight where source = ' " + source + " ' and destination= ' " +destination +" '  and class_name =' " + classname + " '  ";
                    ResultSet rest5 = obj.stm.executeQuery(q5);
                    while (rest5.next()){
                        ch4.add(rest5.getString("price"));
                    }
                    rest5.close();
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        //getting flight code
        ch4.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                ch5.removeAll();
                try {
                    ConnectionsClass obj = new ConnectionsClass();
                    String source = ch1.getSelectedItem();
                    String destination = ch2.getSelectedItem();
                    String classname  = ch3.getSelectedItem();
                    String price  = ch4.getSelectedItem();
                    String q6 = "select distinct f_code from flight where source = ' " + source + " ' and destination= ' " +destination +" '  and class_name =' " + classname + " ' and price=' " + price + " '  ";
                    ResultSet rest6 = obj.stm.executeQuery(q6);
                    while (rest6.next()){
                        ch5.add(rest6.getString("f_code"));
                    }
                    rest6.close();
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        //getting flight name
        ch5.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                try {
                    ConnectionsClass obj = new ConnectionsClass();
                    String source = ch1.getSelectedItem();
                    String destination = ch2.getSelectedItem();
                    String classname  = ch3.getSelectedItem();
                    String price  = ch4.getSelectedItem();
                    String fcode  = ch5.getSelectedItem();
                    String q7 = "select distinct f_name from flight where source = ' " + source + " ' and destination= ' " +destination +" '  and class_name =' " + classname + " ' and price=' " + price + " ' and f_code=' " + fcode + " ' ";
                    ResultSet rest7 = obj.stm.executeQuery(q7);
                    while (rest7.next()){
                        tf2.setText(rest7.getString("f_name"));
                    }
                    rest7.close();
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        //name getting
        ch6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ConnectionsClass obj = new ConnectionsClass();
                    String username = ch6.getSelectedItem();
                    String q2 = "select name from passenger where username = ' " +username +" ' ";
                    ResultSet rest2 = obj.stm.executeQuery(q2);
                    while (rest2.next()){
                        tf5.setText(rest2.getString("name"));
                    }
                    rest2.close();
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == bt1){
           String tid = tf1.getText();
           String source = ch1.getSelectedItem();
           String destination = ch2.getSelectedItem();
           String classname = ch3.getSelectedItem();
           String price = ch4.getSelectedItem();
           String fcode = ch5.getSelectedItem();
           String fname = tf2.getText();
           String jdate = tf3.getText();
           String jtime = tf4.getText();
           String username = ch6.getSelectedItem();
           String name = tf5.getText();
           String status = "success";
                   try {
                       ConnectionsClass obj = new ConnectionsClass();
                       String q8 = "insert into bookedFlight values(' " +tid+ " ',  ' " +source+ " ', ' " + destination + " ', ' " + classname + " ',  ' " + price + " ', ' " + fcode + " ', ' " + fname + " ', ' " + jdate + " ',  ' " + jtime + " ', ' " + username + " ', ' " + name + " ', ' " + status + " ')";
                       int bf = obj.stm.executeUpdate(q8);
                       if (bf == 1){
                           JOptionPane.showMessageDialog(null, "Your Flight Booked Successfully  !!");
                           this.setVisible(false);
                       }
                       else {
                           JOptionPane.showMessageDialog(null, "Please fill all details carefully !!");
                       }

                   }
                   catch (Exception ex){
                       ex.printStackTrace();
                   }
       }
       if (e.getSource() ==bt2){
           JOptionPane.showMessageDialog(null, "Are you sure to go back !!");
           this.setVisible(false);
       }

    }

    public static void main(String[] args) {
        new BookFlight().setVisible(true);

    }

}
