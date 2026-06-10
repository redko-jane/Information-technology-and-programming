import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int score = input.nextInt();
        input.close();
        System.out.println(grade(score));
    }
    public static String grade(int score) {
        if (score <= 100 && score >= 90) {
            return "A";
        }
        if (score <= 89 && score >= 80) {
            return "B";
        }
        if (score <= 79 && score >= 70) {
            return "C";
        }
        if (score <= 69 && score >= 60) {
            return "D";
        }
        if (score <= 59 && score >= 0) {
            return "F";
        }
        return "Invalid";
    }
}