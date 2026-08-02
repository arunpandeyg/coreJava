package ams;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {
    Font f, f1, f2;
    JLabel l1, l2;

    public HomePage() throws HeadlessException {
        super("Learning Airline Home Page !!");
        setLocation(0, 0);
        setSize(1550, 600);
        f = new Font("Late", Font.BOLD, 20);
        f1 = new Font("Open Sans", Font.BOLD, 35);
        f2 = new Font("Monserrat", Font.BOLD, 18);

        //image icon
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("ams/icon/h.jpg"));
        Image im = img.getImage().getScaledInstance( 1550, 600, Image.SCALE_SMOOTH);
        ImageIcon imgh = new ImageIcon(im);
        l1 = new JLabel(imgh);
        JMenuBar m1 = new JMenuBar();
        JMenu men1 = new JMenu("Passenger Profile");
        JMenuItem menuItem = new JMenuItem("Add Passenger Profile");
        JMenuItem menuItm = new JMenuItem("View Passenger Profile");
        men1.add(menuItem);
        men1.add(menuItm);
        m1.add(men1);

        JMenu men2 = new JMenu("Manage Passengers");
        JMenuItem menuItem1 = new JMenuItem("Update Passenger Details");
        JMenuItem menuItem7 = new JMenuItem("Delete Passenger Details");
        men2.add(menuItem1);
        men2.add(menuItem7);
        m1.add(men2);

        JMenu men7 = new JMenu("Your Flight ");
        JMenuItem menuItem6 = new JMenuItem("Book Flight ");
        JMenuItem menuItm5 = new JMenuItem("View Booked Flights ");
        men7.add(menuItem6);
        men7.add(menuItm5);
        m1.add(men7);

        JMenu men3 = new JMenu("Your Flight Details");
        JMenuItem menuItem2 = new JMenuItem("Journey Details ");
        JMenuItem menuItm3 = new JMenuItem("Flight Name");
        men3.add(menuItem2);
        men3.add(menuItm3);
        m1.add(men3);

        JMenu men4 = new JMenu("Cancellation");
        JMenuItem menuItem3 = new JMenuItem("Cancel Ticket");
        JMenuItem menuItm4 = new JMenuItem("View Cancelled Tickets");
        men4.add(menuItem3);
        men4.add(menuItm4);
        m1.add(men4);

        JMenu men5 = new JMenu("Bill");
        JMenuItem menuItem4 = new JMenuItem("Check Payments");
        men5.add(menuItem4);
        m1.add(men5);

        JMenu men6 = new JMenu("Logout");
        JMenuItem menuItem5 = new JMenuItem("Exit");
        men6.setForeground(Color.red);
        men6.add(menuItem5);
        m1.add(men6);

        men1.setFont(f);
        men2.setFont(f);
        men3.setFont(f);
        men4.setFont(f);
        men5.setFont(f);
        men6.setFont(f);
        men7.setFont(f);
        menuItem.setFont(f2);
        menuItem1.setFont(f2);
        menuItem2.setFont(f2);
        menuItem3.setFont(f2);
        menuItem4.setFont(f2);
        menuItem5.setFont(f2);
        menuItem6.setFont(f2);
        menuItem7.setFont(f2);
        menuItm.setFont(f2);
        menuItm3.setFont(f2);
        menuItm4.setFont(f2);
        menuItm5.setFont(f2);
        m1.setBackground(new java.awt.Color(205, 200, 232));
        m1.setForeground(new java.awt.Color(229, 13, 101));

        menuItem.addActionListener(this);
        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);
        menuItem5.addActionListener(this);
        menuItem6.addActionListener(this);
        menuItem7.addActionListener(this);
        menuItm.addActionListener(this);
        menuItm3.addActionListener(this);
        menuItm4.addActionListener(this);
        menuItm5.addActionListener(this);



        setJMenuBar(m1);
        add(l1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String cmd = e.getActionCommand();
         if (cmd.equals("Add Passenger Profile") ){
             new AddPassengerDetails().setVisible(true);
         }
        else if(cmd.equals( "View Passenger Profile")){
             new ViewPassengers().setVisible(true);
         }
        else if (cmd.equals("Update Passenger Details") ) {
             new UpdatePassengerDetails().setVisible(true);
         }
        else if (cmd.equals("Delete Passenger Details") ){
            new DeletePassengerDetails().setVisible(true);
         }
        else if (cmd.equals( "Book Flight")){
            new BookFlight().setVisible(true);
         }
        else if (cmd.equals("View Booked Flights") ){
            new ViewAllFlights().setVisible(true);
         }
        else if (cmd .equals("Journey Details")) {
            new JourneyDetails().setVisible(true);
         }
        else if (cmd.equals("Flight Zone")) {
            new FlightZone().setVisible(true);
         }
        else if (cmd.equals("Cancel Ticket")){
            new CancelTicket().setVisible(true);
         } else if (cmd.equals("View Cancelled Tickets")) {
             new ViewCancelledTickets().setVisible(true);
         } else if (cmd.equals("Check Payments")) {
             new CheckPaymentsDetails().setVisible(true);
         } else if (cmd.equals("Exit")) {
             System.exit(0);
         }
    }

    public static void main(String[] args) {
        new HomePage().setVisible(true);
    }
}
