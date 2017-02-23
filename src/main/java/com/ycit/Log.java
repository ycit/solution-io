package com.ycit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by xlch on 2017/2/9.
 */
public class Log {

    private static final Logger logger = LogManager.getLogger(Log.class);

    public void log(){
        logger.error("log error level");
    }

}
