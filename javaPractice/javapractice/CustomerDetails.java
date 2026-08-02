package javapractice;

import java.util.Scanner;

//record keeping
public class CustomerDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first name.  ");
        String firstName = sc.nextLine();

        System.out.println("Enter your lastName.  ");
        String lastName = sc.nextLine();

        System.out.println("Enter your age");
        int age = sc.nextInt();

        System.out.println("Enter your Phone number  ");
        long phoneNumber = sc.nextLong();

        System.out.println("Enter your gender  ");
        String gender = sc.nextLine();

        System.out.println("Hailing from  ");
        String  city = sc.nextLine();


        System.out.println("Welcome " +"Name  "+ firstName+" " + lastName + "\n"+"Age  " +age+"\n"+"Phone number  "+phoneNumber + "\n"+"Gender  "+gender + "\n"+"Residence  " + city);
    }
}
