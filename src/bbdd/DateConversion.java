package bbdd;

import java.nio.file.LinkOption;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.concurrent.atomic.LongAccumulator;

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

    public static LocalDate nextDay(LocalDate d){
        return d.plusDays(1);
    }

    public static LocalDate nextWeek(LocalDate d){
        return d.plusDays(7);
    }

    public static LocalDate nextMonth(LocalDate d){
        return d.plusDays(30);
    }

    public static ArrayList<LocalDate> getDaysBetween(LocalDate d1, LocalDate d2, int n){

        ArrayList<LocalDate> days =  new ArrayList<>();
        LocalDate di = d1;
        do{
            days.add(di);
            di = di.plusDays(n);
        }
        while(di.isBefore(d2) || di.isEqual(d2));

        return days;
    }

}
