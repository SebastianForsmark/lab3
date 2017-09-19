package se.kth.ID1020;

import se.kth.ID1020.LinkedList.Node;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(30);
        populateList(list);
        System.out.print("List before being sorted: ");
        list.printList();
        System.out.println("\ninversionCount result: " + inversionCount(list));
        System.out.print("Amount of swaps in bubblesort: ");
        bubbleSort(list);
        System.out.print("\nList after being sorted: ");
        list.printList();

    }

    private static void bubbleSort(LinkedList list) {
        int swaps = 0;
        int r = list.nodeCount - 2;
        boolean swapped = true;
        while (r >= 0 && swapped) {
            Node current = list.head; // Reset current to point to the beginning of the list
            swapped = false;
            for (int i = 0; i <= r; i++) {
                if (greaterThan(current, current.next)) {
                    swapped = true;
                    swaps++;
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                current = current.next;
            }
            r--;
        }
        System.out.println(swaps);
    }

    private static boolean greaterThan(Node currentNode, Node nextNode) {
        return currentNode.compareTo(nextNode) == 1;
    }

    private static int inversionCount(LinkedList list) {
        Node compareFrom = list.head;
        int inversions = 0;
        for (int i = 0; i < list.nodeCount - 1; i++) {
            Node compareTo = compareFrom.next;
            while (compareTo != null) {
                if (compareFrom.data > compareTo.data) {
                    inversions++;
                }
                compareTo = compareTo.next;
            }
            compareFrom = compareFrom.next;
        }
        return inversions;
    }

    private static void populateList(LinkedList list) {
        Random ran = new Random();
        list.add(ran.nextInt(100));
        list.add(ran.nextInt(100));
        list.add(ran.nextInt(100));
        list.add(ran.nextInt(100));
        list.add(ran.nextInt(100));
        list.add(ran.nextInt(100));
        list.add(ran.nextInt(100));
        list.add(ran.nextInt(100));
        list.add(ran.nextInt(100));
    }
}