/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mx.itson.cinefilo.cinefilo;

import java.util.Scanner;
import mx.itson.cinefilo.entity.Cine;
import mx.itson.cinefilo.entity.Funcion;

public class Main {
    
    public static void main(String[] args) {
        Cine cine = new Cine();

        // Agregar funciones al cine
        cine.agregarFuncion(new Funcion("Venom el último baile", "2:00 PM", 100.0));
        cine.agregarFuncion(new Funcion("Sonríe 2", "5:00 PM", 120.0));
        cine.agregarFuncion(new Funcion("Gladiador (ReEstreno)", "8:00 PM", 150.0));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Mostrar funciones");
            System.out.println("2. Vender boleto");
            System.out.println("3. Reporte general");
            System.out.println("4. Reporte por función");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    cine.mostrarFunciones();
                    break;
                case 2:
                    cine.mostrarFunciones();
                    System.out.print("Seleccione el número de función: ");
                    int indiceFuncion = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Funcion funcion = cine.seleccionarFuncion(indiceFuncion);
                    funcion.mostrarAsientos();

                    System.out.print("Ingrese su nombre (opcional): ");
                    String cliente = scanner.nextLine();

                    System.out.print("Seleccione un asiento (1-16): ");
                    int numeroAsiento = scanner.nextInt();

                    funcion.venderBoleto(cliente, numeroAsiento);
                    break;
                case 3:
                    cine.reporteGeneral();
                    break;
                case 4:
                    cine.reportePorFuncion();
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema de cine.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
