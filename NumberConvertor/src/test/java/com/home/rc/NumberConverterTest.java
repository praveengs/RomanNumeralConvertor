package com.home.rc;

import com.home.rc.exception.InvalidInputException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by prave_000 on 16/01/2016.
 */
public class NumberConverterTest {

    private NumberConverter numberConverter;

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    public NumberConverterTest() {
        numberConverter = new NumberConverter();
    }

    @Test
    public void testNumberConverterInstanceNotNull () {
        Assert.assertNotNull(numberConverter);
    }


    @Test
    public void testExceptionForNumberLessThanOne (){
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Illegal number. Number should be an integer between 1 and 3999.");
        numberConverter.generate(0);
    }

    @Test
    public void testExceptionForNumberGreaterThan3999 () {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Illegal number. Number should be an integer between 1 and 3999.");
        numberConverter.generate(4000);
    }

    @Test
    public void testConversionFor1 () {
        Assert.assertEquals("I", numberConverter.generate(1));
    }

    @Test
    public void testConversionFor3999 () {
        Assert.assertEquals("MMMCMXCIX", numberConverter.generate(3999));
    }

    @Test
    public void testConversionFor20 () {
        Assert.assertEquals("XX", numberConverter.generate(20));
    }

    @Test
    public void testConversionFor5 () {
        Assert.assertEquals("V", numberConverter.generate(5));
    }

    @Test
    public void testConversionFor1920 () {
        Assert.assertEquals("MCMXX", numberConverter.generate(1920));
    }

    @Test
    public void testConversionFor2015 () {
        Assert.assertEquals("MMXV", numberConverter.generate(2015));
    }
}