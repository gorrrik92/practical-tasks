package com.walking.lesson39_queue1.task1;

import com.walking.lesson39_queue1.task1.model.Stack;

/**
 * Реализуйте односвязный список (можно использовать реализацию в рамках
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson28_generics1/task4/structure/Stack.java">...</a>).
 * <p>
 * Реализуйте метод, разворачивающий односвязный список
 * (первый элемент должен стать последним, второй – предпоследним и т.д.).
 * <p>
 * Также реализуйте метод, удаляющий все узлы, хэшкод элемента которых - четный.
 */
public class Main {
    public static void main(String[] args) {
        Stack<Integer> testStack = createTestIntStack();
        System.out.println(testStack.getSize());
        System.out.println(testStack);

        System.out.println(testStack.find(4));

//        testStack.delete(1);
        testStack.add(8);
        testStack.add(9);
        System.out.println(testStack.getSize());
        System.out.println(testStack);

        testStack = testStack.reverse();
        testStack.deleteByEvenHashCode();
        System.out.println(testStack);
    }

    private static Stack<Integer> createTestIntStack() {
        Stack<Integer> testStack = new Stack<>();
        testStack.add(1);
        testStack.add(2);
        testStack.add(3);
        testStack.add(4);
        testStack.add(5);
        testStack.add(6);
        testStack.add(7);

        return testStack;
    }
}
