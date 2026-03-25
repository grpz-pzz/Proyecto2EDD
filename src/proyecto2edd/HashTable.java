package proyecto2edd;

/**
 * Usa un nombre para calcular un número de cajón (índice) y guarda ahí al usuario.
 * 
 * @author Giancarlo Paolino & Sebastian Velasquez
 */
public class HashTable {

    // Arreglo donde guardamos las listas de usuarios
    private HashNode[] nodos;
    // Tamaño máximo del arreglo
    private int capacidad;

    /**
     * Constructor: Prepara el espacio para guardar los datos.
     * @param tam Cuántos espacios tendrá la tabla.
     */
    public HashTable(int tam) {
        this.capacidad = tam;
        this.nodos = new HashNode[tam];
    }

    /**
     * Esta es la funcion que convierte un nombre en un número (hash).
     * @param clave El nombre del usuario.
     * @return Un número de índice válido dentro del tamaño de la tabla.
     */
    private int generarIndice(String clave) {
        if (clave == null) return 0;
        
        int h = 0;
        for (int i = 0; i < clave.length(); i++) {
            h = (h << 5) - h + clave.charAt(i);
        }
        
        int indice = h % capacidad;
        return (indice < 0) ? -indice : indice;
    }

    /**
     * Guarda un nuevo usuario en la tabla.
     * @param nuevoUsuario El objeto User con toda su información.
     */
    public void insert(User nuevoUsuario) {
        if (nuevoUsuario == null) return;
        
        // Calcularmos dónde debe ir
        int pos = generarIndice(nuevoUsuario.name);
        
        // Si ese nombre ya existe para no repetirlo
        HashNode temp = nodos[pos];
        while (temp != null) {
            if (temp.user.name.equals(nuevoUsuario.name)) return;
            temp = temp.next;
        }

        // Se al inicio de la lista en esa posición
        HashNode nuevoNodo = new HashNode(nuevoUsuario);
        nuevoNodo.next = nodos[pos];
        nodos[pos] = nuevoNodo;
    }

    /**
     * Busca a un usuario por su nombre.
     * @param nombreBuscado El nombre que escribió el usuario en la interfaz.
     * @return El objeto User si lo encuentra, o null si no existe.
     */
    public User buscar(String nombreBuscado) {
        int pos = generarIndice(nombreBuscado);
        HashNode actual = nodos[pos];

        // Recorremos la lista en esa posición hasta encontrar el nombre
        while (actual != null) {
            if (actual.user.name.equals(nombreBuscado)) {
                return actual.user;
            }
            actual = actual.next;
        }
        return null;
    }

    /**
     * Elimina a un usuario de la tabla.
     * @param nombreAEliminar El nombre de la persona que se va a borrar.
     */
    public void eliminar(String nombreAEliminar) {
        int pos = generarIndice(nombreAEliminar);
        HashNode actual = nodos[pos];
        HashNode previo = null;

        while (actual != null) {
            if (actual.user.name.equals(nombreAEliminar)) {
                if (previo == null) {
                    nodos[pos] = actual.next;
                } else {
                    previo.next = actual.next;
                }
                return;
            }
            previo = actual;
            actual = actual.next;
        }
    }
}