package com.walking.lesson42_tree.task1.model;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public BinarySearchTree() {
    }

    public Node getRoot() {
        return root;
    }

    public void insert(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
        } else {
            insert(root, newNode);
        }
    }
    private void insert(Node node, Node  newNode) {
        if (node.compareTo(newNode) >= 0) {
            if (node.getLeft() == null) {
                node.setLeft(newNode);
            } else {
                insert(node.getLeft(), newNode);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(newNode);
            } else {
                insert(node.getRight(), newNode);
            }
        }
        updateHeight(node);
    }

    public void updateHeight(Node node) {
        int height = Math.max(getHeight(node.getLeft()),
                getHeight(node.getRight())) +1;
        node.setHeight(height);
    }

    public int getHeight(Node node) {
        if (node == null)
            return -1;
        else
            return node.getHeight();
    }

    public Node getMaxNode(Node node) {
        if (node.getRight() == null)
            return node;
        return getMaxNode(node.getRight());
    }

    public Node getMinNode(Node node) {
        if (node.getLeft() == null)
            return node;
        return getMinNode(node.getLeft());
    }

    public void deleteNode(Node rootNode, int key) {
        Node node = search(rootNode, key);
        if (node == null)
            return;
    }

    public Node search(int key) {
        return search(root, key);
    }

    private Node search(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (node.getKey() == key) {
            return node;
        } else if (key < node.getKey()) {
            return search(node.getLeft(), key);
        } else {
            return search(node.getRight(), key);
        }
    }

    public void goDirect(Node node) {
        if (node == null) {
            return;
        }
        print(node);
        goDirect(node.getLeft());
        goDirect(node.getRight());
    }

    public void goCentered(Node node) {
        if (node == null) {
            return;
        }
        goCentered(node.getLeft());
        print(node);
        goCentered(node.getRight());
    }


    public void goReverse(Node node) {
        if (node == null) {
            return;
        }
        goReverse(node.getLeft());
        goReverse(node.getRight());
        print(node);
    }

    public void goInWidth() {
        if (root == null) {
            return;
        }
        Queue<Node> widthQueue = new ArrayDeque<>();
        widthQueue.add(root);
        goInWidth(widthQueue);
    }

    private void goInWidth(Queue<Node> widthQueue) {
        Queue<Node> nextQueue = new ArrayDeque<>();
        while (!widthQueue.isEmpty()) {
            Node node = widthQueue.poll();
            print(node);
            if (node.getLeft() != null)
                nextQueue.add(node.getLeft());
            if (node.getRight() != null)
                nextQueue.add(node.getRight());
        }
        System.out.println();
        if (!nextQueue.isEmpty())
            goInWidth(nextQueue);
    }

    private void print(Node node) {
        System.out.printf("%d(%d) ", node.getKey(), node.getHeight());
    }
}
