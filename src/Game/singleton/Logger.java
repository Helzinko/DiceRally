package Game.singleton;

import Game.DateFormat;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Logger {
    private static Logger logger = null;
    private PrintWriter writer;

    public static synchronized Logger getInstance() {
        if (logger == null)
            logger = new Logger();
        return logger;
    }

    private Logger() {
        try {
            String fileName = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
            FileWriter fw = new FileWriter(fileName);
            writer = new PrintWriter(fw, true);
        } catch (IOException e) {
        }
    }

    public void log(String message) {
        writer.println(DateFormat.CurrentTime() + message);
    }
}