import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VistaGeneral extends JFrame{
    private JTextField textFieldVelocidad;
    private JButton cocheNuevoButton;
    private JPanel panelDinamico;
    private JButton correrButton;
    private JTextField textFieldLongitud;
    private JPanel ContenedorPrincipal;

    private int nCoches;

    private ArrayList<Coche> coches = new ArrayList<>();

    public VistaGeneral(){
        inicializarComponentes();
        inicializarPanelDinamico();
        cocheNuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nCoches == 3)
                    cocheNuevoButton.setEnabled(false);
                setCocheVista();
                nCoches++;

            }
        });
        correrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Coche coche: coches) {
                    coche.setLongitudPista(Integer.parseInt(textFieldLongitud.getText()));
                    //System.out.println(coche.toString());
                    coche.execute();
                }

            }
        });
    }

    public void inicializarComponentes(){
        setContentPane(ContenedorPrincipal);
        setSize(650, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    private void inicializarPanelDinamico() {
        panelDinamico.setLayout(new BoxLayout(panelDinamico, BoxLayout.Y_AXIS));
    }
    public void setCocheVista(){
        VistaCoche vistaCoche = new VistaCoche(textFieldVelocidad);
        panelDinamico.add(vistaCoche);
        panelDinamico.revalidate();
        coches.add(vistaCoche.getCoche());
    }



}
