import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        try {
            FileInputStream input = new FileInputStream("start.txt");
            FileOutputStream output = new FileOutputStream("final.txt");
            
            int data;
            while ((data = input.read()) != -1) {
                output.write(data);
            }
            
            input.close();
            output.close();            
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}