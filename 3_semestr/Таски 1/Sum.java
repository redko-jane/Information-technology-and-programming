import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(digitSum(n));
    }
    public static int digitSum(int n) {
        int sum = 0;
        while (n>0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}