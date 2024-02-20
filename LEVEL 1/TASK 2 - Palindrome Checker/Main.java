// Level - 1 
// Task - 2 : Palindrome Checker
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word or phrase to check if it's a palindrome:");
        String input = scanner.nextLine();
        
        try {
            PalindromeChecker palindromeChecker = new PalindromeChecker(input);
            String cleanString = palindromeChecker.getCleanString(); // Obtaining clean string from PalindromeChecker
            System.out.println("Removing spaces and punctuation from the input: " + cleanString);
            
            if (palindromeChecker.isPalindrome()) {
                System.out.println("Yes, it's a palindrome.");
            } else {
                System.out.println("No, it's not a palindrome.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class PalindromeChecker {
    private final String cleanString;

    public PalindromeChecker(String inputString) {
        this.cleanString = inputString.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

    public boolean isPalindrome() {
        // Check if the clean string is empty
        if (cleanString.isEmpty()) {
            throw new IllegalArgumentException("Input string is empty after removing spaces and punctuation.");
        }

        // Check if it's a palindrome
        int left = 0;
        int right = cleanString.length() - 1;

        while (left < right) {
            if (cleanString.charAt(left) != cleanString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String getCleanString() {
        return cleanString;
    }
}