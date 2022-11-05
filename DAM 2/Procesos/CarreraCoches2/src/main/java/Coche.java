import javax.swing.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class Coche extends SwingWorker<String, Integer> {

    private int longitudPista;
    JProgressBar pbBarraProgreso;
    private int numero_coche;

    private static int contador;

    private int velocidad;

    private int recorrido;
    private static boolean ganador = false;

    Coche coche;

    public Coche(int velocidad, JProgressBar pbBarraProgreso) {
        this.longitudPista = 0;
        this.pbBarraProgreso = pbBarraProgreso;
        this.velocidad = velocidad;
        this.numero_coche = contador++;
        this.recorrido = 0;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getNumero_coche() {
        return numero_coche;
    }

    public void setLongitudPista(int longitudPista) {
        this.longitudPista = longitudPista;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "numero_coche=" + numero_coche +
                ", velocidad=" + velocidad +
                '}';
    }

    public boolean isGanador() {
        return ganador;
    }

    public static void infoBox(String mensaje, String titulo){
        JOptionPane.showMessageDialog(null,mensaje, "InfoBox: " + titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    synchronized void setGanador(){
        ganador = true;
        notifyAll();

    }

    @Override
    protected String doInBackground() throws Exception {
        this.pbBarraProgreso.setMaximum(longitudPista);
        this.pbBarraProgreso.setMinimum(1);
        while(!ganador) {
            int random = (int)Math.floor(Math.random() * (1 - (velocidad + 1)) + (velocidad));
            recorrido += random;
            System.out.println("[" + numero_coche + "] Recorrido = " + recorrido + " m");
            if ((recorrido > longitudPista) && !ganador) {
                setGanador();
                infoBox("El ganador es el Coche: " + getNumero_coche(), "Ganador");
                break;
            }
            try {
                sleep(800);
                this.pbBarraProgreso.setValue(recorrido);
            }catch (InterruptedException ex) {
                Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        infoBox("El coche: " + getNumero_coche() + ", recorrio " + recorrido + "m", "Recorrido");
        return "Recorrido" + recorrido;
    }
}
