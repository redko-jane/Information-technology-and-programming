import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        input.close();
        System.out.println(countWords(s));
    }

    public static int countWords(String s) {
        int count = 0;
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            String w = words[i].replace(" ", "");
            if (w.length() > 0) {
                count++;
            }
        }
        return count;
    }
}