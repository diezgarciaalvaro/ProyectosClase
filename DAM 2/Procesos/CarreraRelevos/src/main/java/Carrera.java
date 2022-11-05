public class Carrera {

    Atleta corredor1 = new Atleta("1");

    public static void main(String[] args) throws InterruptedException {
        Atleta a1 = new Atleta("1");
        Atleta a2 = new Atleta("2");
        Atleta a3 = new Atleta("3");
        Atleta a4 = new Atleta("4");
        a1.start();
        a1.join();
        a2.start();
        a2.join();
        a3.start();
        a3.join();
        a4.start();
        a4.join();
    }
}
