import javax.swing.JOptionPane;

public class HotelFazenda {
    public static void main(String[] args) {
        int[] leitos = new int[50], nd = new int[50];
        double[] precos = new double[50], despesas = new double[50]; 
        String[] sit = new String[50], din = new String[50], dout = new String[50]; 
        String[] nome = new String[50], tel = new String[50]; 
        int op, quarto, i;
        String resp, nomep;
        boolean chave = false;
        for (i = 0; i < 50; i++) {
            sit[i] = "L"; 
            leitos[i] = 5; 
            precos[i] = 30.0; 
            nd[i] = 0; 
            despesas[i] = 0.0;
            din[i] = "XXXX";
            dout[i] = "XXXX";
            nome[i] = "";
            tel[i] = "";
        }

        do {
            
            op = Integer.parseInt(JOptionPane.showInputDialog(
                "\nHotel Fazenda Sucesso" +
                "\n1. Cadastrar quartos" +
                "\n2. Listar todos os quartos" +
                "\n3. Listar quartos ocupados" +
                "\n4. Aluguel/Reserva quarto" +
                "\n5. Inserir despesas extras" +
                "\n6. Calcular despesa do quarto" +
                "\n7. Sair" +
                "\nEscolha uma opção:"));

            switch (op) {
                case 1: 
                    if (chave) {
                        JOptionPane.showMessageDialog(null, "Atenção. Dados já cadastrados.");
                    } else {
                        for (i = 0; i < 50; i++) {
                            leitos[i] = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de leitos para o quarto " + (i + 1)));
                            precos[i] = Double.parseDouble(JOptionPane.showInputDialog("Preço do quarto " + (i + 1)));
                            sit[i] = "L"; // Livre
                            nd[i] = 0;
                            despesas[i] = 0.0;
                            din[i] = "XXXX";
                            dout[i] = "XXXX";
                            nome[i] = "";
                            tel[i] = "";
                        }
                        chave = true;
                    }
                    break;

                case 2:
                    if (!chave) {
                        JOptionPane.showMessageDialog(null, "Escolha a opção 1 para cadastrar os quartos.");
                    } else {
                        StringBuilder quartosInfo = new StringBuilder("Lista de todos os quartos:\n");
                        for (i = 0; i < 50; i++) {
                            quartosInfo.append("\nNúmero do quarto: ").append(i + 1)
                                       .append("\nSituação: ").append(sit[i])
                                       .append("\nNome: ").append(nome[i].isEmpty() ? "Não reservado" : nome[i])
                                       .append("\nTelefone: ").append(tel[i].isEmpty() ? "Não reservado" : tel[i])
                                       .append("\nQuantidade de leitos: ").append(leitos[i])
                                       .append("\nPreço: R$ ").append(precos[i])
                                       .append("\nDespesas extras: R$ ").append(despesas[i])
                                       .append("\nData de entrada: ").append(din[i])
                                       .append("\nData de saída: ").append(dout[i])
                                       .append("\nNúmero de diárias: ").append(nd[i])
                                       .append("\n\n");
                        }
                        JOptionPane.showMessageDialog(null, quartosInfo.toString());
                    }
                    break;

                case 3: 
                    if (!chave) {
                        JOptionPane.showMessageDialog(null, "Escolha a opção 1 para cadastrar os quartos.");
                    } else {
                        StringBuilder quartosOcupados = new StringBuilder("Lista de quartos ocupados:\n");
                        for (i = 0; i < 50; i++) {
                            if (sit[i].equals("A")) { 
                                quartosOcupados.append("\nNúmero do quarto: ").append(i + 1)
                                                .append("\nNome: ").append(nome[i])
                                                .append("\nTelefone: ").append(tel[i])
                                                .append("\nDespesas: R$ ").append(despesas[i])
                                                .append("\nData de entrada: ").append(din[i])
                                                .append("\nData de saída: ").append(dout[i])
                                                .append("\nNúmero de diárias: ").append(nd[i])
                                                .append("\n\n");
                            }
                        }
                        JOptionPane.showMessageDialog(null, quartosOcupados.toString());
                    }
                    break;

                case 4:
                    if (!chave) {
                        JOptionPane.showMessageDialog(null, "Escolha a opção 1 para cadastrar os quartos.");
                    } else {
                        resp = JOptionPane.showInputDialog("Digite 'A' para aluguel ou 'R' para reserva:").toUpperCase();
                        while (!resp.equals("A") && !resp.equals("R")) {
                            resp = JOptionPane.showInputDialog("Resposta inválida. Digite 'A' para aluguel ou 'R' para reserva:").toUpperCase();
                        }
                        if (resp.equals("A")) {
                            nomep = JOptionPane.showInputDialog("Digite o nome do cliente para aluguel:");
                            i = 0;
                            while (i < 50 && !nome[i].equals(nomep)) {
                                i++;
                            }
                            if (i < 50) {
                                quarto = i;
                                sit[quarto] = "A";
                                despesas[quarto] = 0.0;
                                din[quarto] = JOptionPane.showInputDialog("Digite a data de entrada (dd/mm/yyyy):");
                                dout[quarto] = JOptionPane.showInputDialog("Digite a data de saída (dd/mm/yyyy):");
                                nd[quarto] = Integer.parseInt(JOptionPane.showInputDialog("Número de diárias:"));
                            } else {
                                JOptionPane.showMessageDialog(null, "Reserva não encontrada.");
                            }
                        } else {
                            quarto = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do quarto para reserva:"));
                            while (quarto < 1 || quarto > 50 || sit[quarto - 1].equals("A")) {
                                quarto = Integer.parseInt(JOptionPane.showInputDialog("Quarto ocupado ou inválido. Digite novamente o número do quarto para reserva:"));
                            }
                            sit[quarto - 1] = "R"; 
                            nome[quarto - 1] = JOptionPane.showInputDialog("Digite o nome do cliente:");
                            tel[quarto - 1] = JOptionPane.showInputDialog("Digite o telefone para contato:");
                            din[quarto - 1] = JOptionPane.showInputDialog("Digite a data de entrada (dd/mm/yyyy):");
                            dout[quarto - 1] = JOptionPane.showInputDialog("Digite a data de saída (dd/mm/yyyy):");
                            nd[quarto - 1] = Integer.parseInt(JOptionPane.showInputDialog("Número de diárias:"));
                        }
                    }
                    break;

                case 5:
                    if (!chave) {
                        JOptionPane.showMessageDialog(null, "Escolha a opção 1 para cadastrar os quartos.");
                    } else {
                        quarto = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do quarto para inserir despesas extras:"));
                        while (quarto < 1 || quarto > 50) {
                            quarto = Integer.parseInt(JOptionPane.showInputDialog("Quarto inválido. Digite novamente o número do quarto:"));
                        }
                        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da despesa:"));
                        despesas[quarto - 1] += valor;
                    }
                    break;

                case 6:
                    if (!chave) {
                        JOptionPane.showMessageDialog(null, "Escolha a opção 1 para cadastrar os quartos.");
                    } else {
                        quarto = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do quarto para calcular a despesa:"));
                        while (quarto < 1 || quarto > 50) {
                            quarto = Integer.parseInt(JOptionPane.showInputDialog("Quarto inválido. Digite novamente o número do quarto:"));
                        }
                        double total = precos[quarto - 1] * nd[quarto - 1] + despesas[quarto - 1];
                        JOptionPane.showMessageDialog(null, "Total de despesas do quarto " + quarto + ": R$ " + total);
                        sit[quarto - 1] = "L"; 
                        despesas[quarto - 1] = 0.0;
                        din[quarto - 1] = "XXXX";
                        dout[quarto - 1] = "XXXX";
                        nome[quarto - 1] = "";
                        tel[quarto - 1] = "";
                        nd[quarto - 1] = 0;
                    }
                    break;

                case 7:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        } while (op != 7); 
    }
}
