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
public class Workspace {
    ArrayList<Archivo> contenido;
    int cantidad;
    public Workspace(){
        this.contenido = new ArrayList<>();
        this.cantidad=0;
    }
    public Workspace(ArrayList<Archivo> contenido, int cantidad){
        this.contenido = contenido;
        this.cantidad= cantidad;
    }
    public void setWorkspace(Archivo elemento){
        (this.contenido).add(elemento);
        this.cantidad= this.cantidad + 1;
    }
    public ArrayList<Archivo> getContenido(){
        return this.contenido;
    }
    public int getCantidad(){
        return this.cantidad;
    }
}
