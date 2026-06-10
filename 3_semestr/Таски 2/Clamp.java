import java.util.Scanner;

public class Clamp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        input.close();
        String numbers[] = s.split(", ");
        int value = Integer.parseInt(numbers[0]);
        int min = Integer.parseInt(numbers[1]);
        int max = Integer.parseInt(numbers[2]);
        System.out.println(clamp(value, min, max));
    }
    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }
}