package Admin;

import java.util.Scanner;

public class Admin_Menu {
    private final Scanner input = new Scanner(System.in);

    Delete_user du;
    Update_a_Book uab;
    Update_A_User uau;
    Add_a_new_Book ada;
    Delete_a_Book dab;
    Search_a_book sab;
    Search_all_books sa_books;
    Search_all_users sau;
    Add_a_new_Admin aan;
    void menu ()
    {
        while (true) {

            int choice;
            System.out.println("Welcome To Admin Panel");
            System.out.println("1- Search All Users");
            System.out.println("2- Delete An Existing User");
            System.out.println("3- Update An Existing User");
            System.out.println("4- Add A New Book To Inventory");
            System.out.println("5- Update An Existing Book");
            System.out.println("6- Delete An Existing Book");
            System.out.println("7- Search An Existing Book");
            System.out.println("8- Show All Books in Inventory");
            System.out.println("9- Add An Admin");
            System.out.println("10- Exit ");
            choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    sau = new Search_all_users();
                    sau.Search_all_user();
                }
                case 2 -> {
                    du = new Delete_user();
                    du.Delete_a_user();
                }
                case 3 -> {
                    uau = new Update_A_User();
                    uau.updateUsername();
                }
                case 4 -> {
                    ada = new Add_a_new_Book();
                    ada.add_a_book();
                }
                case 5 -> {
                    uab = new Update_a_Book();
                    uab.updating_book();
                }
                case 6 -> {
                    dab = new Delete_a_Book();
                    dab.Delete_Book();
                }
                case 7 -> {
                    sab = new Search_a_book();
                    sab.Search_Book();
                }
                case 8 -> {
                    sa_books = new Search_all_books();
                    sa_books.Search_all_Book();
                }
                case 9 -> {
                    aan = new Add_a_new_Admin();
                    aan.adding_a_admin();
                }
                case 10 -> System.exit(0);
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }
}
