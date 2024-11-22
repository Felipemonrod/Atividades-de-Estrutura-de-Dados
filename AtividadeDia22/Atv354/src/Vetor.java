import javax.swing.JOptionPane;

public class Vetor {
    public static void main(String[] args) {
        int[] num = new int[15];
        for (int i = 0; i < 15; i++) {
            num[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o " + (i + 1) + "º número:"));
        }
        StringBuilder relacao = new StringBuilder("RELACAO DOS NUMEROS:\n");
        for (int i = 0; i < 15; i++) {
            relacao.append((i + 1)).append(" - ").append(num[i]);
            if (num[i] % 2 == 0) {
                relacao.append(" é PAR\n");
            } else {
                relacao.append(" é ÍMPAR\n");
            }
        }
        JOptionPane.showMessageDialog(null, relacao.toString());
    }
}