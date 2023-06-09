package pakage;

import java.util.ArrayList;

public class Members extends Data {

    private ArrayList<Books> booksList = new ArrayList<>();

    public Members(String name) {
        super(name, "M-");
    }

    public ArrayList<Books> getBooksList() {
        return booksList;
    }

    public void addBookTOMember(Books book){
        booksList.add(book);
    }

    public void removeBookTOMember(Books book){
        booksList.remove(book);
    }

    public String bookThatMemberBorrowedToString() {
        String print = "";
        if (booksList.isEmpty()) print += "";
        else {
            for (Books name : booksList) {
                print += name.getName() + "/";
            }
        }
        return print;
    }

    public String bookThatMemberBorrowedForFile() {
        String print = "";
        if (booksList.isEmpty()) print += "";
        else {
            for (Books name : booksList) {
                print += name.getName() + "\n";
            }
        }
        return print;
    }

    public String MemberShipCard() {
        String borrowed;
        String nameCapitalize = this.getName().substring(0, 1).toUpperCase() + this.getName().substring(1);
        if (booksList.isEmpty()) borrowed = "[-]";
        else borrowed = booksList.toString();
        return nameCapitalize + "\t" + "\t" + "\t" + this.getId() + "\n\n\n" + borrowed;
    }

    @Override
    public String toString() {
        String borrowed;
        String nameCapitalize = this.getName().substring(0, 1).toUpperCase() + this.getName().substring(1);
        if (booksList.isEmpty()) borrowed = "[-]";
        else borrowed = booksList.toString();

        return "Member name: " + nameCapitalize + "/" + borrowed;
    }
}
