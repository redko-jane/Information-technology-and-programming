import java.util.Scanner;

public class Fahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int C = scanner.nextInt();
        scanner.close();
        System.out.println(toFahrenheit(C));
    }
    public static int toFahrenheit(int C) {
        int F = C * 9 / 5 + 32;
        return F;
    }
}