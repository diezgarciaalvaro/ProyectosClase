package ejercicioFlujos;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class moverFicheroBinario {
	public static void moverFichero() throws IOException {
		byte[] bytes = Files.readAllBytes(Paths.get("./origen/binarios.dat"));
		
		try (FileOutputStream fos = new FileOutputStream("./destino/binarios.dat")) {
			fos.write(bytes);
		}		
	}


	
	public static void main(String[] args) throws IOException {
		moverFichero();
	}
}
