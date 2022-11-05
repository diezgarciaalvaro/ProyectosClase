package ejercicio2;

import java.io.*;

public class Ejemplo {
	public static void leeEmpleados() {
		boolean eof= false;
		try(DataInputStream dis = new DataInputStream(new FileInputStream("empleados.dat"));) {
			while(!eof) {
				System.out.print(dis.readInt() + " ");
				String nombre= "";
				for(int x= 0; x < 10; x++) {
					nombre+= dis.readChar();
				}
				System.out.print(nombre + " ");
				System.out.print(dis.readInt() + " ");
				System.out.print(dis.readDouble());
				System.out.println();
			}
		}catch(EOFException e) {
			eof= true;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public static void creaFichero() {
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("empleados.dat"));) {
			dos.writeInt(1);
			StringBuffer sb1= new StringBuffer("eduardo");
			sb1.setLength(10);
			dos.writeChars(sb1.toString());
			dos.writeInt(1);
			dos.writeDouble(1000.0);
			
			dos.writeInt(2);
			StringBuffer sb2= new StringBuffer("carlos");
			sb2.setLength(10);
			dos.writeChars(sb2.toString());
			dos.writeInt(2);
			dos.writeDouble(1000.0);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
	e1.printStackTrace();
		}
	}
	public static void main(String[] args) {
		//creaFichero();
		leeEmpleados();
	}
}
