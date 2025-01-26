import javax.swing.JOptionPane;

class No {
    String valor;
    No anterior;
    No proximo;

    public No(String valor) {
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }
}

class ListaDuplamenteEncadeada {
    private No inicio;
    private No fim;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
    }

    public void inserir(String valor) {
        No novoNo = new No(valor);
        if (inicio == null) {
            inicio = fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
    }

    public void inserirNoInicio(String valor) {
        No novoNo = new No(valor);
        if (inicio == null) {
            inicio = fim = novoNo;
        } else {
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }
    }

    public void inserirNaPosicao(int posicao, String valor) {
        if (posicao == 0) {
            inserirNoInicio(valor);
            return;
        }
        No atual = inicio;
        int indice = 0;
        while (atual != null && indice < posicao - 1) {
            atual = atual.proximo;
            indice++;
        }
        if (atual == null) {
            JOptionPane.showMessageDialog(null, "Posição inválida!");
        } else {
            No novoNo = new No(valor);
            novoNo.proximo = atual.proximo;
            if (atual.proximo != null) {
                atual.proximo.anterior = novoNo;
            }
            atual.proximo = novoNo;
            novoNo.anterior = atual;
            if (novoNo.proximo == null) {
                fim = novoNo;
            }
        }
    }

    public void remover(String valor) {
        No atual = inicio;
        while (atual != null) {
            if (atual.valor.equals(valor)) {
                if (atual.anterior != null) {
                    atual.anterior.proximo = atual.proximo;
                } else {
                    inicio = atual.proximo;
                }
                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior;
                } else {
                    fim = atual.anterior;
                }
                JOptionPane.showMessageDialog(null, "Elemento " + valor + " removido.");
                return;
            }
            atual = atual.proximo;
        }
        JOptionPane.showMessageDialog(null, "Elemento " + valor + " não encontrado.");
    }

    public void removerDaPosicao(int posicao) {
        if (posicao == 0) {
            removerDoInicio();
            return;
        }
        No atual = inicio;
        int indice = 0;
        while (atual != null && indice < posicao) {
            atual = atual.proximo;
            indice++;
        }
        if (atual == null) {
            JOptionPane.showMessageDialog(null, "Posição inválida!");
        } else {
            if (atual.anterior != null) {
                atual.anterior.proximo = atual.proximo;
            }
            if (atual.proximo != null) {
                atual.proximo.anterior = atual.anterior;
            }
            if (atual == inicio) {
                inicio = atual.proximo;
            }
            if (atual == fim) {
                fim = atual.anterior;
            }
        }
    }

    public void removerDoInicio() {
        if (inicio != null) {
            inicio = inicio.proximo;
            if (inicio != null) {
                inicio.anterior = null;
            } else {
                fim = null;
            }
        }
    }

    public void removerDoFim() {
        if (fim != null) {
            fim = fim.anterior;
            if (fim != null) {
                fim.proximo = null;
            } else {
                inicio = null;
            }
        }
    }

    public boolean contem(String valor) {
        No atual = inicio;
        while (atual != null) {
            if (atual.valor.equals(valor)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public void esvaziar() {
        inicio = fim = null;
    }

    public void exibir() {
        StringBuilder resultado = new StringBuilder();
        No atual = inicio;
        while (atual != null) {
            resultado.append(atual.valor).append(" ");
            atual = atual.proximo;
        }
        JOptionPane.showMessageDialog(null, "Lista: " + resultado.toString());
    }

    public int tamanho() {
        int tamanho = 0;
        No atual = inicio;
        while (atual != null) {
            tamanho++;
            atual = atual.proximo;
        }
        return tamanho;
    }
}

public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        String[] personagens = {"Homer", "Marge", "Bart", "Lisa", "Maggie", "SR.Burns", "Flanders", "Ned","Moll"};
        String[] opcoes = {
            "Inserir no final",
            "Inserir no início",
            "Inserir em uma posição",
            "Remover por valor",
            "Remover do início",
            "Remover do fim",
            "Remover por posição",
            "Verificar se está na lista",
            "Exibir lista",
            "Esvaziar lista",
            "Ver tamanho da lista",
            "Sair"
        };

        while (true) {
            String operacao = (String) JOptionPane.showInputDialog(
                null,
                "Escolha uma operação:",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            if (operacao == null || operacao.equals("Sair")) {
                break;
            }

            switch (operacao) {
                case "Inserir no final" -> {
                    String personagem = (String) JOptionPane.showInputDialog(
                        null,
                        "Escolha um personagem:",
                        "Inserir no final",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        personagens,
                        personagens[0]
                    );
                    lista.inserir(personagem);
                }
                case "Inserir no início" -> {
                    String personagem = (String) JOptionPane.showInputDialog(
                        null,
                        "Escolha um personagem:",
                        "Inserir no início",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        personagens,
                        personagens[0]
                    );
                    lista.inserirNoInicio(personagem);
                }
                case "Inserir em uma posição" -> {
                    String personagem = (String) JOptionPane.showInputDialog(
                        null,
                        "Escolha um personagem:",
                        "Inserir em uma posição",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        personagens,
                        personagens[0]
                    );
                    int posicao = Integer.parseInt(JOptionPane.showInputDialog("Informe a posição:"));
                    lista.inserirNaPosicao(posicao, personagem);
                }
                case "Remover por valor" -> {
                    String personagem = JOptionPane.showInputDialog("Informe o personagem a remover:");
                    lista.remover(personagem);
                }
                case "Remover do início" -> lista.removerDoInicio();
                case "Remover do fim" -> lista.removerDoFim();
                case "Remover por posição" -> {
                    int posicao = Integer.parseInt(JOptionPane.showInputDialog("Informe a posição para remover:"));
                    lista.removerDaPosicao(posicao);
                }
                case "Verificar se está na lista" -> {
                    String personagem = JOptionPane.showInputDialog("Informe o personagem:");
                    boolean contem = lista.contem(personagem);
                    JOptionPane.showMessageDialog(null, personagem + " está na lista? " + contem);
                }
                case "Exibir lista" -> lista.exibir();
                case "Esvaziar lista" -> lista.esvaziar();
                case "Ver tamanho da lista" -> JOptionPane.showMessageDialog(null, "Tamanho da lista: " + lista.tamanho());
            }
        }
    }
}
