package user;

import java.util.Scanner;

public class user_menu {

    private final Scanner input = new Scanner(System.in);

    void user_menus()
    {
        int choice;

        System.out.println("1- Buy A Book ");
        System.out.println("2- See Your cart");
        System.out.println("3- Check Your Orders");
        System.out.println("3- Exit");

        choice = input.nextInt();

        switch (choice)
        {
            case 1 -> {
                Buy_a_Book bab = new Buy_a_Book();
                bab.buying_the_book();
            }
            case 2 -> {

            }
        }
    }
}
