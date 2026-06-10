import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class NonRepeat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        input.close();
        System.out.println(nonRepeat(s));
    }

    public static String nonRepeat(String s) {
        HashMap<Character, Integer> count = new HashMap<>(s.length());
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() > 3) {
                s = s.replaceAll(Character.toString(entry.getKey()), "");
            }
        }
        return s;
    }
}