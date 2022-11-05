package ejercicio2;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Borrado {
	private List<Integer> empleados_borrados;
	private RandomAccessFile fichero;
	public Borrado(String fichero) throws FileNotFoundException {
		empleados_borrados= new ArrayList<>();
		this.fichero = new RandomAccessFile(fichero, "rw");
	}
	public boolean borrar(int id) {
		int identificador;
		boolean eof= false;
		try {
			while(!eof) {
				identificador= fichero.readInt();
				if(id == identificador) {
					empleados_borrados.add(identificador);
					fichero.seek(fichero.getFilePointer()-4);
					fichero.writeInt(-1);
					StringBuffer sb1= new StringBuffer(identificador+"");
					sb1.setLength(10);
					fichero.writeChars(sb1.toString());
					fichero.writeInt(0);
					fichero.writeDouble(0);
					System.out.println("Eliminado empleado con id: "+ id);
					return true;
				}
				for(int x= 0; x < 10; x++) {
					fichero.readChar();
				}
				fichero.readInt();
				fichero.readDouble();
			}
		}catch(EOFException e) {
			eof= true;
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("Empleado no encontrado borrado fallido!");
		return false;
	}
	public void mostrarBorrados() {
		System.out.println("Empleados borrados: ");
		System.out.println(empleados_borrados);
	}
	public static void main(String[] args) throws FileNotFoundException {
		Borrado borrado = new Borrado("empleados.dat");
		borrado.borrar(3);
		borrado.mostrarBorrados();
	}

}
