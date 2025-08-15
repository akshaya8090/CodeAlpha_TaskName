import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private ArrayList<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int grade : grades) sum += grade;
        return (double) sum / grades.size();
    }

    public int getHighest() {
        if (grades.isEmpty()) return 0;
        int max = grades.get(0);
        for (int grade : grades) {
            if (grade > max) max = grade;
        }
        return max;
    }

    public int getLowest() {
        if (grades.isEmpty()) return 0;
        int min = grades.get(0);
        for (int grade : grades) {
            if (grade < min) min = grade;
        }
        return min;
    }

    public void displaySummary() {
        System.out.println("Student Name: " + name);
        System.out.println("Grades: " + grades);
        System.out.printf("Average Score: %.2f\n", getAverage());
        System.out.println("Highest Score: " + getHighest());
        System.out.println("Lowest Score: " + getLowest());
        System.out.println("----------------------------------");
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.print("\nEnter student name: ");
            String name = scanner.nextLine();
            Student student = new Student(name);

            System.out.print("Enter number of grades for " + name + ": ");
            int numGrades = scanner.nextInt();

            for (int j = 0; j < numGrades; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                int grade = scanner.nextInt();
                student.addGrade(grade);
            }
            scanner.nextLine(); // consume newline
            studentList.add(student);
        }

        System.out.println("\n===== Student Grade Summary =====");
        for (Student s : studentList) {
            s.displaySummary();
        }

        scanner.close();
    }
}