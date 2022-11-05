package ejercicios;

import java.io.File;

public class LeerMoverFicheros {
	
	static File origen = new File("./DirOrigen/");
	static File destino = new File("./DirDestino/");
	
	private static void mover(File og, File des) {
		String [] ficheros;
		
		
		if (og.exists()) {
			System.out.println("Origen existe");
			if (des.exists()) {
				System.out.println("Destino Existe");
			} else {
				des.mkdir();
			}
			
			ficheros = og.list();
			
			for (int i = 0; i < ficheros.length; i++) {
				File fich = new File(og + "/" +ficheros[i]);
				
				System.out.println(fich.getName());
				
				if (fich.renameTo(new File (des + "/" + fich.getName()))) {
				    System.out.println("File moved successfully");
				} else {
				    System.out.println("Failed to move file");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		mover(origen, destino);
	}
}
