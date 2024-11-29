import javax.swing.JOptionPane;

public class SubstituirCaracteres {
    public static void main(String[] args) {
        String[] palavras = new String[10];
        for (int i = 0; i < palavras.length; i++) {
            palavras[i] = JOptionPane.showInputDialog("Digite a palavra em letras minúsculas " + (i + 1) + ":");
        }
        String inputChar = JOptionPane.showInputDialog("Digite o caractere que deseja substituir:");
        char caractere = inputChar.charAt(0);

        for (int i = 0; i < palavras.length; i++) {
            int totalRemovidos = substituirCaracteres(palavras, i, caractere);
            JOptionPane.showMessageDialog(null, "Palavra " + (i + 1) + " após substituição: " + palavras[i] + 
                                          "\nTotal de '" + caractere + "' substituídos: " + totalRemovidos);
        }
        StringBuilder resultadoFinal = new StringBuilder("Resultado Final:\n");
        for (int i = 0; i < palavras.length; i++) {
            resultadoFinal.append((i + 1) + " - " + palavras[i] + "\n");
        }
        JOptionPane.showMessageDialog(null, resultadoFinal.toString());
    }
    public static int substituirCaracteres(String[] vetor, int indice, char caractere) {
        String palavra = vetor[indice];
        int contador = 0;
        char[] caracteres = palavra.toCharArray();

        for (int i = 0; i < caracteres.length; i++) {
            if (caracteres[i] == caractere) {
                caracteres[i] = '*';
                contador++;
            }
        }
        vetor[indice] = new String(caracteres);
        return contador;
    }
}
