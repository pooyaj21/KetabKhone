package pakage;

import java.util.ArrayList;
import java.util.InputMismatchException;

public final class KetabKhone {
    private static KetabKhone ketabKhone;
    private static final ArrayList<Data> dataList = new ArrayList<>();

    private KetabKhone() {
    }

    public static KetabKhone getInstance() {
        if (ketabKhone == null) {
            ketabKhone = new KetabKhone();
        }
        return ketabKhone;
    }

    public static ArrayList<Data> getDataList() {
        return dataList;
    }

    public Members getMember(Data data) {
        if (data instanceof Members) {
            for (int i = 0; i < dataList.size(); i++) {
                if (dataList.get(i) == data) {
                    return (Members) data;
                } else {
                    System.err.println(data + " not found!");
                }
            }
        }
        return null;
    }

    public Members getMember(String memberName) {
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).getName().equals(memberName)) {
                return (Members) dataList.get(i);
            }
        }
        return null;
    }

    public void editName(Data data, String newName) {
        for (Data datas : dataList) {
            if (data == datas) {
                data.setName(newName);
            }
        }
    }

    public void remove(Data data) {
        dataList.remove(data);
    }

    public void addBookToMember(Members member, Books book) {
        for (Data data : dataList) {
            if (data == member) {
                addBooksList(member, book);
                book.memberBorrowed(member.getName());
            }
        }
    }

    public void removeBookFromMember(Members member, Books book) {
        for (Data data : dataList) {
            if (data == member) {
                removeBooksList(member, book);
            }
        }
    }

    public void add(Data data) {
        dataList.add(data);
    }

    private void barrowBook(Books book) {
        for (Data data : dataList) {
            if (data == book) {
                book.setBorrow(!book.getIsBorrow());
            }
        }
    }

    private void addBooksList(Members member, Books book) {
        if (!book.getIsBorrow()) {
            member.addBookTOMember(book);
            barrowBook(book);
        }
    }

    public void removeBooksList(Members member, Books book) {
        if (book.getIsBorrow()) {
            member.removeBookTOMember(book);
            barrowBook(book);
        }
    }

    public Books getBook(String bookName) {
        for (Data data : dataList) {
            if (data instanceof Books) {
                if (data.getName().equals(bookName)) {
                    return (Books) data;
                }
            }
        }
        return null;
    }

    public Books getBook(Data data) {
        if (data instanceof Books) {
            for (Data books : dataList) {
                if (books == data) {
                    return (Books) data;
                }
            }
        }
        return null;
    }

    public void editBookName(Books book, String newBookName) {
        for (Data books : dataList) {
            if (books == book) {
                books.setName(newBookName);
            }
        }
    }

    public String printMembers() {
        ArrayList<Members> str = new ArrayList<>();
        StringBuilder chap = new StringBuilder();

        for (Data data : dataList) {
            if (data instanceof Members) {
                str.add((Members) data);
            }
        }

        // Printing using for each loop
        int counter = 1;
        for (Members k : str) {
            chap.append(String.format("%d. %s\n", counter, k));
            counter++;
        }

        if (str.isEmpty()) {
            chap = new StringBuilder("Nothing here to find\n");
        }

        return chap.toString();
    }

    public String printBooks() {
        ArrayList<Books> str = new ArrayList<>();
        StringBuilder chap = new StringBuilder();

        for (Data data : dataList) {
            if (data instanceof Books) {
                str.add((Books) data);
            }
        }

        // Printing using for each loop
        int counter = 1;
        for (Books k : str) {
            chap.append(String.format("%d. %s\n", counter, k));
            counter++;
        }

        if (str.isEmpty()) {
            chap = new StringBuilder("Nothing here to find\n");
        }

        return chap.toString();
    }

    public boolean isBookExists(String bookName) {
        for (Data books : dataList) {
            if (books instanceof Books) {
                if (books.getName().equals(bookName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isMemberExists(String memberName) {
        for (Data members : dataList) {
            if (members instanceof Members) {
                if (members.getName().equals(memberName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Members findMember(String memberName){
        for (Data data:dataList) {
            if(data instanceof Members){
                if (data.getName().equals(memberName))return (Members) data;
            }
        }return null;
    }

    public Books findBook(String bookName){
        for (Data data:dataList) {
            if(data instanceof Books){
                if (data.getName().equals(bookName))return (Books) data;
            }
        }return null;
    }

    @Override
    public String toString() {
        return "\nBooks:\n" + printBooks() + "Members:\n" + printMembers();
    }
}
