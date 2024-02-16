package org.hospitalManagementSystem;

import java.sql.*;
import java.util.Scanner;


public class App {
    private static final String url = "jdbc:mysql://localhost:3306/hms";
    private static final String username = "root";
    private static final String password = "arun";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Patient patient = new Patient(connection, scanner);
            Doctors doctors = new Doctors(connection);
            while (true) {
                System.out.println("HOSPITAL MANAGEMENT SYSTEM");
                System.out.println("1. Add Patients");
                System.out.println("2. View Patients ");
                System.out.println("3. View Doctors");
                System.out.println("4. Book Appointment");
                System.out.println("5. Exit");
                System.out.println("Enter Your Choice");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        //add patients
                        patient.addPatient();
                        System.out.println();
                        break;
                    case 2:
                        //view patients
                        patient.viewPatients();
                        System.out.println();
                        break;
                    case 3:
                        //view Doctors
                        doctors.viewDoctors();
                        System.out.println();
                        break;
                    case 4:
                        //book appointment
                        bookAppointment(patient, doctors, connection, scanner);
                        System.out.println();
                        break;

                    case 5:
                        //exit
                        System.out.println("Thanks for using Hospital Management System.");
                        return;
                    default:
                        System.out.println("Enter valid choice");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //book appointment
    public static void bookAppointment(Patient patient, Doctors doctors, Connection connection, Scanner scanner) {
        System.out.println("Enter Patient's Id : ");
        int patientId = scanner.nextInt();
        System.out.println("Enter Doctor's Id : ");
        int doctorId = scanner.nextInt();
        System.out.println("Enter Appointment date (dd-mm-yyyy): ");
        String appointmentDate = scanner.next();
        if (patient.getPatientById(patientId) && doctors.getDoctorById(doctorId)) {
            if (checkDoctorAvailability(doctorId, appointmentDate, connection)) {
                String appointmentQuery = "INSERT INTO appointments (patient_id, doctorId, appointment_date) VALUES(?, ?, ?)";
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(appointmentQuery);
                    preparedStatement.setInt(1, patientId);
                    preparedStatement.setInt(2, doctorId);
                    preparedStatement.setString(3, appointmentDate);
                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Appointment booked date: " + appointmentDate);
                    } else {
                        System.out.println("Appointment date not available, Please try next date.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Doctor not available on this date. Please try again.");
            }
        } else {
            System.out.println("Either Patient or doctor in not available.");
        }

    }

    //check doctor available or not available
    public static boolean checkDoctorAvailability(int doctorId, String appointmentDate, Connection connection) {
        String query = "SELECT count(*) FROM appointments WHERE doctor_id = ? AND appointment_date = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, doctorId);
            preparedStatement.setString(2, appointmentDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count == 0) {
                    System.out.println("Doctor is available.");
                    ;
                } else {
                    System.out.println("Doctor in not available.");
                    ;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
