package ejercicio2;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Consulta {
    private RandomAccessFile fichero;
    public Consulta(String fichero) throws FileNotFoundException {
        this.fichero = new RandomAccessFile(fichero, "r");
    }
    public boolean consulta(int id) {
        int identificador, departamento;
        String nombre;
        double salario;
        boolean eof= false;
        try {
            while(!eof) {
                identificador= fichero.readInt();
                nombre = "";
                for(int x= 0; x < 10; x++) {
                    nombre+= fichero.readChar();
                }
                departamento= fichero.readInt();
                salario= fichero.readDouble();
                if(id == identificador) {
                    System.out.println("Empleado encontrado!");
                    System.out.printf("Id: %s Nombre: %s Dep: %d Salario: %.2f\n", identificador, nombre, departamento, salario);
                    return true;
                }
            }
        }catch (EOFException e) {
            eof= true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("No se ha encontrado al empleado con id: " + id);
        return false;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Consulta c = new Consulta("empleados.dat");
        c.consulta(3);
    }
}
