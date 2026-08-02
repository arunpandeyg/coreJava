package ams;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;


public class FlightZone extends JFrame implements ActionListener {
    private  JTable table;
    private JTextField tx;
    Choice ch;
    public FlightZone() throws HeadlessException {
        getContentPane().setBackground(new java.awt.Color(77, 157, 227));
        getContentPane().setFont(new Font("Arial", Font.BOLD, 18));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(960, 623);
        setLayout(null);
        setVisible(true);
        JLabel flightDetails = new JLabel("Flight Information");
        flightDetails.setFont(new Font("Arial", Font.BOLD, 32));
        flightDetails.setBounds(340, 20, 570, 35);
        flightDetails.setForeground(new Color(15, 11, 17));
        add(flightDetails);
        JLabel flightCode = new JLabel("Flight Code");
        flightCode.setFont(new Font("Arial", Font.BOLD, 18));
        flightCode.setBounds(100, 100, 150, 30);
        flightCode.setForeground(new Color(15, 11, 17));
        add(flightCode);

        JButton bt = new JButton("Show Details");
        bt.setFont(new Font("Arial", Font.BOLD, 20));
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String code = ch.getSelectedItem();
                    ConnectionsClass ob = new ConnectionsClass();
                    String q = "select from flight values f_code =' " + code +" ' ";
                    ResultSet res = ob.stm.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(res));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        bt.setBounds(550, 100, 220, 30);
        add(bt);
        //table
        table = new JTable();
        table.setBackground(Color.white);
        table.setBounds(23, 250, 800, 300 );
        table.setFont(new Font("Arial", Font.BOLD, 14));
        add(table);
        ch = new Choice();
        ch.setBounds(250, 100, 200, 30);
        ch.setFont(new Font("Arial", Font.BOLD, 18));
        try {
            ConnectionsClass obj = new ConnectionsClass();
            String q = "select distinct f_code from flight ";
            ResultSet res = obj.stm.executeQuery(q);
            while (res.next()){
                ch.add(res.getString("f_code"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        add(ch);

        JLabel flightC = new JLabel("Flight Code");
        flightC.setFont(new Font("Arial", Font.BOLD, 14));
        flightC.setBounds(33, 220, 126, 16);
        flightC.setForeground(new Color(15, 11, 17));
        add(flightC);
        JLabel flightName = new JLabel("Flight Name");
        flightName.setFont(new Font("Arial", Font.BOLD, 14));
        flightName.setBounds(155, 220, 120, 16);
        flightName.setForeground(new Color(15, 11, 17));
        add(flightName);
        JLabel source = new JLabel("Source");
        source.setFont(new Font("Arial", Font.BOLD, 14));
        source.setBounds(275, 220, 104, 16);
        source.setForeground(new Color(15, 11, 17));
        add(source);
        JLabel destination = new JLabel("Destination");
        destination.setFont(new Font("Arial", Font.BOLD, 14));
        destination.setBounds(370, 220, 120, 16);
        destination.setForeground(new Color(15, 11, 17));
        add(destination);
        JLabel capacity = new JLabel("Capacity");
        capacity.setFont(new Font("Arial", Font.BOLD, 14));
        capacity.setBounds(497, 220, 111, 16);
        capacity.setForeground(new Color(15, 11, 17));
        add(capacity);
        JLabel className = new JLabel("Class Name");
        className.setFont(new Font("Arial", Font.BOLD, 14));
        className.setBounds(610, 220, 120, 16);
        className.setForeground(new Color(15, 11, 17));
        add(className);
        JLabel price = new JLabel("Price");
        price.setFont(new Font("Arial", Font.BOLD, 14));
        price.setBounds(750, 220, 126, 16);
        price.setForeground(new Color(15, 11, 17));
        add(price);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 650);
        setVisible(true);
        setLocation(100, 50);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new FlightZone().setVisible(true);
    }
}
