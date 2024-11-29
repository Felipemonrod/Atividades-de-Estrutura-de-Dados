
import javax.swing.JOptionPane;

public class DobroNumeros {
    public static void main(String[] args) {
        // Loop para ler e calcular o dobro de três números
        for (int i = 0; i < 3; i++) {
            // Entrada do número pelo usuário
            String input = JOptionPane.showInputDialog("Digite um número:");
            int numero = Integer.parseInt(input);

            // Chama a função que calcula o dobro
            int resultado = calcularDobro(numero);

            // Mostra o resultado
            JOptionPane.showMessageDialog(null, "Número: " + numero + "\nDobro: " + resultado);
        }
    }

    // Função que calcula o dobro de um número
    public static int calcularDobro(int x) {
        return x * 2;
    }
}
