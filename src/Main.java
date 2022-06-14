import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean entrada = false;
        Plane avioncito = null;
        String fileName = "data/plane.dat";
        FileInputStream inputFile = null;
        BufferedInputStream bufferedInput = null;
        ObjectInputStream objectInput = null;

        try {
            inputFile = new FileInputStream(fileName);
            bufferedInput = new BufferedInputStream(inputFile);
            objectInput = new ObjectInputStream(bufferedInput);

            try {
                Plane plane = (Plane) objectInput.readObject();
                if (plane == null) {
                    System.out.println("Software Plane Empty");
                } else {
                    System.out.println(plane);
                }
            } catch (EOFException ex) {
                System.out.println("--- END of File ---");
            } catch (ClassNotFoundException e) {
                System.out.println("Error al leer el archivo");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado...");
        } catch (IOException e) {
            e.printStackTrace();
        }
            while (!entrada) {
                System.out.println("1. Inicializar F-18");
                System.out.println("2. Alternar estado de los flaps");
                System.out.println("3. Alternar estado del tren de aterrizaje");
                System.out.println("4. Armar sistema de eyección");
                System.out.println("5. Eyectar piloto");
                System.out.println("Q.Salir");

                String opcion = sc.next();
                switch (opcion) {
                    case "1":
                        System.out.println("Introduzca el número de litros de combustible cargados: ");
                        float litros = sc.nextFloat();
                        sc.nextLine();
                        System.out.println("Introduzca apodo del piloto: ");
                        String apodo = sc.next();
                        System.out.println("Introduzca número de escuadrón: ");
                        String numEscuadron = sc.next();
                        avioncito = new Plane(litros, apodo, numEscuadron);
                        System.out.println(avioncito);
                        break;
                    case "2":
                        avioncito.toggleFlaps();
                        break;
                    case "3":
                        avioncito.toggleLandingGear();
                        break;
                    case "4":
                        avioncito.ejectionSystem();
                        break;
                    case "5":
                        avioncito.setSeatOccupation(avioncito.isSeatOccupation());
                        break;
                    case "Q":
                        FileOutputStream outputFile = null;
                        BufferedOutputStream bufferedOutput= null;
                        ObjectOutputStream objectOutput = null;

                        try {
                            outputFile = new FileOutputStream(fileName);
                            bufferedOutput = new BufferedOutputStream(outputFile);
                            objectOutput = new ObjectOutputStream(bufferedOutput);

                            objectOutput.writeObject(avioncito);

                        }catch (FileNotFoundException e){
                            System.out.println("Not found");
                        }catch (IOException e){
                            System.out.println(e);
                        }finally {
                            try {
                                if (objectOutput != null) objectOutput.close();
                                if (bufferedOutput != null) bufferedOutput.close();
                                if (outputFile != null) outputFile.close();
                            } catch (IOException e) {
                                System.out.println("Error al cerrar streams");
                            }
                        }
                        System.out.println(avioncito);

                            entrada = true;
                            System.out.println("Saliendo...");
                            break;
                        }
                }
    }
}
