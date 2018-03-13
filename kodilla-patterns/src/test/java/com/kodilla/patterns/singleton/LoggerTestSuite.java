package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetFileName() {
        //Given
        //When
        Logger.getInstance().log("First log.");
        String result = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("First log.", result);
    }
}
