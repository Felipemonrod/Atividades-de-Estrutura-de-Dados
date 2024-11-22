import javax.swing.JOptionPane;

public class MatrizRaizQuadrada {
    public static void main(String[] args) {
        int[][] n = new int[5][5];
        int soma = 0;
        for (int L = 0; L < 5; L++) {
            for (int c = 0; c < 5; c++) {
                String input = JOptionPane.showInputDialog(null, 
                    "Digite o elemento n[" + L + "][" + c + "]:");
                n[L][c] = Integer.parseInt(input);
            }
        }
        StringBuilder matrizDisplay = new StringBuilder("\nToda a matriz:\n");
        for (int L = 0; L < 5; L++) {
            for (int c = 0; c < 5; c++) {
                matrizDisplay.append(n[L][c]).append("\t");
            }
            matrizDisplay.append("\n");
        }

        for (int L = 1; L < 5; L++) { 
            for (int c = 0; c < L; c++) {  
                if (n[L][c] % 2 == 1) {  
                    soma += n[L][c] * n[L][c];  
                }
            }
        }

        double raizQuadrada = Math.sqrt(soma);

        JOptionPane.showMessageDialog(null, matrizDisplay.toString() +
                "\nRaiz quadrada da soma dos quadrados dos números ímpares: " + raizQuadrada);
    }
}
