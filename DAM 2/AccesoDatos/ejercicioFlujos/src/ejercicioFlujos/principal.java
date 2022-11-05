package ejercicioFlujos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class principal {
	static String fich = "EJERCICIO FLUJOS.docx";
	static String destino = "EJERCICIOS FLUJOS M.docx";
	static String FileNums = "numeros.txt";
	static String FileDepartamentos = "departamentos.dat";
	
	static byte[] arrayBytes = new byte[] {'b','y','t','e'};
	
	static moverFicheroBinario mover = new moverFicheroBinario();
	static EscribirNumeros escribeNumeros = new EscribirNumeros();

	
	static departamento[] departamentos = new departamento[] {
			new departamento(1, "Pepe", "Madrid"), new departamento(2, "Antonio", "Murcia")
	};
	
	private static void leeFichero() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("EJERCICIOS FLUJOS.docx"));

		String linea;
		while ((linea = br.readLine()) != null) {
			System.out.println(linea);
		
		}
		br.close();
	}
	
	public static void escribeNumeros() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("EJERCICIOS FLUJOS.docx", true));
		
		bw.newLine();
		bw.write("123");
		bw.flush();
		
		bw.close();
		
	}
	
	public static void escribeBytes() throws IOException {
		byte[] bytes = Files.readAllBytes(Paths.get("prueba.txt"));
		
		FileOutputStream fos = new FileOutputStream("EJERCICIOS FLUJOS.docx", true);
		fos.write(bytes);
	}
	
	static void registraDepartamento(File binario, departamento[] departamentos) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(binario));
		
		for (departamento departamento : departamentos) {
			oos.writeObject(departamento);
		}
		
		oos.close();
	}
	public static void main(String[] args) throws IOException {
		
		System.out.println("Ejercicio 1");
		leeFichero();
		System.out.println("Escritura de numeros");
		escribeNumeros();
		leeFichero();
		System.out.println("Escritura de bytes");
		escribeBytes();
		leeFichero();
		
		System.out.println("Ejercicio 3");
		moverFicheroBinario.moverFichero();
		
		System.out.println("Ejercicio 4");
		escribeNumeros.escribeNumeros(new File(FileNums));
		escribeNumeros.sumaNumeros(new File(FileNums));
		
		System.out.println("Ejercicio 5");
		registraDepartamento(new File(FileDepartamentos), departamentos);
		
		
		
	}
}
