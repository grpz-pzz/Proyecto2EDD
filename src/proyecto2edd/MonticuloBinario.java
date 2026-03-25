/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author sebvpc
 */

//lo de ingles lo vi despues
public class MonticuloBinario 
{
    public Documento[] monticulo;
    public int tamano;
    public int capacidad;

    public MonticuloBinario(int capacidad) {
        this.capacidad = capacidad;
        this.tamano = 0;
        this.monticulo = new Documento[capacidad];
    }
    
    public Documento[] getMonticulo() {
        return monticulo;
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
    
    public int getSize() {
        return tamano;
    }

    private void intercambiar(int i, int j) {
        Documento temporal = monticulo[i];
        monticulo[i] = monticulo[j];
        monticulo[j] = temporal;
        
        if (monticulo[i] != null) monticulo[i].index = i;
        if (monticulo[j] != null) monticulo[j].index = j;
    }
    
        private void minHeapify(int i) {
        int izq = getHijoIzquierdo(i);
        int der = getHijoDerecho(i);
        int maspequeno = i;

        if (izq < tamano && monticulo[izq].time < monticulo[i].time) {
            maspequeno = izq;
        }

        if (der < tamano && monticulo[der].time < monticulo[maspequeno].time) {
            maspequeno = der;
        }

        if (maspequeno != i) {
            intercambiar(i, maspequeno);
            minHeapify(maspequeno);
        }
    }
    
    public void insertar(Documento doc) {
        if (tamano == capacidad) {
            System.out.println("Esta lleno el monticulo");
            return;
        }

        tamano++;
        int i = tamano - 1;
        monticulo[i] = doc;
        doc.index = i;

        while (i != 0 && monticulo[getPadre(i)].time > monticulo[i].time) {
            intercambiar(i, getPadre(i));
            i = getPadre(i);
        }
    }

    public Documento extraerMinimo() {
        if (tamano <= 0) {
            return null;
        }
        if (tamano == 1) {
            tamano--;
            monticulo[0].index = -1;
            return monticulo[0];
        }

        Documento raiz = monticulo[0];
        raiz.index = -1;
        
        monticulo[0] = monticulo[tamano - 1];
        if (monticulo[0] != null) monticulo[0].index = 0;
        
        tamano--;
        minHeapify(0);

        return raiz;
    }
    
    public void cancelarDocumento(int indice) {
        if (indice < 0 || indice >= tamano) return;
        
        monticulo[indice].time = -9999;
        
        int i = indice;
        while (i != 0 && monticulo[getPadre(i)].time > monticulo[i].time) {
            intercambiar(i, getPadre(i));
            i = getPadre(i);
        }
        
        Documento cancelado = extraerMinimo();
        cancelado.queue = false;
    }
}
