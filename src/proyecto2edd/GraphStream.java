package proyecto2edd;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;

/**
 * @author gianc
 */
public class GraphStream {

    private Graph grafo;
    private Viewer visor;
    
    private final String ARISTA_PREFIX = "edge_";

    public GraphStream() 
    {
        System.setProperty("org.graphstream.ui", "swing");
        
        this.grafo = new SingleGraph("MonticuloBinario");

        configurarEstilos();
    }

    public Viewer mostrarVisor() {
        if (visor == null) {
            visor = grafo.display();
            visor.enableAutoLayout();
        }
        return visor;
    }

    public void actualizararbol(Documento[] monticulo, int tamano) {
        grafo.clear();
        configurarEstilos();

        if (monticulo == null || tamano == 0) {
            return;
        }

        for (int i = 0; i < tamano; i++) {
            if (monticulo[i] != null) {
                String idNodo = String.valueOf(i);
                Node nodo = grafo.addNode(idNodo);
                
                String infoUsuario = monticulo[i].user.name;
                String infoTiempo = "Prioridad: " + monticulo[i].time;
                
                nodo.setAttribute("ui.label", infoUsuario + " | Prio: " + infoTiempo);
                
                if (i == 0) {
                    nodo.setAttribute("ui.class", "raiz");
                }
            }
        }

        for (int i = 0; i < tamano; i++) {
            if (monticulo[i] == null) continue;

            int idHijoIzq = (2 * i) + 1;
            int idHijoDer = (2 * i) + 2;

            if (idHijoIzq < tamano && monticulo[idHijoIzq] != null) {
                String idArista = ARISTA_PREFIX + i + "_" + idHijoIzq;
                grafo.addEdge(idArista, String.valueOf(i), String.valueOf(idHijoIzq));
            }

            if (idHijoDer < tamano && monticulo[idHijoDer] != null) {
                String idArista = ARISTA_PREFIX + i + "_" + idHijoDer;
                grafo.addEdge(idArista, String.valueOf(i), String.valueOf(idHijoDer));
            }
        }
    }

    private void configurarEstilos() {
        String styleSheet = 
            // Cambiamos 'background-color' por 'canvas-color'
            "graph { padding: 40px; canvas-color: white; }" + 
            "node {" +
            "   size: 35px, 25px;" + 
            "   fill-color: #87CEFA;" + 
            "   stroke-mode: plain;" + 
            "   stroke-color: black;" +
            "   text-size: 13;" +
            "   text-alignment: center;" +
            "   text-color: black;" +
            "}" +
            "node.raiz {" + 
            "   fill-color: #FFC0CB;" + 
            "   size: 40px, 30px;" +
            "}" +
            "edge {" +
            "   fill-color: black;" +
            "   size: 2px;" +
            "}";

        grafo.setAttribute("ui.stylesheet", styleSheet);
    }
}