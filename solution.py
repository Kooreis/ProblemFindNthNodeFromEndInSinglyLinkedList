class Node:
    def __init__(self, data=None):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None

    def append(self, data):
        if not self.head:
            self.head = Node(data)
        else:
            current = self.head
            while current.next:
                current = current.next
            current.next = Node(data)

    def find_nth_from_end(self, n):
        main_ptr = self.head
        ref_ptr = self.head
        count = 0

        if self.head is not None:
            while count < n:
                if ref_ptr is None:
                    return
                ref_ptr = ref_ptr.next
                count += 1

        if ref_ptr is None:
            self.head = self.head.next
            if self.head is not None:
                return self.head.data
        else:
            while ref_ptr is not None:
                main_ptr = main_ptr.next
                ref_ptr = ref_ptr.next
            return main_ptr.data


if __name__ == "__main__":
    llist = LinkedList()
    llist.append("A")
    llist.append("B")
    llist.append("C")
    llist.append("D")
    llist.append("E")
    llist.append("F")

    n = 3
    nth_node = llist.find_nth_from_end(n)
    print("The {}th node from the end is {}".format(n, nth_node))