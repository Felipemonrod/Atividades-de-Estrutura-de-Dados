import javax.swing.JOptionPane;

public class FabricaQueijo {
    public static void main(String[] args) {
        int k = 0, codi, codigo, quantidade, i;
        double venda, geral = 0.0, auxp;
        String[] nomeProduto = new String[50];
        int[] codProduto = new int[50];
        int[] quantidadeProduto = new int[50];
        double[] precoProduto = new double[50];
        while (k < 50) {
            codi = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto ou 0 para acabar:"));
            if (codi == 0) break;

            codProduto[k] = codi;
            quantidadeProduto[k] = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto:"));
            precoProduto[k] = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto:"));
            k++;
        }
        while (true) {
            codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto a ser vendido ou 0 para terminar:"));
            if (codigo == 0) break;
            i = 0;
            while (i < k && codProduto[i] != codigo) {
                i++;
            }
            if (i == k) {
                JOptionPane.showMessageDialog(null, "Produto Não-Cadastrado");
            } else {
                quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto:"));
                if (quantidade <= quantidadeProduto[i]) {
                    venda = quantidade * precoProduto[i];
                    geral += venda;
                    quantidadeProduto[i] -= quantidade;
                    JOptionPane.showMessageDialog(null, "Venda realizada: R$ " + venda);
                } else {
                    JOptionPane.showMessageDialog(null, "Estoque Insuficiente");
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Total vendido no dia: R$ " + geral);
        for (i = 0; i < k - 1; i++) {
            for (int j = i + 1; j < k; j++) {
                if (quantidadeProduto[i] < quantidadeProduto[j]) {
                    auxp = precoProduto[i];
                    precoProduto[i] = precoProduto[j];
                    precoProduto[j] = auxp;

                    int aux = codProduto[i];
                    codProduto[i] = codProduto[j];
                    codProduto[j] = aux;

                    aux = quantidadeProduto[i];
                    quantidadeProduto[i] = quantidadeProduto[j];
                    quantidadeProduto[j] = aux;
                }
            }
        }

        // Exibe o estoque final
        StringBuilder estoqueFinal = new StringBuilder("Estoque Final:\n");
        for (i = 0; i < k; i++) {
            estoqueFinal.append("Código: ").append(codProduto[i])
                        .append(" | Quantidade: ").append(quantidadeProduto[i])
                        .append(" | Preço: R$ ").append(precoProduto[i])
                        .append("\n");
        }

        JOptionPane.showMessageDialog(null, estoqueFinal.toString());
    }
}
