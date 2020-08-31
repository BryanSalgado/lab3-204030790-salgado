/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package git;

import java.util.ArrayList;

/**
 *
 * @author Bryan
 */
public class RemoteRepository {
    ArrayList<Commit> contenido;
    int cantidad;
    public RemoteRepository(){
        this.contenido = new ArrayList<>();
        this.cantidad=0;
    }
    public void setRemoteRepository(Commit elemento){
        boolean add;
        add = (this.contenido).add(elemento);
        this.cantidad= this.cantidad + 1;
    }
    public ArrayList<Commit> getRemoteRepository(){
        return this.contenido;
    }
    public int getCantidad(){
        return this.cantidad;
    }
    
}
