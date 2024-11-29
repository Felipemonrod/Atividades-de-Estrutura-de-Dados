import javax.swing.JOptionPane;

public class VerificarCapicua {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Digite um número:");
        int numero = Integer.parseInt(input);
        int reverso = calcularReverso(numero);
        JOptionPane.showMessageDialog(null, numero + " - " + reverso);
        if (numero == reverso) {
            JOptionPane.showMessageDialog(null, "É um número capicua.");
        } else {
            JOptionPane.showMessageDialog(null, "Não é um número capicua.");
        }
    }
    public static int calcularReverso(int num) {
        int soma = 0;
        while (num != 0) {
            int resto = num % 10;    
            soma = soma * 10 + resto; 
            num /= 10;          
        }
        return soma;
    }
}
