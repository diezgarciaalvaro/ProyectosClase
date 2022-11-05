package ejercicios;

import java.io.File;

public class ListarFicheros {
	

	public static void main(String[] args) {
		File file = new File("./directorioPrueba/");
		
		String files [] =  file.list();
		
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
			System.out.println(files[i].length());
		}
	}
}
