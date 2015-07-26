package ru.caesar.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test2 {
    public static void main(String[] args) {

       Calendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        System.out.println(date);

        for (int i = 0; i < 25; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            if (new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Вс")){
                System.out.println(calendar.getTime());
            }

        }




    }
}
