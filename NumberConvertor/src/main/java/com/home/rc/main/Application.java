package com.home.rc.main;

import com.home.rc.NumberConverter;
import com.home.rc.RomanNumeralGenerator;
import com.home.rc.common.CommonConstants;

import java.util.Scanner;

/**
 * Created by Praveen G S on 17/01/2016.
 * <p>
 * This is the main class. This loops around till the user
 * enters q (to quit) and press enter.
 * For each number entered, it find the equivalent roman numer
 * and displays it for the user.
 */
public class Application {

    /**
     * The interface instance.
     */
    private RomanNumeralGenerator romanNumeralGenerator;

    /**
     * The default constructor.
     */
    public Application() {
        setRomanNumeralGenerator(new NumberConverter());
    }

    /**
     * The main method where all the actions starts (or ends).
     *
     * @param args the incoming arguments.
     */
    public static void main(String[] args) {
        Application application = new Application();
        application.start();

    }

    /**
     * This method runs in a loop waiting for user entry, processing
     * one user entry after the other.
     */
    private void start() {
        while (true) {
            System.out.println("Enter q to exit");
            System.out.println("Enter the number to be converted to roman numeral (Between 1 and 3999): ");
            Scanner scan = new Scanner(System.in);
            String inputString = scan.next();
            //Exit in case user enters q
            if ("q".equalsIgnoreCase(inputString)) {
                System.out.println("Exiting now.....");
                break;
            }
            try {
                //try to parse the user entry ensuring if its an integer.
                Integer numToConvert = Integer.parseInt(inputString);
                //If parsing is a success, try to convert it to roman equivalent.
                System.out.println(getRomanNumeralGenerator().generate(numToConvert));
            } catch (NumberFormatException numberFormatException) {
                //Alert user of the invalid entry and return to accept input from user.
                System.out.println("Invalid Number, " + inputString + " try again");
            } catch (RuntimeException runtimeException) {
                //Alert the user of out of bounds entry and return to accept input from user.
                if (CommonConstants.OUT_OF_BOUNDS_EXCEPTION_STRING.equals(runtimeException.getMessage())) {
                    System.out.println(CommonConstants.OUT_OF_BOUNDS_EXCEPTION_STRING);
                } else {
                    //If this is not an expected runtimeException, throw it and exit.
                    throw runtimeException;
                }
            }
        }
    }

    /**
     * Getter for the roman number generator instance.
     *
     * @return instance of RomanNumeralGenerator.
     */
    public RomanNumeralGenerator getRomanNumeralGenerator() {
        return romanNumeralGenerator;
    }

    /**
     * Method to set the RomanNumeralGenerator.
     *
     * @param romanNumeralGenerator the RomanNumeralGenerator instance.
     */
    public void setRomanNumeralGenerator(RomanNumeralGenerator romanNumeralGenerator) {
        this.romanNumeralGenerator = romanNumeralGenerator;
    }
}
