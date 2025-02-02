package Exercicio2;

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

// Classe para a Lista Duplamente Encadeada com Nó Cabeça
public class DoublyLinkedListWithHead {
    private Node head; // Nó cabeça

    // Construtor
    public DoublyLinkedListWithHead() {
        head = new Node(-1); // Nó cabeça com valor inválido (ou sentinela)
        head.next = head; // Aponta para si mesmo (lista vazia)
        head.prev = head;
    }

    // Método para verificar se a lista está vazia
    public boolean isEmpty() {
        return head.next == head;
    }

    // Método para buscar um elemento na lista
    public Node search(int data) {
        Node current = head.next; // Começa do primeiro nó após o cabeça
        while (current != head) { // Percorre até voltar ao cabeça
            if (current.data == data) {
                return current; // Retorna o nó encontrado
            }
            current = current.next;
        }
        return null; // Elemento não encontrado
    }

    // Método para inserir um elemento no início da lista
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head.next; // Novo nó aponta para o primeiro nó atual
        newNode.prev = head; // Novo nó aponta para o cabeça
        head.next.prev = newNode; // O nó anterior ao primeiro nó aponta para o novo nó
        head.next = newNode; // Cabeça aponta para o novo nó
    }

    // Método para inserir um elemento no final da lista
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        newNode.next = head; // Novo nó aponta para o cabeça
        newNode.prev = head.prev; // Novo nó aponta para o último nó atual
        head.prev.next = newNode; // O último nó atual aponta para o novo nó
        head.prev = newNode; // Cabeça aponta para o novo nó como último
    }

    // Método para remover um elemento da lista
    public void delete(int data) {
        Node nodeToDelete = search(data); // Busca o nó a ser removido
        if (nodeToDelete != null) {
            nodeToDelete.prev.next = nodeToDelete.next; // O nó anterior aponta para o próximo
            nodeToDelete.next.prev = nodeToDelete.prev; // O próximo nó aponta para o anterior
            nodeToDelete.next = null; // Limpa as referências do nó removido
            nodeToDelete.prev = null;
        } else {
            System.out.println("Elemento não encontrado na lista.");
        }
    }

    // Método para exibir a lista
    public void display() {
        if (isEmpty()) {
            System.out.println("A lista está vazia.");
            return;
        }
        Node current = head.next; // Começa do primeiro nó após o cabeça
        while (current != head) { // Percorre até voltar ao cabeça
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}