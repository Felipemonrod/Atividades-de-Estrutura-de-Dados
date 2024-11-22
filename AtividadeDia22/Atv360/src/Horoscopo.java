import javax.swing.JOptionPane;

public class Horoscopo {
    public static void main(String[] args) {
        String[] signos = {
            "Capricórnio", "Aquário", "Peixes", "Áries", "Touro", "Gêmeos",
            "Câncer", "Leão", "Virgem", "Libra", "Escorpião", "Sagitário"
        };
        int[] ultimosDias = {20, 19, 20, 20, 20, 20, 21, 22, 22, 22, 21, 21};
        while (true) {
            String input = JOptionPane.showInputDialog("Digite a data de nascimento no formato DDMM (ou 9999 para terminar):");
            int data = Integer.parseInt(input);
            if (data == 9999) {
                break;
            }
            int dia = data / 100;  
            int mes = data % 100;  
            mes--;  
            if (dia > ultimosDias[mes]) {
                mes = (mes + 1) % 12;}

            JOptionPane.showMessageDialog(null, "Signo: " + signos[mes]);
        }
        JOptionPane.showMessageDialog(null, "Programa encerrado.");
    }
}
