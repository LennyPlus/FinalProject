package org.example;

public class Util {
    /**
     * Converts each word in a string to title case
     * @param str The string to be converted
     * @return The converted string
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String[] words = str.split(" ");
        String result = "";

        for (String word : words) {
            result += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
        }

        return result;
    }
}
