package com.checkfood.singluten.utils;

/**
 * Class that provides string utils
 *
 * @author diego.galico
 */
public class StringUtils {

    /**
     * This method capitalize the first letter of a string
     *
     * @param input
     * @return input in the desire format
     */
    public static String capitalizeFirstLetter(String input) {
        if (input != null && !input.isEmpty()) {
            return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
        }
        return input;
    }
}
