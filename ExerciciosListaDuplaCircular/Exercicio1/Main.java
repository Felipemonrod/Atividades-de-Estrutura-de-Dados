package Exercicio1;
public class Main {
    public static void main(String[] args) {
        // Criando duas listas
        DoublyLinkedList list1 = new DoublyLinkedList();
        list1.append(1);
        list1.append(3);
        list1.append(5);
        list1.append(7);

        DoublyLinkedList list2 = new DoublyLinkedList();
        list2.append(2);
        list2.append(4);
        list2.append(6);
        list2.append(8);

        System.out.println("Lista 1:");
        list1.display();

        System.out.println("Lista 2:");
        list2.display();

        // a. Teste de concatenação
        DoublyLinkedList concatenatedList = new DoublyLinkedList();
        concatenatedList.concatenate(list1);
        concatenatedList.concatenate(list2);
        System.out.println("\na. Lista concatenada:");
        concatenatedList.display();

        // b. Teste de separação
        DoublyLinkedList splitList = new DoublyLinkedList();
        splitList.concatenate(concatenatedList);
        DoublyLinkedList[] result = splitList.split();
        
        System.out.println("\nb. Primeira metade após split:");
        result[0].display();
        System.out.println("Segunda metade após split:");
        result[1].display();

        // c. Teste de intercalação de listas ordenadas
        DoublyLinkedList mergedList = DoublyLinkedList.mergeSortedLists(list1, list2);
        System.out.println("\nc. Lista intercalada ordenada:");
        mergedList.display();
    }
}