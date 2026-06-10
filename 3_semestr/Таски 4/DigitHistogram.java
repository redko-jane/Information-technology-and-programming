import java.util.Scanner;

public class DigitHistogram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        int[] result = digitHistogram(n);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static int[] digitHistogram(int n) {
        String s = Integer.toString(n);
        int[] num = new int[s.length()];
        for (int i = 0; i < num.length; i++) {
            num[i] = n % 10;
            n = n / 10;
        }
        int[] count = new int[10];
        for (int i = 0; i < num.length; i++) {
            count[num[i]] ++;
        }
        return count;
    }
}