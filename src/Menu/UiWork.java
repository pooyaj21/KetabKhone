package Menu;

import pakage.Book;
import pakage.BorrowRepository;
import pakage.Library;
import pakage.Member;

import java.util.Scanner;

public class UiWork {
    static Library library = Library.getInstance();

    public static void addBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new Book name: ");
        String bookName = sc.nextLine();
        if (!library.isBookExists(bookName)) {
            Book newBook = new Book(bookName);
            library.addBook(newBook);
            System.out.println("\nNew Book add.\n");
        } else {
            System.err.println("\nThis Book already exist.\n");
        }
    }

    public static void findBook() {
        Scanner sc = new Scanner(System.in);
        Book chosenBook;
        System.out.print("Enter the Book you want to find: ");
        String bookName = sc.nextLine();
        if (library.isBookExists(bookName)) {
            chosenBook = library.getBook(bookName);
            System.out.println("\nYour Book is:" + chosenBook + "\n");
        } else {
            System.err.println("\nThis Book don't exist.\n");
        }
    }

    public static void editBook() {
        Scanner sc = new Scanner(System.in);
        Book chosenBook;
        System.out.print("Enter the Book you want to edit: ");
        String bookName = sc.nextLine();
        if (library.isBookExists(bookName)) {
            chosenBook = library.getBook(bookName);
            System.out.print("Enter the Book new name: ");
            String bookNewName = sc.nextLine();
            library.editBookName(chosenBook, bookNewName);
            System.out.print("The Book has been edited.");
        } else {
            System.err.println("\nThis Book don't exist.\n");
        }
    }

    public static void removeBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Book you want to remove: ");
        String bookName = sc.nextLine();
        if (library.isBookExists(bookName)) {
            library.removeBook(library.getBook(bookName));
            System.out.print("The Book removed.");
        } else {
            System.err.println("\nThis Book don't exist.\n");
        }
    }

    public static void bookCard() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Book you want the Card for: ");
        String bookName = sc.nextLine();
        if (library.isBookExists(bookName)) {
            System.out.print(bookCard(library.getBook(bookName),BorrowRepository.getInstance()));
        } else {
            System.err.println("\nThis Book don't exist.\n");
        }
    }

    public static void addMember() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new Member name: ");
        String memberName = sc.nextLine();
        if (!library.isMemberExists(memberName)) {
            library.addMember(new Member(memberName));
            System.out.println("New Member add.");
        } else {
            System.err.println("\nThis Book already exist.\n");
        }
    }

    public static void findMember() {
        Scanner sc = new Scanner(System.in);
        Member chosenMember;
        System.out.print("Enter the Member you want to find: ");
        String memberName = sc.nextLine();
        if (library.isMemberExists(memberName)) {
            chosenMember = library.getMember(memberName);
            System.out.println("Your Member is:" + chosenMember);
        } else {
            System.err.println("\nThis Member don't exist.\n");
        }
    }

    public static void editMember() {
        Scanner sc = new Scanner(System.in);
        Member chosenMember;
        System.out.print("Enter the Member you want to edit: ");
        String memberName = sc.nextLine();
        if (library.isMemberExists(memberName)) {
            chosenMember = library.getMember(memberName);
            System.out.print("Enter the Member new name: ");
            String memberNewName = sc.nextLine();
            library.editMemberName(chosenMember, memberNewName);
            System.out.print("The Member has been edited.");
        } else {
            System.err.println("\nThis Member don't exist.\n");
        }
    }

    public static void removeMember() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Member you want to remove: ");
        String memberName = sc.nextLine();
        if (library.isMemberExists(memberName)) {
            library.removeMember(library.getMember(memberName));
            System.out.print("The Member removed.");
        } else {
            System.err.println("\nThis Member don't exist.\n");
        }
    }

    public static void barrowBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Member that want to Barrow book: ");
        String memberName = sc.nextLine();
        if (library.isMemberExists(memberName)) {
            System.out.print("Enter the Book they want to Barrow:");
            String bookName = sc.nextLine();
            if (library.isBookExists(bookName)) {
                if (!library.getBook(bookName).getIsBorrow()) {
                    System.out.println(library.getBook(bookName) + "add to" + library.getMember(memberName));
                    library.barrowBook(library.getMember(memberName), library.getBook(bookName), BorrowRepository.getInstance());
                } else System.err.print("\nThis Book is not Available\n");
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
        if (library.isMemberExists(memberName)) {
            System.out.print(library.getMember(memberName));
            System.out.print("Enter the Book they want to Back:");
            String bookName = sc.nextLine();
            if (library.isBookExists(bookName)) {
                System.out.println(library.getBook(bookName) + "get back from" + library.getMember(memberName));
                library.barrowBook(library.getBook(bookName));
            } else {
                System.err.println("\nThis Book don't exist.\n");
            }
        } else {
            System.err.println("\nThis Member don't exist.\n");
        }
    }

    public static void memberCard() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Member you want the Card for: ");
        String memberName = sc.nextLine();
        if (library.isMemberExists(memberName)) {
            System.out.print(MemberShipCard(library.getMember(memberName), BorrowRepository.getInstance()));
        } else {
            System.err.println("\nThis Book don't exist.\n");
        }
    }

    public static StringBuilder MemberShipCard(Member member, BorrowRepository borrowRepository) {
        StringBuilder builder = new StringBuilder();
        String nameCapitalize = member.getName().substring(0, 1).toUpperCase() + member.getName().substring(1);
        builder.append(nameCapitalize).append("\t\t\t").append(member.getId())
                .append("\n\n\n").append("Last Book There borrow").append(borrowRepository.searchWithName(member.getName())).append("\n");
        return builder;
    }

    public static StringBuilder bookCard(Book book, BorrowRepository borrowRepository) {
        StringBuilder builder = new StringBuilder();
        String barrowStatus;
        String nameCapitalize = book.getName().substring(0, 1).toUpperCase() + book.getName().substring(1);
        if (book.getIsBorrow()) barrowStatus = "Not Available";
        else barrowStatus = "Available";
        builder.append(nameCapitalize).append("\t\t\t").append(book.getId())
                .append("\n").append(barrowStatus).append("\n\n").append("Last Person that borrow").append(borrowRepository.searchWithName(book.getName())).append("\n");
        return builder;
    }
}
