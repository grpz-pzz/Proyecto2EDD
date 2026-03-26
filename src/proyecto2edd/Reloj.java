package proyecto2edd;

/**
 * Esta clase simula el paso del tiempo en el sistema.
 * Su función principal es asignar un valor numérico a cada documento
 * por el momento en que llega y la prioridad del usuario.
 * 
 * @author GiancarloSebastian;
 */
public class Reloj {

    // Contador que aumenta cada vez que ocurre una acción en el sistema
    private int tiempo;
    
    /**
     * Constructor: El reloj empieza desde cero.
     */
    public Reloj() {
        this.tiempo = 0;
    }
    
    /**
     * Aumenta el contador de tiempo en una unidad.
     */
    public void avanzar() {
        this.tiempo++;
    }

    /**
     * @return El valor actual del tiempo.
     */
    public int getTime() {
        return tiempo;
    }

    /**
     * Calcula la etiqueta de prioridad para un documento.
     * Entre más bajo sea el resultado, más rápido se imprimirá en el Min-Heap.
     * 
     * @param prioridad El nivel de importancia del usuario (alta, media o baja).
     * @return El número que representará la prioridad en el montículo.
     */
    public int timeToText(String prioridad) {
        int etiqueta = tiempo;
        
        if (null != prioridad) {
            // Dependiendo del rango del usuario, le sumamos mas tiempo
            // para que los de prioridad baja queden más atrás en la fila.
            switch (prioridad) {
                case "prioridad_alta":
                    // Se le suma poco, queda cerca del tiempo actual
                    etiqueta = (tiempo + 1);
                    break;
                case "prioridad_media":
                    // Se le suma un poco más
                    etiqueta = (tiempo + 5);
                    break;
                case "prioridad_baja":
                    // Se le suma mucho, por lo que su valor será alto
                    etiqueta = (tiempo + 10);
                    break;
                default:
                    break;
            }
        }
        return etiqueta;
    }
}