import java.util.Random;

// Clase que representa una puerta de salida del jardín.
// Hereda de Thread para permitir que varias salidas se ejecuten
// de forma concurrente.
class PuertaSalida extends Thread {

    // Referencia al jardín compartido del que saldrán las personas.
    // Este objeto es compartido entre varios hilos.
    private Jardin jardin;

    Random rand = new Random(); // creo una variable tipo Random para generar enteros aleatorios

    // Constructor que recibe el jardín al que está asociada la puerta de salida
    public PuertaSalida(Jardin jardin) {
        this.jardin = jardin;
    }

    // Método que se ejecuta cuando el hilo comienza su ejecución
    public void run() {

        int y = rand.nextInt(1, 1000);// Indica el número de personas que van a salir del jardin

        // Bucle que simula la salida individual de cada persona
        for (int i = 0; i < y; i++) {
            try {
                // Tiempo aleatorio de espera entre la salida de una persona y la siguiente, simulando salidas no simultáneas
                sleep(rand.nextInt(10,100));
            } catch (InterruptedException e) {
                // Si el hilo es interrumpido durante la espera, se lanza una excepción en tiempo de ejecución
                throw new RuntimeException(e);
            }
            try {
                // Llamada al método salir del jardín para simula la salida de una persona del jardín
                jardin.salir();
            } catch (InterruptedException e) {
                // Si ocurre una interrupción durante la salida, se lanza una excepción en tiempo de ejecución
                throw new RuntimeException(e);
            }
        }
    }
}


