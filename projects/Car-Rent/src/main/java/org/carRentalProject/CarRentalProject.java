package org.carRentalProject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalProject {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalProject(){
        cars = new ArrayList<Car>();
        customers = new ArrayList<Customer>();
        rentals = new ArrayList<Rental>();
    }
    //add cars
    public void addCar(Car car){
        cars.add(car);
    }
    //add customers
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    //rent cars
    public void rentCar(Car car, Customer customer, int days){
        if(car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car, customer, days));
        }else{
            System.out.println("No car available");
        }
    }
    //return car
    public void returnCar(Car car){
        car.returnCar();
        Rental rentalToRemove = null;
        for(Rental rental : rentals){
            if(rental.getCar() == car){
                rentalToRemove = rental;
                break;
            }
        }
        if(rentalToRemove != null){
            rentals.remove(rentalToRemove);
            //System.out.println("Car returned.");
        }else{
            System.out.println("Car not returned wait or Call Police");
        }
    }

    //menu
    public void menu(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("====Car Renting Project====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Returned a Car");
            System.out.println("3. Exit");
            System.out.println("Enter Your Choice");

            int choice = scanner.nextInt();
            scanner.nextLine();
            if(choice == 1){
                System.out.println("\n=== Rent a Car===");
                System.out.println("Enter Your Name");
                String customerName = scanner.nextLine();

                System.out.println("\nAvailable Cars: ");
                for(Car car : cars){
                    if(car.isAvailable()){
                        System.out.println(car.getCarId() + "-"+ car.getBrand() + "-" + car.getModel());
                    }
                }
                System.out.println("\nEnter the car Id or Model you want to rent: ");
                String carId = scanner.nextLine();

                System.out.println("Enter the Days number you want to rent car: ");
                int rentalDays = scanner.nextInt();
                scanner.nextLine();

                Customer newCustomer = new Customer("Customer"+(customers.size() + 1), customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for(Car car : cars){
                    if(car.getCarId().equals(carId) && car.isAvailable()){
                        selectedCar = car;
                        break;
                    }
                }
                if(selectedCar != null){
                    double totalPrice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("\n=== Rental information ===\n");
                    System.out.println("Customer Id: " +newCustomer.getCustomerId());
                    System.out.println("Customer Name: " + newCustomer.getCustomerName());
                    System.out.println("Car: " + selectedCar.getBrand()+ " " + selectedCar.getModel());
                    System.out.println("Rental Days: " + rentalDays);
                    System.out.println("total Price: $ " + totalPrice);   //$%.2f%n

                    System.out.println("\nConfirm Rental (Y/N): ");
                    String confirm = scanner.nextLine();

                    if(confirm.equalsIgnoreCase("Y")){
                        rentCar(selectedCar, newCustomer, rentalDays);
                        System.out.println("\nCar Rented: " + customerName);
                    }else{
                        System.out.println("\nRental Canceled");
                    }
                }else{
                    System.out.println("\nInvalid car selection or car is not available right now.");
                }
            }else if(choice == 2){
                System.out.println("\n=== Return a Car ===");
                System.out.println("Enter the Car Id you want to return");
                String carId = scanner.nextLine();

                Car carToReturn = null;
                for(Car car : cars){
                    if(car.getCarId().equals(carId) && !car.isAvailable()){
                        carToReturn = car;
                        break;
                    }
                }
                if(carToReturn != null){
                    Customer customer = null;
                    for(Rental rental : rentals){
                        if(rental.getCar() == carToReturn){
                            customer = rental.getCustomer();
                            break;
                        }
                    }
                    if(customer != null){
                        returnCar(carToReturn);
                        System.out.println("Car returned: " +customer.getCustomerName());
                    }else {
                        System.out.println("Car is not returned or rental info is missing.");
                    }
                }else{
                    System.out.println("Invalid car  id or car is not returned.");
                }
            }else if(choice == 3){
                System.out.println("Thanks for using car rantal project");
                break;
            }else{
                System.out.println("Invalid choice Please read carefully and enter right choice.");
            }
        }
        System.out.println("\n*** Thanks for using car rental project ***");
    }
}
