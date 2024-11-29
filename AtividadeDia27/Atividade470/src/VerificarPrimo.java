import javax.swing.JOptionPane;

public class VerificarPrimo {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Digite um número maior que 0:");
        int numero = Integer.parseInt(input);
        boolean ehPrimo = verificarPrimo(numero);
        if (ehPrimo) {
            JOptionPane.showMessageDialog(null, "O número " + numero + " é primo.");
        } else {
            JOptionPane.showMessageDialog(null, "O número " + numero + " não é primo.");
        }
    }
    public static boolean verificarPrimo(int n) {
        if (n <= 1) {
            return false; 
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false; 
            }
        }
        return true; 
    }
}
