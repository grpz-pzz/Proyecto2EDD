package proyecto2edd;

/**
 * Esta clase organiza los documentos en un Montículo Binario (Min-Heap).
 * Su función es que el documento con el menor número de time
 * siempre esté en la parte superior para ser impreso primero.
 * 
 * @author GiancarloSebastian;
 */
public class MonticuloBinario {
    
    public Documento[] monticulo; // El arreglo donde se guardan los documentos
    public int tamano;           // Cuántos documentos hay actualmente
    public int capacidad;        // Máximo de documentos permitidos

    /**
     * Constructor: Prepara el arreglo con un tamaño máximo definido.
     * @param capacidad Límite de documentos en la cola.
     */
    public MonticuloBinario(int capacidad) {
        this.capacidad = capacidad;
        this.tamano = 0;
        this.monticulo = new Documento[capacidad];
    }

    private int getPadre(int i) {
        return (i - 1) / 2;
    }

    private int getHijoIzquierdo(int i) {
        return (2 * i) + 1;
    }

    private int getHijoDerecho(int i) {
        return (2 * i) + 2;
    }

    /**
     * Intercambia dos documentos de lugar en el arreglo y actualiza sus índices.
     */
    private void intercambiar(int i, int j) {
        Documento temporal = monticulo[i];
        monticulo[i] = monticulo[j];
        monticulo[j] = temporal;
        
        // Actualizamos el índice interno del documento para saber dónde quedó
        if (monticulo[i] != null) monticulo[i].index = i;
        if (monticulo[j] != null) monticulo[j].index = j;
    }
    
    /**
     * Reorganiza el montículo hacia abajo para mantener el orden.
     * Se usa después de extraer el mínimo.
     */
    private void minHeapify(int i) {
        int izq = getHijoIzquierdo(i);
        int der = getHijoDerecho(i);
        int maspequeno = i;

        // Comparamos con el hijo izquierdo
        if (izq < tamano && monticulo[izq].time < monticulo[i].time) {
            maspequeno = izq;
        }

        // Comparamos con el hijo derecho
        if (der < tamano && monticulo[der].time < monticulo[maspequeno].time) {
            maspequeno = der;
        }

        // Si el actual no es el más pequeño, intercambiamos y seguimos bajando
        if (maspequeno != i) {
            intercambiar(i, maspequeno);
            minHeapify(maspequeno);
        }
    }
    
    /**
     * Inserta un nuevo documento y lo hace "subir" hasta su posición correcta.
     * @param doc El documento a imprimir.
     */
    public void insertar(Documento doc) {
        if (tamano == capacidad) {
            System.out.println("Esta lleno el monticulo");
            return;
        }

        // Ponemos el nuevo documento al final del arreglo
        tamano++;
        int i = tamano - 1;
        monticulo[i] = doc;
        doc.index = i;

        // Mientras no sea la raíz y sea más prioritario que su padre, sube
        while (i != 0 && monticulo[getPadre(i)].time > monticulo[i].time) {
            intercambiar(i, getPadre(i));
            i = getPadre(i);
        }
    }

    /**
     * Saca el documento que está en la cima (la posición 0).
     * @return El documento con mayor prioridad.
     */
    public Documento extraerMinimo() {
        if (tamano <= 0) return null;
        
        if (tamano == 1) {
            tamano--;
            monticulo[0].index = -1;
            return monticulo[0];
        }

        // Guardamos la raíz para devolverla al final
        Documento raiz = monticulo[0];
        raiz.index = -1;
        
        // Pasamos el último documento a la cima y lo hacemos bajar
        monticulo[0] = monticulo[tamano - 1];
        if (monticulo[0] != null) monticulo[0].index = 0;
        
        tamano--;
        minHeapify(0);

        return raiz;
    }
    
    /**
     * Elimina un documento específico usando su índice.
     * @param indice La posición donde se encuentra el documento.
     */
    public void cancelarDocumento(int indice) {
        if (indice < 0 || indice >= tamano) return;
        
        // Le ponemos una prioridad súper alta para que suba a la raíz
        monticulo[indice].time = -999999;
        
        int i = indice;
        while (i != 0 && monticulo[getPadre(i)].time > monticulo[i].time) {
            intercambiar(i, getPadre(i));
            i = getPadre(i);
        }
        
        // Una vez en la raíz lo extraemos
        Documento cancelado = extraerMinimo();
        cancelado.queue = false;
    }

    public Documento[] getMonticulo() {
        return monticulo;
    }
    
    public int getSize() {
        return tamano;
    }
}