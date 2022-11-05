package ejercicio2;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Insercion {
    private RandomAccessFile fichero;
    public Insercion(String fichero) throws FileNotFoundException {
        this.fichero = new RandomAccessFile(fichero, "rw");
    }
    public boolean insertar(int id, String nombre, int dep, double salario) throws IOException {
        Consulta consulta = new Consulta("empleados.dat");
        boolean eof= false;
        int identificador;
        try{
            while(!eof){
                identificador= fichero.readInt();
                for(int x= 0; x < 10; x++) {
                    fichero.readChar();
                }
                fichero.readInt();
                fichero.readDouble();
                if(id == identificador){
                    System.out.println("Empleado ya existente insercion fallida!");
                    return false;
                }
            }
        }catch(EOFException e){
            eof= true;
        }catch(IOException e){
            e.printStackTrace();
        }
        fichero.writeInt(id);
		StringBuffer sb1= new StringBuffer(nombre);
		sb1.setLength(10);
		fichero.writeChars(sb1.toString());
		fichero.writeInt(dep);
		fichero.writeDouble(salario);
		System.out.println("Insercion exitosa!");
		return true;
    }

    public static void main(String[] args) throws IOException {
        Insercion insercion = new Insercion("empleados.dat");
        insercion.insertar(1, "Pepe", 1, 4000.0);
        insercion.insertar(2, "Juan", 2, 2000.0);
        insercion.insertar(3, "Alvaro", 3, 1000.0);
    }
}
