import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        FilaDinamicaImpl fila = new FilaDinamicaImpl();
        while (true) {
            String escolha = JOptionPane.showInputDialog(
                "Escolha uma opção:\n" +
                "1. Adicionar elemento\n" +
                "2. Remover elemento\n" +
                "3. Mostrar fila\n" +
                "4. Sair"
            );

            if (escolha == null || escolha.equals("4")) {
                break; // Sair do programa
            }

            switch (escolha) {
                case "1": // Adicionar elemento
                    String valorStr = JOptionPane.showInputDialog("Digite um valor para adicionar:");
                    try {
                        int valor = Integer.parseInt(valorStr);
                        fila.adicionar(valor);
                        JOptionPane.showMessageDialog(null, "Valor " + valor + " adicionado à fila!");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Valor inválido! Digite um número inteiro.");
                    }
                    break;

                case "2": // Remover elemento
                    int valorRemovido = fila.remover();
                    if (valorRemovido == -1) {
                        JOptionPane.showMessageDialog(null, "Fila vazia! Não é possível remover.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor " + valorRemovido + " removido da fila!");
                    }
                    break;

                case "3": // Mostrar fila
                    JOptionPane.showMessageDialog(null, fila.mostrarFila());
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
}

class Elemento {
    int dado;
    Elemento proximo;

    public Elemento(int dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

class FilaDinamicaImpl {
    private Elemento primeiro;
    private Elemento ultimo;

    public FilaDinamicaImpl() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public void adicionar(int dado) {
        Elemento novoElemento = new Elemento(dado);
        if (estaVazia()) {
            primeiro = novoElemento;
        } else {
            ultimo.proximo = novoElemento;
        }
        ultimo = novoElemento;
    }

    public int remover() {
        if (estaVazia()) {
            return -1; 
        }
        int dadoRemovido = primeiro.dado;
        primeiro = primeiro.proximo;
        if (primeiro == null) {
            ultimo = null; 
        }
        return dadoRemovido;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public String mostrarFila() {
        if (estaVazia()) {
            return "Fila vazia!";
        }
        StringBuilder filaStr = new StringBuilder("Conteúdo da fila: ");
        Elemento atual = primeiro;
        while (atual != null) {
            filaStr.append(atual.dado).append(" ");
            atual = atual.proximo;
        }
        return filaStr.toString();
    }
}
