import java.util.stream.*;

public class TransformProcessor {
    
    @DataProcessor
    public Stream<String> makeUpperCase(Stream<String> stream) {
        return stream.map(line -> {
            String[] parts = line.split(",");
            parts[0] = parts[0].toUpperCase();
            return String.join(",", parts);
        });
    }
    
    @DataProcessor
    public Stream<String> calculateTotal(Stream<String> stream) {
        return stream.map(line -> {
            String[] parts = line.split(",");
            int count = Integer.parseInt(parts[1]);
            double price = Double.parseDouble(parts[2]);
            double total = count * price;
            return line + ",ИТОГО:" + total;
        });
    }
}