public class Jardin {
    private int totalPersonas = 100;

    public synchronized void entrar() {
        totalPersonas++;
        notifyAll();
        System.out.println("Entrando 1 persona, hay " + totalPersonas + " en el Jardin");
    }

    public synchronized void salir() throws InterruptedException {
        while (totalPersonas == 0) {
            wait();
        }
        totalPersonas--;
        System.out.println("Saliendo 1 persona, hay " + totalPersonas + " en el Jardin");
    }

    public int getTotalPersonas() {
        return totalPersonas;
    }
}
