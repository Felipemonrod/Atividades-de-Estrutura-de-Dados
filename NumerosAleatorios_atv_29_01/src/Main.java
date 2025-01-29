class No {
    int valor;
    No anterior;
    No proximo;

    public No(int valor) {
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }
}

class ListaDuplamenteEncadeada {
    private No inicio;
    private No fim;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
    }

    public void inserirOrdenado(int valor) {
        No novoNo = new No(valor);
        if (inicio == null) {
            inicio = fim = novoNo;
        } else {
            No atual = inicio;
            while (atual != null && atual.valor < valor) {
                atual = atual.proximo;
            }
            if (atual == null) {
                novoNo.anterior = fim;
                fim.proximo = novoNo;
                fim = novoNo;
            } else if (atual.anterior == null) {
                novoNo.proximo = inicio;
                inicio.anterior = novoNo;
                inicio = novoNo;
            } else {
                novoNo.proximo = atual;
                novoNo.anterior = atual.anterior;
                atual.anterior.proximo = novoNo;
                atual.anterior = novoNo;
            }
        }
    }

    public void imprimirCrescente() {
        StringBuilder sb = new StringBuilder();
        No atual = inicio;
        while (atual != null) {
            sb.append(atual.valor).append(" ");
            atual = atual.proximo;
        }
        System.out.println("\nLista em ordem crescente:\n" + sb.toString());
    }

    public void imprimirDecrescente() {
        StringBuilder sb = new StringBuilder();
        No atual = fim;
        while (atual != null) {
            sb.append(atual.valor).append(" ");
            atual = atual.anterior;
        }
        System.out.println("\nLista em ordem decrescente:\n" + sb.toString());
    }

    public void removerPrimos() {
        No atual = inicio;
        while (atual != null) {
            if (ehPrimo(atual.valor)) {
                if (atual.anterior == null) {
                    inicio = atual.proximo;
                    if (inicio != null) {
                        inicio.anterior = null;
                    }
                } else if (atual.proximo == null) {
                    fim = atual.anterior;
                    if (fim != null) {
                        fim.proximo = null;
                    }
                } else {
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;
                }
            }
            atual = atual.proximo;
        }
    }

    private boolean ehPrimo(int numero) {
        if (numero < 2) {
            return false;
        }
        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] vetor = new int[1000];
        for (int i = 0; i < 1000; i++) {
            vetor[i] = (int) (Math.random() * 19999) - 9999;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vetor.length; i++) {
            sb.append(vetor[i]).append(" ");
        }
        System.out.println("\nVetor gerado:\n" + sb.toString());

        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        for (int i = 0; i < vetor.length; i++) {
            lista.inserirOrdenado(vetor[i]);
        }

        lista.imprimirCrescente();
        lista.imprimirDecrescente();

        lista.removerPrimos();
        System.out.println("\nLista após remover números primos:");
        lista.imprimirCrescente();
    }
}