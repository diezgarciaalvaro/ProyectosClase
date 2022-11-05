package ejercicio2;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Modificacion {
	private RandomAccessFile fichero;
	public Modificacion(String fichero) throws FileNotFoundException {
		this.fichero = new RandomAccessFile(fichero, "rw");
	}
	public boolean modifica(int id, double importe) {
		int identificador;
		double salario;
		boolean eof= false;
		try {
			while(!eof) {
				identificador= fichero.readInt();

				//Apellido
				for(int x= 0; x < 10; x++) {
					fichero.readChar();
				}
				//Departamento
				fichero.readInt();
				//Salario
				salario= fichero.readDouble();
				if(id==identificador) {
					fichero.seek(fichero.getFilePointer()-8);
					fichero.writeDouble(importe);
					System.out.println("Modificacion exitosa!");
					System.out.println("Modificado empleado con id: " + id + " Salario anterior: " + salario + " Salario nuevo: " + importe);
					return true;
				}
			}
		}catch(EOFException e) {
			eof= true;
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("Modificacion falla!");
		System.out.println("empleado con id: " + id + " no encontrado!");
		return false;
	}
	public static void main(String[] args) throws FileNotFoundException {
		Modificacion m = new Modificacion("empleados.dat");
		m.modifica(2, 4000.0);
	}

}
