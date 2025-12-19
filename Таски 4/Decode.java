import java.util.Scanner;

public class Decode {

    public static int[] decode(String message, String key) {
        if (message == null || key == null || key.isEmpty()) {
            return new int[0];
        }

        int n = message.length();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            char messageChar = message.charAt(i);
            char keyChar = key.charAt(i % key.length());
            result[i] = messageChar ^ keyChar;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().trim();

        input = input.replaceAll("\\s+", "");

        if (input.startsWith("\"") && input.endsWith("\"")) {
            input = input.substring(1, input.length() - 1);

            String[] parts = input.split("\",\"", 2);

            if (parts.length == 2) {
                String message = parts[0];
                String key = parts[1];

                int[] result = decode(message, key);

                System.out.print("[");
                for (int i = 0; i < result.length; i++) {
                    System.out.print(result[i]);
                    if (i < result.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            } else {
                System.out.println("Ошибка ");
            }
        } else {
            System.out.println(".");
        }

        scanner.close();
    }
}
