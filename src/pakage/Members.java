package pakage;

import java.util.ArrayList;

public class Members {
    private String name;
    private String id;
     ArrayList<Books> booksList = new ArrayList<>();
    private static int counter;


    public Members(String name) {
        this.name = name;
        this.id = "M-" + counter;
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



    @Override
    public String toString() {
        return "Member name='" + name + "/" + booksList;
    }
}
