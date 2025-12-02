import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        input.close();
        String[] numbers = s.split(", ");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        int c = Integer.parseInt(numbers[2]);
        System.out.println(isTriangle(a,b,c));
    }

    public static boolean isTriangle(int a, int b, int c) {
        if (a + b > c && a + c > b && b + c > a) {
            return true;
        }
        return false;
    }
}