import Menu.EnumTools;
import Menu.MainMenuItems;
import pakage.BorrowRepository;
import pakage.FileManagement;

public class Main {

    public static void main(String[] args) {
        FileManagement.readFromFile(BorrowRepository.getInstance());
        EnumTools.makeMenu(MainMenuItems.class);
    }
}