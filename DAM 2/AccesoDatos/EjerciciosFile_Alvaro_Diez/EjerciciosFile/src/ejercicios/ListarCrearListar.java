package ejercicios;

import java.io.File;

public class ListarCrearListar {
	
	public static void main(String[] args) {
		String cadena = "./ejer_ficherosFileListar";
		
		File file = new File(cadena);
		
		if (file.exists() && file.isDirectory()) {
			System.out.println(file.getName() + " es un directorio");
			
			String [] content = file.list();
			
			for (int i = 0; i < content.length; i++) {
				System.out.println(content[i] + " longitud: " + content[i].length());
			}
		} else {
			System.out.println(file.getName() + " no es un directorio o no existe");
		}
	}
}
