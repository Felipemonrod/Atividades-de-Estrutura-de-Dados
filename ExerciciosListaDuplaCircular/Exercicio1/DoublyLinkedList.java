package Exercicio1;

// Classe que representa um nó da lista
class Node {
    int data;
    Node next, prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// Classe para a Lista Duplamente Encadeada
public class DoublyLinkedList {
    Node head, tail;

    // Adicionar um elemento ao final da lista
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Exibir a lista
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // a. Método para concatenar duas listas
    public void concatenate(DoublyLinkedList other) {
        if (this.head == null) {
            this.head = other.head;
            this.tail = other.tail;
        } else if (other.head != null) {
            this.tail.next = other.head;
            other.head.prev = this.tail;
            this.tail = other.tail;
        }
    }

    // b. Método para dividir a lista em duas
    public DoublyLinkedList[] split() {
        if (head == null) return new DoublyLinkedList[]{new DoublyLinkedList(), new DoublyLinkedList()};

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        DoublyLinkedList firstHalf = new DoublyLinkedList();
        firstHalf.head = head;
        firstHalf.tail = slow.prev;
        if (firstHalf.tail != null) firstHalf.tail.next = null;

        DoublyLinkedList secondHalf = new DoublyLinkedList();
        secondHalf.head = slow;
        secondHalf.tail = this.tail;
        if (secondHalf.head != null) secondHalf.head.prev = null;

        // Limpa a lista original
        this.head = null;
        this.tail = null;

        return new DoublyLinkedList[]{firstHalf, secondHalf};
    }

    // c. Método para intercalar duas listas ordenadas em uma lista ordenada
    public static DoublyLinkedList mergeSortedLists(DoublyLinkedList l1, DoublyLinkedList l2) {
        DoublyLinkedList mergedList = new DoublyLinkedList();
        Node a = l1.head, b = l2.head;

        while (a != null && b != null) {
            if (a.data < b.data) {
                mergedList.append(a.data);
                a = a.next;
            } else {
                mergedList.append(b.data);
                b = b.next;
            }
        }

        while (a != null) {
            mergedList.append(a.data);
            a = a.next;
        }

        while (b != null) {
            mergedList.append(b.data);
            b = b.next;
        }

        return mergedList;
    }
}