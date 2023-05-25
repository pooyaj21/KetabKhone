package pakage;

public class Books {
    private String name;
    private String id;
    private boolean isBorrow;
    private static int counter;


    public Books(String name) {
        this.name = name;
        this.id = "B-"+counter;
        counter++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setBorrow(boolean borrow) {
        isBorrow = borrow;
    }

    public boolean getIsBorrow() {
        return isBorrow;
    }

    @Override
    public String toString() {
        String barrowStatus;
        if(this.isBorrow) barrowStatus="Not Available";
        else barrowStatus = "Available";

        return "Book name=" + name + "/"+barrowStatus;
    }
}
