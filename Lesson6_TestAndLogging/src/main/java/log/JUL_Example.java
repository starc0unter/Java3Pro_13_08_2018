package log;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class JUL_Example {

    private static final Logger LOGGER = Logger.getLogger(JUL_Example.class.getName());

    public static void main(String[] args) throws SecurityException, IOException {
//        LogManager.getLogManager().readConfiguration(new FileInputStream("C:\\Users\\krylo\\IdeaProjects\\Java 3 Pro\\Lesson6_TestAndLogging\\src\\main\\resources\\jul.properties"));

        LOGGER.info("Logger Name: " + LOGGER.getName());
        LOGGER.log(Level.INFO,"Logger Name: {0}. My name is {1}", new Object[]{LOGGER.getName(), "Oleg"});
        LOGGER.warning("Can cause ArrayIndexOutOfBoundsException");

        //An array of size 3
        int[] a = {1, 2, 3};
        int index = 4;
        LOGGER.config("index is set to " + index);

        try {
            System.out.println(a[index]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            LOGGER.log(Level.SEVERE, "Exception occur", ex);
        }
    }

}
