package bbdd;

public class TestDataBase {

    public static DataBase db, db2;

    public static void main(String[] args) {
        db = new DataBase("admin", "12345", "provabbdd");
        db.connect();

        // Número de clients
        int n = db.getNumFilesTaula("client");
        System.out.printf("Hi ha %d clients.\n", n);

        // Nom del client amb dni = 18224746H
        String nomClient = db.getNomClientAmbDNI("18224746H");
        System.out.println(nomClient);

        // Noms de tots els clients ordenats alfabèticament
        String[] noms = db.getNomTotsClients();
        db.printArray1D(noms);

        // Tota la informació de la taula clients
        String[][] infoClients = db.getInfoTotsClients();
        db.printArray2D(infoClients);

        // Connecta a una altra base de dades
        db2 = new DataBase("admin", "12345", "concesionari");
        db2.connect();

        // Informació de dues taules relacionades (Cotxe i Marca) amb relació 1:N
        String[][] infoCotxes = db2.getInfoCotxosSEAT();
        db2.printArray2D(infoCotxes);


    }
}
