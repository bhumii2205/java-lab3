// StudentOperations.java
// Contains methods to perform CRUD operations on Student objects

import java.util.ArrayList;

public class StudentOperations {
    private ArrayList<Student> students = new ArrayList<>();

    // Add a new student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                student.displayStudent();
            }
        }
    }

    // Search by PRN
    public Student searchByPrn(String prn) {
        for (Student student : students) {
            if (student.getPrn().equalsIgnoreCase(prn)) {
                return student;
            }
        }
        return null;
    }

    // Search by Name
    public void searchByName(String name) {
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                student.displayStudent();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with name: " + name);
        }
    }

    // Search by position (index)
    public void searchByPosition(int index) {
        if (index >= 0 && index < students.size()) {
            students.get(index).displayStudent();
        } else {
            System.out.println("Invalid position.");
        }
    }

    // Update student details
    public void updateStudent(String prn, String name, String dob, double marks) {
        Student student = searchByPrn(prn);
        if (student != null) {
            student.setName(name);
            student.setDob(dob);
            student.setMarks(marks);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Delete a student by PRN
    public void deleteStudent(String prn) {
        Student student = searchByPrn(prn);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
}