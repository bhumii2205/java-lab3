//Main.java
// Main program with a menu-driven approach

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentOperations studentOperations = new StudentOperations();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Menu options
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Position");
            System.out.println("6. Update Student");
            System.out.println("7. Delete Student");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear the buffer
                continue;
            }
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Adding student
                    System.out.print("Enter PRN: ");
                    String prn = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter DOB (dd-mm-yyyy): ");
                    String dob = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    studentOperations.addStudent(new Student(prn, name, dob, marks));
                    break;

                case 2:
                    // Displaying all students
                    studentOperations.displayStudents();
                    break;

                case 3:
                    // Searching by PRN
                    System.out.print("Enter PRN: ");
                    String searchPrn = scanner.nextLine();
                    Student student = studentOperations.searchByPrn(searchPrn);
                    if (student != null) {
                        student.displayStudent();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    // Searching by Name
                    System.out.print("Enter Name: ");
                    String searchName = scanner.nextLine();
                    studentOperations.searchByName(searchName);
                    break;

                case 5:
                    // Searching by Position
                    System.out.print("Enter Position (index): ");
                    int position;
                    try {
                        position = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        studentOperations.searchByPosition(position);
                    } catch (Exception e) {
                        System.out.println("Invalid input! Position must be a number.");
                        scanner.nextLine(); // Clear the buffer
                    }
                    break;

                case 6:
                    // Updating student details
                    System.out.print("Enter PRN to update: ");
                    String updatePrn = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New DOB (dd-mm-yyyy): ");
                    String newDob = scanner.nextLine();
                    System.out.print("Enter New Marks: ");
                    double newMarks = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    studentOperations.updateStudent(updatePrn, newName, newDob, newMarks);
                    break;

                case 7:
                    // Deleting student
                    System.out.print("Enter PRN to delete: ");
                    String deletePrn = scanner.nextLine();
                    studentOperations.deleteStudent(deletePrn);
                    break;

                case 8:
                    // Exit program
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}