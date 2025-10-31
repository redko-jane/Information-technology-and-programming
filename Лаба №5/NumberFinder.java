import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "В 2024 году цена составит 199.99 рублей за 5 единиц товара.";
        try {
            Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: ");
        }
    }
}