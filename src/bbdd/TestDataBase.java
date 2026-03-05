package bbdd;

public class TestDataBase {

    public static DataBase db;

    public static void main(String[] args) {
        db = new DataBase("admin", "12345", "provabbdd");
        db.connect();

        String s = db.getInfo("client", "nom", "dni", "18224746H");
        System.out.println(s);

        int n = db.getNumFilesTaula("client");
        System.out.println(n);

        String[] noms = db.getInfoArray("client", "nom");
        for(int i=0; i<noms.length; i++){
            System.out.println(noms[i]);
        }
    }
}
