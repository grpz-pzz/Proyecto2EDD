/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author gianc
 */
public class HashNode 
{
    public User user;
    public HashNode next;

    public HashNode(User usuario) 
    {
        this.user = usuario;
        this.next = null;
    }
}
