package proyecto2edd;

/**
 *
 * @author gianc
 */
public class HashTable
{

    private HashNode[] nodos;
    private int capacidad;

    public HashTable(int tam) 
    {
        this.capacidad = tam;
        this.nodos = new HashNode[tam];
    }

    private int generarIndice(String clave) {
        if (clave == null) return 0;
        
        int h = 0;
        for (int i = 0; i < clave.length(); i++) {
            // (h << 5) - h es lo mismo que h * 31
            h = (h << 5) - h + clave.charAt(i);
        }
        
        // Convertimos a positivo manualmente y ajustamos al tamaño
        int indice = h % capacidad;
        return (indice < 0) ? -indice : indice;
    }

    public void insert(User nuevoUsuario) {
        if (nuevoUsuario == null) return;
        
        int pos = generarIndice(nuevoUsuario.name);
        HashNode cabeza = nodos[pos];

        HashNode temp = cabeza;
        while (temp != null) {
            if (temp.user.name.equals(nuevoUsuario.name)) return;
            temp = temp.next;
        }

        HashNode nuevoNodo = new HashNode(nuevoUsuario);
        nuevoNodo.next = nodos[pos];
        nodos[pos] = nuevoNodo;
    }

    public User buscar(String nombreBuscado) {
        int pos = generarIndice(nombreBuscado);
        HashNode actual = nodos[pos];

        while (actual != null) {
            if (actual.user.name.equals(nombreBuscado)) {
                return actual.user;
            }
            actual = actual.next;
        }
        return null;
    }

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