import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        input.close();
        s = s.replace(" ", "");
        String[] words = s.split(",");
        if (words.length != 2) {
            System.out.println("false");
        }
        else {
            String a = words[0];
            String b = words[1];
            System.out.println(isAnagram(a,b));
        }
    }

    public static boolean isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(b1);
        return Arrays.equals(a1,b1);
    }
}