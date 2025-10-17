import java.util.Scanner;

public class Season {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(season(n));
    }
    public static String season(int n) {
        if (n >= 4 && n <= 6) {
            return "весна";
        }
        else if (n >= 6 && n <= 8) {
            return "лето";
        }
        else if (n >= 9 && n <= 11) {
            return "осень";
        }
        else {
            return "зима";
        }
    }
} 