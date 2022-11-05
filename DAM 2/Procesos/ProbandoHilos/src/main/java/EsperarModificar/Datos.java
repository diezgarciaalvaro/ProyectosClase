package EsperarModificar;

public class Datos {
    private String paquete;

    private boolean emision = true;

    public synchronized void envio(String paquete){
        while(!emision)
            esperaHastaModificacion();
        this.paquete = paquete;
        emision = false;
        notifyAll();
    }

    public synchronized String recepcion(){
        while (emision)
            esperaHastaModificacion();
        String returnPaquete = this.paquete;
        emision = true;
        notifyAll();
        return returnPaquete;
    }
    private void esperaHastaModificacion() {
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Hilo interrumpido. " + Thread.currentThread().getName());
        }
    }
}
