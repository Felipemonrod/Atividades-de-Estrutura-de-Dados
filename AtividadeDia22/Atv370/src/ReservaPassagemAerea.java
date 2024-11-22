import javax.swing.JOptionPane;

public class ReservaPassagemAerea {
    public static void main(String[] args) {
        int numeroVoos;
        numeroVoos = Integer.parseInt(JOptionPane.showInputDialog("Entre com o número de voos:"));
        String[] identificacaoVoo = new String[numeroVoos];
        int[] lugaresDisponiveis = new int[numeroVoos];
        for (int i = 0; i < numeroVoos; i++) {
            identificacaoVoo[i] = JOptionPane.showInputDialog("Entre com a identificação do voo " + (i + 1) + ":");
            lugaresDisponiveis[i] = Integer.parseInt(
                JOptionPane.showInputDialog("Entre com a quantidade de lugares disponíveis no voo " + identificacaoVoo[i] + ":")
            );
        }
        while (true) {
            String numeroVooDesejado = JOptionPane.showInputDialog("Entre com o número do voo desejado ou '0' para terminar:");
            if (numeroVooDesejado.equals("0")) {
                break;
            }
            int indiceVoo = -1;
            for (int i = 0; i < numeroVoos; i++) {
                if (identificacaoVoo[i].equals(numeroVooDesejado)) {
                    indiceVoo = i;
                    break;
                }
            }
            if (indiceVoo == -1) {
                JOptionPane.showMessageDialog(null, "Não existe este voo.");
                continue;
            }
            if (lugaresDisponiveis[indiceVoo] > 0) {
                lugaresDisponiveis[indiceVoo]--;
                String identidadeCliente = JOptionPane.showInputDialog("Qual o número da identidade do cliente?");
                JOptionPane.showMessageDialog(null, "Reserva confirmada!\nIdentidade: " + identidadeCliente + "\nVoo: " + numeroVooDesejado);
            } else {
                JOptionPane.showMessageDialog(null, "Não existem mais lugares neste voo.");
            }
        }

        JOptionPane.showMessageDialog(null, "Sistema encerrado.");
    }
}
