// Level - 1
// Task - 3 : Student Grade Calculator
import java.util.InputMismatchException;
import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);

        try(Scanner scanner = new Scanner(System.in)) {
            int numGrades;
            do {
                System.out.print("Enter the number of grades os Student(must be a positive integer): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a positive integer.");
                    scanner.next();
                }
                numGrades = scanner.nextInt();
            } while (numGrades <= 0);

            int totalGrade = 0;
            for (int i = 1; i <= numGrades; i++) {
                int grade;
                do {
                    System.out.print("Enter grade " + i + " (must be between 0 and 10): ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid grade between 0 and 10.");
                        scanner.next();
                    }
                    grade = scanner.nextInt();
                } while (grade < 0 || grade > 10);

                totalGrade += grade;
            }

            double averageGrade = (double) totalGrade / numGrades;
            System.out.println("Average grade of Student: " + averageGrade);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid grade.");
        }
    }
}
