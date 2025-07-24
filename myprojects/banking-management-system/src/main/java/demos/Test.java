package demos;

import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.*;
public class Test {
  private static Logger logger =
          Logger.getLogger(demos.Test.class.getName());

  public static void main(String[] args) throws IOException {

    LogManager.getLogManager().readConfiguration(
            Test.class.getClassLoader().getResourceAsStream("logging.properties")
    );

    logger.log(Level.INFO, "Program started message");

    logger.log(Level.SEVERE, "Severe error message 1");

    try {
      /* actions that can throw exceptions */
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Your error message", e);
    }
    logger.log(Level.INFO, "Your message");
    logger.info("Your message");


  }
}


