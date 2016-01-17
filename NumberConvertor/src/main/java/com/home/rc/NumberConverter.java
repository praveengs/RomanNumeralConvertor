package com.home.rc;


import com.home.rc.common.CommonConstants;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Praveen G S on 16/01/2016.
 * <p>
 * This class is an implementation of the RomanNumeralGenerator class.
 * This class implements the generate method to find the roman numerals.
 */
public class NumberConverter implements RomanNumeralGenerator {


    /**
     * static map to hold roman equivalent of relevant integers.
     */
    private static HashMap<Integer, String> romanNumeralsMap;

    /**
     * Static variable to hold the keyArray
     */
    private static Integer[] keyArray;

    /**
     * Static block to initialise the static maps
     */
    static {
        romanNumeralsMap = new LinkedHashMap<>(13);
        romanNumeralsMap.put(1000, "M");
        romanNumeralsMap.put(900, "CM");
        romanNumeralsMap.put(500, "D");
        romanNumeralsMap.put(400, "CD");
        romanNumeralsMap.put(100, "C");
        romanNumeralsMap.put(90, "XC");
        romanNumeralsMap.put(50, "L");
        romanNumeralsMap.put(40, "XL");
        romanNumeralsMap.put(10, "X");
        romanNumeralsMap.put(9, "IX");
        romanNumeralsMap.put(5, "V");
        romanNumeralsMap.put(4, "IV");
        romanNumeralsMap.put(1, "I");

        keyArray = romanNumeralsMap.keySet().toArray(new Integer[romanNumeralsMap.keySet().size()]);
    }

    /**
     * This method uses the help of a recursive method, to find the roman numerals
     * that account for the number that is passed in.
     *
     * @param number the number to be converted to roman numeral.
     * @return the roman numeral.
     * @throws RuntimeException if the numbers are outside the boundaries i.e. below 1 or above 3999.
     */
    @Override
    public String generate(int number) {
        //Check for upper and lower boundaries
        if (number < 1 || number > 3999) {
            throw new RuntimeException(CommonConstants.OUT_OF_BOUNDS_EXCEPTION_STRING);
        }

        return generateRomanNumeral(keyArray, 0, number);
    }

    /**
     * This method will use a reduce approach to find the roman numeral.
     * The highest numerals are first tried against the incoming number.
     * The entry at the index of the static array is retrieved.
     * If incoming number minus the index entry is greater than zero; this means the equivalent roman
     * numeral can be used. The remaining value of the number (after subtraction)
     * is then passed to the next call.
     * Else if the negation gave value less than zero, we need to try the next element in the array.
     * <p>
     * Continue this until array gets exhausted or the number is reduced to 0; in which case return.
     *
     * @param intArray the keys in the static map
     * @param index    the current index of the intArray that is being checked
     * @param number   the number to convert to roman numeral
     * @return the roman equivalent
     */
    private String generateRomanNumeral(Integer[] intArray, int index, int number) {
        if (index >= intArray.length || number == 0) {
            return "";
        } else {
            int currentNumeral = intArray[index];
            int newNumber = number - currentNumeral;
            if (newNumber >= 0) {
                return romanNumeralsMap.get(currentNumeral) + generateRomanNumeral(intArray, index, newNumber);
            } else {
                return generateRomanNumeral(intArray, index + 1, number);
            }
        }
    }
}
