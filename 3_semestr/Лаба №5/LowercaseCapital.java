import java.util.regex.*;
import java.util.Scanner;

public class LowercaseCapital {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        try {
            Pattern pattern = Pattern.compile("[a-z][A-Z]");
            Matcher matcher = pattern.matcher(text);
            StringBuffer result = new StringBuffer();
            while (matcher.find()) {
                String lc = matcher.group();
                String rep = "!" + lc + "!";
                matcher.appendReplacement(result, rep);
            }
            matcher.appendTail(result);
            System.out.println(result);
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        } finally {
            input.close();
        }
    }
}