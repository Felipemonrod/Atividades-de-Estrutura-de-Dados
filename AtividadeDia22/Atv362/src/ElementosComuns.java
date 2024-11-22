import javax.swing.JOptionPane;

public class ElementosComuns {
    public static void main(String[] args) {
        int[] vetor1 = new int[10];
        int[] vetor2 = new int[20];
        int[] elementosComuns = new int[10];
        int contadorComuns = 0;
        JOptionPane.showMessageDialog(null, "Entrada de dados do vetor 1 (10 elementos):");
        for (int i = 0; i < 10; i++) {
            vetor1[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento " + (i + 1) + ":"));
        }
        JOptionPane.showMessageDialog(null, "Entrada de dados do vetor 2 (20 elementos):");
        for (int i = 0; i < 20; i++) {
            vetor2[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento " + (i + 1) + ":"));
        }
        for (int num1 : vetor1) {
            for (int num2 : vetor2) {
                if (num1 == num2) {
                    boolean jaExiste = false;
                    for (int j = 0; j < contadorComuns; j++) {
                        if (elementosComuns[j] == num1) {
                            jaExiste = true;
                            break;
                        }
                    }
                    if (!jaExiste) {
                        elementosComuns[contadorComuns] = num1;
                        contadorComuns++;
                    }
                }
            }
        }
        if (contadorComuns == 0) {
            JOptionPane.showMessageDialog(null, "Não existem elementos comuns.");
        } else {
            StringBuilder resultado = new StringBuilder("Elementos comuns:\n");
            for (int i = 0; i < contadorComuns; i++) {
                resultado.append(elementosComuns[i]).append("\n");
            }
            JOptionPane.showMessageDialog(null, resultado.toString());
        }
    }
}
