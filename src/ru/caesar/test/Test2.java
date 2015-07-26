package ru.caesar.test;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
       Calendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        System.out.println(date);

        for (int i = 0; i < 7; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);


                System.out.println(new SimpleDateFormat("E").format(calendar.getTime()));

        }




    }
}
