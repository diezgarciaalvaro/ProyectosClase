package ejercicios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ObjetosFile {

	File f1, f2, f3, f4;
	String [] arrayf3;
	
	public ObjetosFile() {
		String nombre = "archivo.txt";
		this.arrayf3 = new String[2];
		this.f1 = new File("./directorioPrueba/archivoPrueba");
		this.f2 = new File("archivoInexistente.txt");
		this.f3 = new File(".");
		this.f4 = new File(nombre);
	}
	
	public static void ordenesF1(File file) {
		System.out.println("---Ejercicios con f1---");
		
		System.out.println(file.getName());
		
		System.out.println(file.getPath());
		
		System.out.println(file.getParent());
		
		if (file.exists()) {
			System.out.println("Existe");
		} else {
			System.out.println("No existe");
		}
		
		if (file.canWrite()) {
			System.out.println("Se puede escribir en el");
		} else {
			System.out.println("No se puede escribir en el");
		}
		
		if (file.isDirectory()) {
			System.out.println("Es un directorio");
		} else {
			System.out.println("No es un directorio");
		}
		
		if (file.isFile()) {
			System.out.println("Es un fichero");
		} else {
			System.out.println("No es un fichero");
		}
		
		if (file.isAbsolute()) {
			System.out.println("Es ruta absoluta y su longitud es" + file.length());
		} else {
			System.out.println("NO es una ruta absoluta");
		}
	}
	
	private static void ordenesF2(File file) {
		System.out.println("---Ejercicio con f2---");
		System.out.println(file.getAbsolutePath());
	}
	
	private static void ordenesF3(File file, String [] array) {
		System.out.println("---Ejercicio con f3---");
		
		array[1] = file.toString();
		
		System.out.println(array[1]);
	}
	
	private static void ordenesF4(File file) throws IOException {
		System.out.println("---Ejercicio con f4---");
		FileWriter fr = new FileWriter(file);
	}
	
	
	public static void main(String[] args) throws IOException {
		ObjetosFile of = new ObjetosFile();
		ordenesF1(of.f1);
		ordenesF2(of.f2);
		ordenesF3(of.f3, of.arrayf3);
		ordenesF4(of.f4);
		

	}


}
