import javax.swing.JOptionPane;

public class EstruturaPrincipal {

    public static void main(String[] args) {
        CalculoDiscos calculoDiscos = new CalculoDiscos();
        calculoDiscos.quantidadeDiscos = Long.parseLong(JOptionPane.showInputDialog("Digite a quantidade de discos para as Torres de Hanói: "));
        System.out.println("\nResolvendo Torres de Hanoi com " + calculoDiscos.quantidadeDiscos + " discos...");
        long inicioExecucao = System.currentTimeMillis();
        long totalMovimentos = (1L << calculoDiscos.quantidadeDiscos) - 1; 
        calculoDiscos.resolverHanoi(calculoDiscos.quantidadeDiscos, '1', '2', '3'); 
        long fimExecucao = System.currentTimeMillis();
        long duracaoExecucao = fimExecucao - inicioExecucao;
        long horas = duracaoExecucao / 3600000;
        long minutos = (duracaoExecucao % 3600000) / 60000;
        long segundos = (duracaoExecucao % 60000) / 1000;
        long milissegundos = duracaoExecucao % 1000;
        System.out.printf("\nTempo gasto: horas %02d: minutos %02d: segundos %02d: milissegundos %03d\n", horas, minutos, segundos, milissegundos);
        System.out.println("Movimentos realizados: " + totalMovimentos);
    }
}
