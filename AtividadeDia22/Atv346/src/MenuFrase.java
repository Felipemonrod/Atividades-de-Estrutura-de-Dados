import javax.swing.JOptionPane;

public class MenuFrase {
    public static void main(String[] args) {
        int opcao;
        String frase;

        do {
            String menu = "MENU\n"
                    + "1 - Imprime o comprimento da frase\n"
                    + "2 - Imprime os dois primeiros e os dois últimos caracteres da frase\n"
                    + "3 - Imprime a frase espelhada\n"
                    + "4 - Termina o algoritmo\n\n"
                    + "Escolha uma opção:";
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    frase = JOptionPane.showInputDialog("Digite uma frase:");
                    JOptionPane.showMessageDialog(null, "Número de caracteres: " + frase.length());
                    break;

                case 2:
                    frase = JOptionPane.showInputDialog("Digite uma frase:");
                    if (frase.length() < 2) {
                        JOptionPane.showMessageDialog(null, "A frase deve ter pelo menos 2 caracteres.");
                    } else {
                        String primeiros = frase.substring(0, 2);
                        String ultimos = frase.substring(frase.length() - 2);
                        JOptionPane.showMessageDialog(null, "Dois primeiros caracteres: " + primeiros
                                + "\nDois últimos caracteres: " + ultimos);
                    }
                    break;
                case 3:
                    frase = JOptionPane.showInputDialog("Digite uma frase:");
                    StringBuilder espelhada = new StringBuilder(frase).reverse();
                    JOptionPane.showMessageDialog(null, "Frase espelhada: " + espelhada.toString());
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Fim do algoritmo.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);
    }
}
