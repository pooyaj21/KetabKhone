package pakage;

public class Books extends Data{

    private boolean isBorrow;

    public Books(String name) {
        super(name, "T-");
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
        String nameCapitalize = this.getName().substring(0, 1).toUpperCase() + this.getName().substring(1);
        if(this.isBorrow) barrowStatus="Not Available";
        else barrowStatus = "Available";

        return "Book name: " + nameCapitalize + "/"+barrowStatus;
    }
}
