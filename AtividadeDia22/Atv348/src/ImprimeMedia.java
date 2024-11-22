import javax.swing.JOptionPane;

public class ImprimeMedia {
    public static void main(String[] args) {
        String[] nomes = new String[5];
        double[] nt1 = new double[5];
        double[] nt2 = new double[5];
        double[] media = new double[5];
        for (int i = 0; i < 5; i++) {
            nomes[i] = JOptionPane.showInputDialog("Digite o nome do aluno " + (i + 1) + ":");
            nt1[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite a 1ª nota de " + nomes[i] + ":"));
            nt2[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite a 2ª nota de " + nomes[i] + ":"));
            media[i] = (nt1[i] + nt2[i]) / 2;
        }
        StringBuilder resultado = new StringBuilder("NOTAS:\n");
        for (int i = 0; i < 5; i++) {
            resultado.append((i + 1)).append(" - ").append(nomes[i]).append("\n")
                    .append("\tNota 1: ").append(nt1[i]).append("\n")
                    .append("\tNota 2: ").append(nt2[i]).append("\n")
                    .append("\tMédia: ").append(media[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}
