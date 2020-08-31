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
public class Commit {
    ArrayList<Archivo> contenido;
    int cantidad;
    String autor;
    int fecha[];
    public Commit(String autor, int dia, int mes, int ano, ArrayList<Archivo> contenido, int cantidad){
        this.contenido = contenido;
        this.fecha= new int[3];
        this.fecha[0]= dia;
        this.fecha[1]= mes;
        this.fecha[2]= ano;
        this.cantidad= cantidad;
        this.autor= autor;
    }
    public int[] getFecha(){
        return this.fecha;
    }
    public String getAutor(){
        return this.autor;
    }
    
    public ArrayList<Archivo> getContenido(){
        return this.contenido;
    }
    public int getCantidad(){
        return this.cantidad;
    }
    
}
