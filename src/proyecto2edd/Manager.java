/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

public class Manager 
{
    public HashTable users;
    public MonticuloBinario cola;
    public Reloj reloj;

    public Manager(HashTable usuarios) 
    {
        this.users = usuarios;
        this.cola = new MonticuloBinario(100);
        this.reloj = new Reloj();
    }
    
    public MonticuloBinario getColaimpresion() {
        return cola;
    }
    
    public HashTable getUsuarios() {
        return users;
    }

    public void imprimir(String nombreusuario, String nombredocumento, int tamano) 
    {
        User usuario = users.buscar(nombreusuario);
        
        if (usuario != null) {
            Documento nuevodocumento = new Documento(nombredocumento, tamano, usuario);
            usuario.list.insert(nuevodocumento);
            
            int etiqueta = reloj.timeToText(usuario.priority);
            
            nuevodocumento.time = etiqueta;
            
            nuevodocumento.queue = true;
            
            cola.insertar(nuevodocumento);
            reloj.avanzar();
            
        }
    }

    public Documento imprimirsiguiente() 
    {
        Documento doc = cola.extraerMinimo();
        if (doc != null) 
        {
            doc.queue = false;
            reloj.avanzar();
        }
        return doc;
    }
    
    public void cancelar(String nombreusuario, String nombredocumento) 
    {
        User usuario = users.buscar(nombreusuario);
        Documento doc = usuario.list.search(nombredocumento);
        cola.cancelarDocumento(doc.index);
        reloj.avanzar();
    }
}
