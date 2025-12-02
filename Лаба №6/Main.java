public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(5);
        
        stack.push("Первый");
        stack.push("Второй");
        stack.push("Третий");
        
        System.out.println(stack.peek()); 
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}