public class Jardin {
    private int totalPersonas = 100;

    public Jardin(int n) {
    }


    public synchronized void entrar(int x) {
        totalPersonas++;
        System.out.println("Entrando 1 persona, hay " + totalPersonas + " en el Jardin");
    }

    public synchronized void salir(int y) {
        totalPersonas--;
        System.out.println("Saliendo 1 persona, hay " + totalPersonas + " en el Jardin");
    }
}
