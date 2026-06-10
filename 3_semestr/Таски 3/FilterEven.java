import java.util.Scanner;
import java.util.Arrays;

public class FilterEven {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        input.close();
        s = s.replace("[", "").replace("]", "").replace(" ", "");
        String[] numbers = s.split(",");
        int[] n = new int[numbers.length];
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            n[i] = Integer.parseInt(numbers[i]);
            if (n[i] % 2 == 0) {
                count++;
            }
        }
        System.out.println(Arrays.toString(filterEven(n,count)));
    }

    public static int[] filterEven(int[] n, int count) {
        int[] filter = new int[count];
        int j = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] % 2 == 0) {
                filter[j] = n[i];
                j++;
            }
        }
        return filter;
    }
}