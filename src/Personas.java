import java.util.Random;

public class Personas extends Thread {

    private static final int NUMERO_DE_VECES = 10, TIEMPO_MINIMO = 10, TIEMPO_MAXIMO = 1000;
    private final Jardin jardin;
    private final Random rand = new Random();
    private final int x = rand.nextInt(1, 100);
    private final int y = rand.nextInt(1, 100);

    public Personas(int i, Jardin jardin) {
        this.jardin = jardin;
    }

    public void run() {
        try {
//          while (true) { -> cambio el while por el for para que se pueda ejecutar un número de veces determinado, y no quede en bucle infinito
            for (int i = 0; i < NUMERO_DE_VECES; i++) {
                jardin.entrar(x);
                Thread.sleep(rand.nextInt(TIEMPO_MINIMO, TIEMPO_MAXIMO));
                jardin.salir(y);


            }
        } catch (InterruptedException e) { // // Captura de la interrupción del hilo.
            System.out.println("Entradas y salidas interrumpidas");
        }
    }
}

