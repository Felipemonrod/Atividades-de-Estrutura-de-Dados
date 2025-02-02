package Exercicio4;

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

// Classe para a Lista Circular Duplamente Encadeada
public class DoublyCircularLinkedList {
    private Node head; // Referência para o primeiro nó da lista

    // Construtor
    public DoublyCircularLinkedList() {
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
            head.prev = head;
        } else {
            Node last = head.prev; // Último nó da lista
            newNode.next = head;
            newNode.prev = last;
            last.next = newNode;
            head.prev = newNode;
            head = newNode; // Atualiza a cabeça
        }
    }

    // c. Método para concatenar duas listas circulares
    public void concatenate(DoublyCircularLinkedList other) {
        if (this.head == null) {
            this.head = other.head;
        } else if (other.head != null) {
            Node thisLast = this.head.prev; // Último nó da lista atual
            Node otherLast = other.head.prev; // Último nó da outra lista

            thisLast.next = other.head;
            other.head.prev = thisLast;
            otherLast.next = this.head;
            this.head.prev = otherLast;
        }
    }

    // d. Método para intercalar duas listas ordenadas
    public static DoublyCircularLinkedList mergeSortedLists(DoublyCircularLinkedList list1, DoublyCircularLinkedList list2) {
        DoublyCircularLinkedList mergedList = new DoublyCircularLinkedList();
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
                    a.prev = tail;
                }
                tail = a;
                a = a.next;
            } else {
                if (mergedList.head == null) {
                    mergedList.head = b;
                } else {
                    tail.next = b;
                    b.prev = tail;
                }
                tail = b;
                b = b.next;
            }
        } while (a != list1.head && b != list2.head);

        // Adiciona os elementos restantes de list1
        while (a != list1.head) {
            tail.next = a;
            a.prev = tail;
            tail = a;
            a = a.next;
        }

        // Adiciona os elementos restantes de list2
        while (b != list2.head) {
            tail.next = b;
            b.prev = tail;
            tail = b;
            b = b.next;
        }

        // Mantém a circularidade
        tail.next = mergedList.head;
        mergedList.head.prev = tail;
        return mergedList;
    }

    // e. Método para fazer uma cópia da lista
    public DoublyCircularLinkedList copy() {
        DoublyCircularLinkedList newList = new DoublyCircularLinkedList();
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

    // f. Método para remover um elemento da lista
    public void delete(int data) {
        if (head == null) {
            System.out.println("Lista vazia.");
            return;
        }
        Node current = head;
        do {
            if (current.data == data) {
                if (current == head && head.next == head) {
                    head = null; // Lista com um único nó
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    if (current == head) {
                        head = head.next; // Atualiza a cabeça se o nó removido for a cabeça
                    }
                }
                return;
            }
            current = current.next;
        } while (current != head);
        System.out.println("Elemento não encontrado na lista.");
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