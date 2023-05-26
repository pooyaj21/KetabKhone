package pakage;

import java.util.ArrayList;

public class KetabKhone {
    private static ArrayList<Members> membersList = new ArrayList<>();
    private static ArrayList<Books> booksList = new ArrayList<>();


    public void addMember(Members member) {
        membersList.add(member);
    }

    public Members getMember(String memberName) {
        Members chosenMember;
        for (Members members : membersList) {
            if (members.getName().equals(memberName)) {
                chosenMember = members;
                return chosenMember;
            }
        }
        return null;
    }

    public void editMemberName(String memberName, String newMemberName) {
        for (Members members : membersList) {
            if (members.getName().equals(memberName)) {
                members.setName(newMemberName);
            }
        }
    }

    public void deleteMember(String memberName) {
        for (int i = 0; i < membersList.size(); i++) {
            if (membersList.get(i).getName().equals(memberName)) {
                membersList.remove(i);
            }
        }
    }

    public void addBookToMember(String memberName, Books book) {
        for (Members members : membersList) {
            if (members.getName().equals(memberName)) {
                addBooksList(members, book);
            }
        }
    }

    public void addBook(Books book) {
        booksList.add(book);
    }

    public void barrowBook(String bookName) {
        for (Books books : booksList) {
            if (books.getName().equals(bookName)) {
                books.setBorrow(!books.getIsBorrow());
            }
        }
    }

    public void barrowBook(Books bookName) {
        for (Books books : booksList) {
            if (books == bookName) {
                books.setBorrow(!books.getIsBorrow());
            }
        }
    }

    public void addBooksList(Members member, Books book) {
        member.booksList.add(book);
        barrowBook(book);
    }

    public Books getBook(String bookName) {
        Books chosenBook;
        for (Books books : booksList) {
            if (books.getName().equals(bookName)) {
                chosenBook = books;
                return chosenBook;
            }
        }
        return null;
    }

    public void editBookName(String bookName, String newBookName) {
        for (Books books : booksList) {
            if (books.getName().equals(bookName)) {
                books.setName(newBookName);
            }
        }
    }

    public void deleteBook(String bookName) {
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getName().equals(bookName)) {
                booksList.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        Members[] str = new Members[membersList.size()];
        String chap = "";
        for (int i = 0; i < membersList.size(); i++) {
            str[i] = membersList.get(i);
        }

        // Printing using for each loop
        int counter = 1;
        for (Members k : str) {
            chap += String.format("%d. %s\n", counter, k);
            counter++;
        }
        return chap;
    }
}
