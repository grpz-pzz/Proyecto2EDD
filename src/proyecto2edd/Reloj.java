/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author gianc
 */
public class Reloj 
{
    private int tiempo;
    
    public Reloj() {
        this.tiempo = 0;
    }
    
    public void avanzar() {
        this.tiempo++;
    }

    public int getTime() {
        return tiempo;
    }

    public int timeToText(String prioridad) {
        int etiqueta = tiempo;
        if (null != prioridad)
        {
            switch (prioridad) 
            {
                case "prioridad_alta":
                    etiqueta = (tiempo + 1);
                    break;
                case "prioridad_media":
                    etiqueta = (tiempo + 5);
                    break;
                case "prioridad_baja":
                    etiqueta = (tiempo + 10);
                    break;
                default:
                    break;
            }
        }
        return etiqueta;
    }
}
