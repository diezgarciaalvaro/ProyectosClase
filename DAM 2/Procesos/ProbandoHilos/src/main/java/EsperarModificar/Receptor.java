package EsperarModificar;

public class Receptor implements Runnable{

    Datos datos;
    public Receptor(Datos datos) {
        this.datos = datos;
    }

    @Override
    public void run() {
        for(String mensajeRecibido = datos.recepcion(); !"END".equals(mensajeRecibido);mensajeRecibido = datos.recepcion()){
            System.out.println("Mensaje recibido: " + mensajeRecibido);
            esperaUnSegundo();
        }
    }
    private static void esperaUnSegundo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido. " + Thread.currentThread().getName());
        }
    }
}
