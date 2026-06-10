import java.util.Arrays;
import java.util.Scanner;

public class Digits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        input.close();
        System.out.print(countEvenOddDigits(s)[0]);
        System.out.print(", ");
        System.out.print(countEvenOddDigits(s)[1]);
    }
    public static int[] countEvenOddDigits(String s) {
        int countEven = 0;
        int countOdd = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-') {
                int a = Character.getNumericValue(s.charAt(i));
                if (a % 2 == 0) {
                    countEven++;
                }
                else {
                    countOdd++;
                }
            }
        }
        int[] n = {countEven, countOdd};
        return n;
    }
}