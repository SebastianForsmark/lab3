package se.kth.ID1020;

import java.util.Iterator;

public class LinkedList implements Iterable<LinkedList.Node> {

    Node head;
    private Node current;
    int nodeCount;

    LinkedList(int data) {
        head = new Node(data);
        current = head;
        nodeCount = 1;
    }

    public Iterator<Node> iterator() {

        return new Iterator<Node>() {
            public void remove() {
            }

            public boolean hasNext() {
                return current != null;
            }

            public Node next() {
                Node node = current;
                current = current.next;
                return node;
            }
        };

    }

    void add(int data) {
        while (current.next != null)
            current = current.next;

        current.next = new Node(data);
        nodeCount++;
    }

    void printList() {
        Node temp = current;
        current = head;
        System.out.print("\n" + current.data + " -> ");
        while (current.next != null) {
            System.out.print(current.next.data + " -> ");
            current = current.next;
        }
        current = temp;
        System.out.println();
    }

    public static class Node implements Comparable<Node> {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        public int compareTo(Node other) {
            if (data > other.data)
                return 1;
            else if (data < other.data)
                return -1;
            else
                return 0;
        }

    }

}