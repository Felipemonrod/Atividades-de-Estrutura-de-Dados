package Exercicio3;

public class Main {
    public static void main(String[] args) {
        // Criando duas listas circulares
        CircularLinkedList list1 = new CircularLinkedList();
        list1.insertLeftOfHead(3);
        list1.insertLeftOfHead(1);
        list1.insertLeftOfHead(5);

        CircularLinkedList list2 = new CircularLinkedList();
        list2.insertLeftOfHead(4);
        list2.insertLeftOfHead(2);
        list2.insertLeftOfHead(6);

        System.out.println("Lista 1:");
        list1.display(); // Saída esperada: 5 1 3

        System.out.println("Lista 2:");
        list2.display(); // Saída esperada: 6 2 4

        // a. Contar o número de elementos
        System.out.println("a. Número de elementos na Lista 1: " + list1.countElements()); // Saída esperada: 3

        // b. Inserir à esquerda da cabeça
        list1.insertLeftOfHead(0);
        System.out.println("b. Lista 1 após inserir 0 à esquerda da cabeça:");
        list1.display(); // Saída esperada: 0 5 1 3

        // c. Concatenar duas listas
        list1.concatenate(list2);
        System.out.println("c. Lista 1 após concatenar com Lista 2:");
        list1.display(); // Saída esperada: 0 5 1 3 6 2 4

        // d. Intercalar duas listas ordenadas
        CircularLinkedList list3 = new CircularLinkedList();
        list3.insertLeftOfHead(1);
        list3.insertLeftOfHead(3);
        list3.insertLeftOfHead(5);

        CircularLinkedList list4 = new CircularLinkedList();
        list4.insertLeftOfHead(2);
        list4.insertLeftOfHead(4);
        list4.insertLeftOfHead(6);

        CircularLinkedList mergedList = CircularLinkedList.mergeSortedLists(list3, list4);
        System.out.println("d. Lista intercalada ordenada:");
        mergedList.display(); // Saída esperada: 1 2 3 4 5 6

        // e. Fazer uma cópia da lista
        CircularLinkedList copiedList = list1.copy();
        System.out.println("e. Cópia da Lista 1:");
        copiedList.display(); // Saída esperada: 0 5 1 3 6 2 4
    }
}