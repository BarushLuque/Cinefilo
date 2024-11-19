/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.cinefilo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una función en un cine, con un nombre, horario,
 * precio de boletos, asientos, y registro de ventas.
 */
public class Funcion {

    // Nombre de la película
    private String nombre;

    // Horario de la función
    private String horario;

    // Lista de asientos disponibles en la función
    private List<Asiento> asientos;

    // Precio del boleto para esta función
    private double precio;

    // Contador de boletos vendidos
    private int boletosVendidos;

    // Ganancia total generada por la venta de boletos
    private double totalGanancia;

    /**
     * Constructor de la clase Funcion.
     * Inicializa la función con un nombre, horario y precio de boleto.
     * Crea 16 asientos numerados para la función.
     * 
     * @param nombre  El nombre de la película.
     * @param horario El horario de la función.
     * @param precio  El precio del boleto.
     */
    public Funcion(String nombre, String horario, double precio) {
        this.nombre = nombre;
        this.horario = horario;
        this.precio = precio;
        this.asientos = new ArrayList<>();
        this.boletosVendidos = 0;
        this.totalGanancia = 0.0;

        // Crear 16 asientos numerados
        for (int i = 1; i <= 16; i++) {
            asientos.add(new Asiento(i));
        }
    }

    /**
     * Obtiene el nombre de la película.
     * 
     * @return El nombre de la película.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el horario de la función.
     * 
     * @return El horario de la función.
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Obtiene la lista de asientos disponibles en la función.
     * 
     * @return Lista de objetos Asiento.
     */
    public List<Asiento> getAsientos() {
        return asientos;
    }

    /**
     * Obtiene la ganancia total de la función.
     * 
     * @return La ganancia total generada por la función.
     */
    public double getTotalGanancia() {
        return totalGanancia;
    }

    /**
     * Obtiene el total de boletos vendidos en la función.
     * 
     * @return El número de boletos vendidos.
     */
    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    /**
     * Vende un boleto para un asiento específico.
     * Marca el asiento como ocupado, registra la venta, y actualiza las ganancias.
     * 
     * @param cliente       El nombre del cliente (puede estar vacío para "anónimo").
     * @param numeroAsiento El número del asiento a vender (1-16).
     */
    public void venderBoleto(String cliente, int numeroAsiento) {
        // Obtiene el asiento correspondiente (índice basado en 0)
        Asiento asiento = asientos.get(numeroAsiento - 1);

        // Verifica si el asiento está disponible
        if (!asiento.isOcupado()) {
            // Marca el asiento como ocupado
            asiento.setOcupado(true);

            // Incrementa el contador de boletos vendidos y las ganancias
            boletosVendidos++;
            totalGanancia += precio;

            // Muestra la confirmación de la venta
            System.out.println("Boleto vendido a: " + (cliente.isEmpty() ? "Cliente Anónimo" : cliente));
            System.out.println("Asiento: " + numeroAsiento + " | Película: " + nombre);
        } else {
            // Muestra un mensaje si el asiento ya está ocupado
            System.out.println("El asiento " + numeroAsiento + " ya está ocupado.");
        }
    }

    /**
     * Muestra el estado de todos los asientos en la función.
     * Los asientos ocupados se muestran como "[X]" y los libres con su número.
     * Se organizan en filas de 4 asientos.
     */
    public void mostrarAsientos() {
        for (int i = 0; i < asientos.size(); i++) {
            // Imprime el estado del asiento
            System.out.print(asientos.get(i) + " ");

            // Salta a la siguiente línea cada 4 asientos
            if ((i + 1) % 4 == 0) System.out.println();
        }
    }
}
