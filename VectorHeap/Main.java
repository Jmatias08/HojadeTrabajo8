import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        VectorHeap<Paciente> cola = new VectorHeap<>();

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

        System.out.println("Atendiendo pacientes (VectorHeap):");
        while (!cola.isEmpty()) {
            System.out.println(cola.remove());
        }
    }
}