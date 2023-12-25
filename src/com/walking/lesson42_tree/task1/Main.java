package com.walking.lesson42_tree.task1;

import com.walking.lesson42_tree.task1.model.BeSearchTree;
import com.walking.lesson42_tree.task1.model.Node;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Реализуйте бинарное дерево поиска. Учтите возможность использования дерева как для Comparable-сущностей,
 * так и для сортировки на основе компаратора.
 * <p>
 * Реализуйте в рамках дерева методы, производящие обход в глубину (любой из трех рассмотренных в статье) и ширину.
 * Результатом работы этих методов должно быть перечисление элементов дерева в консоли в порядке их обхода.
 * <p>
 * Обратите внимание: в этой задаче не идет речи об автобалансировке дерева.
 * <p>
 * Опциональное условие(*): реализуйте метод балансировки дерева по высоте.
 * В рамках текущей задачи принимается реализация любой степени наивности,
 * если она дает корректный результат.
 */
public class Main {
    public static void main(String[] args) {
        BeSearchTree tree = new BeSearchTree();
        System.out.println("Enter the elements:");
        Scanner sc = new Scanner(System.in);
        String elements = sc.nextLine();
        String[] elArray = elements.trim().split(" ");
        for (int i = 0; i < elArray.length; i++) {
            int el = Integer.parseInt(elArray[i]);
            tree.insert(el, el);
        }
        sc.close();
        System.out.println("Go around centered:");
        tree.goCentered(tree.getRoot());

        System.out.println("\nGo around direct:");
        tree.goDirect(tree.getRoot());

        System.out.println("\nGo around reverse:");
        tree.goReverse(tree.getRoot());

        System.out.println("\nGo around in width:");
        tree.goInWidth();
    }
}
