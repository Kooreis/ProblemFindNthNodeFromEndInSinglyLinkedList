Here is a simple console application in C# that solves the problem:

```csharp
using System;

public class Node
{
    public int Data;
    public Node Next;
}

public class LinkedList
{
    private Node head;

    public void Add(int data)
    {
        Node newNode = new Node() { Data = data };

        if (head == null)
        {
            head = newNode;
        }
        else
        {
            Node current = head;
            while (current.Next != null)
            {
                current = current.Next;
            }
            current.Next = newNode;
        }
    }

    public int FindNthFromEnd(int n)
    {
        Node mainPtr = head;
        Node refPtr = head;

        int count = 0;
        while (count < n)
        {
            if (refPtr == null)
            {
                return -1;
            }
            refPtr = refPtr.Next;
            count++;
        }

        while (refPtr != null)
        {
            mainPtr = mainPtr.Next;
            refPtr = refPtr.Next;
        }

        return mainPtr.Data;
    }
}

class Program
{
    static void Main(string[] args)
    {
        LinkedList list = new LinkedList();
        list.Add(1);
        list.Add(2);
        list.Add(3);
        list.Add(4);
        list.Add(5);

        Console.WriteLine("3rd node from end is " + list.FindNthFromEnd(3));
    }
}
```

This program creates a linked list with 5 nodes. It then finds the 3rd node from the end of the list and prints its value to the console. The `FindNthFromEnd` method uses two pointers to traverse the list. The first pointer starts at the head of the list and moves n nodes into the list. The second pointer then starts at the head of the list and moves along with the first pointer until the first pointer reaches the end of the list. At this point, the second pointer will be at the nth node from the end of the list.