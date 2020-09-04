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
public class Repositorio {
    String autor;
    String nombre;
    //Arreglo con las modificaciones
    Index index;
    Workspace workspace;
    LocalRepository localRepository;
    RemoteRepository remoteRepository;
    public Repositorio(String nombre, String autor){
        this.index= new Index();
        this.workspace= new Workspace();
        this.localRepository= new LocalRepository();
        this.remoteRepository= new RemoteRepository();
        this.autor= autor; 
        this.nombre= nombre;
    }
    
    
    public void add( ArrayList<String> archivos){
        int nArchivos = archivos.size();
        int nWorkSpace= (this.workspace).getCantidad();
        ArrayList<Archivo> contenido= (this.workspace).getContenido();
        for (int i = 0; i < nArchivos; ++i){
            for (int e = 0; e < nWorkSpace; ++e){
                if (((contenido.get(e)).getNombre()).equals(archivos.get(i))){
                    (this.index).setIndex(contenido.get(e));
                }
                
            }
        }
    }
    public void newCommit(String mensaje, int dia, int mes, int ano){
        Commit commit;
        int nArchivos= (this.index).getCantidad();
        ArrayList<Archivo> contenido = (this.index).getContenido();
        commit= new Commit(mensaje, dia, mes, ano, contenido, nArchivos);
        this.index = new Index();
        (this.localRepository).setLocalRepository(commit);
    }
    public void push(){
        int nLocal= (this.localRepository).getCantidad();
        int nRemote= (this.remoteRepository).getCantidad();
        ArrayList<Commit> contenidoL= (this.localRepository).getLocalRepository();
        ArrayList<Commit> contenidoR= (this.remoteRepository).getRemoteRepository();
        for (int i = 0; i < nLocal; ++i){
            for (int e = 0; e < nRemote; ++e){
                if (!((contenidoL.get(e)).getMensaje()).equals((contenidoR.get(e)).getMensaje())){
                    (this.remoteRepository).setRemoteRepository(contenidoL.get(e));
                }
                
            }
        }
    }
    
}
