public class Programa {

    static void main(String[] args) throws InterruptedException {
        Jardin jardin = new Jardin();

        Thread entrada = new PuertaEntrada(jardin);
        Thread salida = new PuertaSalida(jardin);

        entrada.start();
        salida.start();

        entrada.join();
        salida.join();

        System.out.println("Personas finales: " + jardin.getTotalPersonas());
    }
}
