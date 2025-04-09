package org.bill.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BotLogger {
    private static final Logger logger = LoggerFactory.getLogger(BotLogger.class);

    public static Logger getLogger() {
        return logger;
    }

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logWarn(String message) {
        logger.warn(message);
    }

    public static void logError(String message) {
        logger.error(message);
    }
}
