import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        boolean x = checkAge(n);
        if (x) {
            System.out.println("соверешннолетний");
        }
        else {
            System.out.println("несоверешннолетний");
        }
    }
    public static boolean checkAge(int n) {
        if (n >= 18) {
            return true;
        }
        else {
            return false;
        }
    }
}