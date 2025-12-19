import java.util.Scanner;

public class RomanConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        System.out.println(convertToRome(number));
    }

    public static String convertToRome(int num) {
        if (num <= 0 || num > 1502) {
            return "";
        }
        
        String[] thousands = {"", "M"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        
        return thousands[num / 1000] + 
               hundreds[(num % 1000) / 100] + 
               tens[(num % 100) / 10] + 
               ones[num % 10];
    }
}