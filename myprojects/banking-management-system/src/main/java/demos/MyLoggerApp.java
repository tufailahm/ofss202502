package demos;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MyLoggerApp {

    private static final Logger logger = Logger.getLogger(MyLoggerApp.class.getName());

    public static void main(String[] args) {
        LogManager lm = LogManager.getLogManager();
        Enumeration<String> nameEnum = lm.getLoggerNames();
        while (nameEnum.hasMoreElements()) {
            String loggerName = nameEnum.nextElement();
            Logger lgr = Logger.getLogger(loggerName);
            System.out.println(lgr.getName());
        }

        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not load logging properties file: " + e.getMessage());
        }

        logger.info("This is an INFO message.");
        logger.warning("This is a WARNING message.");
        logger.severe("This is a SEVERE message.");
        logger.fine("This is a FINE message (might not be shown depending on level).");
    }
}