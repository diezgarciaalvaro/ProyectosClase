import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class VistaCoche extends JPanel{
    private JProgressBar pbBarraProgreso;
    private JLabel labelNombre;
    private JPanel contenedorCoche;
    private JLabel labelVelocidad;

    Coche coche;

    public VistaCoche(JTextField textFieldVelocidad){
        Coche cocheNuevo = new Coche(Integer.parseInt(textFieldVelocidad.getText()), pbBarraProgreso);
        labelNombre.setText(String.valueOf("Coche " + cocheNuevo.getNumero_coche()));
        labelVelocidad.setText(String.valueOf("Velocidad: " + cocheNuevo.getVelocidad()));
        iniciarGUI();
        coche = cocheNuevo;
    }
    public void iniciarGUI(){
        add(contenedorCoche);
    }

    public Coche getCoche() {
        return coche;
    }


}
