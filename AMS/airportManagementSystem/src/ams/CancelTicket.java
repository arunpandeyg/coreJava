package ams;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class CancelTicket extends JFrame implements ActionListener {
    JButton bt1, bt2;
    JPanel jp1, jp2, jp3;
    Font f1, f2;
    Choice ch1;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11;
    public CancelTicket() throws HeadlessException {
        super("Cancel Your Flight !!");
        setLocation(50, 10);
        setSize(1100, 650);
        //fonts
        f1 = new Font("Arial", Font.BOLD, 25);
        f2 = new Font("Arial", Font.BOLD, 18);
        ch1 = new Choice();
        ch1.setForeground(Color.RED);
        try {
            ConnectionsClass obj = new ConnectionsClass();
            String q = "select distinct tid from bookedflight where status= 'success'  ";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()){
                ch1.add(rest.getString("tid"));
            }
            rest.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        //labels
        l1 = new JLabel("Cancel Your Flight Ticket !!");
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
        l14 = new JLabel("Reason");
        //text fields
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();
        tf9 = new JTextField();
        tf10 = new JTextField();
        tf11 = new JTextField();
        //text fields disabled
        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
        tf5.setEditable(false);
        tf6.setEditable(false);
        tf7.setEditable(false);
        tf8.setEditable(false);
        tf9.setEditable(false);
        tf10.setEditable(false);
        //buttons
        bt1 = new JButton("Cancel Flight");
        bt2 = new JButton("Back");
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        //l1 heading
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setBackground(new java.awt.Color(240, 2, 125));
        l1.setForeground(new java.awt.Color(176, 4, 21));
        //set fonts
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
        l14.setFont(f2);
        ch1.setFont(f2);
        tf1.setFont(f2);
        tf2.setFont(f2);
        tf3.setFont(f2);
        tf4.setFont(f2);
        tf5.setFont(f2);
        tf6.setFont(f2);
        tf7.setFont(f2);
        tf8.setFont(f2);
        tf9.setFont(f2);
        tf10.setFont(f2);
        tf11.setFont(f2);
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
        l14.setForeground(new java.awt.Color(193, 3, 173));
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
        jp2.setLayout(new GridLayout(13, 2, 10, 10));
        jp2.add(l2);    //ticket id
        jp2.add(ch1);
        jp2.add(l3); //source
        jp2.add(tf1);
        jp2.add(l4); //destination
        jp2.add(tf2);
        jp2.add(l5); //class
        jp2.add(tf3);
        jp2.add(l6); //price
        jp2.add(tf4);
        jp2.add(l7); //flight code
        jp2.add(tf5);
        jp2.add(l8); //flight name
        jp2.add(tf6);
        jp2.add(l9); //journey date
        jp2.add(tf7);
        jp2.add(l10); // journey time
        jp2.add(tf8);
        jp2.add(l11); //username
        jp2.add(tf9);
        jp2.add(l12); // name
        jp2.add(tf10);
        jp2.add(l14);
        jp2.add(tf11);
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
        //mouse Listener
        ch1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                try {
                    ConnectionsClass obj1 = new ConnectionsClass();
                    String tId = ch1.getSelectedItem();
                    String q2 = "select * from bookedflight where tId = ' " +tId +" ' ";
                    ResultSet rest1 = obj1.stm.executeQuery(q2);
                    while (rest1.next()){
                        tf1.setText(rest1.getString("source"));
                        tf2.setText(rest1.getString("destination"));
                        tf3.setText(rest1.getString("class_came"));
                        tf4.setText(rest1.getString("price"));
                        tf5.setText(rest1.getString("fcode"));
                        tf6.setText(rest1.getString("fname"));
                        tf7.setText(rest1.getString("jdate"));
                        tf8.setText(rest1.getString("jtime"));
                        tf9.setText(rest1.getString("username"));
                        tf10.setText(rest1.getString("name"));
                    }
                    rest1.close();
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
            String tid = ch1.getSelectedItem();
            String source = tf1.getText();
            String destination = tf2.getText();
            String classname = tf3.getText();
            String price = tf4.getText();
            String fcode = tf4.getText();
            String fname = tf6.getText();
            String jdate = tf7.getText();
            String jtime = tf8.getText();
            String username = tf9.getText();
            String name = tf10.getText();
            String reason = tf11.getText();
            String status = "cancelled";
            try {
                ConnectionsClass obj2 = new ConnectionsClass();
                String q3 = "insert into cancelflight values(' " +tid+ " ',  ' " +source+ " ', ' " + destination + " ', ' " + classname + " ',  ' " + price + " ', ' " + fcode + " ', ' " + fname + " ', ' " + jdate + " ',  ' " + jtime + " ', ' " + username + " ', ' " + name + " ', ' " + reason + " ')";
                String q4 = "update bookedflight set status=' " +status+ " ' where tid=' " +tid+ " ' " ;
                int a = obj2.stm.executeUpdate(q3);
                if (a ==1){
                    JOptionPane.showMessageDialog(null, "Your flight successfully cancelled !!");
                    int aa = obj2.stm.executeUpdate(q4);
                    this.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "Please fill all details carefully !!");
                }
                ResultSet rest1 = obj2.stm.executeQuery(q3);
                ResultSet rest2 = obj2.stm.executeQuery(q4);

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        if (e.getSource()==bt2){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CancelTicket().setVisible(true);
    }
}
