import javax.swing.JOptionPane;

public class ProcuraNomePeloNumero {
    public static void main(String[] args) {
        String[] nomes = new String[5];
        for (int i = 0; i < 5; i++) {
            nomes[i] = JOptionPane.showInputDialog("Digite o nome da pessoa " + (i + 1) + ":");
        }
        int num;
        do {
            num = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da pessoa (1 a 5):"));
            if (num < 1 || num > 5) {
                JOptionPane.showMessageDialog(null, "Número fora do intervalo! Digite novamente.");
            }
        } while (num < 1 || num > 5);
        JOptionPane.showMessageDialog(null, "O nome da pessoa é: " + nomes[num - 1]);
    }
}
