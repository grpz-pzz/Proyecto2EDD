package proyecto2edd;

/**
 * Clase que sirve como un elemento de una lista enlazada.
 * Guarda un objeto de tipo Documento y permite conectarlo con otro 
 * nodo para que la Tabla Hash pueda manejar varios datos en una misma posición.
 * 
 * @author GiancarloSebastian;
 */
public class DocumentNode {

    // El objeto que contiene la información del archivo a imprimir
    Documento documento;

    // Referencia que indica cuál es el siguiente nodo en la lista
    public DocumentNode next;

    /**
     * Constructor que recibe el documento y lo asigna al nodo.
     * Al inicio, el valor de next es null porque no tiene un sucesor.
     * 
     * @param documento El dato que se va a guardar en este espacio
     */
    public DocumentNode(Documento documento) {
        this.documento = documento;
        this.next = null;
    }
}