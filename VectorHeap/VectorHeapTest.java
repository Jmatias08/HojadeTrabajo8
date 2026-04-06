public class VectorHeapTest {

    public static void main(String[] args) {
        VectorHeap<Paciente> heap = new VectorHeap<>();

        // Insertar pacientes
        heap.add(new Paciente("Juan", "dolor", 'C'));
        heap.add(new Paciente("Maria", "apendicitis", 'A'));
        heap.add(new Paciente("Pedro", "fiebre", 'B'));

        // Test 1: verificar que el primero es A
        Paciente p1 = heap.remove();
        assert p1.getPrioridad() == 'A' : "Error: debía salir A primero";

        // Test 2: verificar que el siguiente es B
        Paciente p2 = heap.remove();
        assert p2.getPrioridad() == 'B' : "Error: debía salir B segundo";

        // Test 3: verificar que el último es C
        Paciente p3 = heap.remove();
        assert p3.getPrioridad() == 'C' : "Error: debía salir C tercero";

        // Test 4: heap vacío
        assert heap.isEmpty() : "Error: el heap debería estar vacío";

        System.out.println("✔ Todos los tests pasaron correctamente");
    }
}