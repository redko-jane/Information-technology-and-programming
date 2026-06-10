import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        FileReader input = null;
        FileWriter output = null;

        try {
            input = new FileReader("start.txt");
            output = new FileWriter("final.txt");
            
            int data;
            while ((data = input.read()) != -1) {
                output.write(data);
            }
            
            System.out.println("Файл успешно скопирован");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        } finally {
            try {
                if (input != null) input.close();
                if (output != null) output.close();
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии файла.");
            }
        }
    }
}