package com.home.rc;


import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by prave_000 on 16/01/2016.
 */
public class NumberConverter implements RomanNumeralGenerator {


    /**
     * static map to hold roman equivalent of relevant integers.
     */
    private static HashMap<Integer, String> romanNumeralsMap = createRomanNumeralsMap();

    /**
     * Create the map with the values.
     *
     * @return a map with numeral as key and its roman equivalent as value.
     */
    private static HashMap<Integer, String> createRomanNumeralsMap() {
        HashMap<Integer, String> tempMap = new LinkedHashMap<>(13);
        tempMap.put(1000, "M");
        tempMap.put(900, "CM");
        tempMap.put(500, "D");
        tempMap.put(400, "CD");
        tempMap.put(100, "C");
        tempMap.put(90, "XC");
        tempMap.put(50, "L");
        tempMap.put(40, "XL");
        tempMap.put(10, "X");
        tempMap.put(9, "IX");
        tempMap.put(5, "V");
        tempMap.put(4, "IV");
        tempMap.put(1, "I");
        return tempMap;
    }

    /**
     * This method will use a reduce approach to find the
     *
     * @param number
     * @return
     */
    @Override
    public String generate(int number) {
        //Check for upper and lower boundaries
        if (number < 1 || number > 3999) {
            throw new RuntimeException("Illegal number. Number should be an integer between 1 and 3999.");
        }

        return generateRomanNumeral(romanNumeralsMap.keySet().toArray(new Integer[romanNumeralsMap.keySet().size()]), 0, number);
    }

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
