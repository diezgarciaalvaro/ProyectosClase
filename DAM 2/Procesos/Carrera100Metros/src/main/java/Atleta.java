public class Atleta extends Thread{

    private String dorsal;

    public Atleta(String dorsal) {
        this.dorsal = dorsal;
    }
    @Override
    public void run(){
        try {
            Thread.sleep((int) Math.floor(Math.random() * (11000 - 9000) + (9000)));
            System.out.println(dorsal + " tarda " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
