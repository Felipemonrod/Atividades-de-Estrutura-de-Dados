import javax.swing.JOptionPane;

public class MenuVetores {
    public static void main(String[] args) {
        int[] vetorA = new int[5];
        int[] vetorB = new int[5];
        boolean vetorAInserido = false; 
        boolean vetorBInserido = false; 
        int opcao;

        do {
            String menu = "\nVETORES\n" +
                          "1. Dados do VETOR A\n" +
                          "2. Dados do VETOR B\n" +
                          "3. Imprime VETORES\n" +
                          "4. Soma VETORES\n" +
                          "5. Subtrai VETORES\n" +
                          "6. Sai do programa\n" +
                          "OPÇÃO: ";
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    entradaVetor(vetorA, "A");
                    vetorAInserido = true;
                    break;

                case 2:
                    entradaVetor(vetorB, "B");
                    vetorBInserido = true;
                    break;

                case 3:
                    if (vetorAInserido && vetorBInserido) {
                        imprimirVetor(vetorA, "A");
                        imprimirVetor(vetorB, "B");
                    } else {
                        JOptionPane.showMessageDialog(null, "Escolha primeiro as opções 1 e 2 para inserir os vetores.");
                    }
                    break;

                case 4:
                    if (vetorAInserido && vetorBInserido) {
                        somarVetores(vetorA, vetorB);
                    } else {
                        JOptionPane.showMessageDialog(null, "Escolha primeiro as opções 1 e 2 para inserir os vetores.");
                    }
                    break;

                case 5:
                    if (vetorAInserido && vetorBInserido) {
                        subtrairVetores(vetorA, vetorB);
                    } else {
                        JOptionPane.showMessageDialog(null, "Escolha primeiro as opções 1 e 2 para inserir os vetores.");
                    }
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, "Saindo do algoritmo.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 6); 
    }
    public static void entradaVetor(int[] vetor, String nomeVetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o número " + (i + 1) + " do vetor " + nomeVetor + ":"));
        }
    }

    public static void imprimirVetor(int[] vetor, String nomeVetor) {
        StringBuilder resultado = new StringBuilder("VETOR " + nomeVetor + "\n");
        for (int i = 0; i < vetor.length; i++) {
            resultado.append((i + 1) + " - " + vetor[i] + "\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    public static void somarVetores(int[] vetorA, int[] vetorB) {
        StringBuilder resultado = new StringBuilder("SOMA DOS VETORES\n");
        for (int i = 0; i < vetorA.length; i++) {
            resultado.append("Posição " + (i + 1) + ": " + (vetorA[i] + vetorB[i]) + "\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    public static void subtrairVetores(int[] vetorA, int[] vetorB) {
        StringBuilder resultado = new StringBuilder("DIFERENÇA DOS VETORES\n");
        for (int i = 0; i < vetorA.length; i++) {
            resultado.append("Posição " + (i + 1) + ": " + (vetorA[i] - vetorB[i]) + "\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}
