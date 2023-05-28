package pakage;

public class Data {
    private String name;
    private final String id;
    private static int counter;

    public Data(String name, String id) {
        this.name = name;
        this.id = id+counter;
        counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
