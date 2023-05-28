package pakage;

import java.util.ArrayList;

public class KetabKhone {
    private static ArrayList<Members> membersList = new ArrayList<>();
    private static ArrayList<Books> booksList = new ArrayList<>();

    public void addMember(Members member) {
        membersList.add(member);
    }

    public Members getMember(Members memberName) {
        for (int i = 0; i < membersList.size(); i++) {
            if (membersList.get(i) == memberName) {
                return membersList.get(i);
            } else System.err.println(memberName + " not found!");
        }
        return null;
    }

    public Members getMember(String memberName) {
        for (int i = 0; i < membersList.size(); i++) {
            if (membersList.get(i).getName().equals(memberName)) {
                return membersList.get(i);
            }
        }
        return null;
    }

    public void editMemberName(Members member, String newMemberName) {
        for (Members members : membersList) {
            if (members == member) {
                members.setName(newMemberName);
            }
        }
    }

    public void deleteMember(Members member) {
        membersList.remove(member);
    }

    public void addBookToMember(Members member, Books book) {
        for (Members members : membersList) {
            if (members == member) {
                addBooksList(members, book);
            }
        }
    }

    public void removeBookFromMember(Members member, Books book) {
        for (Members members : membersList) {
            if (members == member) {
                removeBooksList(members, book);
            }
        }
    }
    public void addBook(Books book) {
        booksList.add(book);
    }


    public void barrowBook(Books book) {
        for (Books books : booksList) {
            if (books == book) {
                books.setBorrow(!books.getIsBorrow());
            }
        }
    }

    public void addBooksList(Members member, Books book) {
        if (!book.getIsBorrow()) {
            member.booksList.add(book);
            barrowBook(book);
        }
    }
    public void removeBooksList(Members member, Books book) {
        if (book.getIsBorrow()) {
            member.booksList.remove(book);
            barrowBook(book);
        }
    }



    public Books getBook(String bookName) {
        for (Books books : booksList) {
            if (books.getName().equals(bookName)) {
                return books;
            }
        }
        return null;
    }

    public Books getBook(Books book) {
        for (Books books : booksList) {
            if (books == book) return books;
        }
        return null;
    }

    public void editBookName(Books book, String newBookName) {
        for (Books books : booksList) {
            if (books==book) {
                books.setName(newBookName);
            }
        }
    }

    public void deleteBook(Books book) {
      booksList.remove(book);
    }

    public String printMembers(){
        Members[] str = new Members[membersList.size()];
        String chap = "";
        if (membersList.isEmpty())chap+="Nothing here to find\n";
        for (int i = 0; i < membersList.size(); i++) {
            str[i] = membersList.get(i);
        }

        // Printing using for each loop
        int counter = 1;
        for (Members k : str) {
            chap += String.format("%d. %s\n", counter, k);
            counter++;
        }
        return chap;
    }

    public String printBooks(){
        Books[] str = new Books[booksList.size()];
        String chap = "";
        if (booksList.isEmpty())chap+="Nothing here to find\n";
        for (int i = 0; i < booksList.size(); i++) {
            str[i] = booksList.get(i);
        }

        // Printing using for each loop
        int counter = 1;
        for (Books k : str) {
            chap += String.format("%d. %s\n", counter, k);
            counter++;
        }
        return chap;
    }


    @Override
    public String toString() {
        return  "Books:\n"+printBooks()+"Members:\n"+printMembers();
    }
}
