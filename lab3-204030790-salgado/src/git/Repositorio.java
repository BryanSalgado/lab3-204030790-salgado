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
    ArrayList<String> cambios;
    int nCambios;
    int estado;
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
        this.cambios= new ArrayList<>();
        this.estado=1;
        this.nCambios=0;
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
        (this.cambios).add("add");
        this.nCambios= this.nCambios + 1;
    }
    public void newCommit(String mensaje, int dia, int mes, int ano){
        Commit commit;
        int nArchivos= (this.index).getCantidad();
        ArrayList<Archivo> contenido = (this.index).getContenido();
        commit= new Commit(mensaje, dia, mes, ano, contenido, nArchivos);
        this.index = new Index();
        (this.localRepository).setLocalRepository(commit);
        (this.cambios).add("commit");
        this.nCambios= this.nCambios + 1;
        this.estado=0;
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
        (this.cambios).add("push");
        this.nCambios= this.nCambios + 1;
        this.estado=1;
    }
    public void pull(){
        int ultimo= (this.remoteRepository).getCantidad() - 1;
        Commit uCommit= ((this.remoteRepository).getRemoteRepository()).get(ultimo);
        ArrayList<Archivo> contenido = uCommit.getContenido();
        int cantidad = uCommit.getCantidad();
        (this.workspace)=new Workspace(contenido, cantidad);
        (this.cambios).add("pull");
        this.nCambios= this.nCambios + 1;
    }
    public void log(){
        int nLocal= (this.localRepository).getCantidad();
        ArrayList<Commit> contenidoL= (this.localRepository).getLocalRepository();
        int i=nLocal -1;
        System.out.println("Ultimos 5 commits:\n");
        while((nLocal-6)<i && 0<=i){
            System.out.println((contenidoL.get(i)).getMensaje() + "\n");
            System.out.println((contenidoL.get(i)).getFecha()[0] + "/");
            System.out.println((contenidoL.get(i)).getFecha()[1] + "/");
            System.out.println((contenidoL.get(i)).getFecha()[2] + "/n");            
            i=i-1;
        }
        
    }
    public void agregarArchivo(Archivo arch){
        (this.workspace).setWorkspace(arch);
    }
    public void status(){
        System.out.println("Repositorio: " + (this.nombre));
        System.out.println("\nCreado por: " +(this.autor) + "\n");
        System.out.println("Numero de archivos en Workspace: " +(this.workspace).getCantidad());
        System.out.println("Numero de archivos en Index: " +(this.index).getCantidad());
        System.out.println("Numero de Commits en Local Repository: " +(this.localRepository).getCantidad());
        if((this.estado)==1){
            System.out.println("Remote Repository al dia");
        }
        else{
            System.out.println("Aun hay commits sin agregar al Remote Repository");
        }
    }
}
