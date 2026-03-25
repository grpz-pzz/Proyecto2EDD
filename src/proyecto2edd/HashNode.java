package proyecto2edd;

/**
 * Esta clase representa el nodo de la Tabla Hash de usuarios.
 * 
 * @author Giancarlo Paolino & Sebastian Velasquez
 */
public class HashNode {

    // El objeto que contiene los datos del usuario
    public User user;

    // Referencia que apunta al siguiente usuario en la lista
    public HashNode next;

    /**
     * Constructor: Se encarga de crear el nodo y asignarle un usuario.
     * Al crearse, el valor de next es null porque todavía no tiene a nadie después.
     * 
     * @param usuario El objeto de tipo User que queremos guardar en este nodo.
     */
    public HashNode(User usuario) {
        this.user = usuario;
        this.next = null;
    }
}