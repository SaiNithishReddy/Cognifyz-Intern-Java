// Level - 2 
// Task - 2 : Password Strength Checker
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Let's check strength of Password -----");
        System.out.print("Enter a password to check strength: ");
        String password = scanner.nextLine();

        try {
            PasswordStrengthChecker strengthChecker = new PasswordStrengthChecker(password);
            int strengthScore = strengthChecker.calculateStrengthScore();
            strengthChecker.provideFeedback(strengthScore);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally{
            scanner.close();
        }
    }
}

class PasswordStrengthChecker {
    private final String password;

    public PasswordStrengthChecker(String password) {
        this.password = password;
    }

    public int calculateStrengthScore() {
        int length = password.length();
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialChar = !password.matches("[A-Za-z0-9]*");

        int strengthScore = 0;

        if (length >= 8) {
            strengthScore++;
        }
        if (hasUppercase) {
            strengthScore++;
        }
        if (hasLowercase) {
            strengthScore++;
        }
        if (hasDigit) {
            strengthScore++;
        }
        if (hasSpecialChar) {
            strengthScore++;
        }
        if (length <= 6) {
            strengthScore--;
        }

        return strengthScore;
    }

    public void provideFeedback(int strengthScore) {
        if (strengthScore == 5) {
            System.out.println("Password is very strong.");
        } else if (strengthScore == 4) {
            System.out.println("Password is strong.");
        } else if (strengthScore >= 2) {
            System.out.println("Password is medium.");
        } else {
            System.out.println("Password is weak.");
        }
    }
}
