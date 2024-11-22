import javax.swing.JOptionPane;

public class AtelierMaravilha {
    public static void main(String[] args) {
        int op, n, ped;
        String[] nome = new String[10];
        String[] tel = new String[10];
        double[] preco = new double[8];
        double[] pedido = new double[10];
        double soma, valor;
        String resp;
        int flag = 0, flagi = 0;
        for (int i = 0; i < 10; i++) {
            pedido[i] = 0.0;
        }

        while (true) {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                "\n\n\nAtelier Maravilha\n" +
                "1 - Cadastrar as freguesas\n" +
                "2 - Cadastrar preços das costuras\n" +
                "3 - Calcular e imprimir o total que será pago por cada freguesa\n" +
                "4 - Listar dados de uma cliente\n" +
                "5 - Sair do programa\n" +
                "OPÇÃO:"
            ));

            if (op == 1) {
                flag = 1;
                for (int i = 0; i < 10; i++) {
                    nome[i] = JOptionPane.showInputDialog("Digite o nome da freguesa " + (i + 1) + ":");
                    tel[i] = JOptionPane.showInputDialog("Digite o telefone da freguesa " + (i + 1) + ":");
                }
            } else if (op == 2) {
                flagi = 1;
                String[] tipos = {"Ves-s", "Ves-p", "Ves-L", "Conjunto", "Blazer", "Saia", "Calça", "Blusa"};
                for (int i = 0; i < 8; i++) {
                    preco[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço para " + tipos[i] + ":"));
                }
            } else if (op == 3) {
                if (flagi == 0) {
                    JOptionPane.showMessageDialog(null, "Não tem preços cadastrados.");
                } else {
                    soma = 0.0;
                    while (true) {
                        ped = Integer.parseInt(JOptionPane.showInputDialog(
                            "1 - Ves-s 2 - Ves-p 3 - Ves-L 4 - Conjunto 5 - Blazer 6 - Saia 7 - Calça 8 - Blusa\n" +
                            "Digite o número do pedido ou 0 para acabar:"
                        ));
                        if (ped == 0) break;
                        if (ped >= 1 && ped <= 8) {
                            soma += preco[ped - 1];
                        } else {
                            JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Total a pagar: R$ " + soma);
                    resp = JOptionPane.showInputDialog("Cliente cadastrada(S/N)?");
                    if (resp.equalsIgnoreCase("S")) {
                        n = Integer.parseInt(JOptionPane.showInputDialog("Número da cliente (1-10):"));
                        while (n < 1 || n > 10) {
                            n = Integer.parseInt(JOptionPane.showInputDialog("Número inválido. Digite um número entre 1 e 10:"));
                        }
                        pedido[n - 1] = soma;
                    }
                }
            } else if (op == 4) {
                StringBuilder listaClientes = new StringBuilder();
                for (int i = 0; i < 10; i++) {
                    listaClientes.append((i + 1) + ": " + nome[i] + "\n");
                }
                n = Integer.parseInt(JOptionPane.showInputDialog(listaClientes.toString() + "Número da cliente (1-10):"));
                while (n < 1 || n > 10) {
                    n = Integer.parseInt(JOptionPane.showInputDialog("Número inválido. Digite um número entre 1 e 10:"));
                }
                JOptionPane.showMessageDialog(null, "Saldo R$: " + pedido[n - 1]);
                resp = JOptionPane.showInputDialog("Fazer pagamento(S/N)?");
                if (resp.equalsIgnoreCase("S")) {
                    valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do pagamento:"));
                    pedido[n - 1] -= valor;
                }
            } else if (op == 5) {
                JOptionPane.showMessageDialog(null, "Saindo do algoritmo.");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Opção não disponível.");
            }
        }
    }
}
