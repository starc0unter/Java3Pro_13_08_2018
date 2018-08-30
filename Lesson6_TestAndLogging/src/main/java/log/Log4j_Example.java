package log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j_Example {

    private static final Logger LOGGER = LogManager.getLogger(Log4j_Example.class.getName());

    public static void main(String[] args)
    {
        LOGGER.debug("Debug Message Logged !!!");
        LOGGER.info("Info Message Logged !!! My name is {}", "Oleg");
        LOGGER.error("Error Message Logged !!!", new NullPointerException("NullError"));
    }
}
