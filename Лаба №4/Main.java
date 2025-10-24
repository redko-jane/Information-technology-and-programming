import java.util.Scanner;

public class Main {
    
    public static void validateAge(int age) throws CustomAgeException {
        if (age < 0) {
            throw new CustomAgeException("Возраст не может быть отрицательным");
        }
        if (age > 120) {
            throw new CustomAgeException("Возраст не может превышать 120 лет");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                
        while (true) {
            System.out.println("Введите возраст: ");
            String input = scanner.nextLine();
            
            if (input.equals(" ")) {
                break;
            }
            
            try {
                int age = Integer.parseInt(input);
                
                validateAge(age);
                System.out.println("Возраст введен правильно");
                
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: нужно ввести число, а не '" + input + "'");
                ExceptionLogger.log(e);
                
            } catch (CustomAgeException e) {
                System.out.println(e.getMessage());
                ExceptionLogger.log(e);
            }
        }
        
        scanner.close();
    }
}