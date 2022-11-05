import java.io.*;
import java.util.Scanner;

public class VehiculSerializar {

    static Scanner teclado = new Scanner(System.in);

    public static void nuevoVehiculo() throws IOException {
        String matricula;
        String marca;
        double deposito;
        String modelo;

        System.out.println("Introduzca matricula");
        matricula = teclado.next();
        System.out.println("Introduzca marca");
        marca = teclado.next();
        System.out.println("Introduca deposito");
        deposito = Double.parseDouble(teclado.next());
        System.out.println("Introduzca modelo");
        modelo = teclado.next();

        Vehiculo v1 = new Vehiculo(matricula, marca, deposito, modelo);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("vehiculos.datos", true));){
            oos.writeObject(v1);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void leeVehiculos() {
        Vehiculo vehiculo;
        boolean eof = false;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("vehiculos.datos"))) {

            while(!eof) {
               vehiculo= (Vehiculo) ois.readObject();
                System.out.println(vehiculo.toString());
            }

        }catch (EOFException e) {
          eof = true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        nuevoVehiculo();
        leeVehiculos();
    }
}
