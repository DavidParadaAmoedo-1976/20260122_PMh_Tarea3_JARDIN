import java.util.Random;

class PuertaSalida extends Thread {
    private Jardin jardin;
    Random rand = new Random();

    public PuertaSalida(Jardin jardin) {
        this.jardin = jardin;
    }

    public void run() {
        int y = rand.nextInt(1, 1000);
        for (int i = 0; i < y; i++) {
            try {
                sleep(rand.nextInt(10,100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                jardin.salir();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

