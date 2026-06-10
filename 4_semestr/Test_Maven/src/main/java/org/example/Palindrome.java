package org.example;

public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            System.out.print(s);
            if (isPalindrome(s)) {
                System.out.println(" is palindrome");
            }
            else {
                System.out.println(" is not palindrome");
            }
        }
    }
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    public static boolean isPalindrome(String s) {
        String s1 = s;
        String s2 = reverseString(s);
        return s1.equals(s2);
    }
}