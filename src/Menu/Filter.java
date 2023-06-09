package Menu;

public class Filter {
    public static <T extends Enum<T>> void getAllEnumToString(Class<T> enumClass) {
        StringBuilder builder = new StringBuilder();
        T[] enumValues = enumClass.getEnumConstants();
        for (T value : enumValues) {
            builder.append(value.toString()).append("\n");
        }
        System.out.println(builder);
    }



    public static <T extends Enum<T>> T findById(int id,Class<T> enumClass) {
        T[] enumValues = enumClass.getEnumConstants();
        for (T value : enumValues) {
            if (value.ordinal()==id) return value;
        }
        return null;
    }
}
