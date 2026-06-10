import java.util.regex.*;
import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        try {
            boolean x = true;
            Pattern pattern1 = Pattern.compile("^[A-Za-z\\d]{8,16}$");
            Matcher matcher1 = pattern1.matcher(text);
            if (!matcher1.matches()) {
                x = false;
            }
            else {
                Pattern pattern2 = Pattern.compile(".*[A-Z].*");
                Matcher matcher2 = pattern2.matcher(text);
                if (!matcher2.matches()) {
                    x = false;
                }
                else {
                    Pattern pattern3 = Pattern.compile(".*\\d.*");
                    Matcher matcher3 = pattern3.matcher(text);
                    if (!matcher3.matches()) {
                        x = false;
                    }
                }
            }
            if (x) {
                System.out.println("Введенный пароль корректен");
            }
            else {
                System.out.println("Введенный пароль некорректен");
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: ");
        } finally {
            input.close();
        }
    }
}