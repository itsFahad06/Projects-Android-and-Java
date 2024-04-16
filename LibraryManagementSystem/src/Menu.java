import Admin.Admin_Login;
import user.Login;
import user.Sign_Up;

import java.util.Scanner;

public class Menu {

    private final Scanner input = new Scanner(System.in);

    Sign_Up sup;
    Login lg;

    Admin_Login al;

    void menu ()
    {
        int choice;

        System.out.println("Welcome To Library Management System");
        System.out.println("1- Register Yourself");
        System.out.println("2- Login User");
        System.out.println("3- Admin Login");
        choice = input.nextInt();

        switch (choice){
            case 1 -> {
                sup = new Sign_Up();
                sup.Register_user();
            }
            case 2 -> {
                lg = new Login();
                lg.Login_user();
            }
            case 3 -> {
                al = new Admin_Login();
                al.Admin_login();
            }
        }
    }

}
