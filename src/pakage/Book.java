package pakage;

import java.util.UUID;

public class Book {

    private String name;
    private final String id;
    private boolean isBorrow;

    public Book(String name) {
        this.name = name;
        this.id = String.valueOf(UUID.randomUUID());
    }

    public Book(String name, String id, boolean isBorrow) {
        this.name = name;
        this.id = id;
        this.isBorrow = isBorrow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public boolean isBorrow() {
        return isBorrow;
    }

    void setBorrow(boolean borrow) {
        isBorrow = borrow;
    }

    public boolean getIsBorrow() {
        return isBorrow;
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
