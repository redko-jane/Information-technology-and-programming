import java.util.stream.*;

public class FilterProcessor {
    
    @DataProcessor
    public Stream<String> filterExpensive(Stream<String> stream) {
        return stream.filter(line -> {
            String[] parts = line.split(",");
            double price = Double.parseDouble(parts[2]);
            return price > 50.0;
        });
    }
    
    @DataProcessor
    public Stream<String> filterManyItems(Stream<String> stream) {
        return stream.filter(line -> {
            String[] parts = line.split(",");
            int count = Integer.parseInt(parts[1]);
            return count >= 10;
        });
    }
}