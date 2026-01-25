public class Programa {

    static void main(String[] args) throws InterruptedException {
        Jardin jardin = new Jardin();

        Thread entrada = new HiloEntrada(jardin);
        Thread salida = new HiloSalida(jardin);

        entrada.start();
        salida.start();

        entrada.join();
        salida.join();

        System.out.println("Personas finales: " + jardin.getTotalPersonas());
    }
}
