/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

/* Name: Le Cong Hung
Student Code: SE161248
Purpose: StudentList.
 */
import java.util.ArrayList;
import java.util.List;

public class BottomUpHeap {

    private List<Student> heap;

    public BottomUpHeap() {
        heap = new ArrayList<>();
    }

    public void insert(Student student) {
        // Add the student to the end of the list (bottom-up)
        heap.add(student);
        // Perform bottom-up heapify
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        while (index > 0 && heap.get(index).getStudentID() < heap.get(parentIndex).getStudentID()) {
            // Swap the student at the current index with its parent
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void swap(int i, int j) {
        Student temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void display() {
        for (Student student : heap) {
            System.out.println(student.getLastName() + " (" + student.getStudentID() + ")");
        }
    }

}
