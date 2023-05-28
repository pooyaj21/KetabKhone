import pakage.Books;
import pakage.KetabKhone;
import pakage.Members;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    KetabKhone ketabKhone = new KetabKhone();

    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public static void main(String[] args) {

        String[] MainOptions = {"\n1- Books",
                "2- Members",
                "3- Lists",
                "4- Exit",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 4) {
            printMenu(MainOptions);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        BooksOptions();
                        break;
                    case 2:
                        System.out.println(2);
                        break;
                    case 3:
                        System.out.println(3);
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + MainOptions.length);
                scanner.next();
            } catch (Exception ex) {
                System.out.println("An unexpected error happened. Please try again");
            }
        }
    }

    public static void BooksOptions() {
        String[] BooksOptions = {"\n1- Add a Book",
                "2- Find a Book",
                "3- Edit a Book",
                "4- Remove a Book",
                "5- List of Books",
                "6- Back to Main Manu",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 6) {
            printMenu(BooksOptions);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println(1);
                        break;
                    case 2:
                        System.out.println(2);
                        break;
                    case 3:
                        System.out.println(3);
                        break;
                    case 4:
                        System.out.println(4);
                        break;
                    case 5:
                        System.out.println(5);
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + BooksOptions.length);
                scanner.next();
            } catch (Exception ex) {
                System.out.println("An unexpected error happened. Please try again");
            }
        }
    }

    public static void addBook() {
        KetabKhone ketabKhone=new KetabKhone();
        Books newBook;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your new Book name: ");


    }
}
