import java.sql.SQLOutput;

public class Carrera {

    public static void main(String[] args) throws InterruptedException {

        Atleta corredor1 = new Atleta("1");
        Atleta corredor2 = new Atleta("2");

        System.out.println("Preparados");
        Thread.sleep(1000);
        System.out.println("Listos");
        Thread.sleep(1000);
        System.out.println("YA!");

        corredor1.start();
        corredor2.start();

    }
}
