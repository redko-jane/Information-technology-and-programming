import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        scanner.close();
        System.out.println(rectangleArea(a,b));
    }
    public static double rectangleArea(double a, double b) {
        double S = a * b;
        return S;
    }
}