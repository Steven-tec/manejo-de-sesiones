// Define el paquete donde se encuentra esta interfaz
package service;

// Importa la clase Producto que se utilizará en la interfaz
import models.Producto;

import java.util.List; // Importa la clase List para manejar listas de productos

// Interfaz que define el contrato para los servicios relacionados con productos
public interface ProductoService {

    // Método que debe ser implementado para obtener una lista de productos
    List<Producto> listar();
}

