import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
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
