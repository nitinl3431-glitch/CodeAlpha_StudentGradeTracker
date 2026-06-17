import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        String[] names = new String[n];
        int[] grades = new int[n];

        // Input student data
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter student name: ");
            names[i] = sc.next();

            System.out.print("Enter grade: ");
            grades[i] = sc.nextInt();
        }

        // Calculate average, highest, lowest
        int sum = 0;
        int highest = grades[0];
        int lowest = grades[0];

        for (int i = 0; i < n; i++) {
            sum += grades[i];

            if (grades[i] > highest) {
                highest = grades[i];
            }

            if (grades[i] < lowest) {
                lowest = grades[i];
            }
        }

        double average = (double) sum / n;

        // Display report
        System.out.println("\n===== STUDENT REPORT =====");

        for (int i = 0; i < n; i++) {
            System.out.println(names[i] + " : " + grades[i]);
        }

        System.out.println("\nAverage Score : " + average);
        System.out.println("Highest Score : " + highest);
        System.out.println("Lowest Score  : " + lowest);

        sc.close();
    }
}