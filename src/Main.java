import pakage.Books;
import pakage.KetabKhone;
import pakage.Members;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static KetabKhone ketabKhone = new KetabKhone();

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
                        MembersOptions();
                        break;
                    case 3:
                        listOptions();
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
                        addBook();
                        break;
                    case 2:
                        findBook();
                        break;
                    case 3:
                        editBook();
                        break;
                    case 4:
                        removeBook();
                        break;
                    case 5:
                        System.out.println(ketabKhone.printBooks());
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

    public static void MembersOptions() {
        String[] BooksOptions = {"\n1- Add a Member",
                "2- Find a Member",
                "3- Edit a Member",
                "4- Remove a Member",
                "5- Barrow a Book",
                "6- Back a Book",
                "7- List of Members",
                "8- Back to Main Manu",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 8) {
            printMenu(BooksOptions);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        addMember();
                        break;
                    case 2:
                        findMember();
                        break;
                    case 3:
                        editMember();
                        break;
                    case 4:
                        removeMember();
                        break;
                    case 5:
                        barrowBook();
                        break;
                    case 6:
                        backBook();
                        break;
                    case 7:
                        System.out.println(ketabKhone.printMembers());
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

    public static void listOptions() {
        String[] BooksOptions = {"\n1- Members list",
                "2- Books list",
                "3- Full list",
                "4- Back to Main Manu",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 4) {
            printMenu(BooksOptions);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println(ketabKhone.printMembers());
                        break;
                    case 2:
                        System.out.println(ketabKhone.printBooks());
                        break;
                    case 3:
                        System.out.println(ketabKhone);
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
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new Book name: ");
        String bookName = sc.nextLine();
        if (!ketabKhone.isBookExists(bookName)) {
            Books newBook = new Books(bookName);
            ketabKhone.addBook(newBook);
            System.out.println("\nNew Book add.\n");
        } else {
            System.err.println("\nThis Book already exist.\n");
        }
    }

    public static void findBook() {
        Scanner sc = new Scanner(System.in);
        Books chosenBook;
        System.out.print("Enter the Book you want to find: ");
        String bookName = sc.nextLine();
        if (ketabKhone.isBookExists(bookName)) {
            chosenBook = ketabKhone.getBook(bookName);
            System.out.println("\nYour Book is:" + chosenBook + "\n");
        } else {
            System.err.println("\nThis Book don't exist.\n");
        }
    }

    public static void editBook() {
        Scanner sc = new Scanner(System.in);
        Books chosenBook;
        System.out.print("Enter the Book you want to edit: ");
        String bookName = sc.nextLine();
        if (ketabKhone.isBookExists(bookName)) {
            chosenBook = ketabKhone.getBook(bookName);
            System.out.print("Enter the Book new name: ");
            String bookNewName = sc.nextLine();
            ketabKhone.editBookName(chosenBook, bookNewName);
            System.out.print("The Book has been edited.");
        } else {
            System.err.println("\nThis Book don't exist.\n");
        }
    }

    public static void removeBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Book you want to remove: ");
        String bookName = sc.nextLine();
        if (ketabKhone.isBookExists(bookName)) {
            ketabKhone.removeBook(ketabKhone.getBook(bookName));
            System.out.print("The Book removed.");
        } else {
            System.err.println("\nThis Book don't exist.\n");
        }
    }

    public static void addMember() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new Member name: ");
        String memberName = sc.nextLine();
        if (!ketabKhone.isMemberExists(memberName)) {
            Members newMember = new Members(memberName);
            ketabKhone.addMember(newMember);
            System.out.println("New Member add.");
        } else {
            System.err.println("\nThis Book already exist.\n");
        }
    }


    public static void findMember() {
        Scanner sc = new Scanner(System.in);
        Members chosenMember;
        System.out.print("Enter the Member you want to find: ");
        String memberName = sc.nextLine();
        if (ketabKhone.isMemberExists(memberName)) {
            chosenMember = ketabKhone.getMember(memberName);
            System.out.println("Your Member is:" + chosenMember);
        } else {
            System.err.println("\nThis Member don't exist.\n");
        }
    }

    public static void editMember() {
        Scanner sc = new Scanner(System.in);
        Members chosenMember;
        System.out.print("Enter the Member you want to edit: ");
        String memberName = sc.nextLine();
        if (ketabKhone.isMemberExists(memberName)) {
            chosenMember = ketabKhone.getMember(memberName);
            System.out.print("Enter the Member new name: ");
            String memberNewName = sc.nextLine();
            ketabKhone.editMemberName(chosenMember, memberNewName);
            System.out.print("The Member has been edited.");
        } else {
            System.err.println("\nThis Member don't exist.\n");
        }
    }

    public static void removeMember() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Member you want to remove: ");
        String memberName = sc.nextLine();
        if (ketabKhone.isMemberExists(memberName)) {
            ketabKhone.removeMember(ketabKhone.getMember(memberName));
            System.out.print("The Member removed.");
        } else {
            System.err.println("\nThis Member don't exist.\n");
        }
    }

    public static void barrowBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Member that want to Barrow book: ");
        String memberName = sc.nextLine();
        if (ketabKhone.isMemberExists(memberName)) {
            System.out.print("Enter the Book they want to Barrow:");
            String bookName = sc.nextLine();
            if (ketabKhone.isBookExists(bookName)) {
                System.out.println(ketabKhone.getBook(bookName) + "add to" + ketabKhone.getMember(memberName));
                ketabKhone.addBookToMember(ketabKhone.getMember(memberName), ketabKhone.getBook(bookName));
            } else {
                System.err.println("\nThis Book don't exist.\n");
            }
        } else {
            System.err.println("\nThis Member don't exist.\n");
        }
    }

    public static void backBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Member that want to Back book: ");
        String memberName = sc.nextLine();
        if (ketabKhone.isMemberExists(memberName)) {
            System.out.print(ketabKhone.getMember(memberName));
            System.out.print("Enter the Book they want to Back:");
            String bookName = sc.nextLine();
            if (ketabKhone.isBookExists(bookName)) {
                System.out.println(ketabKhone.getBook(bookName) + "get back from" + ketabKhone.getMember(memberName));
                ketabKhone.removeBookFromMember(ketabKhone.getMember(memberName), ketabKhone.getBook(bookName));
            } else {
                System.err.println("\nThis Book don't exist.\n");
            }
        } else {
            System.err.println("\nThis Member don't exist.\n");
        }
    }

}
