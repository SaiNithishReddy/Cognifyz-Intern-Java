// Level - 2 
// Task - 3 : File Encryption & Decryption
import java.io.*;

public class FileEncryptionDecryption {
    public static void main(String[] args) {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Prompt user to choose encryption or decryption
            System.out.println("Choose an option:");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            int choice = Integer.parseInt(inputReader.readLine());

            // Prompt user for file name or path
            System.out.println("Enter the input file name or path:");
            String inputFilepath = inputReader.readLine();
            File inputFile = new File(inputFilepath);

            if (!inputFile.exists()) {
                System.out.println("Input file does not exist.");
                return;
            }

            System.out.println("Enter the output file name or path:");
            String outputFilepath = inputReader.readLine();
            File outputFile = new File(outputFilepath);

            // Using switch expression
            String resultMessage = switch (choice) {
                case 1 -> {
                    EncryptionManager.encrypt(inputFile, outputFile);
                    yield "File encrypted successfully.";
                }
                case 2 -> {
                    EncryptionManager.decrypt(inputFile, outputFile);
                    yield "File decrypted successfully.";
                }
                default -> "Invalid option. Please choose 1 or 2.";
            };

            System.out.println(resultMessage);
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format: " + e.getMessage());
        }
    }
}

// Define an EncryptionManager class to handle encryption and decryption
class EncryptionManager {
    // Encryption method
    public static void encrypt(File inputFile, File outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            int charValue;
            while ((charValue = reader.read()) != -1) {
                // Encrypt each character by shifting its ASCII value by 1
                char encryptedChar = (char) (charValue + 1);
                writer.write(encryptedChar);
            }
        }
    }

    // Decryption method
    public static void decrypt(File inputFile, File outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            int charValue;
            while ((charValue = reader.read()) != -1) {
                // Decrypt each character by shifting its ASCII value by -1
                char decryptedChar = (char) (charValue - 1);
                writer.write(decryptedChar);
            }
        }
    }
}
