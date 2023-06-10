package Menu;

public class EnumTools {

    public static <T extends Enum<T>> void getAllEnumToString(Class<T> enumClass) {
        StringBuilder builder = new StringBuilder();
        T[] enumValues = enumClass.getEnumConstants();
        int counter = 1;
        for (T value : enumValues) {
            builder.append(counter).append(". ").append(value.toString()).append("\n");
            counter++;
        }
        System.out.println(builder);
    }

    public static <T extends Enum<T>> T findById(int id, Class<T> enumClass) {
        T[] enumValues = enumClass.getEnumConstants();
        for (T value : enumValues) {
            if (value.ordinal() == id) return value;
        }
        return null;
    }

    public static <T extends Enum> void makeMenu(Class<T> enumClass) {
        MenuController<T> controller = new MenuController<T>(
                new MenuCallback<T>() {
                    @Override
                    public void onMenuSelected(T t, MenuController menuController) {
                        if (t instanceof MenuCallback) ((MenuCallback<T>) t).onMenuSelected(t, menuController);
                    }
                }
        );
        controller.show(enumClass);
    }

}