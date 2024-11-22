import javax.swing.JOptionPane;

public class MatrizDiferenca {
    public static void main(String[] args) {
        int[][] A = new int[5][5];
        int[][] B = new int[5][5];
        int[][] DIF = new int[5][5];

        for (int L = 0; L < 5; L++) {
            for (int c = 0; c < 5; c++) {
                String input = JOptionPane.showInputDialog(null,
                    "Digite o elemento de A[" + (L + 1) + "][" + (c + 1) + "]:");
                A[L][c] = Integer.parseInt(input);
            }
        }

        for (int L = 0; L < 5; L++) {
            for (int c = 0; c < 5; c++) {
                String input = JOptionPane.showInputDialog(null,
                    "Digite o elemento de B[" + (L + 1) + "][" + (c + 1) + "]:");
                B[L][c] = Integer.parseInt(input);
                DIF[L][c] = A[L][c] - B[L][c];
            }
        }

        StringBuilder resultadoDisplay = new StringBuilder("\nMATRIZ DIFERENCA:\n");
        for (int L = 0; L < 5; L++) {
            for (int c = 0; c < 5; c++) {
                resultadoDisplay.append(DIF[L][c]).append("\t");
            }
            resultadoDisplay.append("\n");
        }

        JOptionPane.showMessageDialog(null, resultadoDisplay.toString());
    }
}
