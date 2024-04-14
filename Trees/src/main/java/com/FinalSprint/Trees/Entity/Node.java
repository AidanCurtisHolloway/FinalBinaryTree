package com.FinalSprint.Trees.Entity;

public class Node {
    private int data;
    private Node left;
    private Node right;

    // Constructors
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // Getters and setters for data
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    // Getters and setters for left child node
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    // Getters and setters for right child node
    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
