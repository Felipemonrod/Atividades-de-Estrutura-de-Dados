package Exercicio5;

// Classe que representa um nó da lista
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Classe para a Lista Circular com Nó Cabeça
public class CircularLinkedListWithHead {
    private Node head; // Nó cabeça (não armazena dados)

    // Construtor
    public CircularLinkedListWithHead() {
        head = new Node(-1); // Nó cabeça com valor inválido (ou sentinela)
        head.next = head; // Aponta para si mesmo (lista vazia)
    }

    // Método para verificar se a lista está vazia
    public boolean isEmpty() {
        return head.next == head;
    }

    // Método para inserir um elemento no início da lista
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head.next; // Novo nó aponta para o primeiro nó atual
        head.next = newNode; // Nó cabeça aponta para o novo nó
    }

    // Método para inserir um elemento no final da lista
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        Node current = head;
        while (current.next != head) {
            current = current.next; // Encontra o último nó
        }
        newNode.next = head; // Novo nó aponta para o nó cabeça
        current.next = newNode; // Último nó aponta para o novo nó
    }

    // Método para remover um elemento da lista
    public void delete(int data) {
        if (isEmpty()) {
            System.out.println("Lista vazia.");
            return;
        }
        Node current = head;
        while (current.next != head) {
            if (current.next.data == data) {
                Node nodeToDelete = current.next;
                current.next = nodeToDelete.next; // Remove o nó
                nodeToDelete.next = null; // Limpa a referência
                System.out.println("Elemento " + data + " removido.");
                return;
            }
            current = current.next;
        }
        System.out.println("Elemento " + data + " não encontrado na lista.");
    }

    // Método para contar o número de elementos na lista
    public int countElements() {
        int count = 0;
        Node current = head.next;
        while (current != head) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Método para exibir a lista
    public void display() {
        if (isEmpty()) {
            System.out.println("A lista está vazia.");
            return;
        }
        Node current = head.next;
        while (current != head) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}