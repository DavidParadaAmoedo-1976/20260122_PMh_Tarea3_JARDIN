import java.util.Random;

class PuertaSalida extends Thread {
    private Jardin jardin;
    Random rand = new Random();

    public PuertaSalida(Jardin jardin) {
        this.jardin = jardin;
    }

    public void run() {
//        while (true) {
        for (int i = 0; i < 1000; i++) {
            rand.nextInt(100,1000);
            try {
                jardin.salir();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

