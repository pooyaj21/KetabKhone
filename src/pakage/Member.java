package pakage;


import java.util.UUID;

public class Member {

    private String name;
    private final String id;

    public Member(String name){
        this.name = name;
        this.id = String.valueOf(UUID.randomUUID());
    }

    public Member(String name, String id) {
        this.name = name;
        this.id = id;
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
        String nameCapitalize = this.getName().substring(0, 1).toUpperCase() + this.getName().substring(1);
        return "Member name: " + nameCapitalize;
    }
}
