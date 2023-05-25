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
        for (int i = 0; i < membersList.size(); i++) {
            if (membersList.get(i).getName().equals(memberName)) {
                chosenMember = membersList.get(i);
                return chosenMember;
            }
        }
        return null;
    }
    public void editMemberName(String memberName, String newMemberName) {
        for (int i = 0; i < membersList.size(); i++) {
            if (membersList.get(i).getName().equals(memberName)) {
                membersList.get(i).setName(newMemberName);
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
    public void addBookToMember(String memberName,Books book) {
        Members chosenMember;
        for (int i = 0; i < membersList.size(); i++) {
            if (membersList.get(i).getName().equals(memberName)) {
                chosenMember = membersList.get(i);
                addBooksList(chosenMember,book);
                membersList.remove(i);
                membersList.add(chosenMember);
            }
        }
    }

    public void addBook(Books book) {
        booksList.add(book);
    }
    public void barrowBook(String bookName) {
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getName().equals(bookName)) {
                booksList.get(i).setBorrow(!booksList.get(i).getIsBorrow());
            }
        }
    }
    public void barrowBook(Books bookName) {
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i)==bookName) {
                booksList.get(i).setBorrow(!booksList.get(i).getIsBorrow());
            }
        }
    }
    public void addBooksList(Members member,Books book) {
        member.booksList.add(book);
        barrowBook(book);
    }
    public Books getBook(String bookName) {
        Books chosenBook;
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getName().equals(bookName)) {
                chosenBook = booksList.get(i);
                return chosenBook;
            }
        }
        return null;
    }
    public void editBookName(String bookName, String newBookName) {
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getName().equals(bookName)) {
                booksList.get(i).setName(newBookName);
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
        return membersList.toString();
    }
}
