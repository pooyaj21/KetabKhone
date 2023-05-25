import pakage.Books;
import pakage.KetabKhone;
import pakage.Members;

public class Main {
    public static void main(String[] args) {
        KetabKhone ketabKhone = new KetabKhone();
        Members m1 = new Members("mamd");
        Members m2 = new Members("asghar");
        Members m3 = new Members("akbar");
        Members m4 = new Members("naghi");

        Books b1 = new Books("dastan1");
        Books b2 = new Books("dastan2");
        Books b3 = new Books("dastan3");
        Books b4 = new Books("dastan4");

        ketabKhone.addMember(m1);
//        ketabKhone.addMember(m2);
//        ketabKhone.addMember(m3);
//        ketabKhone.addMember(m4);

        ketabKhone.addBook(b1);
        ketabKhone.addBook(b2);
        ketabKhone.addBook(b3);
        ketabKhone.addBook(b4);

        ketabKhone.addBookToMember("mamd",b2);
        ketabKhone.addBookToMember("mamd",b4);
        System.out.println(ketabKhone);
    }
}