package pakage;

import java.util.ArrayList;

public class Books extends Data {

    private boolean isBorrow;
    ArrayList<String> membersBorrowed = new ArrayList<>();

    public Books(String name) {
        super(name, "B-");
    }

    void setBorrow(boolean borrow) {
        isBorrow = borrow;
    }

    public boolean getIsBorrow() {
        return isBorrow;
    }

    void memberBorrowed(String memberName) {
        this.membersBorrowed.add(memberName);
    }

    private String memberBorrowedToString() {
        String print = "";
        if (membersBorrowed.isEmpty()) print += "";
        else {
            for (String name : membersBorrowed) {
                print += name + "/";
            }
        }
        return print;
    }

    public String bookCard() {
        String barrowStatus;
        String nameCapitalize = this.getName().substring(0, 1).toUpperCase() + this.getName().substring(1);
        if (this.isBorrow) barrowStatus = "Not Available";
        else barrowStatus = "Available";
        return nameCapitalize + "\t" + "\t" + "\t" + this.getId() + "\n" + barrowStatus + "\n\n" + memberBorrowedToString();
    }

    @Override
    public String toString() {
        String barrowStatus;
        String nameCapitalize = this.getName().substring(0, 1).toUpperCase() + this.getName().substring(1);
        if (this.isBorrow) barrowStatus = "Not Available";
        else barrowStatus = "Available";

        return "Book name: " + nameCapitalize + "/" + barrowStatus;
    }
}
