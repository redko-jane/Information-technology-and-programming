import java.util.Scanner;

public class SumOfPozitives {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] numbers = s.split(", ");
        int[] n = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            n[i] = Integer.parseInt(numbers[i]);
        }
        input.close();
        System.out.println(sumOfPozitives(n));
    }
    public static int sumOfPozitives(int[] n) {
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] > 0) {
                sum += n[i];
            }
        }
        return sum;
    }
}