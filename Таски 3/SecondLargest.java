import java.util.Scanner;

public class SecondLargest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        input.close();
        s = s.replace("[", "").replace("]", "");
        String[] numbers = s.split(", ");
        int[] n = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            n[i] = Integer.parseInt(numbers[i]);
        }
        System.out.println(secondLargest(n));
    }

    public static int secondLargest(int[] n) {
        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] > max1) {
                max1 = n[i];
            }
        }
        for (int i = 0; i < n.length; i++) {
            if (n[i] > max2 && n[i] < max1) {
                max2 = n[i];
            }
        }
        return max2;
    }
}