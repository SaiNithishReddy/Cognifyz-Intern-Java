// Level - 1
// Task - 1 : Temperature Converter
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter unit of measurement (C for Celsius, F for Fahrenheit): ");
            char unit;
            boolean isValidUnit = false;

            do {
                unit = scanner.next().charAt(0);
                unit = Character.toLowerCase(unit); // Convert to lowercase for simplicity

                switch (unit) {
                    case 'c' -> {
                        System.out.print("Enter temperature value: ");
                        double celsiusValue = scanner.nextDouble();
                        System.out.println("Temperature in Fahrenheit: " + convertToCelsius(celsiusValue) + " F");
                        isValidUnit = true;
                    }
                    case 'f' -> {
                        System.out.print("Enter temperature value: ");
                        double fahrenheitValue = scanner.nextDouble();
                        System.out.println("Temperature in Celsius: " + convertToFahrenheit(fahrenheitValue) + " C");
                        isValidUnit = true;
                    }
                    default -> System.out.println("Invalid unit of measurement. Please enter C or F.");
                }
            } while (!isValidUnit);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid temperature value.");
        }
    }

    public static double convertToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }
}