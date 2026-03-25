/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author gianc
 */
public class DocumentNode 
{
    Documento documento;
    public DocumentNode next;

    public DocumentNode (Documento documento) {
        this.documento = documento;
        this.next = null;
    }
}
