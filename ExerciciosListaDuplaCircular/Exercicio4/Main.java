package Exercicio4;

public class Main {
    public static void main(String[] args) {
        // Criando duas listas circulares duplamente encadeadas
        DoublyCircularLinkedList list1 = new DoublyCircularLinkedList();
        list1.insertLeftOfHead(3);
        list1.insertLeftOfHead(1);
        list1.insertLeftOfHead(5);

        DoublyCircularLinkedList list2 = new DoublyCircularLinkedList();
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
        DoublyCircularLinkedList list3 = new DoublyCircularLinkedList();
        list3.insertLeftOfHead(1);
        list3.insertLeftOfHead(3);
        list3.insertLeftOfHead(5);

        DoublyCircularLinkedList list4 = new DoublyCircularLinkedList();
        list4.insertLeftOfHead(2);
        list4.insertLeftOfHead(4);
        list4.insertLeftOfHead(6);

        DoublyCircularLinkedList mergedList = DoublyCircularLinkedList.mergeSortedLists(list3, list4);
        System.out.println("d. Lista intercalada ordenada:");
        mergedList.display(); // Saída esperada: 1 2 3 4 5 6

        // e. Fazer uma cópia da lista
        DoublyCircularLinkedList copiedList = list1.copy();
        System.out.println("e. Cópia da Lista 1:");
        copiedList.display(); // Saída esperada: 0 5 1 3 6 2 4

        // f. Remover um elemento da lista
        list1.delete(5);
        System.out.println("f. Lista 1 após remover 5:");
        list1.display(); // Saída esperada: 0 1 3 6 2 4
    }
}