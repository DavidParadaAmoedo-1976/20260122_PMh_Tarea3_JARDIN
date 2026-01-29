import java.util.Random;

// Clase que representa una puerta de entrada al jardín.
// Hereda de Thread para que cada puerta pueda ejecutarse de forma concurrente.
class PuertaEntrada extends Thread {

    // Referencia al jardín compartido donde entrarán las personas
    private Jardin jardin;

    Random rand = new Random(); // creo una variable tipo Random para generar enteros aleatorios

    // Constructor que recibe el jardín al que está asociada la puerta
    public PuertaEntrada(Jardin jardin) {
        this.jardin = jardin;
    }

    // Método que se ejecuta cuando el hilo inicia (al llamar a start())
    public void run() {


        int x = rand.nextInt(1, 1000); // Indica el número de personas que van a entrar en el jardin
        // Bucle que se repite hasta que ya entraron todas las personas
        for (int i = 0; i < x; i++) {
            try {
                sleep(rand.nextInt(10,100)); // Tiempo aleatorio de espera entre que una persona entra y vuelve a intentar entrar

            // En caso de que el hilo sea interrumpido durante el tiempo de espera,
            // se lanza una excepción en tiempo de ejecución
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // Llama al método entrar del jardín para simular la entrada de una persona
            jardin.entrar();
        }
    }
}