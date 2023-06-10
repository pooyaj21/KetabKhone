package pakage;

import java.util.HashMap;

public class BorrowRepository {

    private static BorrowRepository borrowRepository;

    private static final HashMap<String, String> libraryRepositoryWithId = new HashMap<>();
    private static final HashMap<String, String> libraryRepositoryWithName = new HashMap<>();

    private BorrowRepository() {
    }

    public static BorrowRepository getInstance() {
        if (borrowRepository == null) {
            borrowRepository = new BorrowRepository();
        }
        return borrowRepository;
    }

    public void addInformation(Member member, Book book) {
        libraryRepositoryWithId.put(member.getId(), book.getId());
        libraryRepositoryWithName.put(member.getName(),book.getName());
    }


    public  String searchWithId(String id) {
        return libraryRepositoryWithId.get(id);
    }
    public  String searchWithName(String name) {
        return libraryRepositoryWithName.get(name);
    }


    public  HashMap<String,String> getRepositoryWithId(){
        return libraryRepositoryWithId;
    }
    public  HashMap<String,String> getRepositoryWithName(){
        return libraryRepositoryWithName;
    }

}
