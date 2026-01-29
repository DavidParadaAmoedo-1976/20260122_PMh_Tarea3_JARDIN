public class Programa {

    // inicia una variable booleana para indicar cuando termina el hilo de las personas que enytraron
    public static boolean personasEntraron = true;
    static void main(String[] args) throws InterruptedException {

        // Se crea una instancia del jardín compartido por las puertas
        Jardin jardin = new Jardin();

        // Se crean los hilos de entrada y salida, pasando el mismo jardín
        Thread entrada = new PuertaEntrada(jardin);
        Thread salida = new PuertaSalida(jardin);

        // Se inician ambos hilos para que se ejecuten concurrentemente
        entrada.start();
        salida.start();

        // Se espera a que ambos hilos terminen antes de continuar
        entrada.join();
        personasEntraron = false; // indica que ya entraron todas las personas y el hilo ya finalizó.
        salida.join();

        // Se muestra por pantalla el número final de personas en el jardín
        System.out.println("Personas finales: " + jardin.getTotalPersonas());
    }
}

