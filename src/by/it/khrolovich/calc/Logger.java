package by.it.khrolovich.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;

public enum Logger {
    INSTANCE;

    //private static Logger logger;

    //объкт один - this
    synchronized void log(String message) {

        String filePath = FileNameHelper.getFilePath("log.txt", Logger.class);
        //Locale.
        Language lang = Language.INSTANCE;
        //1 способ вывода даты с временем
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.CANADA);
        Instant now = Instant.now();
        Time time = new Time(now.getNano());//время
        //DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss",lang.getLocale());
        DateFormat dtf = SimpleDateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.SHORT,lang.getLocale());

        try(PrintWriter printWriter = new PrintWriter(new FileWriter(filePath, true))) {

            //printWriter.println(df.format(new Date())+" "+time+": "+message);//1 способ
            printWriter.println(dtf.format(new Date())+": "+message);//2 способ

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}