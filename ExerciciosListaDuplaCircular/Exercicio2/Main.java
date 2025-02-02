package Exercicio2;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedListWithHead list = new DoublyLinkedListWithHead();

        // Inserindo elementos no início e no final
        list.insertAtBeginning(10);
        list.insertAtBeginning(5);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        System.out.println("Lista após inserções:");
        list.display(); // Saída esperada: 5 10 20 30

        // Buscando elementos
        Node node = list.search(20);
        if (node != null) {
            System.out.println("Elemento 20 encontrado.");
        } else {
            System.out.println("Elemento 20 não encontrado.");
        }

        // Removendo elementos
        list.delete(10);
        System.out.println("Lista após remover 10:");
        list.display(); // Saída esperada: 5 20 30

        list.delete(5);
        System.out.println("Lista após remover 5:");
        list.display(); // Saída esperada: 20 30

        list.delete(30);
        System.out.println("Lista após remover 30:");
        list.display(); // Saída esperada: 20

        // Tentando remover um elemento que não existe
        list.delete(100); // Saída esperada: "Elemento não encontrado na lista."
    }
}