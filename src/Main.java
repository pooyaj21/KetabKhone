import Menu.Menu;
import pakage.Books;
import pakage.FileManagement;
import pakage.KetabKhone;
import pakage.Members;

public class Main {
    public static void main(String[] args) {


        KetabKhone ketabKhone = KetabKhone.getInstance();


        FileManagement.readFromFile();
        Menu.mainMenu();
        System.out.println(ketabKhone);


    }
}
