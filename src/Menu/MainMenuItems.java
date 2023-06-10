package Menu;

import pakage.BorrowRepository;
import pakage.FileManagement;
import pakage.Library;

public enum MainMenuItems implements MenuCallback{
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
        return title;
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

    @Override
    public void onMenuSelected(Enum anEnum, MenuController menuController) {
        if (anEnum != null) {
            switch ((MainMenuItems)anEnum) {
                case BOOKS:
                    EnumTools.makeMenu(BookMenuItems.class);
                    break;
                case MEMBERS:
                    EnumTools.makeMenu(MemberMenuItems.class);
                    break;
                case LISTS:
                    EnumTools.makeMenu(ListMenuItems.class);
                    break;
                case SAVE:
                    FileManagement.writeForSave(Library.getInstance().getBooksList(),Library.getInstance().getMembersList(),
                            BorrowRepository.getInstance());
                    break;
            }
        }
        menuController.show(MainMenuItems.class);
    }
}
