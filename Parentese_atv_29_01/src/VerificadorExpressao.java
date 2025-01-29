import javax.swing.JOptionPane;

class No {
    char valor;
    No proximo;

    public No(char valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

class Pilha {
    private No topo;

    public Pilha() {
        this.topo = null;
    }

    public void push(char valor) {
        No novoNo = new No(valor);
        novoNo.proximo = topo;
        topo = novoNo;
    }

    public char pop() {
        if (topo == null) {
            return '\0'; // Pilha vazia
        }
        char valor = topo.valor;
        topo = topo.proximo;
        return valor;
    }

    public boolean estaVazia() {
        return topo == null;
    }
}

public class VerificadorExpressao {
    public static void main(String[] args) {
        String expressao = JOptionPane.showInputDialog("Digite uma expressão aritmética:");

        if (verificarExpressao(expressao)) {
            JOptionPane.showMessageDialog(null, "A expressão está correta!");
        } else {
            JOptionPane.showMessageDialog(null, "A expressão está incorreta!");
        }
    }

    public static boolean verificarExpressao(String expressao) {
        Pilha pilha = new Pilha();

        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);

            if (caractere == '(' || caractere == '[' || caractere == '{') {
                pilha.push(caractere);
            } else if (caractere == ')' || caractere == ']' || caractere == '}') {
                if (pilha.estaVazia()) {
                    return false;
                }
                char topo = pilha.pop();

                if (!corresponde(topo, caractere)) {
                    return false;
                }
            }
        }

        return pilha.estaVazia();
    }

    public static boolean corresponde(char abre, char fecha) {
        return (abre == '(' && fecha == ')') ||
               (abre == '[' && fecha == ']') ||
               (abre == '{' && fecha == '}');
    }
}