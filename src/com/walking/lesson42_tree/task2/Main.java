package com.walking.lesson42_tree.task2;

import com.walking.lesson42_tree.task1.model.BinarySearchTree;
import com.walking.lesson42_tree.task2.model.AVLTree;

import java.util.Scanner;

/**
 * Реализуйте АВЛ-дерево.
 * Сопроводите действия по добавлению (и последующей балансировке)
 * и удалению элементов выводом соответствующих сообщений в консоль.
 */
public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        System.out.println("Enter the elements:");
//        Scanner sc = new Scanner(System.in);
        String elements = "4 3 5 0 2 8 9 6 7 0 11 3";
        String[] elArray = elements.trim().split(" ");
        for (int i = 0; i < elArray.length; i++) {
            int el = Integer.parseInt(elArray[i]);
            tree.insert(el);
        }
        //sc.close();
/*        System.out.println("Go around centered:");
        tree.goCentered(tree.getRoot());

        System.out.println("\nGo around direct:");
        tree.goDirect(tree.getRoot());

        System.out.println("\nGo around reverse:");
        tree.goReverse(tree.getRoot());*/

        System.out.println("\nGo around in width:");
        tree.goInWidth();

        tree.deleteNode(3);
        System.out.println("\nGo around in width:");
        tree.goInWidth();

        tree.deleteNode(0);
        System.out.println("\nGo around in width:");
        tree.goInWidth();
    }
}
