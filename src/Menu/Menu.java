package Menu;

import pakage.Books;
import pakage.FileManagement;
import pakage.KetabKhone;
import pakage.Members;

import java.util.Scanner;

public class Menu {

    static KetabKhone ketabKhone =KetabKhone.getInstance();
    public static void mainMenu() {
        MenuController<MainMenuItems> controller = new MenuController<MainMenuItems>(
                new MenuCallback<MainMenuItems>() {
                    @Override
                    public void onMenuSelected(
                            MainMenuItems menuItem,
                            MenuController menuController
                    ) {
                        if (menuItem != null) {
                            switch (menuItem) {
                                case BOOKS:
                                    booksMenu();
                                    break;
                                case MEMBERS:
                                    MembersMenu();
                                    break;
                                case LISTS:
                                    listMenu();
                                    break;
                                case SAVE:
                                    FileManagement.writeForSave(KetabKhone.getDataList());
                                    break;
                            }
                        }

                    }
                }
        );
        controller.show(MainMenuItems.class);

    }

    public static void booksMenu() {
        MenuController<BookMenuItems> controller = new MenuController<BookMenuItems>(
                new MenuCallback<BookMenuItems>() {
                    @Override
                    public void onMenuSelected(
                            BookMenuItems menuItem,
                            MenuController menuController
                    ) {
                        if (menuItem != null) {
                            switch (menuItem) {
                                case ADD_A_BOOK:
                                    addBook();
                                    break;
                                case FIND_A_BOOK:
                                    findBook();
                                    break;
                                case EDIT_A_BOOK:
                                    editBook();
                                    break;
                                case REMOVE_A_BOOK:
                                    removeBook();
                                    break;
                                case BOOK_CARD:
                                    bookCard();
                                    break;
                                case LIST_OF_BOOKS:
                                    System.out.println(KetabKhone.getInstance().printBooks());
                                    break;
                                case BACK_TO_MAIN_MENU:
                                    mainMenu();
                                    break;
                            }
                        }
                    }
                }
        );
        controller.show(BookMenuItems.class);

    }

    public static void MembersMenu() {
        MenuController<MemberMenuItems> controller = new MenuController<MemberMenuItems>(
                new MenuCallback<MemberMenuItems>() {
                    @Override
                    public void onMenuSelected(
                            MemberMenuItems menuItem,
                            MenuController menuController
                    ) {
                        if (menuItem != null) {
                            switch (menuItem) {
                                case ADD_A_MEMBER:
                                    addMember();
                                    break;
                                case FIND_A_MEMBER:
                                    findMember();
                                    break;
                                case EDIT_A_MEMBER:
                                    editMember();
                                    break;
                                case REMOVE_A_MEMBER:
                                    removeMember();
                                    break;
                                case MemberShip_CARD:
                                    memberCard();
                                    break;
                                case LIST_OF_MEMBERS:
                                    System.out.println(ketabKhone.printMembers());
                                    break;
                                case BACK_TO_MAIN_MENU:
                                    mainMenu();
                                    break;
                            }
                        }
                        menuController.show(MemberMenuItems.class);
                    }
                }
        );
        controller.show(MemberMenuItems.class);

    }

    public static void listMenu() {
        MenuController<ListMenuItems> controller = new MenuController<ListMenuItems>(
                new MenuCallback<ListMenuItems>() {
                    @Override
                    public void onMenuSelected(
                            ListMenuItems menuItem,
                            MenuController menuController
                    ) {
                        if (menuItem != null) {
                            switch (menuItem) {
                                case MEMBERS_LIST:
                                    System.out.println(ketabKhone.printMembers());
                                    break;
                                case BOOKS_LIST:
                                    System.out.println(ketabKhone.printBooks());
                                    break;
                                case FULL_LIST:
                                    System.out.println(ketabKhone);
                                    break;
                                case BACK_TO_MAIN_MENU:
                                    mainMenu();
                                    break;
                            }
                        }
                        menuController.show(ListMenuItems.class);
                    }
                }
        );
        controller.show(ListMenuItems.class);

    }

    public static void addBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new Book name: ");
        String bookName = sc.nextLine();
        if (!ketabKhone.isBookExists(bookName)) {
            Books newBook = new Books(bookName);
            ketabKhone.add(newBook);
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
            ketabKhone.remove(ketabKhone.getBook(bookName));
            System.out.print("The Book removed.");
        } else {
            System.err.println("\nThis Book don't exist.\n");
        }
    }

    public static void bookCard() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Book you want the Card for: ");
        String bookName = sc.nextLine();
        if (ketabKhone.isBookExists(bookName)) {
            System.out.print(ketabKhone.getBook(bookName).bookCard());
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
            ketabKhone.add(newMember);
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
            ketabKhone.editName(chosenMember, memberNewName);
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
            ketabKhone.remove(ketabKhone.getMember(memberName));
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
                if (!ketabKhone.getBook(bookName).getIsBorrow()) {
                    System.out.println(ketabKhone.getBook(bookName) + "add to" + ketabKhone.getMember(memberName));
                    ketabKhone.addBookToMember(ketabKhone.getMember(memberName), ketabKhone.getBook(bookName));
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

    public static void memberCard() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Member you want the Card for: ");
        String memberName = sc.nextLine();
        if (ketabKhone.isMemberExists(memberName)) {
            System.out.print(ketabKhone.getMember(memberName).MemberShipCard());
        } else {
            System.err.println("\nThis Book don't exist.\n");
        }
    }
}
