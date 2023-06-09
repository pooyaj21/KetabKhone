package Menu;
public enum MemberMenuItems {
    ADD_A_MEMBER(1, "Add a Member"),
    FIND_A_MEMBER(2, "Find a Member"),
    EDIT_A_MEMBER(3, "Edit a Member"),
    REMOVE_A_MEMBER(4, "Remove a Member"),
    MemberShip_CARD(5, "Book Member"),
    LIST_OF_MEMBERS(6, "List of Member"),
    BACK_TO_MAIN_MENU(7, "Back to Main Manu");

    private final int id;
    private final String title;


    MemberMenuItems(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return id + "." + title;
    }

    public void printItems() {
        for (MemberMenuItems item : values()) {
            System.out.println(item);
        }
    }

    public static MemberMenuItems findById(int id) {
        for (MemberMenuItems item : values()) {
            if (item.id == id) return item;
        }
        return null;
    }

    public String getTitle() {
        return title;
    }
}
