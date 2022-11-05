package ejercicioFlujos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class EscribirNumeros {
	
	FileWriter fw;
	FileReader fr;
	
	void escribeNumeros(File FileNumeros) throws IOException {
		fw = new FileWriter(FileNumeros);
		for (int i = 0; i <= 20; i++) {
			fw.write(i);
			fw.close();
		}
	}
	
	void sumaNumeros(File FileNumeros) throws IOException {
		fr = new FileReader(FileNumeros);
		int suma = 0;
		int n;
		
		while ((n = fr.read()) != -1) {
			suma += n;
			System.out.println(suma);
		}
	}
}
