import java.util.Scanner;

public class DifferenceMaxMin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        input.close();
        s = s.replace("[", "").replace("]", "").replace(" ", "");
        String[] numbers = s.split(",");
        int[] n = new int[numbers.length];
        for (int i = 0; i < n.length; i++) {
            n[i] = Integer.parseInt(numbers[i]);
        }
        System.out.println(differenceMaxMin(n));
    }

    public static int differenceMaxMin(int[] n) {
        int min = 10000;
        int max = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] > max) {
                max = n[i];
            }
            if (n[i] < min) {
                min = n[i];
            }
        }
        return max - min;
    }
}