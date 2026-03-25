package proyecto2edd;

/**
 * Representa la entidad de un trabajo de impresión dentro del sistema.
 * Esta clase almacena los datos, el estado de prioridad y la 
 * información del usuario para cada archivo en la cola.
 * 
 * @author Giancarlo Paolino & Sebastian Velasquez
 */
public class Documento {
    
    // El nombre del documento
    public String name;
    
    // Indicador booleano para saber si el documento ya está en la cola
    public boolean queue;
    
    // Valor de tiempo o prioridad utilizado para el montículo binario
    public int time;
    
    // La posición actual del documento dentro del arreglo del montículo
    public int index;
    
    // El tamaño físico del documento (por ejemplo, número de páginas)
    public int size;
    
    // El propietario del documento, usado para determinar el nivel de prioridad
    public User user;
    
    /**
     * Constructor para inicializar un nuevo Documento con sus propiedades básicas.
     * Se asignan valores por defecto a las variables de control como tiempo e índice.
     * 
     * @param name El nombre del archivo
     * @param size El tamaño total del documento
     * @param user El objeto Usuario que creó este documento
     */
    public Documento(String name, int size, User user) {
        this.name = name;
        this.size = size;
        this.user = user;
        
        // Estado inicial: no en cola, sin tiempo asignado y sin índice en el heap
        this.queue = false;
        this.time = 0;
        this.index = -1;
    }
}