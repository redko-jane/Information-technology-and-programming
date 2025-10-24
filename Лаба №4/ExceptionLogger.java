import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ExceptionLogger {
    public static void log(Exception e) {
        try (FileWriter fw = new FileWriter("exceptions.log", true)) {
            fw.write(LocalDateTime.now() + " — " + e.getClass().getSimpleName() + ": " + e.getMessage() + "\n");
        } catch (IOException io) {
            System.out.println("Ошибка при записи в лог-файл: " + io.getMessage());
        }
    }
}

