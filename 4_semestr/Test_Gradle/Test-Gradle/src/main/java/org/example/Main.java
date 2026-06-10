package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("The program is running");

        readBuildPassport();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the line: ");
        String input = scanner.nextLine();

        String result = StringProcessor.reverse(input);

        logger.info("The entered string: {}", input);
        logger.info("Reversed string: {}", result);

        logger.info("The program is completed");
        scanner.close();
    }

    private static void readBuildPassport() {
        try (InputStream input = Main.class.getClassLoader()
                .getResourceAsStream("build-passport.properties")) {

            if (input != null) {
                Properties props = new Properties();
                props.load(input);

                logger.info("========== BUILD INFORMATION ==========");
                logger.info("User: {}", props.getProperty("build.username"));
                logger.info("Operating system: {}", props.getProperty("build.os.name"));
                logger.info("Version Java: {}", props.getProperty("build.java.version"));
                logger.info("Build date and time: {}", props.getProperty("build.date"));
                logger.info("Build number: {}", props.getProperty("build.number"));
                logger.info("Git commit: {}", props.getProperty("build.git.commit"));
                logger.info("Message: {}", props.getProperty("build.message"));
                logger.info("========================================");
            } else {
                logger.warn("File build-passport.properties not founded in resources");
            }
        } catch (Exception e) {
            logger.error("Reading error build-passport.properties: {}", e.getMessage());
        }
    }
}