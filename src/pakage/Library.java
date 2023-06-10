package pakage;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Library {
    private static final ArrayList<Member> membersList = new ArrayList<>();
    private static final ArrayList<Book> booksList = new ArrayList<>();

    private static Library library;

    private Library() {
    }

    public static Library getInstance() {
        if (library == null) {
            library = new Library();
        }
        return library;
    }

     public  ArrayList<Member> getMembersList(){
        return membersList;
    }

    public  ArrayList<Book> getBooksList(){
        return booksList;
    }

    public void addMember(Member member) {
        membersList.add(member);
    }

    public Member getMember(Member memberName) {
        for (int i = 0; i < membersList.size(); i++) {
            if (membersList.get(i) == memberName) {
                return membersList.get(i);
            } else System.err.println(memberName + " not found!");
        }
        return null;
    }

    public Member getMember(String memberName) {
        for (int i = 0; i < membersList.size(); i++) {
            if (membersList.get(i).getName().equals(memberName)) {
                return membersList.get(i);
            }
        }
        return null;
    }

    public void editMemberName(Member member, String newMemberName) {
        for (Member members : membersList) {
            if (members == member) {
                members.setName(newMemberName);
            }
        }
    }

    public void removeMember(Member member) {
        membersList.remove(member);
    }

    public void addBook(Book book) {
        booksList.add(book);
    }

    public void removeBook(Book book) {
        booksList.remove(book);
    }

    public void barrowBook(Book book) {
        for (Book books : booksList) {
            if (books == book) {
                books.setBorrow(!books.getIsBorrow());
            }
        }
    }

    public void barrowBook(Member member, Book book, BorrowRepository borrowRepository) {
        if (!book.getIsBorrow()) {
            borrowRepository.addInformation(member, book);
            barrowBook(book);
        } else {
            throw new InputMismatchException("Book is not Available");
        }
    }

    public Book getBook(String bookName) {
        for (Book books : booksList) {
            if (books.getName().equals(bookName)) {
                return books;
            }
        }
        return null;
    }

    public Book getBook(Book book) {
        for (Book books : booksList) {
            if (books == book) return books;
        }
        return null;
    }

    public void editBookName(Book book, String newBookName) {
        for (Book books : booksList) {
            if (books == book) {
                books.setName(newBookName);
            }
        }
    }

    public String printMembers() {
        Member[] str = new Member[membersList.size()];
        String chap = "";
        if (membersList.isEmpty()) chap += "Nothing here to find\n";
        for (int i = 0; i < membersList.size(); i++) {
            str[i] = membersList.get(i);
        }

        // Printing using for each loop
        int counter = 1;
        for (Member k : str) {
            chap += String.format("%d. %s\n", counter, k);
            counter++;
        }
        return chap;
    }

    public String printBooks() {
        Book[] str = new Book[booksList.size()];
        String chap = "";
        if (booksList.isEmpty()) chap += "Nothing here to find\n";
        for (int i = 0; i < booksList.size(); i++) {
            str[i] = booksList.get(i);
        }

        // Printing using for each loop
        int counter = 1;
        for (Book k : str) {
            chap += String.format("%d. %s\n", counter, k);
            counter++;
        }
        return chap;
    }

    public boolean isBookExists(String bookName) {
        for (Book books : booksList) {
            if (books.getName().equals(bookName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isMemberExists(String memberName) {
        for (Member members : membersList) {
            if (members.getName().equals(memberName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nBooks:\n" + printBooks() + "Members:\n" + printMembers();
    }

}
