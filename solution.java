Here is a Java console application that solves the problem:

```java
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    int getNthFromLast(int n) {
        Node mainPtr = head;
        Node refPtr = head;

        int count = 0;
        while (count < n) {
            if (refPtr == null) {
                return -1;
            }
            refPtr = refPtr.next;
            count++;
        }

        while (refPtr != null) {
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }

        return mainPtr.data;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the linked list:");
        int numElements = scanner.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < numElements; i++) {
            list.push(scanner.nextInt());
        }

        System.out.println("Enter the position from the end:");
        int n = scanner.nextInt();

        int nthFromLast = list.getNthFromLast(n);
        if (nthFromLast != -1) {
            System.out.println("The " + n + "th node from the end is " + nthFromLast);
        } else {
            System.out.println("The linked list is too short for your request");
        }
    }
}
```

This program first asks the user to enter the number of elements in the linked list, then the elements themselves. It then asks for the position from the end, and prints the data of the node at that position. If the linked list is too short, it informs the user.