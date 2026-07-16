import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static double[] cutoffs = {90, 80, 70, 60};
    static char[] letters = {'A', 'B', 'C', 'D', 'F'};

    public static char letterFor(double grade) {
        for (int i = 0; i < cutoffs.length; i++) {
            if (grade >= cutoffs[i]) {
                return letters[i];
            }
        }
        return letters[letters.length - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> roster = new ArrayList<>();

        boolean running = true;

        while (running) {

            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Class Average");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice;

            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from 1-4.");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:

                    String name;

                    while (true) {

                        System.out.print("Student Name: ");
                        name = sc.nextLine().trim();

                        if (name.isEmpty()) {
                            System.out.println("Name cannot be empty.");
                            continue;
                        }

                        boolean duplicate = false;

                        for (Student s : roster) {
                            if (s.name.equalsIgnoreCase(name)) {
                                duplicate = true;
                                break;
                            }
                        }

                        if (duplicate) {
                            System.out.println("Student already exists.");
                            continue;
                        }

                        break;
                    }

                    double grade;

                    while (true) {

                        try {

                            System.out.print("Grade (0-100): ");
                            grade = sc.nextDouble();
                            sc.nextLine();

                            if (grade < 0 || grade > 100) {
                                System.out.println("Grade must be between 0 and 100.");
                                continue;
                            }

                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid grade. Please enter a number.");
                            sc.nextLine();
                        }
                    }

                    roster.add(new Student(name, grade));
                    System.out.println("Student added successfully!");
                    break;

                case 2:

                    if (roster.isEmpty()) {
                        System.out.println("No students found.");
                    } else {

                        System.out.println("\n----- Student List -----");

                        for (Student s : roster) {
                            System.out.println(s.name + " - " + s.grade + " (" + letterFor(s.grade) + ")");
                        }
                    }

                    break;

                case 3:

                    if (roster.isEmpty()) {
                        System.out.println("No students available.");
                    } else {

                        double total = 0;

                        for (Student s : roster) {
                            total += s.grade;
                        }

                        double average = total / roster.size();

                        System.out.println("Class Average: " + average + " (" + letterFor(average) + ")");
                    }

                    break;

                case 4:

                    running = false;
                    System.out.println("Thank you for using Grade Tracker!");
                    break;

                default:

                    System.out.println("Please choose between 1 and 4.");
            }
        }

        sc.close();
    }
}

class Student {

    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}