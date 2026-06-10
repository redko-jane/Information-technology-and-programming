import java.util.Arrays;
import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        input.close();
        String output = Arrays.toString(reverseWords(s));
        output = output.replace("[", "").replace("]","").replace(",", "");
        System.out.println(output);
    }

    public static String[] reverseWords(String s) {
        String[] words = s.split(" ");
        String[] rwords = new String[words.length];
        for (int i = words.length-1; i >= 0; i--) {
            rwords[words.length-i-1] = words[i];
        }
        return rwords;
    }
}