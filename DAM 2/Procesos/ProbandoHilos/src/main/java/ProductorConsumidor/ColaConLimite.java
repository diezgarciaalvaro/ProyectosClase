package ProductorConsumidor;

public class ColaConLimite {
    public static final int TAMANO_MAXIMO = 16;

    private int posicion = 0;
    public int[] valores = new int[TAMANO_MAXIMO];

    public synchronized  void pon(int nuevoValor){
        if (posicion == TAMANO_MAXIMO) {
            throw new RuntimeException("No se pueden poner mas numeros.");
        }else
            valores[++posicion] = nuevoValor;
    }
    public synchronized int quita(){
        if (posicion == 0)
            throw new RuntimeException("No hay nada que quitar");
//        int devolucion = valores[posicion];
//        posicion--;

        return valores[posicion--];
    }
}
