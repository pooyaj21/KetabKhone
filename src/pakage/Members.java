package pakage;

import java.util.ArrayList;

public class Members extends Data{

     ArrayList<Books> booksList = new ArrayList<>();


    public Members(String name) {
        super(name, "S-");
    }

    @Override
    public String toString() {
        String borrowed;
        String nameCapitalize = this.getName().substring(0, 1).toUpperCase() + this.getName().substring(1);
        if (booksList.isEmpty())borrowed="[-]";
        else borrowed =booksList.toString();

        return "Member name: " + nameCapitalize + "/" + borrowed;
    }
}
