package ProductorConsumidor;

public class main {
    public static void main(String[] args) {
        //Escenario
        ColaConLimite buffer = new ColaConLimite();
        //Actores
        Productor productor= new Productor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        Thread tProductor = new Thread(productor);
        Thread tConsumidor = new Thread(consumidor);
        tProductor.start();
        tConsumidor.start();
    }
}
