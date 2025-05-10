// FOR ATM
import java.util.Scanner;

public class Main {

    static double balance = 1000.00;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        double amount;

        while (true) {
            // ATM menu
            System.out.println("\nATM Menu");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            if (choice == 1) {
                System.out.println("Balance: $" + balance);
            } else if (choice == 2) {
                System.out.print("Enter amount to deposit: ");
                amount = input.nextDouble();
                if (amount > 0) {
                    balance += amount;
                    System.out.println("Deposited: $" + amount);
                } else {
                    System.out.println("Invalid amount.");
                }
            } else if (choice == 3) {
                System.out.print("Enter amount to withdraw: ");
                amount = input.nextDouble();
                if (amount > 0 && amount <= balance) {
                    balance -= amount;
                    System.out.println("Withdrawn: $" + amount);
                } else {
                    System.out.println("Insufficient balance or invalid amount.");
                }
            } else if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        input.close();
    }
}

//FOR GRADE
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // Student class to hold individual student details
    static class Student {
        private String name;
        private String studentId;
        private double grade;

        public Student(String name, String studentId, double grade) {
            this.name = name;
            this.studentId = studentId;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public String getStudentId() {
            return studentId;
        }

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Student ID: " + studentId + ", Name: " + name + ", Grade: " + grade;
        }
    }

    // Gradebook class to manage student records
    static class Gradebook {
        private Map<String, Student> studentRecords;

        public Gradebook() {
            studentRecords = new HashMap<>();
        }

        public void addStudent(String name, String studentId, double grade) {
            if (!studentRecords.containsKey(studentId)) {
                studentRecords.put(studentId, new Student(name, studentId, grade));
                System.out.println("Student added successfully.");
            } else {
                System.out.println("Student with this ID already exists.");
            }
        }

        public void updateGrade(String studentId, double newGrade) {
            Student student = studentRecords.get(studentId);
            if (student != null) {
                student.setGrade(newGrade);
                System.out.println("Grade updated successfully.");
            } else {
                System.out.println("Student not found.");
            }
        }

        public void viewStudent(String studentId) {
            Student student = studentRecords.get(studentId);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("Student not found.");
            }
        }

        public void viewAllStudents() {
            if (studentRecords.isEmpty()) {
                System.out.println("No students in the gradebook.");
            } else {
                for (Student student : studentRecords.values()) {
                    System.out.println(student);
                }
            }
        }
    }

    // Main application to interact with the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gradebook gradebook = new Gradebook();

        while (true) {
            System.out.println("\n--- Gradebook Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Grade");
            System.out.println("3. View Student");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    double grade = scanner.nextDouble();
                    scanner.nextLine(); // Consume the leftover newline
                    gradebook.addStudent(name, studentId, grade);
                    break;

                case 2:
                    System.out.print("Enter student ID to update grade: ");
                    studentId = scanner.nextLine();
                    System.out.print("Enter new grade: ");
                    double newGrade = scanner.nextDouble();
                    scanner.nextLine(); // Consume the leftover newline
                    gradebook.updateGrade(studentId, newGrade);
                    break;

                case 3:
                    System.out.print("Enter student ID to view record: ");
                    studentId = scanner.nextLine();
                    gradebook.viewStudent(studentId);
                    break;

                case 4:
                    gradebook.viewAllStudents();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
