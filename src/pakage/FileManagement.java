package pakage;

import java.io.*;
import java.util.ArrayList;

public class FileManagement {
    private static final Library library = Library.getInstance();

    public static void writeForSave(ArrayList<Book> bookList, ArrayList<Member> memberList,BorrowRepository borrowRepository) {
        try {
            BufferedWriter writerBook = new BufferedWriter(new FileWriter("InventoryBook.txt"));
            for (Book book : bookList) {
                writerBook.write(book.getName());
                writerBook.newLine();
                writerBook.write(book.getId());
                writerBook.newLine();
                writerBook.write(String.valueOf(book.getIsBorrow()));
                writerBook.newLine();
            }
            writerBook.close();
            BufferedWriter writerMember = new BufferedWriter(new FileWriter("InventoryMember.txt"));
            for (Member member : memberList) {
                writerMember.write(member.getName());
                writerMember.newLine();
                writerMember.write(member.getId());
                writerMember.newLine();
            }
            writerMember.close();
            BufferedWriter writerRepositoryId = new BufferedWriter(new FileWriter("repositoryId.txt"));
            for (String objectName : borrowRepository.getRepositoryWithId().keySet()) {
                writerRepositoryId.write(objectName);
                writerRepositoryId.newLine();
                writerRepositoryId.write(borrowRepository.getRepositoryWithId().get(objectName));
                writerRepositoryId.newLine();
            }
            writerRepositoryId.close();
            BufferedWriter writerRepositoryName = new BufferedWriter(new FileWriter("repositoryName.txt"));
            for (String objectName : borrowRepository.getRepositoryWithName().keySet()) {
                writerRepositoryName.write(objectName);
                writerRepositoryName.newLine();
                writerRepositoryName.write(borrowRepository.getRepositoryWithName().get(objectName));
                writerRepositoryName.newLine();
            }
            writerRepositoryName.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile(BorrowRepository borrowRepository) {
        ArrayList<String> books = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("InventoryBook.txt"));
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                books.add(readLine);
            }reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < books.size(); i=i+3) {
                library.addBook(new Book(books.get(i),books.get(i+1)
                        ,Boolean.parseBoolean(books.get(i + 2))));
        }

        ArrayList<String> members = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("InventoryMember.txt"));
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                members.add(readLine);
            }reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < members.size(); i=i+2) {
            Library.getInstance().addMember(new Member(members.get(i),members.get(i+1)));
        }

        ArrayList<String> repositoryId = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("repositoryId.txt"));
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                repositoryId.add(readLine);
            }reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < repositoryId.size(); i=i+2) {
            borrowRepository.getRepositoryWithId().put(repositoryId.get(i),repositoryId.get(i+1));
        }

        ArrayList<String> repositoryName = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("repositoryName.txt"));
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                repositoryName.add(readLine);
            }reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < repositoryName.size(); i=i+2) {
            borrowRepository.getRepositoryWithName().put(repositoryName.get(i),repositoryName.get(i+1));
        }

    }



}
