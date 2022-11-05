import java.io.*;
import java.util.Scanner;

public class VehiculoData {

    static Scanner teclado = new Scanner(System.in);

    public static void nuevoVehiculo() {
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

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("vehiculos.txt", true));){

            dos.writeUTF(v1.getMatricula());
            dos.writeUTF(v1.getMarca());
            dos.writeDouble(v1.getDeposito());
            dos.writeUTF(v1.getModelo());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leeVehiculo() {
        boolean eof = false;
        try (DataInputStream dis = new DataInputStream(new FileInputStream("vehiculos.datos"))){
            while(!eof) {
                String matricula = dis.readUTF();
                String marca = dis.readUTF();
                double deposito = dis.readDouble();
                String modelo  = dis.readUTF();

                Vehiculo v = new Vehiculo(matricula, marca, deposito, modelo);
                System.out.println(v.toString());
            }
        }  catch (EOFException e){
            eof = true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
       nuevoVehiculo();
       leeVehiculo();
    }
}
