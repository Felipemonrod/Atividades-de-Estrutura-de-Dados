import javax.swing.JOptionPane;

public class OrdenarNomes {
    public static void main(String[] args) {
        String[] nomes = new String[5];
        for (int i = 0; i < nomes.length; i++) {
            nomes[i] = JOptionPane.showInputDialog("Digite o nome " + (i + 1) + ":");
        }
        ordenarNomes(nomes);
        StringBuilder resultado = new StringBuilder("NOMES ORDENADOS\n");
        for (int i = 0; i < nomes.length; i++) {
            resultado.append((i + 1) + " - " + nomes[i] + "\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
    public static void ordenarNomes(String[] vetor) {
        int tamanho = vetor.length;
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = i + 1; j < tamanho; j++) {
                if (vetor[i].compareToIgnoreCase(vetor[j]) > 0) {
                    String temp = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = temp;
                }
            }
        }
    }
}
