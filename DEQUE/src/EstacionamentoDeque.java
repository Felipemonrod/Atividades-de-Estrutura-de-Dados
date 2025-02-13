import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

public class EstacionamentoDeque {
    private static final int CAPACIDADE_MAXIMA = 10;
    private LinkedList<Integer> estacionamento = new LinkedList<>();
    private Queue<Integer> filaEspera = new LinkedList<>();

    public void chegada(int placa, boolean pelaRBC) {
        if (estacionamento.size() < CAPACIDADE_MAXIMA) {
            if (pelaRBC) {
                estacionamento.addLast(placa);
                JOptionPane.showMessageDialog(null, "Carro " + placa + " estacionado na RBC.");
            } else {
                estacionamento.addFirst(placa);
                JOptionPane.showMessageDialog(null, "Carro " + placa + " estacionado na PT.");
            }
        } else {
            filaEspera.add(placa);
            JOptionPane.showMessageDialog(null, "Estacionamento cheio. Carro " + placa + " entrou na fila de espera.");
        }
    }

    public void partida(int placa) {
        if (!estacionamento.contains(placa)) {
            JOptionPane.showMessageDialog(null, "Carro " + placa + " não está no estacionamento.");
            return;
        }

        int deslocamentos = 0;
        LinkedList<Integer> temp = new LinkedList<>();
        
        while (!estacionamento.isEmpty() && estacionamento.peekLast() != placa) {
            temp.addFirst(estacionamento.removeLast());
            deslocamentos++;
        }

        estacionamento.removeLast(); 
        deslocamentos++;

        while (!temp.isEmpty()) {
            estacionamento.addLast(temp.removeFirst());
        }

        JOptionPane.showMessageDialog(null, "Carro " + placa + " saiu com " + deslocamentos + " deslocamentos.");
        
        if (!filaEspera.isEmpty()) {
            int novoCarro = filaEspera.poll();
            estacionamento.addFirst(novoCarro);
            JOptionPane.showMessageDialog(null, "Carro " + novoCarro + " saiu da fila de espera e estacionou.");
        }
    }

    public void listarCarros() {
        if (estacionamento.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O estacionamento está vazio.");
        } else {
            JOptionPane.showMessageDialog(null, "Carros no estacionamento: " + estacionamento.toString());
        }
    }

    public void executar() {
        while (true) {
            String opcao = JOptionPane.showInputDialog("Escolha uma opção:\n1 - Entrada de carro\n2 - Saída de carro\n3 - Listar carros\n4 - Sair");
            if (opcao == null || opcao.equals("4")) break;
            
            switch (opcao) {
                case "1":
                    String placaEntrada = JOptionPane.showInputDialog("Digite a placa do carro:");
                    if (placaEntrada == null) break;
                    
                    try {
                        int placa = Integer.parseInt(placaEntrada);
                        String localEntrada = JOptionPane.showInputDialog("Digite 'PT' para entrada pela PT ou 'RBC' para entrada pela RBC:");
                        boolean pelaRBC = localEntrada != null && localEntrada.equalsIgnoreCase("RBC");
                        chegada(placa, pelaRBC);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Placa inválida.");
                    }
                    break;
                
                case "2":
                    String placaSaida = JOptionPane.showInputDialog("Digite a placa do carro para saída:");
                    if (placaSaida == null) break;
                    
                    try {
                        int placa = Integer.parseInt(placaSaida);
                        partida(placa);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Placa inválida.");
                    }
                    break;
                
                case "3":
                    listarCarros();
                    break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new EstacionamentoDeque().executar();
    }
}
