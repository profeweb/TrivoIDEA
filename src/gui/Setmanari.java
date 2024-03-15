package gui;

import processing.core.PApplet;

import java.time.LocalDate;
import java.util.Calendar;

import static java.util.Calendar.YEAR;

public class Setmanari {

    // Textos representatius dels mesos
    String[] months = {"Jan","Feb","Mar","Apr","May","Jun", "Jul","Aug","Sep","Oct","Nov","Dec"};

    // Textos representatius dels dies
    String[] days = {"Sun", "Mon","Tue","Wen","Thu","Fri","Sat"};

    // Informació del calendari
    int any, mes, dia;
    int numDaysMonth, numDaysPrevMonth;
    int dayOfWeek, firstDay;

    // Data seleccionada
    boolean dateSelected = false;
    int selectedDay=0, selectedMonth=0, selectedYear=0;

    // Calendari actual, i del mes anterior
    Calendar cal, cPrev;

    // Botons del setmanari
    DayButton[] buttons;

    // Dimensions del calendari
    int x, y, w, h;


    // Constructor
    public Setmanari(int x, int y, int w, int h){

        this.buttons = new DayButton[7];

        this.cal = Calendar.getInstance();

        this.any = cal.get(YEAR);
        this.mes = cal.get(Calendar.MONTH) + 1;
        this.dia = cal.get(Calendar.DATE);

        System.out.println("AVUI: "+ this.dia+"/"+this.mes+"/"+this.any);

        this.dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println("DAY OF WEEK: "+this.dayOfWeek);

        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        this.firstDay = cal.get(Calendar.DATE);
        System.out.println("1ST DAY OF WEEK: "+this.firstDay);

        this.x = x; this.y = y; this.w = w; this.h = h;
        createCalendar(x, y, w, h);
    }

    // Getters
    public boolean isDateSelected(){
        return this.dateSelected;
    }
    public String getSelectedDate(){
        return this.selectedDay +"/"+ this.selectedMonth + "/"+ this.selectedYear;
    }


    // Setters

    public void setCalendar(int d, int m, int y){
        cal.set(YEAR, y);
        cal.set(Calendar.MONTH, m);
        cal.set(Calendar.DATE, d);
    }

    public void setPrevCalendar(int d, int m, int y){
        cPrev.set(YEAR, y);
        cPrev.set(Calendar.MONTH, m);
        cPrev.set(Calendar.DATE, d);
    }

    public void setSelectedDate(int d, int m, int y){
        this.selectedDay = d;
        this.selectedMonth = m;
        this.selectedYear = y;
    }

    // Va un mes enrera en el Calendari
    public void prevWeek(){

        this.buttons = new DayButton[7];

        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        LocalDate localDate = LocalDate.of(cal.get(YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        LocalDate yesterdayDate = localDate.minusWeeks(1);
        setCalendar(yesterdayDate.getDayOfMonth(), yesterdayDate.getMonthValue(), yesterdayDate.getYear());

        this.firstDay = yesterdayDate.getDayOfMonth();
        this.dia = yesterdayDate.getDayOfMonth();
        this.mes = yesterdayDate.getMonthValue();
        this.any = yesterdayDate.getYear();

        this.dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println("DAY OF WEEK: "+this.dayOfWeek);

        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        this.firstDay = cal.get(Calendar.DATE);
        System.out.println("1ST DAY OF WEEK: "+this.firstDay);

        createCalendar(x, y, w, h);
    }

    public void createCalendar(int x, int y, int w, int h){

        float dayWidth  = w / 7;
        float dayHeight = h;

        int day = this.firstDay;

        for(int d=0; d<7; d++){
            if(day>0 && day<=31) {
                buttons[d] = new DayButton(x + d * dayWidth, y, dayWidth, dayHeight, day, mes, any);
            }
            day++;
        }
    }

    // Va un mes endavant en el calendari
    public void nextWeek(){

        this.buttons = new DayButton[7];


        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        LocalDate localDate = LocalDate.of(cal.get(YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        LocalDate yesterdayDate = localDate.plusWeeks(1);



        this.firstDay = yesterdayDate.getDayOfMonth();
        this.dia = yesterdayDate.getDayOfMonth();
        this.mes = yesterdayDate.getMonthValue();
        this.any = yesterdayDate.getYear();

        setCalendar(this.dia, this.mes+1, this.any);

        System.out.println(dia+"/"+mes+"/"+any);

        createCalendar(x, y, w, h);
    }



    // Dibuixa el Calendari
    public void display(PApplet p5){
        p5.pushStyle();
        p5.fill(0); p5.textSize(36); p5.textAlign(p5.LEFT);
        p5.text(months[mes-1]+"/"+any, x, y - 30);
        for(DayButton b : buttons){
            if(b!=null){
                b.display(p5);
            }
        }

        if(dateSelected){
            String dateText = this.selectedDay+"/"+this.selectedMonth+"/"+this.selectedYear;
            p5.fill(0); p5.textSize(24); p5.textAlign(p5.RIGHT);
            p5.text(dateText, x+w, y - 30);
        }
        p5.popStyle();
    }


    // Comprova si pitjam sobre els botons del Calendari
   public  void checkButtons(PApplet p5){
        for(DayButton b : buttons){
            if((b!=null)&&(b.enabled)&&(b.mouseOver(p5))){
                boolean prevState = b.selected;
                deselectAll();
                b.setSelected(!prevState);
                if(b.selected){
                    dateSelected = true;
                    setSelectedDate(b.dia,b.mes,b.any);
                }
                else {
                    dateSelected = false;
                }
            }
        }
    }

    // Deselecciona tots els botons del Calendari
    public void deselectAll(){
        for(DayButton b : buttons){
            if(b!=null){
                b.setSelected(false);
            }
        }
    }
}
