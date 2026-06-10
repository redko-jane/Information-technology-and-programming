package org.example;

import org.apache.commons.lang3.StringUtils;

public class StringProcessor {

    public static String reverse(String input) {
        return StringUtils.reverse(input);
    }

    public static String capitalize(String input) {
        return StringUtils.capitalize(input);
    }

    public static boolean isEmpty(String input) {
        return StringUtils.isEmpty(input);
    }

    public static String reverseAndCapitalize(String input) {
        String reversed = StringUtils.reverse(input);
        return StringUtils.capitalize(reversed);
    }
}
