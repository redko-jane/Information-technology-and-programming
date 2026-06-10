import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class DataManager {
    private List<Object> processors = new ArrayList<>();
    private List<String> data = new ArrayList<>();
    private ExecutorService executor;
    
    public DataManager() {
        executor = Executors.newFixedThreadPool(3);
    }
    
    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }
    
    public void loadData(String source) {
        System.out.println("Загружаем данные из: " + source);
        data = Arrays.asList(
            "яблоко,10,50.5",
            "банан,20,30.2", 
            "апельсин,5,80.0",
            "виноград,15,120.3",
            "манго,8,200.0"
        );
    }
    
    public void processData() {
        List<String> currentData = new ArrayList<>(data);
        List<Future<List<String>>> futures = new ArrayList<>();
        
        for (Object processor : processors) {
            Callable<List<String>> task = () -> {
                return applyProcessorMethods(new ArrayList<>(currentData), processor);
            };
            
            Future<List<String>> future = executor.submit(task);
            futures.add(future);
        }
        
        try {
            for (int i = 0; i < futures.size(); i++) {
                Future<List<String>> future = futures.get(i);
                List<String> result = future.get();
                data = result; 
            }
        } catch (InterruptedException e) {
            System.err.println("Обработка была прервана: " + e.getMessage());
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            System.err.println("Ошибка выполнения задачи: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    private List<String> applyProcessorMethods(List<String> dataList, Object processor) {
        Stream<String> stream = dataList.stream();
        
        for (var method : processor.getClass().getMethods()) {
            if (method.isAnnotationPresent(DataProcessor.class)) {
                try {
                    System.out.println("Применяем " + method.getName() + " в потоке: " + Thread.currentThread().getName());
                    stream = (Stream<String>) method.invoke(processor, stream);
                } catch (Exception e) {
                    System.err.println("Ошибка при применении метода " + method.getName() + ": " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return stream.collect(Collectors.toList());
    }
    
    public void saveData(String destination) {
        data.forEach(System.out::println);
    }
    
    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}