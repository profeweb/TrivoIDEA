package bbdd;

import gui.Button;
import gui.Counter;
import gui.PagedTable;
import gui.TextField;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class ImportBooksDBTest extends PApplet {

    // Variable de BBDD
    DataBase db;

    public static void main(String[] args) {
        PApplet.main("bbdd.ImportBooksDBTest", args);
    }

    public void settings(){
        size(1300, 600);
        smooth(10);
    }

    public void setup(){

        // Configura els paràmetres de connexió a la BBDD
        db = new DataBase("admin", "12345", "trivio");

        // Connecta amb la BBDD
        db.connect();

        // Crea els inserts amb dades de la BBDD (CSV)
        //getEditorsInfoDataBase("books.csv");
        //getAuthorsInfoDataBase("books.csv");
        getBooksInfoDataBase("books.csv");

    }

    public void draw(){
        background(255);
        fill(0); textSize(28);

    }

    // Crea la taula Table amb les dades de la BBDD.
    public void getEditorsInfoDataBase(String dbName){

        String[] lines = loadStrings(dbName);
        ArrayList<String> editors = new ArrayList<>();
        for(String l : lines){
            String[] info = l.split(",");
            String editorName = info[11];
            if(!editors.contains(editorName)){
                editors.add(editorName);
            }
        }

        for(String editor: editors){
            // INSERT INTO `editorial` (`ideditorial`, `nombre`) VALUES ('', 'sdf');
            System.out.println("INSERT INTO editorial (ideditorial, nombre) VALUES ('', '"+editor+"'); ");
        }

    }

    public void getAuthorsInfoDataBase(String dbName){

        String[] lines = loadStrings(dbName);
        ArrayList<String> authors = new ArrayList<>();
        for(String l : lines){
            String[] info = l.split(",");
            String authorName = info[2];
            if(authorName.indexOf("/")!=-1){
                authorName = authorName.split("/")[0];
            }
            if(!authors.contains(authorName)){
                authors.add(authorName);
            }
        }

        for(String author: authors){
            System.out.println("INSERT INTO autor (idautor, nombre) VALUES ('', '"+author+"'); ");
        }

    }

    public void getBooksInfoDataBase(String dbName){
        String[] lines = loadStrings(dbName);
        for(String l : lines){
            // bookID,title,authors,average_rating,isbn,isbn13,language_code,  num_pages,ratings_count,text_reviews_count,publication_date,publisher
            String[] info = l.split(",");
            String title = info[1].replace("\'", "\\'").replace("\"", "\\\"");
            String author = info[2];
            String average = info[3];
            String isbn = info[5];
            String numpages = info[7];
            String editor = info[11];

            String idAuthor = db.getInfo("autor", "idautor", "nombre", author);
            String idEditor = db.getInfo("editorial", "ideditorial", "nombre", editor);

            // INSERT INTO `libro` (`isbn`, `titulo`, `numpags`, `valoracion`, `fechapublicacion`, `resena`, `editorial_ideditorial`, `autor_idautor`, `genero_idgenero`, `coleccion_idcolecion`, `fecha`)
            // VALUES ('11111', 'aaaa', '123', '', '', '', '2386', '0', '1', '2', '');
            String sql = "INSERT INTO libro (isbn, titulo, numpags, valoracion, fechapublicacion, resena, editorial_ideditorial, autor_idautor, genero_idegenero, coleccion_idecoleccion, fecha)";
            sql += " VALUES ('"+isbn+"', '"+title+"', '"+numpages+"', '', '', '', '"+ idEditor+"', '"+idAuthor+"', '1', '2', ''); ";
            System.out.println(sql);

        }

    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){

    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
