package EsperarModificar;

public class Main {
    public static void main(String[] args) {
        Datos datos = new Datos();
        Thread emisor = new Thread(new Emisor(datos));
        Thread receptor = new Thread(new Receptor(datos));

        emisor.start();
        receptor.start();
    }
}
