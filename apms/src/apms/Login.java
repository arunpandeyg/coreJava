package apms;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4;
    JButton bt1, bt2;
    JPasswordField pf;
    JTextField tf;
    JFrame f;
    public Login() throws HeadlessException {
        //frame
        f = new JFrame("Login Page");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(Color.white);
        f.setLayout(null);
        //layout
        l1 = new JLabel();
        l1.setBounds(0, 0, 500, 350);
        l1.setLayout(null);
        //image icon
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("apms/icon/8.jpg"));
        Image i1 = img.getImage().getScaledInstance( 500, 350, Image.SCALE_SMOOTH);
        ImageIcon img2 = new ImageIcon(i1);
        l1.setIcon(img2);

        //username
        l2 = new JLabel("Username");
        l2.setBounds(120, 120, 150, 30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l1.add(l2);
        f.add(l1);

        //login page
        l3 = new JLabel("Login Page");
        l3.setBounds(170, 25, 500, 50);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Arial", Font.BOLD, 30));
        l1.add(l3);

        //password
        l4 = new JLabel("Password");
        l4.setBounds(120, 170, 150, 30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l1.add(l4);

        //Username text field
        tf  = new JTextField();
        tf.setBounds(320, 120, 150, 30);
        l1.add(tf);

        //Password text field
        pf  = new JPasswordField();
        pf.setBounds(320, 170, 150, 30);
        l1.add(pf);

        // j button
        bt1 = new JButton("Login");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.white);
        bt1.setBounds(120, 220, 150, 40);
        l1.add(bt1);
        // j button
        bt2 = new JButton("Signup");
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.white);
        bt2.setBounds(320, 220, 150, 40);
        l1.add(bt2);

        //action listener bt1
        bt1.addActionListener(this);
        bt2.addActionListener(this);


        f.setVisible(true);
        f.setSize(500, 350);
        f.setLocation(300, 100);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == bt1){
             String username = tf.getText();
             String pass = pf.getUIClassID();
             try{
                 ConnectionsClass obj = new ConnectionsClass();
                 String q = "select * from signup where username=' " + username + " 'and password =' " +pass+" ' ";
                 ResultSet rs = obj.stm.executeQuery(q);
                 if (rs.next()){
                    // new HomePage().setVisible(true);
                     f.setVisible(false);
                 }
                 else {
                     JOptionPane.showMessageDialog(null,"You entered wrong username or password");
                     f.setVisible(false);
                     f.setVisible(true);
                 }
             }catch (Exception ex){
                 ex.printStackTrace();
             }
         }
         if (e.getSource() ==bt2){
             this.f.setVisible(false);
             //new signupMessage();
         }
    }

    public static void main(String[] args) {
        new Login();
    }

}

