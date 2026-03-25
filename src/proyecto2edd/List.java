/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author gianc
 */
public class List 
{
    private DocumentNode head;

    public List() {
        this.head = null;
    }

    public void insert(Documento doc) {
        DocumentNode newDocument = new DocumentNode(doc);
        newDocument.next = head;
        head = newDocument;
    }

    public Documento search(String name) 
    {
        DocumentNode actual = head;
        while (actual != null) {
            if (actual.documento.name.equals(name)) {
                return actual.documento;
            }
            actual = actual.next;
        }
        return null;
    }

    public boolean delete(String name)
    {
        if (head == null) return false;

        if (head.documento.name.equals(name)) 
        {
            if (!head.documento.queue) 
            {
                head = head.next;
                return true;
            }
            return false;
        }

        DocumentNode actual = head;
        while (actual.next != null) 
        {
            if (actual.next.documento.name.equals(name)) 
            {
                if (!actual.next.documento.queue) 
                {
                    actual.next = actual.next.next;
                    return true;
                }
                return false;
            }
            actual = actual.next;
        }
        return false;
    }
}
