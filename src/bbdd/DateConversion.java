package bbdd;

public class DateConversion {


    public static String formataFechaEsp(String fechaEntrada){

        String y = fechaEntrada.split("-")[0];
        String m = fechaEntrada.split("-")[1];
        String d = fechaEntrada.split("-")[2];

        return d+"/"+m+"/"+y;
    }

    public static String formataFechaEng(String fechaEntrada){

        String y = fechaEntrada.split("/")[2];
        String m = fechaEntrada.split("/")[1];
        String d = fechaEntrada.split("/")[0];

        return y+"-"+m+"-"+d;
    }

}
