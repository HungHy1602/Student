/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package student;

/* Name: Le Cong Hung
Student Code: SE161248
Purpose: StudentList.
 */
public class Student {

    private int studentID;
    private String firstName;
    private String lastName;
    private int grade;

    public Student(int studentID, String firstName, String lastName, int grade) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    // Define getter methods for grade, if needed
    public int getStudentID() {
        return studentID;
    }

    public String getLastName() {
        return lastName;
    }

    // Rest of your Student class
    @Override
    public String toString() {
        return lastName + " (" + studentID + ")";
    }
}
