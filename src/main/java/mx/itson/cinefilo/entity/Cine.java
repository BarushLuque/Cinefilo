/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.cinefilo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un cine con una lista de funciones disponibles.
 */
public class Cine {

    // Lista que almacena las funciones del cine
    private List<Funcion> funciones;

    /**
     * Constructor de la clase Cine.
     * Inicializa la lista de funciones como un ArrayList vacío.
     */
    public Cine() {
        this.funciones = new ArrayList<>();
    }

    /**
     * Agrega una función a la lista de funciones del cine.
     * 
     * @param funcion La función que se desea agregar.
     */
    public void agregarFuncion(Funcion funcion) {
        funciones.add(funcion); // Añade la función a la lista
    }

    /**
     * Muestra todas las funciones disponibles en el cine.
     * Cada función se muestra con un número, su nombre y horario.
     */
    public void mostrarFunciones() {
        for (int i = 0; i < funciones.size(); i++) { // Itera por las funciones
            Funcion funcion = funciones.get(i); // Obtiene cada función
            // Muestra el número, el nombre y el horario de la función
            System.out.println((i + 1) + ". " + funcion.getNombre() + " | Horario: " + funcion.getHorario());
        }
    }

    /**
     * Selecciona una función específica de la lista basándose en su índice.
     * 
     * @param indice El número de la función seleccionada por el usuario (base 1).
     * @return La función seleccionada.
     */
    public Funcion seleccionarFuncion(int indice) {
        // Resta 1 al índice porque las listas en Java son base 0
        return funciones.get(indice - 1);
    }

    /**
     * Genera un reporte general del cine.
     * Muestra el total de boletos vendidos y las ganancias totales de todas las funciones.
     */
    public void reporteGeneral() {
        System.out.println("Reporte General:");
        double totalGanancias = 0; // Acumula las ganancias totales
        int totalBoletos = 0; // Acumula el número total de boletos vendidos

        // Itera por cada función para calcular las ganancias y boletos
        for (Funcion funcion : funciones) {
            totalGanancias += funcion.getTotalGanancia(); // Suma las ganancias de la función
            totalBoletos += funcion.getBoletosVendidos(); // Suma los boletos vendidos
        }

        // Muestra el total de boletos y ganancias
        System.out.println("Total de boletos vendidos: " + totalBoletos);
        System.out.println("Ganancias totales: $" + totalGanancias);
    }

    /**
     * Genera un reporte detallado por cada función.
     * Muestra el nombre de la película, boletos vendidos y ganancias de cada función.
     */
    public void reportePorFuncion() {
        System.out.println("Reporte por Función:");
        // Itera por todas las funciones para mostrar los detalles de cada una
        for (Funcion funcion : funciones) {
            System.out.println("Película: " + funcion.getNombre()); // Nombre de la película
            System.out.println("Boletos vendidos: " + funcion.getBoletosVendidos()); // Boletos vendidos
            System.out.println("Ganancia total: $" + funcion.getTotalGanancia()); // Ganancia total
            System.out.println(); // Línea en blanco para separar funciones
        }
    }
}
