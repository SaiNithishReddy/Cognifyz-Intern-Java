// Level - 1 
// Task - 4 : Random Password Generator
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    private final int length;
    private final boolean includeLowercase;
    private final boolean includeUppercase;
    private final boolean includeNumbers;
    private final boolean includeSpecialCharacters;

    public RandomPasswordGenerator(int length, boolean includeLowercase, boolean includeUppercase,
                                    boolean includeNumbers, boolean includeSpecialCharacters) {
        this.length = length;
        this.includeLowercase = includeLowercase;
        this.includeUppercase = includeUppercase;
        this.includeNumbers = includeNumbers;
        this.includeSpecialCharacters = includeSpecialCharacters;
    }

    public String generatePassword() {
        StringBuilder password = new StringBuilder();
        String validChars = "";

        if (includeLowercase)
            validChars += LOWERCASE_LETTERS;
        if (includeUppercase)
            validChars += UPPERCASE_LETTERS;
        if (includeNumbers)
            validChars += NUMBERS;
        if (includeSpecialCharacters)
            validChars += SPECIAL_CHARACTERS;

        if (validChars.isEmpty()) {
            throw new IllegalArgumentException("At least one character type should be selected.");
        }

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }

        return password.toString();
    }

   // Method to prompt user for "yes" or "no" input
    private static boolean promptYesNo(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.next().toLowerCase();
            boolean isValidInput = switch (input) {
                case "yes" -> true;
                case "no" -> false;
                default -> {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    yield false; // This is the default value if input doesn't match any case
                }
            };
            
            if (isValidInput) {
                return isValidInput;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the desired length of the password: ");
            int length = scanner.nextInt();

            if (length <= 0) {
                throw new IllegalArgumentException("Password length must be greater than 0.");
            }

            boolean includeLowercase = promptYesNo(scanner, "Include lowercase letters? (yes/no): ");
            boolean includeUppercase = promptYesNo(scanner, "Include uppercase letters? (yes/no): ");
            boolean includeNumbers = promptYesNo(scanner, "Include numbers? (yes/no): ");
            boolean includeSpecialCharacters = promptYesNo(scanner, "Include special characters? (yes/no): ");

            RandomPasswordGenerator generator = new RandomPasswordGenerator(length, includeLowercase, includeUppercase,
                    includeNumbers, includeSpecialCharacters);

            String password = generator.generatePassword();
            System.out.println("Generated Password: " + password);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid value.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}