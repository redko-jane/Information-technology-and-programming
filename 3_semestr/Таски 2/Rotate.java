import java.util.Arrays;
import java.util.Scanner;

public class Rotate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        input.close();
        s = s.replace("[", "").replace("]", "");
        String[] numbers = s.split(",");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i].trim();
        }
        if (numbers.length == 1 && numbers[0].isEmpty()) {
            System.out.println("[]");
        }
        else if (numbers.length == 2 && numbers[0] == "") {
            System.out.println("[]");
        }
        else {
            int[] n = new int[numbers.length-1];
            for (int i = 0; i < numbers.length-1; i++) {
                n[i] = Integer.parseInt(numbers[i]);
            }
            int k = Integer.parseInt(numbers[numbers.length-1]);
            System.out.println(Arrays.toString(rotateRight(n, k)));
        }
    }
    public static int[] rotateRight(int[] n, int k) {
        int[] m = new int[n.length];
        k = k % n.length;
        for (int i = 0; i < n.length; i++) {
            m[(i + k) % n.length] = n[i];
        }
        return m;
    }
}