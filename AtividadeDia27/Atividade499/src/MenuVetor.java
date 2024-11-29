import javax.swing.JOptionPane;

public class MenuVetor {
    public static void main(String[] args) {
        int[] vetor = new int[5];
        boolean dadosInseridos = false; 
        int opcao;
        do {
            String menu = "\nMENU VETOR - FUNÇÃO\n" +
                          "1. Dados do VETOR\n" +
                          "2. Ordena VETOR\n" +
                          "3. Imprime VETOR\n" +
                          "4. Sai do programa\n" +
                          "OPÇÃO: ";
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    entradaVetor(vetor);
                    dadosInseridos = true;
                    break;
                case 2:
                    if (dadosInseridos) {
                        ordenarVetor(vetor);
                        JOptionPane.showMessageDialog(null, "Vetor ordenado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Escolha primeiro a opção 1 para inserir os dados.");
                    }
                    break;
                case 3:
                    if (dadosInseridos) {
                        imprimirVetor(vetor);
                    } else {
                        JOptionPane.showMessageDialog(null, "Escolha primeiro a opção 1 para inserir os dados.");
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saindo do algoritmo.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 4); 
    }
    public static void entradaVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o número " + (i + 1) + ":"));
        }
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
    public static void imprimirVetor(int[] vetor) {
        StringBuilder resultado = new StringBuilder("VETOR\n");
        for (int i = 0; i < vetor.length; i++) {
            resultado.append((i + 1) + " - " + vetor[i] + "\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}
