package ams;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class JourneyDetails extends JFrame implements ActionListener {

    JFrame f;
    JLabel l1, l2, l3;
    JButton bt1, bt2;
    Choice ch1, ch2;
    Font f1;
    public JourneyDetails() throws HeadlessException {
        f = new JFrame("View Flight Details!!");
        f.setBackground(Color.GREEN);
        f.setLayout(null);
        //image
        l1 = new JLabel();
        l1.setBounds(0, 0,800, 370);
        l1.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("ams/icon/4.jpg"));
        Image img1 = img.getImage().getScaledInstance(700, 370, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img1);
        l1.setIcon(ic1);
        l2 = new JLabel("Source");
        l2.setVisible(true);
        l2.setBounds(90, 60, 150, 30);
        l2.setForeground(Color.BLACK);
        f1= new Font("Arial", Font.BOLD, 20);
        l2.setFont(f1);
        l1.add(l2);
        f.add(l1);
        l3 = new JLabel("Destination");
        l3.setVisible(true);
        l3.setLayout(null);
        l3.setBounds(90, 120, 150, 30);
        l3.setForeground(Color.BLACK);
        l3.setFont(f1);
        l1.add(l3);
        ch1 = new Choice();
        ch1.setBounds(240, 60, 150, 25);
        try {
            ConnectionsClass obj = new ConnectionsClass();
            //String username = ch1.getSelectedItem();
            String q = "select distinct source from bookedFlight ";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()){
                ch1.add(rest.getString("source"));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        ch2 = new Choice();
        ch2.setBounds(240, 120, 150, 25);
        try {
            ConnectionsClass obj = new ConnectionsClass();
            //String username = ch2.getSelectedItem();
            String q1 = "select distinct destination from bookedFlight ";
            ResultSet rest1 = obj.stm.executeQuery(q1);
            while (rest1.next()){
                ch2.add(rest1.getString("destination"));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        l1.add(ch1);
        l1.add(ch2);
        ch1.setFont(f1);
        ch2.setFont(f1);
        bt1 = new JButton("Search");
        bt1.setBounds(140, 165, 100, 30);
        bt1.addActionListener(this);
        l1.add(bt1);
        bt2 = new JButton("Close");
        bt2.setBounds(260, 165, 100, 30);
        bt2.addActionListener(this);
        bt2.setBackground(Color.RED);
        bt2.setForeground(Color.white);
        l1.add(bt2);
        f.setSize(500, 270);
        f.setLocation(450, 250);
        f.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource()==bt2){
          f.setVisible(false);
          /*new HomePage().setVisible(true);*/
      }
      if (e.getSource() == bt1){
          f.setVisible(false);
          new FlightJourneyDetails(ch1.getSelectedItem(), ch2.getSelectedItem()).setVisible(true);
      }
    }

    public static void main(String[] args) {
        new JourneyDetails().setVisible(true);
    }
}
