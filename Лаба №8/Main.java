public class Main {
    public static void main(String[] args) {
        DataManager manager = new DataManager();
        
        manager.registerDataProcessor(new FilterProcessor());
        manager.registerDataProcessor(new TransformProcessor());
        manager.loadData("test.csv");
        manager.processData();
        manager.saveData("result.csv");
        manager.shutdown();
    }
}