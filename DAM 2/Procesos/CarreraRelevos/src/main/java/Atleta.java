public class Atleta extends Thread{

    private String relevo;
    private static double tiempoT;

    public Atleta(String relevo) {
        super(relevo);
    }

    public Atleta() {
        tiempoT = 0;
    }

    @Override
    public void run() {
        double tiempo = 0;
        synchronized (getClass()) {
            if (tiempoT == 0) {
                System.out.println("Comienza a correr " + getName());
                tiempo = (double) (Math.random() * (11 - 9) + 9);
                tiempoT += tiempo;
            } else {
                System.out.println("Ahora tiene el relevo: " + getName());
                tiempo = (double) (Math.random() * (11 - 9) + 9);
                tiempoT += tiempo;
            }
            System.out.println(getName() + " tarda " + tiempo);
        }
    }
}
