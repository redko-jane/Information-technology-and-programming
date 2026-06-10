package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Starting combined demo: Palindrome checker + JSON serialization");

        logger.info("=== PART 1: Palindrome checker ===");
        String[] testWords = {"radar", "hello", "level", "world", "madam"};

        for (String word : testWords) {
            if (Palindrome.isPalindrome(word)) {
                logger.info("Word '{}' is palindrome", word);
            } else {
                logger.info("Word '{}' is NOT palindrome", word);
            }
        }

        logger.info("Calling Palindrome.main with arguments:");
        Palindrome.main(testWords);

        logger.info("=== PART 2: JSON Serialization ===");
        try {
            ObjectMapper mapper = new ObjectMapper();

            Person person = new Person("Иван Петров", 30, "ivan@example.com");
            String json = mapper.writeValueAsString(person);
            logger.info("Serialized JSON: {}", json);

            String input = "{\"name\":\"Анна Смирнова\",\"age\":25,\"email\":\"anna@example.com\"}";
            Person p = mapper.readValue(input, Person.class);
            logger.info("Deserialized object: {} ({} лет, email: {})",
                    p.getName(), p.getAge(), p.getEmail());

        } catch (Exception e) {
            logger.error("Error working with JSON", e);
        }
    }
}