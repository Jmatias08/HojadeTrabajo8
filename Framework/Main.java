import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        PriorityQueue<Paciente> cola = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"));
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");

            cola.add(new Paciente(
                partes[0].trim(),
                partes[1].trim(),
                partes[2].trim().charAt(0)
            ));
        }

        br.close();

        System.out.println("Atendiendo pacientes (Java PQ):");
        while (!cola.isEmpty()) {
            System.out.println(cola.poll());
        }
    }
}