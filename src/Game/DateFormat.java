package Game;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

    // 2021.03.24.16.34.26
    public static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    // 2021-03-24T16:44:39.083+08:00
    public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    // 2021-03-24 16:48:05
    public static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String CurrentTime(){

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        return "[" + DateFormat.sdf3.format(timestamp) + "] ";
    }
}
