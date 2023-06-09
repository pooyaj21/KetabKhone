package Menu;
public enum BookMenuItems {
    ADD_A_BOOK(1, "Add a Book"),
    FIND_A_BOOK(2, "Find a Book"),
    EDIT_A_BOOK(3, "Edit a Book"),
    REMOVE_A_BOOK(4, "Remove a Book"),
    BOOK_CARD(5, "Book card"),
    LIST_OF_BOOKS(6, "List of Books"),
    BACK_TO_MAIN_MENU(7, "Back to Main Manu");

    private final int id;
    private final String title;


    BookMenuItems(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return id + "." + title;
    }

    public void printItems() {
        for (BookMenuItems item : values()) {
            System.out.println(item);
        }
    }

    public static BookMenuItems findById(int id) {
        for (BookMenuItems item : values()) {
            if (item.id == id) return item;
        }
        return null;
    }

    public String getTitle() {
        return title;
    }
}

