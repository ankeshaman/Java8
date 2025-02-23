package main.java.dateandtime;

//import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
public class LocalDateClass {

    LocalDate today = LocalDate.now();
   // System.out.println("printing cur Date: ");
    LocalDate yest = today.minusDays(1);

    //gives day of the month
    int day = today.getDayOfMonth();
    int month = today.getMonthValue();

}
