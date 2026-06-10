import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        System.out.println(isPalindrome(s));
    }
    public static String reverseString(String s) {
        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse += s.charAt(i);
        }
        return reverse;
    }
    public static boolean isPalindrome(String s) {
        String s1 = s;
        String s2 = reverseString(s);
        return s1.equals(s2);
    }
}