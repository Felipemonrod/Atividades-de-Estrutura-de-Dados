import javax.swing.JOptionPane;

public class EscolaViva {
    public static void main(String[] args) {
        String[] nomes = new String[50];
        double[] nota1 = new double[50];
        double[] nota2 = new double[50];
        double[] media = new double[50];
        
        int opcao;
        boolean nomeCadastrado = false, nota1Cadastrada = false, nota2Cadastrada = false;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                "\nESCOLA VIVA\n" +
                "1 - Entrar nomes\n" +
                "2 - Entrar 1ª nota\n" +
                "3 - Entrar 2ª nota\n" +
                "4 - Calcular média\n" +
                "5 - Listar no display\n" +
                "6 - Sair\n" +
                "Opção:"));

            switch (opcao) {
                case 1: 
                    for (int i = 0; i < 50; i++) {
                        nomes[i] = JOptionPane.showInputDialog("Digite o " + (i + 1) + "º nome (máximo de 30 caracteres):");
                        while (nomes[i].length() > 30) {
                            nomes[i] = JOptionPane.showInputDialog("Nome com mais de 30 caracteres. Digite novamente o " + (i + 1) + "º nome:");
                        }
                    }
                    nomeCadastrado = true;
                    break;

                case 2: 
                    if (!nomeCadastrado) {
                        JOptionPane.showMessageDialog(null, "Primeiro cadastre os nomes.");
                    } else {
                        for (int i = 0; i < 50; i++) {
                            nota1[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite a 1ª nota do aluno " + nomes[i] + ":"));
                        }
                        nota1Cadastrada = true;
                    }
                    break;

                case 3:
                    if (!nomeCadastrado || !nota1Cadastrada) {
                        JOptionPane.showMessageDialog(null, "Primeiro cadastre os nomes e as 1ª notas.");
                    } else {
                        for (int i = 0; i < 50; i++) {
                            nota2[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite a 2ª nota do aluno " + nomes[i] + ":"));
                        }
                        nota2Cadastrada = true;
                    }
                    break;

                case 4: 
                    if (!nomeCadastrado || !nota1Cadastrada || !nota2Cadastrada) {
                        JOptionPane.showMessageDialog(null, "Faltam dados para calcular a média.");
                    } else {
                        for (int i = 0; i < 50; i++) {
                            media[i] = (3 * nota1[i] + 7 * nota2[i]) / 10;
                        }
                        JOptionPane.showMessageDialog(null, "Média calculada com sucesso.");
                    }
                    break;

                case 5: 
                    if (!nomeCadastrado || !nota1Cadastrada || !nota2Cadastrada) {
                        JOptionPane.showMessageDialog(null, "Faltam dados para listar.");
                    } else {
                        StringBuilder lista = new StringBuilder("NOME\t\t\t\tNOTA1\tNOTA2\tMÉDIA\n");
                        for (int i = 0; i < 50; i++) {
                            lista.append(nomes[i])
                                 .append("\t").append(nota1[i])
                                 .append("\t").append(nota2[i])
                                 .append("\t").append(media[i])
                                 .append("\n");
                        }
                        JOptionPane.showMessageDialog(null, lista.toString());
                    }
                    break;

                case 6: 
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        } while (opcao != 6); 
    }
}
