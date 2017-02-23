package com.ycit.log;

import com.ycit.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by xlch on 2017/2/9.
 */
public class Log4j2 {

    private static final Logger logger = LogManager.getLogger(Log4j2.class);

    public static void main(String [] args) {
        logger.trace("log4j2 trace level");
        Log log = new Log();
        log.log();
        logger.debug("exit app");
    }

}
