/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author gianc y 
 */

// **************************************
// hazlo con lo mas ingles que puedas
// **************************************
public class Documento {
    public String name;
    public boolean queue;
    public int time;
    public int index;
    public int size;
    public User user;
    
    public Documento(String name, int size, User user) {
        this.name = name;
        this.queue = false;
        this.size = size;
        this.time = 0;
        this.index = -1;
        this.user = user;
    }
}
