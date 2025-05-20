// Define el paquete donde se encuentra esta clase
package service;

// Importa la clase Producto del modelo
import models.Producto;

// Importa clases necesarias para manejar listas
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Clase que implementa la interfaz ProductoService
public class ProductoServiceImpl implements ProductoService {

    // Implementación del método listar() definido en la interfaz ProductoService
    @Override
    public List<Producto> listar() {
        // Retorna una lista fija (inmutable) de productos utilizando Arrays.asList()
        return Arrays.asList(
                new Producto(1L, "laptop", "computacion", 523.21),           // Producto 1
                new Producto(2L, "Mouse", "inalambrico", 15.25),             // Producto 2
                new Producto(3L, "Impresora", "tinta continua", 256.25)      // Producto 3
        );
    }
}
