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