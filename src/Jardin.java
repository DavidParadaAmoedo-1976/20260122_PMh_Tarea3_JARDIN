public class Jardin {

    // Número total de personas que hay actualmente en el jardín.
    // Se inicializa con un valor inicial de 100 personas.
    private int totalPersonas = 100;

    // Método sincronizado que permite la entrada de una persona al jardín.
    // Al ser synchronized, solo un hilo puede ejecutarlo a la vez.
    public synchronized void entrar() {

        // Incrementa el número total de personas en el jardín
        totalPersonas++;

        // Despierta a todos los hilos que estén esperando
        // (por ejemplo, puertas de salida cuando el jardín estaba vacío)
        notifyAll();

        // Muestra por consola el estado actual del jardín
        System.out.println("Entrando 1 persona, hay " + totalPersonas + " en el Jardin");
    }

    // Método sincronizado que permite la salida de una persona del jardín.
    // Puede lanzar InterruptedException si el hilo es interrumpido mientras espera.
    public synchronized void salir() throws InterruptedException {

        // Mientras no haya personas en el jardín,
        // el hilo que quiere salir debe esperar
        while (totalPersonas == 0) {
            // Si ya no van a entrar más personas al jardín, y no hay personas dentro
            // se finaliza la ejecución del programa
            if (!Programa.personasEntraron) {
                System.exit(0);
            }
            // El hilo queda en espera hasta que otro hilo
            // invoque notify o notifyAll
            wait();
        }
        // Decrementa el número total de personas en el jardín
        totalPersonas--;

        // Muestra por consola el estado actual del jardín
        System.out.println("Saliendo 1 persona, hay " + totalPersonas + " en el Jardin");
    }

    // Método getter que devuelve el número total de personas
    // que hay actualmente en el jardín
    public int getTotalPersonas() {
        return totalPersonas;
    }
}

