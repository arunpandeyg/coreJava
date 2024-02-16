package org.carRentalProject;

/**
 * Arun Pandey!
 *
 */
public class App 
{
    public static void main( String[] args ){
        CarRentalProject carRentalProject = new CarRentalProject();
        Car car1 = new Car("C001", "Toyota", "Camry", 50);
        Car car2 = new Car("C002", "Honda", "Accord", 50);
        Car car3 = new Car("C003", "Maruti", "Baleno", 20);
        Car car4 = new Car("C004", "Toyota", "Innova", 40);
        carRentalProject.addCar(car1);
        carRentalProject.addCar(car2);
        carRentalProject.addCar(car3);
        carRentalProject.addCar(car4);

        carRentalProject.menu();
    }
}
