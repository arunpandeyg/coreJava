package ams;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewPassengers extends JFrame implements ActionListener {
    JTable t;
    String[] s = {"Username", "Name", "Age", "Date of Birth", "Address", "Phone", "Email", "Nationality", "Gender", "PassportNo"};
    String[][] y = new String[20][10];
    int i = 0, j = 0;
    Font f ;

    public ViewPassengers() throws HeadlessException {
        super("All Passengers Details");
        setSize(1300, 400);
        setLocation(0, 10);
        f = new Font("Arial", Font.BOLD, 17);
        try {
            ConnectionsClass obj = new ConnectionsClass();
            String q = "select * from passenger";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()){
                y[i][j++] = rest.getString("username");
                y[i][j++] = rest.getString("name");
                y[i][j++] = rest.getString("age");
                y[i][j++] = rest.getString("dob");
                y[i][j++] = rest.getString("address");
                y[i][j++] = rest.getString("phone");
                y[i][j++] = rest.getString("email");
                y[i][j++] = rest.getString("nationality");
                y[i][j++] = rest.getString("gender");
                y[i][j++] = rest.getString("passportNo");
                i++;
                j = 0;
            }
            t = new JTable(y, s);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        t.setFont(f);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.GREEN);

        JScrollPane js = new JScrollPane(t);

        add(js);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new ViewPassengers().setVisible(true);

    }
}
