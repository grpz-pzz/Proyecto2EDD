package proyecto2edd;

/**
 * Lista de documentos.
 * Cada usuario tiene una lista como esta para organizar sus archivos
 * antes de mandarlos a la cola de impresión.
 * 
 * @author Giancarlo Paolino & Sebastian Velasquez
 */
public class List {
    
    // El primer nodo de la lista (el inicio de la cadena)
    private DocumentNode head;

    /**
     * Constructor: Crea una lista vacía.
     */
    public List() {
        this.head = null;
    }

    /**
     * Agrega un nuevo documento al inicio de la lista.
     * @param doc El documento que queremos guardar.
     */
    public void insert(Documento doc) {
        DocumentNode newDocument = new DocumentNode(doc);
        newDocument.next = head;
        head = newDocument;
    }

    /**
     * Busca un documento recorriendo la lista por su nombre.
     * @param name El nombre del archivo que buscamos.
     * @return El documento si lo encuentra, o null si no existe.
     */
    public Documento search(String name) {
        DocumentNode actual = head;
        while (actual != null) {
            if (actual.documento.name.equals(name)) {
                return actual.documento;
            }
            actual = actual.next;
        }
        return null;
    }

    /**
     * Elimina un documento de la lista, pero solo si no está en la cola.
     * @param name Nombre del archivo a borrar.
     * @return true si se borro, false si no se encontró o si ya está en impresion.
     */
    public boolean delete(String name) {
        if (head == null) return false;

        // El documento que queremos borrar es el primero
        if (head.documento.name.equals(name)) {
            // Solo borramos si el documento NO está en la cola (queue == false)
            if (!head.documento.queue) {
                head = head.next; // Saltamos el primer nodo
                return true;
            }
            return false;
        }

        // El documento está en medio o al final
        DocumentNode actual = head;
        while (actual.next != null) {
            if (actual.next.documento.name.equals(name)) {
                // Verificamos de nuevo que no esté en la cola
                if (!actual.next.documento.queue) {
                    // "Puenteamos" el nodo para quitarlo de la lista
                    actual.next = actual.next.next;
                    return true;
                }
                return false;
            }
            actual = actual.next;
        }
        return false;
    }
}