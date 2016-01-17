package com.home.rc;

/**
 * Created by Praveen G S on 16/01/2016.
 *
 * The interface for the roman numeral generator.
 *
 */
public interface RomanNumeralGenerator {
    /**
     * Common interface method to generate roman numeral
     *
     * @param number the input number
     * @return the number in roman numeral form
     */
    String generate(int number);
}
