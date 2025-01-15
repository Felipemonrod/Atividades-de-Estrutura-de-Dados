import javax.swing.JOptionPane;
import java.util.Stack;

public class CalculadoraNotacao {

    public static void main(String[] args) {
        String tipoNotacao = JOptionPane.showInputDialog("Informe o tipo de notação (Infixa, Pós-fixa, Pré-fixa):");
        String expressao = JOptionPane.showInputDialog("Informe a expressão exemplo (2 + 3 * 3):");

        String resultadoFinal = "";
        String notacaoInfixa = "";
        String notacaoPosfixa = "";
        String notacaoPrefixa = "";

        switch (tipoNotacao.toLowerCase()) {
            case "infixa":
                resultadoFinal = String.valueOf(avaliarNotacaoInfixa(expressao));
                notacaoInfixa = expressao;
                notacaoPosfixa = converterInfixaParaPosfixa(expressao);
                notacaoPrefixa = converterInfixaParaPrefixa(expressao);
                break;

            case "pós-fixa":
                resultadoFinal = String.valueOf(avaliarNotacaoPosfixa(expressao));
                notacaoPosfixa = expressao;
                notacaoInfixa = converterPosfixaParaInfixa(expressao);
                notacaoPrefixa = converterPosfixaParaPrefixa(expressao);
                break;

            case "pré-fixa":
                resultadoFinal = String.valueOf(avaliarNotacaoPrefixa(expressao));
                notacaoPrefixa = expressao;
                notacaoInfixa = converterPrefixaParaInfixa(expressao);
                notacaoPosfixa = converterPrefixaParaPosfixa(expressao);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Tipo de notação inválido!");
                return;
        }

        String mensagemResultado = "Resultado: " + resultadoFinal + "\n" +
                                    "Notação Infixa: " + notacaoInfixa + "\n" +
                                    "Notação Pós-fixa: " + notacaoPosfixa + "\n" +
                                    "Notação Pré-fixa: " + notacaoPrefixa;

        JOptionPane.showMessageDialog(null, mensagemResultado);
    }

    public static double avaliarNotacaoInfixa(String expressao) {
        String posfixa = converterInfixaParaPosfixa(expressao);
        return avaliarNotacaoPosfixa(posfixa);
    }

    public static double avaliarNotacaoPosfixa(String expressao) {
        Stack<Double> pilhaValores = new Stack<>();
        for (String token : expressao.split(" ")) {
            if (ehOperando(token)) {
                pilhaValores.push(Double.parseDouble(token));
            } else {
                double valor2 = pilhaValores.pop();
                double valor1 = pilhaValores.pop();
                pilhaValores.push(calcularOperacao(valor1, valor2, token));
            }
        }
        return pilhaValores.pop();
    }

    public static double avaliarNotacaoPrefixa(String expressao) {
        Stack<Double> pilhaValores = new Stack<>();
        String[] tokens = expressao.split(" ");
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (ehOperando(token)) {
                pilhaValores.push(Double.parseDouble(token));
            } else {
                double valor1 = pilhaValores.pop();
                double valor2 = pilhaValores.pop();
                pilhaValores.push(calcularOperacao(valor1, valor2, token));
            }
        }
        return pilhaValores.pop();
    }

    public static String converterInfixaParaPosfixa(String expressao) {
        Stack<String> pilhaOperadores = new Stack<>();
        StringBuilder expressaoPosfixa = new StringBuilder();

        for (String token : expressao.split(" ")) {
            if (ehOperando(token)) {
                expressaoPosfixa.append(token).append(" ");
            } else if (token.equals("(")) {
                pilhaOperadores.push(token);
            } else if (token.equals(")")) {
                while (!pilhaOperadores.isEmpty() && !pilhaOperadores.peek().equals("(")) {
                    expressaoPosfixa.append(pilhaOperadores.pop()).append(" ");
                }
                pilhaOperadores.pop();
            } else {
                while (!pilhaOperadores.isEmpty() && prioridadeOperador(token) <= prioridadeOperador(pilhaOperadores.peek())) {
                    expressaoPosfixa.append(pilhaOperadores.pop()).append(" ");
                }
                pilhaOperadores.push(token);
            }
        }

        while (!pilhaOperadores.isEmpty()) {
            expressaoPosfixa.append(pilhaOperadores.pop()).append(" ");
        }

        return expressaoPosfixa.toString().trim();
    }

    public static String converterInfixaParaPrefixa(String expressao) {
        StringBuilder expressaoReversa = new StringBuilder(expressao).reverse();
        expressaoReversa = new StringBuilder(expressaoReversa.toString().replace("(", "TEMP").replace(")", "(").replace("TEMP", ")"));
        String posfixaReversa = converterInfixaParaPosfixa(expressaoReversa.toString());
        return new StringBuilder(posfixaReversa).reverse().toString();
    }

    public static String converterPosfixaParaInfixa(String expressao) {
        Stack<String> pilhaExpressoes = new Stack<>();
        for (String token : expressao.split(" ")) {
            if (ehOperando(token)) {
                pilhaExpressoes.push(token);
            } else {
                String valor2 = pilhaExpressoes.pop();
                String valor1 = pilhaExpressoes.pop();
                String novaExpressao = "(" + valor1 +  token + valor2 + ")";
                pilhaExpressoes.push(novaExpressao);
            }
        }
        return pilhaExpressoes.pop();
    }

    public static String converterPosfixaParaPrefixa(String expressao) {
        Stack<String> pilhaExpressoes = new Stack<>();
        for (String token : expressao.split(" ")) {
            if (ehOperando(token)) {
                pilhaExpressoes.push(token);
            } else {
                String valor2 = pilhaExpressoes.pop();
                String valor1 = pilhaExpressoes.pop();
                String novaExpressao = token + valor1 + valor2;
                pilhaExpressoes.push(novaExpressao);
            }
        }
        return pilhaExpressoes.pop();
    }

    public static String converterPrefixaParaInfixa(String expressao) {
        Stack<String> pilhaExpressoes = new Stack<>();
        String[] tokens = expressao.split(" ");
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (ehOperando(token)) {
                pilhaExpressoes.push(token);
            } else {
                String valor1 = pilhaExpressoes.pop();
                String valor2 = pilhaExpressoes.pop();
                String novaExpressao = "(" + valor1 + token + valor2 + ")";
                pilhaExpressoes.push(novaExpressao);
            }
        }
        return pilhaExpressoes.pop();
    }

    public static String converterPrefixaParaPosfixa(String expressao) {
        Stack<String> pilhaExpressoes = new Stack<>();
        String[] tokens = expressao.split(" ");
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (ehOperando(token)) {
                pilhaExpressoes.push(token);
            } else {
                String valor1 = pilhaExpressoes.pop();
                String valor2 = pilhaExpressoes.pop();
                String novaExpressao = valor1 + valor2 + token;
                pilhaExpressoes.push(novaExpressao);
            }
        }
        return pilhaExpressoes.pop();
    }

    public static boolean ehOperando(String token) {
        return token.matches("\\d+(\\.\\d+)?");
    }

    public static int prioridadeOperador(String operador) {
        return switch (operador) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }

    public static double calcularOperacao(double valor1, double valor2, String operador) {
        return switch (operador) {
            case "+" -> valor1 + valor2;
            case "-" -> valor1 - valor2;
            case "*" -> valor1 * valor2;
            case "/" -> valor1 / valor2;
            default -> throw new IllegalArgumentException("Operador inválido: " + operador);
        };
    }
}
