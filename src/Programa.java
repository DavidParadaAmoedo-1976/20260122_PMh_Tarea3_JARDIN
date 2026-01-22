public class Programa {

    static void main(String[] args) {
        int n = 2; // Número total de filósofos
        Jardin jardin = new Jardin(n);


        for (int i = 0; i < n; i++) {

            new Personas(i, jardin).start();
        }
    }
}
