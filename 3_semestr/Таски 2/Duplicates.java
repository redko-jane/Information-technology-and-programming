import java.util.Scanner;

public class Duplicates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] numbers = s.split(", ");
        int[] n = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            n[i] = Integer.parseInt(numbers[i]);
        }
        input.close();
        System.out.println(hasDuplicates(n));
    }
    public static boolean hasDuplicates(int[] n) {
        boolean x = false;
        for (int i = 0; i < n.length-1; i++) {
            for (int j = i+1; j < n.length; j++) {
                if (n[i] == n[j]) {
                    x = true;
                    break;
                }
            }
        }
        return x;
    }
}