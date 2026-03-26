package proyecto2edd;

/**
 * Esta clase representa a un usuario dentro del sistema de impresión.
 * Cada usuario tiene un nombre único, un rango de prioridad y su propia
 * lista personal de documentos.
 * 
 * @author GiancarloSebastian;
 */
public class User {

    // El nombre del usuario que se usa como clave en la Tabla Hash
    public String name;
    
    // La lista enlazada donde el usuario guarda sus propios documentos
    public List list;
    
    // El rango del usuario: prioridad_alta, prioridad_media o prioridad_baja
    public String priority;

    /**
     * Constructor: Crea un nuevo usuario y le asigna una lista de documentos vacía.
     * 
     * @param name El nombre de identificación del usuario.
     * @param priority El nivel de importancia para el orden de impresión.
     */
    public User(String name, String priority) {
        this.name = name;
        this.priority = priority;
        
        // Cada vez que creamos un usuario, le damos su propio espacio de documentos
        this.list = new List();
    }
}