package com.FinalSprint.Trees.Entity;

import jakarta.persistence.*;

@Entity
public class BinaryTree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String input_numbers;

    @Transient // Exclude from persistence
    private Node root;

    // Constructors, getters, setters, and other methods

    // Default constructor
    public BinaryTree() {
        this.root = null;
    }

    // Constructor with input numbers
    public BinaryTree(int[] numbers) {
        this.root = null; // Root will be constructed by insert method
        this.input_numbers = arrayToString(numbers);
        // Will be constructed by insert method
        for (int num : numbers) {
            insert(num); // Constructing the tree while inserting each number
        }
    }

    // Getter for root
    public Node getRoot() {
        return root;
    }

    // Setter for root
    public void setRoot(Node root) {
        this.root = root;
    }

    // Method to insert a node into the binary search tree
    public void insert(int data) {
        root = insertRec(root, data);
    }

    // Recursive method to insert a node into the binary search tree
    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.getData()) {
            root.setLeft(insertRec(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(insertRec(root.getRight(), data));
        }
        return root;
    }

    // Helper method to convert an array to a string
    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(", ");
        }
        return sb.delete(sb.length() - 2, sb.length()).toString(); // Remove last comma and space
    }

    // Helper method to convert a binary tree to a string (in-order traversal)
    private String treeToString(Node root) {
        StringBuilder sb = new StringBuilder();
        inOrderTraversal(root, sb);
        return sb.toString();
    }

    // Helper method for in-order traversal of the binary tree
    private void inOrderTraversal(Node root, StringBuilder sb) {
        if (root != null) {
            inOrderTraversal(root.getLeft(), sb);
            sb.append(root.getData()).append(", ");
            inOrderTraversal(root.getRight(), sb);
        }
    }
}
