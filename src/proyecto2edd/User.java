/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

public class User 
{
    public String name;
    public List list;
    public String priority;

    public User(String name, String priority) 
    {
        this.name = name;
        this.list = new List();
        this.priority = priority;
    }
}
