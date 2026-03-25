package proyecto2edd;

/**
 * Esta clase administra el sistema completo.
 * Coordina la búsqueda de usuarios, el envío de documentos a la cola 
 * de impresión y el manejo del tiempo mediante el reloj.
 * 
 * @author Giancarlo Paolino & Sebastian Velasquez
 */
public class Manager {
    
    // Almacén de usuarios registrados
    public HashTable users;
    // La cola de prioridad donde se ordenan los documentos para imprimir
    public MonticuloBinario cola;
    // El objeto que asigna los turnos o marcas de tiempo
    public Reloj reloj;

    /**
     * Constructor: Configura el sistema con una tabla de usuarios ya existente.
     * @param usuarios La tabla hash con los usuarios cargados.
     */
    public Manager(HashTable usuarios) {
        this.users = usuarios;
        // Creamos una cola con capacidad para 100 documentos
        this.cola = new MonticuloBinario(100);
        this.reloj = new Reloj();
    }
    
    public MonticuloBinario getColaimpresion() {
        return cola;
    }
    
    public HashTable getUsuarios() {
        return users;
    }

    /**
     * Crea un documento y lo mete a la cola de impresión.
     * @param nombreusuario Quién manda a imprimir.
     * @param nombredocumento Nombre del archivo.
     * @param tamano Cuántas páginas o peso tiene.
     */
    public void imprimir(String nombreusuario, String nombredocumento, int tamano) {
        // Buscamos si el usuario existe en la tabla hash
        User usuario = users.buscar(nombreusuario);
        
        if (usuario != null) {
            // Creamos el documento y lo guardamos en la lista personal del usuario
            Documento nuevodocumento = new Documento(nombredocumento, tamano, usuario);
            usuario.list.insert(nuevodocumento);
            
            // Asignar una marca de tiempo según la prioridad del usuario
            int etiqueta = reloj.timeToText(usuario.priority);
            nuevodocumento.time = etiqueta;
            
            // Se marca como en cola y lo metemos al montículo
            nuevodocumento.queue = true;
            cola.insertar(nuevodocumento);
            
            // El tiempo del sistema avanza
            reloj.avanzar();
        }
    }

    /**
     * Saca el documento con mayor prioridad (el mínimo en el montículo) para imprimirlo.
     * @return El documento que sigue en la fila.
     */
    public Documento imprimirsiguiente() {
        Documento doc = cola.extraerMinimo();
        if (doc != null) {
            // Al salir de la cola, actualizamos su estado
            doc.queue = false;
            reloj.avanzar();
        }
        return doc;
    }
    
    /**
     * Elimina un documento que ya estaba en la fila de espera.
     * @param nombreusuario El dueño del documento.
     * @param nombredocumento El nombre del archivo a quitar.
     */
    public void cancelar(String nombreusuario, String nombredocumento) {
        // Buscamos al usuario y luego el documento dentro de su lista
        User usuario = users.buscar(nombreusuario);
        Documento doc = usuario.list.search(nombredocumento);
        
        // Usamos el índice que el documento tiene guardado para quitarlo del montículo
        cola.cancelarDocumento(doc.index);
        reloj.avanzar();
    }
}