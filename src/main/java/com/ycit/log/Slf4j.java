package com.ycit.log;

import com.ycit.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xlch on 2017/2/11.
 */
public class Slf4j {

    private static final Logger logger = LoggerFactory.getLogger(Slf4j.class);

    public static void main(String [] args) {
        logger.trace("log4j2 trace level");
        Log log = new Log();
        log.log();
        logger.debug("exit app");
    }

}
