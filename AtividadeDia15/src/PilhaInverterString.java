import javax.swing.JOptionPane;

public class PilhaInverterString {
    static class Pilha {
        private char[] elementos;
        private int topo;
        public Pilha(int capacidade) {
            elementos = new char[capacidade];
            topo = -1;
        }
        public void empilhar(char elemento) {
            if (topo == elementos.length - 1) {
                throw new IllegalStateException("Pilha cheia");
            }
            elementos[++topo] = elemento;
        }
        public char desempilhar() {
            if (estaVazia()) {
                throw new IllegalStateException("Pilha vazia");
            }
            return elementos[topo--];
        }
        public boolean estaVazia() {
            return topo == -1;
        }
    }

    public static void main(String[] args) {
        String entrada = JOptionPane.showInputDialog("Digite uma frase para inverter as letras de cada palavra:");

        if (entrada == null || entrada.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma entrada fornecida.");
            return;
        }
        String[] palavras = entrada.split(" ");
        StringBuilder resultado = new StringBuilder();

        for (String palavra : palavras) {
            Pilha pilha = new Pilha(palavra.length());
            for (char letra : palavra.toCharArray()) {
                pilha.empilhar(letra);
            }
            while (!pilha.estaVazia()) {
                resultado.append(pilha.desempilhar());
            }
            resultado.append(" ");
        }
        String resultadoFinal = resultado.toString().trim();
        JOptionPane.showMessageDialog(null, "Resultado: " + resultadoFinal);
    }
}
