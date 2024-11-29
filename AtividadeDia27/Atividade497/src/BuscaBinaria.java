import javax.swing.JOptionPane;

public class BuscaBinaria {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o número " + (i + 1) + ":"));
        }
        int chave = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de busca:"));
        ordenarVetor(numeros);
        int posicao = buscaBinaria(numeros, chave);
        StringBuilder resultado = new StringBuilder("VETOR ORDENADO\n");
        for (int i = 0; i < numeros.length; i++) {
            resultado.append((i + 1) + " - " + numeros[i] + "\n");
        }
        if (posicao != -1) {
            resultado.append("\nPosição no vetor: " + (posicao + 1)); 
        } else {
            resultado.append("\n\nNÃO ENCONTRADO");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
    public static void ordenarVetor(int[] vetor) {
        int tamanho = vetor.length;
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = i + 1; j < tamanho; j++) {
                if (vetor[i] > vetor[j]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = temp;
                }
            }
        }
    }
    public static int buscaBinaria(int[] vetor, int chave) {
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (vetor[meio] == chave) {
                return meio; 
            } else if (chave < vetor[meio]) {
                fim = meio - 1;
            } else {
                inicio = meio + 1; 
            }
        }
        return -1; 
    }
}
