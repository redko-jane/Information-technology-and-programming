import java.util.Scanner;

public class Weeks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = scanner.nextInt();
        scanner.close();
        int[] res = daysToWeeks(days);
        int w = res[0];
        int d = res[1];
        System.out.print(w);
        if (w == 0)
            System.out.print(" недель ");
        else if (w == 1) 
            System.out.print(" неделя ");
        else
            System.out.print(" недели ");
            
        System.out.print("и ");
        System.out.print(d);

        if (d == 1)
            System.out.print(" день");
        else if (d >= 2 && d <= 4) 
            System.out.print(" дня");
        else
            System.out.print(" дней");
    }
    
    public static int[] daysToWeeks(int days) {
        int w = days / 7;
        int d = days % 7;
        return new int[]{w, d};
    }
}