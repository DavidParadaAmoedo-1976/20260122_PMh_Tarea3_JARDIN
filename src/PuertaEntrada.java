import java.util.Random;

class PuertaEntrada extends Thread {
    private Jardin jardin;
    Random rand = new Random();

    public PuertaEntrada(Jardin jardin) {
        this.jardin = jardin;
    }

    public void run() {
//        while (true) {
        for (int i = 0; i < rand.nextInt(1,100); i++) {
            rand.nextInt(100,1000);
            jardin.entrar();
        }
    }
}

