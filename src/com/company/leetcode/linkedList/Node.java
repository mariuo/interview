package com.company.leetcode.linkedList;
class Node<T> {
    T value;
    Node<T> next;
    Node<T> prev;

    public Node(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addToFront(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addToEnd(T value) {
        Node<T> newNode = new Node<>(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public T removeFromFront() {
        if (head == null) return null;
        T removedValue = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        return removedValue;
    }

    public T removeFromEnd() {
        if (tail == null) return null;
        T removedValue = tail.value;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        return removedValue;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) System.out.print(" <-> ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> intList = new DoublyLinkedList<>();
        intList.addToFront(1);
        intList.addToEnd(2);
        intList.addToFront(0);
        intList.addToEnd(3);

        intList.printList();  // Saída: 0 <-> 1 <-> 2 <-> 3

        intList.removeFromFront();
        intList.printList();  // Saída: 1 <-> 2 <-> 3

        intList.removeFromEnd();
        intList.printList();  // Saída: 1 <-> 2

        System.out.println();

        DoublyLinkedList<String> stringList = new DoublyLinkedList<>();
        stringList.addToFront("C");
        stringList.addToEnd("Java");
        stringList.addToFront("Python");
        stringList.addToEnd("Go");

        stringList.printList();  // Saída: Python <-> C <-> Java <-> Go

        stringList.removeFromFront();
        stringList.printList();  // Saída: C <-> Java <-> Go

        stringList.removeFromEnd();
        stringList.printList();  // Saída: C <-> Java
    }
}
