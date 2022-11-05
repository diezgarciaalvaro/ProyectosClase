package EsperarModificar;

public class Emisor implements Runnable{

    private Datos datos;

    String[] mensajitos= {
            "Patata", "Boniato", "Nabo","END"
    };
    public Emisor(Datos datos) {
        this.datos = datos;
    }

    @Override
    public void run() {
        for (String mensaje:mensajitos) {
            datos.envio(mensaje);
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
