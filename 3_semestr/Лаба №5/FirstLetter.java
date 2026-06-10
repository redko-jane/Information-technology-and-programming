import java.util.regex.*;
import java.util.Scanner;

public class FirstLetter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        String letter = input.nextLine();
        try {
            Pattern pattern = Pattern.compile("\\b" + letter + "\\w*");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        } finally {
            input.close();
        }
    }
}