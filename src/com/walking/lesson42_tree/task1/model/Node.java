package com.walking.lesson42_tree.task1.model;

public class Node implements Comparable<Node>{
    private int key;
    private Node left;
    private Node right;
    private int height;

    public Node(int key) {
        this.key = key;
        this.height = 0;
    }

    public int getKey() {
        return key;
    }


    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int compareTo(Node node) {
        return this.key - node.getKey();
    }
}
