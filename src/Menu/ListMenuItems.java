package Menu;

import pakage.Library;

public enum ListMenuItems implements MenuCallback {
    MEMBERS_LIST(1, "Members list"),
    BOOKS_LIST(2, "Books list"),
    FULL_LIST(3, "Full list"),
    BACK_TO_MAIN_MENU( 4,"Back to Main Manu");

    private final int id;
    private final String title;



    ListMenuItems(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
    public void printItems() {
        for (ListMenuItems item : values()) {
            System.out.println(item);
        }
    }

    public static ListMenuItems findById(int id) {
        for (ListMenuItems item : values()) {
            if (item.id == id) return item;
        }
        return null;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void onMenuSelected(Enum anEnum, MenuController menuController) {
        if (anEnum != null) {
            switch ((ListMenuItems)anEnum) {
                case MEMBERS_LIST:
                    System.out.println(Library.getInstance().printMembers());
                    break;
                case BOOKS_LIST:
                    System.out.println(Library.getInstance().printBooks());
                    break;
                case FULL_LIST:
                    System.out.println(Library.getInstance());
                    break;
                case BACK_TO_MAIN_MENU:
                    EnumTools.makeMenu(MainMenuItems.class);
                    break;
            }
        }
        menuController.show(ListMenuItems.class);
    }
}
