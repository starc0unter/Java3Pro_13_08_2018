package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4J_Example {
 
    private static Logger logger = LoggerFactory.getLogger(SLF4J_Example.class);
 
    public static void main(String[] args) {
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.info("{}, {}!", "Hello", "World");
        logger.error("Error log message");
    }
}