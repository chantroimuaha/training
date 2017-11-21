/**
LogbackTest.java
*/
package com.demo.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/************************************
 * Created Date: Nov 21, 2017
 * Created By: ndthien
 * Desc: 
 * **********************************
 * Modified Date: 
 * Modified By: 
 * Desc: 
 ************************************/
public class LogbackTest {
    private static Logger LOGGER = LoggerFactory.getLogger(LogbackTest.class);
    @Test
    public void test() {
        LOGGER.error("This is test message");
        LOGGER.debug("This is test message");
        LOGGER.info("This is test message");
        LOGGER.trace("This is test message");
    }

}
