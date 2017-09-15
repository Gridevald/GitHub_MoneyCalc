package org.home.model.logic;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    @Test
    public void TestCast() {
        String value = "001.5";
        double d = Double.valueOf(value);
        assertTrue(d == 1.5);
    }
}
