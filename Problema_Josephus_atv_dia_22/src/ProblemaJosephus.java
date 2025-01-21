import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;

public class ProblemaJosephus {

    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pessoas na roda:"));
        if (n <= 0) {
            JOptionPane.showMessageDialog(null, "A quantidade de pessoas deve ser maior que 0.");
            return;
        }
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String name = JOptionPane.showInputDialog("Digite o nome da pessoa " + i + ":");
            String phone = JOptionPane.showInputDialog("Digite o telefone da pessoa " + i + ":");
            String address = JOptionPane.showInputDialog("Digite o endereço da pessoa " + i + ":");
            String cpf = JOptionPane.showInputDialog("Digite o CPF da pessoa " + i + ":");
            people.add(new Person(i, name, phone, address, cpf));
        }
        Random random = new Random();
        int m = random.nextInt(n - 1) + 1; 
        JOptionPane.showMessageDialog(null, "A primeira posição a ser eliminada é: " + m);

        int index = 0; 
        while (people.size() > 1) {
            index = (index + m - 1) % people.size(); 
            Person removed = people.remove(index);
            JOptionPane.showMessageDialog(null, "Eliminada: " + removed);
        }

        Person survivor = people.get(0);
        JOptionPane.showMessageDialog(null, "A pessoa sobrevivente é:\n" + survivor);
    }

    static class Person {
        int number;
        String name;
        String phone;
        String address;
        String cpf;

        public Person(int number, String name, String phone, String address, String cpf) {
            this.number = number;
            this.name = name;
            this.phone = phone;
            this.address = address;
            this.cpf = cpf;
        }

        @Override
        public String toString() {
            return "Número: " + number + "\nNome: " + name + "\nTelefone: " + phone +
                    "\nEndereço: " + address + "\nCPF: " + cpf;
        }
    }
}
