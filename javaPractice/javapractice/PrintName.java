package javapractice;

import java.util.Scanner;

public class PrintName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your First name : ");
        String  firstName = sc.nextLine();
        System.out.println("Enter your last name:  ");
        String lastName = sc.nextLine();
        System.out.println("so your Full name is : " + firstName+" "+ lastName);
    }
}
