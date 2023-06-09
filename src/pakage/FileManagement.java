package pakage;

import java.io.*;
import java.util.ArrayList;

public class FileManagement {
    private static final KetabKhone ketabKhone = KetabKhone.getInstance();

    public static void writeForSave(ArrayList<Data> dataList) {
        try {
            BufferedWriter writerBook = new BufferedWriter(new FileWriter("InventoryBook.txt"));
            for (Data data : dataList) {
                if (data instanceof Books) {
                    writerBook.write("#BOOK");
                    writerBook.newLine();
                    writerBook.write(data.getName());
                    writerBook.newLine();
                    writerBook.write(((Books) data).getIsBorrowToString());
                    writerBook.newLine();
                    writerBook.write(((Books) data).memberBorrowedForFile());
                    writerBook.newLine();
                }
            }
            writerBook.close();
            BufferedWriter writerMember = new BufferedWriter(new FileWriter("InventoryMember.txt"));
            for (Data data : dataList) {
                if (data instanceof Members) {
                    writerMember.write("#MEMBER");
                    writerMember.newLine();
                    writerMember.write(data.getName());
                    writerMember.newLine();
                    writerMember.write(((Members) data).bookThatMemberBorrowedForFile());
                    writerMember.newLine();
                }
            }
            writerMember.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile() {
        ArrayList<String> books = new ArrayList<>();
        ArrayList<String> members = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("InventoryBook.txt"));
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                books.add(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).contains("#BOOK")) {
                Books book = new Books(books.get(i + 1));
                book.setBorrow(Boolean.parseBoolean(books.get(i + 2)));
                ketabKhone.add(book);
                System.out.println(book);
            }
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("InventoryMember.txt"));
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                members.add(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).contains("#MEMBER")) {
                ketabKhone.add(new Members(members.get(i + 1)));
            }
        }

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).contains("#MEMBER")) {
                int contLine = i + 2;
                while (!members.get(contLine).isEmpty()) {
                    ketabKhone.findMember(members.get(i + 1)).addBookTOMember(ketabKhone.findBook(members.get(contLine)));
                    contLine++;
                }
            }
        }
    }


    public static Boolean seeFileIsEmpty() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("InventorySource.txt"));
            if (reader.readLine() == null) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
