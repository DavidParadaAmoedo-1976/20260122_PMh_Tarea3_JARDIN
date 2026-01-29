
import java.util.Random;

// Clase que representa una puerta de entrada al jardín.
// Hereda de Thread para que cada puerta pueda ejecutarse de forma concurrente.
class PuertaEntrada extends Thread {

    // Referencia al jardín compartido donde entrarán las personas
    private Jardin jardin;

    // Generador de números aleatorios para simular comportamiento variable
    Random rand = new Random();

    // Constructor que recibe el jardín al que está asociada la puerta
    public PuertaEntrada(Jardin jardin) {
        this.jardin = jardin;
    }

    // Método que se ejecuta cuando el hilo inicia
    public void run() {

        // Bucle que se repite un número aleatorio de veces entre 1 y 100
        int x = rand.nextInt(1, 1000);
        for (int i = 0; i < x; i++) {
            try {
                sleep(rand.nextInt(10,100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // Llama al método entrar del jardín para simular la entrada de una persona
            jardin.entrar();
        }
    }
}


