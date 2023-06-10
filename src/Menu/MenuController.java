package Menu;

import java.util.Scanner;

public class MenuController<T extends Enum> {

    private final Scanner scanner = new Scanner(System.in);
    private final MenuCallback menuCallback;

    private static final String SEPERATOR =
            "********************************************************\n" +
                    "\t\t\t\t\t %s\n" +
                    "********************************************************\n";

    public MenuController(MenuCallback menuCallback) {
        this.menuCallback = menuCallback;
    }

    public void show(Class<T> enumClass) {
        // Print Menu Items
        System.out.printf(SEPERATOR, enumClass.getCanonicalName());
        EnumTools.getAllEnumToString(enumClass);
        // Ask for an ID
        System.out.println("-------------------------");
        System.out.print("Enter a menu id: ");
        String input = scanner.nextLine();
        // Validate input
        if (input.matches("[0-9]+")) {
            // Convert input to an integer
            int id = Integer.parseInt(input);
            // Find equivalent menu item
            T menuItem =(T) EnumTools.findById(id-1,enumClass);
            // Print Separator
            if (menuItem != null) {
                System.out.printf(SEPERATOR,enumClass.getName());
            }
            // Invoke Callback
            menuCallback.onMenuSelected(menuItem, this);
        } else {
            // Invoke Callback
            menuCallback.onMenuSelected(null, this);
        }
    }
}






