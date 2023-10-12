/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

/* Name: Le Cong Hung
Student Code: SE161248
Purpose: StudentList.
 */
public class AVLTree {

    private TreeNode root;

    private class TreeNode {

        private Student student;
        private TreeNode left;
        private TreeNode right;
        private int height;

        public TreeNode(Student student) {
            this.student = student;
            this.height = 1;
        }
    }

    public void insert(Student student) {
        root = insert(root, student);
    }

    private TreeNode insert(TreeNode node, Student student) {
        if (node == null) {
            return new TreeNode(student);
        }

        int studentID = student.getStudentID();
        int nodeID = node.student.getStudentID();

        if (studentID < nodeID) {
            node.left = insert(node.left, student);
        } else if (studentID > nodeID) {
            node.right = insert(node.right, student);
        } else {
            // Duplicate student IDs not allowed in this example
            throw new IllegalArgumentException("Duplicate student ID: " + studentID);
        }

        // Update height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // Perform AVL balancing
        int balance = getBalance(node);

        // Left heavy
        if (balance > 1 && studentID < nodeID) {
            return rightRotate(node);
        }

        // Right heavy
        if (balance < -1 && studentID > nodeID) {
            return leftRotate(node);
        }

        // Left-Right heavy
        if (balance > 1 && studentID > nodeID) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right-Left heavy
        if (balance < -1 && studentID < nodeID) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private int getHeight(TreeNode node) {
        return (node != null) ? node.height : 0;
    }

    private int getBalance(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    private TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    public void displayInOrder() {
        displayInOrder(root);
    }

    private void displayInOrder(TreeNode node) {
        if (node != null) {
            displayInOrder(node.left);
            System.out.println(node.student.getLastName() + " (" + node.student.getStudentID() + ")");
            displayInOrder(node.right);
        }
    }

}
