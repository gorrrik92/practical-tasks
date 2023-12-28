package com.walking.lesson42_tree.task2.model;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

public class AVLTree {
    private Node root;

    public AVLTree(Node root) {
        this.root = root;
    }

    public AVLTree() {
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
            if (node.left == null) {
                node.left = newNode;
            } else {
                insert(node.left, newNode);
            }
        } else {
            if (node.right == null) {
                node.right = newNode;
            } else {
                insert(node.right, newNode);
            }
        }
        updateHeight(node);
        balance(node);
    }

    public void updateHeight(Node node) {
        int height = Math.max(getHeight(node.left),
                getHeight(node.right)) + 1;
        node.height = height;
    }

    public int getHeight(Node node) {
        if (node == null)
            return -1;
        else
            return node.height;
    }

    public Node getMaxNode() {
        return getMaxNode(root);
    }

    public Node getMaxNode(Node node) {
        if (node == null || node.right == null)
            return node;
        return getMaxNode(node.right);
    }

    public Node getMinNode() {
        return getMinNode(root);
    }

    public Node getMinNode(Node node) {
        if (node == null || node.left == null)
            return node;
        return getMinNode(node.left);
    }

    public Node deleteNode(int key) {
        return deleteNode(root, key);
    }

    public Node deleteNode(Node node, int key) {
        if (node == null) {
            return null;
        } else if (key < node.key) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.key) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.left != null && node.right != null) {
                Node maxInLeftNode = getMaxNode(node.left);
                node.key = maxInLeftNode.key;
                node.left = deleteNode(node.left, maxInLeftNode.key);
            } else {
                node = (node.left != null) ? node.left : node.right;
            }
        }

        if (node != null) {
            updateHeight(node);
            balance(node);
        }

        return node;
    }
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        } else {
            return getHeight(node.right) - getHeight(node.left);
        }
    }

    public void balance(Node node) {
        int balanceValue = getBalance(node);
        if (Math.abs(balanceValue) < 2) {
            return;
        }
        if (balanceValue == -2) {
            if (getBalance(node.left) == 1){
                leftRotate(node.left);
            }
            rightRotate(node);
        } else {
            if (getBalance(node.right) == -1){
                rightRotate(node.right);
            }
            leftRotate(node);
        }
    }

    private void rightRotate(Node node) {
        swapNodes(node, node.left);
        Node buffer = node.right;
        node.right = node.left;
        node.left = node.right.left;
        node.right.left = node.right.right;
        node.right.right = buffer;

        updateHeight(node.right);
        updateHeight(node);
    }

    private void leftRotate(Node node) {
        swapNodes(node, node.right);
        Node buffer = node.left;
        node.left = node.right;
        node.right = node.left.right;
        node.left.right = node.left.left;
        node.left.left = buffer;

        updateHeight(node.left);
        updateHeight(node);

    }

    private void swapNodes(Node a, Node b) {
        int bufferKey = a.key;
        a.key = b.key;
        b.key = bufferKey;
    }

    public Node search(int key) {
        return search(root, key);
    }

    private Node search(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (node.key == key) {
            return node;
        } else if (key < node.key) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    public void goDirect(Node node) {
        if (node == null) {
            return;
        }
        print(node);
        goDirect(node.left);
        goDirect(node.right);
    }

    public void goCentered(Node node) {
        if (node == null) {
            return;
        }
        goCentered(node.left);
        print(node);
        goCentered(node.right);
    }


    public void goReverse(Node node) {
        if (node == null) {
            return;
        }
        goReverse(node.left);
        goReverse(node.right);
        print(node);
    }

    public void goInWidth() {
        if (root == null) {
            return;
        }
        Queue<Node> widthQueue = new ArrayDeque<>(Collections.singleton(root));
        goInWidth(widthQueue);
    }

    private void goInWidth(Queue<Node> widthQueue) {
        Queue<Node> nextQueue = new ArrayDeque<>();
        while (!widthQueue.isEmpty()) {
            Node node = widthQueue.poll();
            print(node);
            if (node.left != null)
                nextQueue.add(node.left);
            if (node.right != null)
                nextQueue.add(node.right);
        }
        System.out.println();
        if (!nextQueue.isEmpty())
            goInWidth(nextQueue);
    }

    private void print(Node node) {
        System.out.printf("%d(%d) ", node.key, node.height);
    }
    
    public class Node implements Comparable<Node>{
        private int key;
        private Node left;
        private Node right;
        private int height;

        public Node(int key) {
            this.key = key;
            this.height = 0;
        }

        @Override
        public int compareTo(Node node) {
            return this.key - node.key;
        }
    }
}
