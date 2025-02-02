package Exercicio5;

public class Main {
    public static void main(String[] args) {
        // Criando uma lista circular com nó cabeça
        CircularLinkedListWithHead list = new CircularLinkedListWithHead();

        // Inserindo elementos no início e no final
        list.insertAtBeginning(10);
        list.insertAtBeginning(5);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        System.out.println("Lista após inserções:");
        list.display(); // Saída esperada: 5 10 20 30

        // Contar o número de elementos
        System.out.println("Número de elementos na lista: " + list.countElements()); // Saída esperada: 4

        // Remover um elemento
        list.delete(10);
        System.out.println("Lista após remover 10:");
        list.display(); // Saída esperada: 5 20 30

        // Tentar remover um elemento que não existe
        list.delete(100); // Saída esperada: "Elemento 100 não encontrado na lista."

        // Inserir mais elementos
        list.insertAtBeginning(1);
        list.insertAtEnd(40);

        System.out.println("Lista após novas inserções:");
        list.display(); // Saída esperada: 1 5 20 30 40
    }
}