/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package git;

/**
 *
 * @author Bryan
 */
public class Archivo {
    String nombre;
    int fecha[];
    String contenido;
    public Archivo(java.lang.String nombre, int dia, int mes, int ano, java.lang.String contenido){
        this.nombre=nombre;
        this.fecha= new int[3];
        this.fecha[0]=dia;
        this.fecha[1]=mes;
        this.fecha[2]=ano;
        this.contenido=contenido;        
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getContenido(){
        return this.contenido;
    }
    public int[] getFecha(){
        return this.fecha;
    }
}
