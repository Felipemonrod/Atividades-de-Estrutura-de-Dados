import javax.swing.JOptionPane;

public class Vetor {
    public static void main(String[] args) {
        double[] precoCompra = new double[3];
        double[] precoVenda = new double[3];
        int totLucroMenor10 = 0;
        int totLucroEntre10e20 = 0;
        int totLucroMaior20 = 0;
        for (int i = 0; i < 3; i++) {
            precoCompra[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço de compra da mercadoria " + (i + 1) + ":"));
            precoVenda[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço de venda da mercadoria " + (i + 1) + ":"));
        }
        for (int i = 0; i < 3; i++) {
            double lucro = ((precoVenda[i] - precoCompra[i]) / precoCompra[i]) * 3; // Cálculo do lucro em porcentagem
            if (lucro < 10.0) {
                totLucroMenor10++;
            } else if (lucro <= 20.0) {
                totLucroEntre10e20++;
            } else {
                totLucroMaior20++;
            }
        }
        String resultado = "RESULTADO FINAL:\n"
                + "Total de mercadorias com lucro < 10%: " + totLucroMenor10 + "\n"
                + "Total de mercadorias com 10% <= lucro <= 20%: " + totLucroEntre10e20 + "\n"
                + "Total de mercadorias com lucro > 20%: " + totLucroMaior20;

        JOptionPane.showMessageDialog(null, resultado);
    }
}
