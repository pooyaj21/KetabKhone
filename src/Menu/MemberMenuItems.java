package Menu;
import pakage.Library;

public enum MemberMenuItems implements MenuCallback{
    ADD_A_MEMBER(1, "Add a Member"),
    FIND_A_MEMBER(2, "Find a Member"),
    EDIT_A_MEMBER(3, "Edit a Member"),
    REMOVE_A_MEMBER(4, "Remove a Member"),
    BARROW_A_BOOK(5, "Barrow a Book"),
    BACK_A_BOOK(6, "Back a Book"),
    MemberShip_CARD(7, "MemberShip card"),
    LIST_OF_MEMBERS(8, "List of Member"),
    BACK_TO_MAIN_MENU(9, "Back to Main Manu");

    private final int id;
    private final String title;


    MemberMenuItems(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
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

    @Override
    public void onMenuSelected(Enum anEnum, MenuController menuController) {
        if (anEnum != null) {
            switch ((MemberMenuItems)anEnum) {
                case ADD_A_MEMBER:
                    UiWork.addMember();
                    break;
                case FIND_A_MEMBER:
                    UiWork.findMember();
                    break;
                case EDIT_A_MEMBER:
                    UiWork.editMember();
                    break;
                case REMOVE_A_MEMBER:
                    UiWork.removeMember();
                    break;
                case BARROW_A_BOOK:
                    UiWork.barrowBook();
                    break;
                case BACK_A_BOOK:
                    UiWork.backBook();
                    break;
                case MemberShip_CARD:
                    UiWork.memberCard();
                    break;
                case LIST_OF_MEMBERS:
                    System.out.println(Library.getInstance().printMembers());
                    break;
                case BACK_TO_MAIN_MENU:
                    EnumTools.makeMenu(MainMenuItems.class);
                    break;
            }
        }
        menuController.show(MemberMenuItems.class);
    }
}
