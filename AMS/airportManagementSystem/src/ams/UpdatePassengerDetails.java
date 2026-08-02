package ams;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdatePassengerDetails extends JFrame implements ActionListener {

    Font f1, f2;
    Choice ch;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JButton bt1, bt2;
    JPanel jp1, jp2, jp3;
    JTextField tf1, tf2, tf3, tf4, tf5,tf6, tf7, tf8, tf9,tf10;
    public UpdatePassengerDetails() throws HeadlessException {
          super("Update Passenger");
          setLocation(450, 10);
          setSize(740, 600);

          f1 = new Font("Arial", Font.BOLD, 25);
          f2 = new Font("Arial", Font.BOLD, 18);
          ch = new Choice();
          //db connection
        try {
            ConnectionsClass obj = new ConnectionsClass();
            String q = "select username from passenger";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()){
                ch.add(rest.getString("username"));
            }
            rest.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        //labels
        l1 = new JLabel("Update Passengers Details !!");
        l2 = new JLabel("Username");
        l3 = new JLabel("Name");
        l4 = new JLabel("Age");
        l5 = new JLabel("Date of Birth");
        l6 = new JLabel("Address");
        l7 = new JLabel("Phone");
        l8 = new JLabel("Email");
        l9 = new JLabel("Nationality");
        l10 = new JLabel("Gender");
        l11 = new JLabel("Passport No");

        //text field
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();
        tf9 = new JTextField();
        tf10 = new  JTextField();
       //buttons
        bt1 = new JButton("Update Passengers");
        bt2 = new JButton("Back");
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        //label l1
        l1.setHorizontalAlignment(JLabel.CENTER);

        //panel 1
        jp1 = new JPanel();
        jp1.setLayout(new GridLayout(1, 1, 10, 10));
        jp1.add(l1);

        //panel 2
        jp2 = new JPanel();
        jp2.setLayout(new GridLayout(11, 2, 10, 10));
        jp2.add(l2);
        jp2.add(ch);
        jp2.add(l3);
        jp2.add(tf1);
        jp2.add(l4);
        jp2.add(tf2);
        jp2.add(l5);
        jp2.add(tf3);
        jp2.add(l6);
        jp2.add(tf4);
        jp2.add(l7);
        jp2.add(tf5);
        jp2.add(l8);
        jp2.add(tf6);
        jp2.add(l9);
        jp2.add(tf7);
        jp2.add(l10);
        jp2.add(tf9);
        jp2.add(l11);
        jp2.add(tf10);
        jp2.add(bt1);
        jp2.add(bt2);
        //panel 3
        //image
        jp3 = new JPanel();
        jp3.setLayout(new GridLayout(1,1,10, 10));
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("ams/icon/10.jpg"));
        Image img1 = img.getImage().getScaledInstance(300, 500, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img1);
        l12 = new JLabel(ic1);
        jp3.add(l12);

        //layout
        setLayout(new BorderLayout(10, 10));
        add(jp1, "North");
        add(jp2, "Center");
        add(jp3, "West");

        //action
        ch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ConnectionsClass obj2 = new ConnectionsClass();
                    String username = ch.getSelectedItem();
                    String q1 = "select * from passenger where username=' " +username + " ' ";
                    ResultSet rest1 = obj2.stm.executeQuery(q1);
                    while (rest1.next()){
                        tf1.setText(rest1.getString("name"));
                        tf2.setText(rest1.getString("age"));
                        tf3.setText(rest1.getString("dob"));
                        tf4.setText(rest1.getString("address"));
                        tf5.setText(rest1.getString("phone"));
                        tf6.setText(rest1.getString("email"));
                        tf7.setText(rest1.getString("nationality"));
                        tf8.setText(rest1.getString("gender"));
                        tf9.setText(rest1.getString("passportNo"));
                    }
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
            String username = ch.getSelectedItem();
            String name = tf1.getText();
            String age = tf2.getText();
            String dob = tf3.getText();
            String address = tf4.getText();
            String phone = tf5.getText();
            String email = tf6.getText();
            String nationality = tf7.getText();
            String gender = tf8.getText();
            String passportNo = tf9.getText();
            try {
            ConnectionsClass obj3 = new ConnectionsClass();
            String q3 ="update passenger set name=' "+name+" ', age= ' "+age+" ' , dob= ' "+dob+" ', address=' "+address+" ', phone=' "+phone+" ', email=' "+email+" ', nationality=' "+nationality+" ', gender=' "+gender+" ', passportNo=' "+passportNo+" '  where username=' "+username+" ' ";
            int a = obj3.stm.executeUpdate(q3);
            if (a == 1){
                JOptionPane.showMessageDialog(null, "Your data successfully updated !!");
                this.setVisible(false);
                new  ViewPassengers().setVisible(true);
            }
                else {
                    JOptionPane.showMessageDialog(null, "Please, fill all fields carefully!!");
            }
            }
            catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == bt2){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdatePassengerDetails().setVisible(true);
    }
}
