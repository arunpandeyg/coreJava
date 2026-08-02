package ams;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CheckPaymentsDetails extends JFrame implements ActionListener {
    JTextField textField;
    JTable table;
    JLabel sector, flightCode, capacity, classCode, className, label;

    public CheckPaymentsDetails() throws HeadlessException {
        initialise();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args) {
        new CheckPaymentsDetails().setVisible(true);
    }
    private void initialise(){
        setTitle("Payment Details");
        getContentPane().setBackground(Color.white);
        setSize(970, 600);
        setLayout(null);

        JLabel fcode = new JLabel("Username");
        fcode.setFont(new Font("Arial", Font.BOLD, 16));
        fcode.setBounds(190, 140, 150, 24);
        add(fcode);
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 14));
        textField.setBounds(300, 140, 150, 24);
        add(textField);

        table = new JTable();
        table.setBounds(93, 297, 744, 150);
        add(table);

        JButton show = new JButton( "Show");
        show.setFont(new Font("Arial", Font.BOLD, 14));
        show.setBackground(Color.BLACK);
        show.setForeground(Color.RED);
        show.setBounds(600, 140, 150, 24);
        add(show);
       sector = new JLabel("Check Payment Details !!");
       sector.setForeground(Color.BLACK);
       sector.setFont(new Font("Arial", Font.BOLD, 33));
       sector.setBounds(291, 17, 850, 39);
       add(sector);
        flightCode = new JLabel("Ticket Id");
        flightCode.setFont(new Font("Arial", Font.BOLD, 14));
        flightCode.setBounds(117, 262, 100, 26);
        flightCode.setForeground(Color.BLACK);
        add(flightCode);
        capacity = new JLabel("price");
        capacity.setFont(new Font("Arial", Font.BOLD, 14));
        capacity.setBounds(257, 262, 100, 26);
        add(capacity);
        classCode = new JLabel("Journey Date");
        classCode.setFont(new Font("Arial", Font.BOLD, 14));
        classCode.setBounds(355, 262, 101, 26);
        add(classCode);
        className = new JLabel("Journey Time");
        className.setFont(new Font("Arial", Font.BOLD, 14));
        className.setBounds(490, 262, 101, 26);
        add(className);

        JLabel user  = new JLabel("Username");
        user.setFont(new Font("Arial", Font.BOLD, 14));
        user.setBounds(625, 262, 101, 26);
        add(user);
        JLabel status = new JLabel("Status");
        status.setFont(new Font("Arial", Font.BOLD, 14));
        status.setBounds(752, 262, 100, 26);
        add(status);
        label = new JLabel("");
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("ams/icon/5.jpg"));
        Image img1 = img.getImage().getScaledInstance(970, 600, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img1);
        label.setIcon(ic1);
        label.setBounds(0, 0, 970, 600);
        add(label);
        setVisible(true);
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String use = textField.getText();
                    String success = textField.getText();
                    ConnectionsClass obj = new ConnectionsClass();
                    String st = "select tid, price journey_date, journey_time, username, status from bookedflight where username=' "+use+" ' and status=' "+success+" ' ";
                    ResultSet rt = obj.stm.executeQuery(st);
                    table.setModel(DbUtils.resultSetToTableModel(rt));
                    table.setFont(new Font("Arial", Font.BOLD, 14));

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        //setSize(970, 600);
        setLocation(100, 40);
        setVisible(true);
    }


}
