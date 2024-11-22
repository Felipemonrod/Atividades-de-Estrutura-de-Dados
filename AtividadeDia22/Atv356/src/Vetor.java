import javax.swing.JOptionPane;

public class Vetor {
    public static void main(String[] args) {
        String[] nomes = new String[15];
        String[] sit = new String[15];
        double[] pr1 = new double[15];
        double[] pr2 = new double[15];
        int[] media = new int[15]; 
        for (int i = 0; i < 15; i++) {
            do {
                nomes[i] = JOptionPane.showInputDialog("Digite o nome do aluno " + (i + 1) + " (máx. 30 caracteres):");
                if (nomes[i].length() > 30) {
                    JOptionPane.showMessageDialog(null, "O nome deve ter até 30 caracteres. Digite novamente.");
                }
            } while (nomes[i].length() > 30);
            nomes[i] = String.format("%-30s", nomes[i]);
            pr1[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite a 1ª nota de " + nomes[i].trim() + ":"));
            pr2[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite a 2ª nota de " + nomes[i].trim() + ":"));
            media[i] = (int) Math.round((pr1[i] + pr2[i]) / 2);

            if (media[i] >= 5) {
                sit[i] = "APROVADO"; 
            } else {
                sit[i] = "RPEPROVADO";
            }
        }
            String resultado = "RELACAO FINAL:\n\nNome\n\nNota 1\nNota 2\nMédia\nSituação\n\n";
            for (int i = 0; i < 15; i++) {
                resultado += nomes[i].trim() + "\n" + pr1[i] + "\n" + pr2[i] + "\n" + media[i] + "\n" + sit[i] + "\n";
            }
            JOptionPane.showMessageDialog(null, resultado);
        }
}
