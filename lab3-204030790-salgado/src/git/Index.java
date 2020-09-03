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
public class Index {
    ArrayList<Archivo> contenido;
    int cantidad;
    public Index(){
        this.contenido = new ArrayList<>();
        this.cantidad=0;
    }
    public void setIndex(Archivo elemento){
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
