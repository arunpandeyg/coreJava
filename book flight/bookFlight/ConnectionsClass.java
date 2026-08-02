package bookFlight;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionsClass {
    Connection con;
    Statement stm;

    public ConnectionsClass() {
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String databaseUrl = "jdbc:mysql://localhost:3306/AMS";
            String username = "root";
            String password = "arun";
            Class.forName(driver);
            con = DriverManager.getConnection(databaseUrl, username, password);
            stm = con.createStatement();
            //System.out.println("database connected.");
        }
        catch (Exception ex){
            ex.printStackTrace();
            //System.out.println("something gone wrong!!");
        }
    }

    public static void main(String[] args) {
        new ConnectionsClass();
    }
}

