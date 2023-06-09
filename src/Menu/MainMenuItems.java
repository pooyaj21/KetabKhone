package Menu;

public enum MainMenuItems {
    BOOKS(1, "Books"),
    MEMBERS(2, "Members"),
    LISTS(3, "Lists"),
    SAVE( 4,"Save");

    private final int id;
    private final String title;



    MainMenuItems(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return id + "." + title;
    }
    public void printItems() {
        for (MainMenuItems item : values()) {
            System.out.println(item);
        }
    }

    public static MainMenuItems findById(int id) {
        for (MainMenuItems item : values()) {
            if (item.id == id) return item;
        }
        return null;
    }

    public String getTitle() {
        return title;
    }
}
