package ProductorConsumidor;

public class Consumidor implements Runnable{
    ColaConLimite buffer;
    public Consumidor(ColaConLimite buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(true) {
            try {
                esperaUnSegundo();
                int leido = this.buffer.quita();
                System.out.println("El leido por el consumidor es " + leido);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static void esperaUnSegundo() throws InterruptedException {
        Thread.sleep(5000);
    }
}
