/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

/* Name: Le Cong Hung
Student Code: SE161248
Purpose: StudentList.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentManager {

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        BottomUpHeap bottomUpHeap = new BottomUpHeap();
        TopDownHeap topDownHeap = new TopDownHeap();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/students.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = parseStudent(line);

                avlTree.insert(student);
                bottomUpHeap.insert(student);
                topDownHeap.insert(student);
            }
            reader.close();
            System.out.println("================");
            System.out.println("AVL Tree:");
            System.out.println("================");
            avlTree.displayInOrder();

            System.out.println("\n================");
            System.out.println("Bottom-Up Heap:");
            System.out.println("================");
            bottomUpHeap.display();

            System.out.println("\n================");
            System.out.println("Top-Down Heap:");
            System.out.println("================");
            topDownHeap.display();
            System.out.println("================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Student parseStudent(String line) {
        String[] parts = line.split(" ");

        if (parts.length < 4) {
            throw new IllegalArgumentException("Invalid data format in line: " + line);
        }

        // Extract the student ID
        String studentIDString = parts[0];
        int studentID = parseStudentID(studentIDString);

        String firstName = parts[1];
        String lastName = parts[2];
        int grade = Integer.parseInt(parts[3]);

        return new Student(studentID, firstName, lastName, grade);
    }

    private static int parseStudentID(String studentIDString) {
        // Remove non-numeric characters and parse the numeric part
        String numericPart = studentIDString.replaceAll("[^0-9]", "");
        return Integer.parseInt(numericPart);
    }

}
