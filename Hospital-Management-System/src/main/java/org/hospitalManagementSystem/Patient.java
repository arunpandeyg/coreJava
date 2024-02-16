package org.hospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient {
    private Connection connection;
    private Scanner scanner;

    public Patient(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }
    //add patient
    public void addPatient() throws SQLException {
        System.out.println("Enter Patient Name: ");
        String name = scanner.next();
        System.out.println("Enter Patient's age: ");
        int age = scanner.nextInt();
        System.out.println("Enter Patient's Gender: ");
        String gender = scanner.next();

        try {
            String query = "INSERT INTO patients (name, age, gender) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, String.valueOf(age));
            preparedStatement.setString(3, gender);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Patient added successfully");
            } else {
                System.out.println("Patient not added something went wrong");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        // view patients
    public void viewPatients(){
            String query = "select * from patients";
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery(query);
                System.out.println("Patients: ");
                System.out.println("+------------+-----------------+---------------+---------------");
                System.out.println("| Patient Id | Patient Name    | Patient Age   | Patient Gender");
                System.out.println("+------------+-----------------+---------------+---------------");
                while(resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String gender = resultSet.getString("gender");
                    System.out.printf("|    %-10s |    %-15s |   %-13s |    %-13s |\n",id, name, age, gender);
                    System.out.println("+------------+-----------------+---------------+---------------");
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
    }

    //geting single patient
    public boolean getPatientById(int id){
        String query = "SELECT * FROM patient WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}
