package com.walking.lesson39_queue1.task1.model;

import com.walking.lesson39_queue1.task1.exception.ElementNotFoundException;

import java.util.Objects;

public class Stack<T> {
    private Node<T> top;
    private long size;

    public Stack() {
    }

    public Stack(T top) {
        this.top = new Node<>(top);
        size++;
    }

    public void add(T element) {
        top = new Node<>(element, top);
        size++;
    }

    public void delete(T element) {
        Node<T> temp = top;

        if (Objects.equals(element, top.value)) {
            top = top.next;
            size--;

            return;
        }

        while (temp.next != null) {
            if (Objects.equals(element, temp.next.value)) {
                temp.next = temp.next.next;
                size--;

                return;
            }

            temp = temp.next;
        }

        throw new ElementNotFoundException();
    }

    public void deleteByEvenHashCode() {
        Node<T> temp = top;

        while (temp.next != null) {
            if (temp.next.hashCode() % 2 == 0) {
                temp.next = temp.next.next;
                size--;
            } else {
                temp = temp.next;
            }
        }

        if (top.hashCode() % 2 == 0) {
            top = top.next;
            size--;
        }
    }

    public Stack reverse() {
        Stack reversStack = new Stack(top.value);
        Node<T> next = top;
        while (next.next != null) {
            reversStack.add(next.next.value);
            next = next.next;
        }
        return reversStack;
    }

    public T find(T element) {
        Node<T> temp = top;

        while (temp != null) {
            if (Objects.equals(element, temp.value)) {
                return temp.value;
            }

            temp = temp.next;
        }

        throw new ElementNotFoundException();
    }

    public long getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder toStringValue = new StringBuilder("[");
        Node<T> temp = top;

        while (temp != null) {
            toStringValue.append(temp.value);
            toStringValue.append(String.format("(%d)", temp.hashCode()));
            if (temp.next != null) {
                toStringValue.append(", ");
            }

            temp = temp.next;
        }

        toStringValue.append("]");

        return toStringValue.toString();
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }

        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return value.equals(node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
}