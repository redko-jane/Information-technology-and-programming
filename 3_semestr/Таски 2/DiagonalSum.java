import java.util.Scanner;

public class DiagonalSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        input.close();
        s = s.replace("[","").replace("]","");
        String[] numbers = s.split(",");
        int n = (int) Math.sqrt(numbers.length);
        int[][] m = new int[n][n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = Integer.parseInt(numbers[index]);
                index++;
            }
        }
        System.out.println(diagonalSum(m));
    }
    public static int diagonalSum(int[][] m) {
        int sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][i];
        }
        return sum;
    }
}