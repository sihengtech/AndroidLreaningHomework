package com.meibaorui.printmaxvalue;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrintMaxValueTest extends TestCase {

    private int[] array = {0, -1, 1, 88, -99, 0, 0, -1, 988, 999, 997};

    @Test
    public void testGetMaxValueFromArray() throws Exception {
        assertEquals(999, PrintMaxValue.getMaxValueFromArray(array));
    }

    @Test
    public void testPrintMaxValueFromArray() throws Exception {
        ByteArrayOutputStream actualOutContent = new ByteArrayOutputStream();
        ByteArrayOutputStream expectedOutContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(actualOutContent));
        PrintMaxValue.printMaxValueFromArray(array);
        String actual = actualOutContent.toString();

        System.setOut(new PrintStream(expectedOutContent));
        System.out.println(999);
        String expected = expectedOutContent.toString();

        System.setOut(null);
        assertEquals(expected, actual);
    }
}