package ProductorConsumidor;

public class Productor implements  Runnable{

    ColaConLimite buffer;
    public Productor(ColaConLimite buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int numeroNuevo;
        while (true){
            try {
                esperaUnSegundo();
                numeroNuevo = (int) Math.random() * 10 + 1;
                this.buffer.pon(numeroNuevo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private static void esperaUnSegundo() throws InterruptedException {
        Thread.sleep(5000);
    }
}
