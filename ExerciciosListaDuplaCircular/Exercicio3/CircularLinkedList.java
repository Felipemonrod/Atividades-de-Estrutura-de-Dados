package Exercicio3;

// Classe que representa um nó da lista
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Classe para a Lista Encadeada Circular
public class CircularLinkedList {
    private Node head; // Referência para o primeiro nó da lista

    // Construtor
    public CircularLinkedList() {
        head = null;
    }

    // a. Método para contar o número de elementos na lista
    public int countElements() {
        if (head == null) {
            return 0; // Lista vazia
        }
        int count = 0;
        Node current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }

    // b. Método para inserir um elemento à esquerda da cabeça da lista
    public void insertLeftOfHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head; // Lista circular com um único nó
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next; // Encontra o último nó
            }
            newNode.next = head;
            last.next = newNode;
            head = newNode; // Atualiza a cabeça
        }
    }

    // c. Método para concatenar duas listas circulares
    public void concatenate(CircularLinkedList other) {
        if (this.head == null) {
            this.head = other.head;
        } else if (other.head != null) {
            Node thisLast = this.head;
            while (thisLast.next != this.head) {
                thisLast = thisLast.next; // Encontra o último nó da lista atual
            }
            Node otherLast = other.head;
            while (otherLast.next != other.head) {
                otherLast = otherLast.next; // Encontra o último nó da outra lista
            }
            thisLast.next = other.head; // Concatena as listas
            otherLast.next = this.head; // Mantém a circularidade
        }
    }

    // d. Método para intercalar duas listas ordenadas
    public static CircularLinkedList mergeSortedLists(CircularLinkedList list1, CircularLinkedList list2) {
        CircularLinkedList mergedList = new CircularLinkedList();
        Node a = list1.head, b = list2.head;

        if (a == null) return list2;
        if (b == null) return list1;

        Node tail = null; // Rastreia o último nó adicionado à lista intercalada

        do {
            if (a.data <= b.data) {
                if (mergedList.head == null) {
                    mergedList.head = a;
                } else {
                    tail.next = a;
                }
                tail = a;
                a = a.next;
            } else {
                if (mergedList.head == null) {
                    mergedList.head = b;
                } else {
                    tail.next = b;
                }
                tail = b;
                b = b.next;
            }
        } while (a != list1.head && b != list2.head);

        // Adiciona os elementos restantes de list1
        while (a != list1.head) {
            tail.next = a;
            tail = a;
            a = a.next;
        }

        // Adiciona os elementos restantes de list2
        while (b != list2.head) {
            tail.next = b;
            tail = b;
            b = b.next;
        }

        // Mantém a circularidade
        tail.next = mergedList.head;
        return mergedList;
    }

    // e. Método para fazer uma cópia da lista
    public CircularLinkedList copy() {
        CircularLinkedList newList = new CircularLinkedList();
        if (head == null) {
            return newList; // Lista vazia
        }
        Node current = head;
        do {
            newList.insertLeftOfHead(current.data); // Insere os elementos na nova lista
            current = current.next;
        } while (current != head);
        return newList;
    }

    // Método para exibir a lista
    public void display() {
        if (head == null) {
            System.out.println("A lista está vazia.");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}